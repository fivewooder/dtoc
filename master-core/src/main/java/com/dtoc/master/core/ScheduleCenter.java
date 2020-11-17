package com.dtoc.master.core;

import com.dtoc.common.param.Instance;
import com.dtoc.common.param.Task;
import com.dtoc.common.param.TaskPhase;
import com.dtoc.master.param.TaskStatus;

import javax.annotation.Resource;
import java.util.Date;
import java.util.ListIterator;

/**
 * @author yang
 * @date 11/17/20 11:20 pm
 */
public class ScheduleCenter {

    final static long maxWaitTime = 500;

    @Resource
    private TaskFacade taskFacade;

    public void check(){
        synchronized (MasterCore.lock){
            if (MasterCore.getContextInstance().done){
                return;
            }
            boolean allFinish = true;
            ListIterator it = MasterCore.getContextInstance().taskList.listIterator();
            while (it.hasNext()){
                Task task = (Task) it.next();
                if (task.getStatus() == TaskStatus.TASK_STATUS_READY.getStatus()){
                    allFinish = false;
                    Instance instance = taskFacade.getTask(it.nextIndex());
                    MasterCore.getContextInstance().instanceQueue.offer(instance);
                    MasterCore.getContextInstance().taskList.
                            get(it.nextIndex()).setStatus(TaskStatus.TASK_STATUS_QUEUE.getStatus());
                }else if (task.getStatus() == TaskStatus.TASK_STATUS_QUEUE.getStatus()){
                    allFinish = false;
                }else if (task.getStatus() == TaskStatus.TASK_STATUS_RUNNING.getStatus()){
                    allFinish = false;
                    Date curTime = new Date();
                    Long subTime = curTime.getTime() - task.getStartTime().getTime();
                    if (subTime >= maxWaitTime){
                        MasterCore.getContextInstance().taskList.
                                get(it.nextIndex()).setStatus(TaskStatus.TASK_STATUS_QUEUE.getStatus());
                        Instance instance = taskFacade.getTask(it.nextIndex());
                        MasterCore.getContextInstance().instanceQueue.offer(instance);
                    }
                }else if (task.getStatus() == TaskStatus.TASK_STATUS_ERR.getStatus()){
                    allFinish = false;
                    Instance instance = taskFacade.getTask(it.nextIndex());
                    MasterCore.getContextInstance().instanceQueue.offer(instance);
                    MasterCore.getContextInstance().taskList.
                            get(it.nextIndex()).setStatus(TaskStatus.TASK_STATUS_QUEUE.getStatus());
                }
            }
            if (allFinish){
                if (MasterCore.getContextInstance().taskPhase == TaskPhase.MAP_PHASE){
                    MasterCore.initReduceTask();
                }else{
                    MasterCore.getContextInstance().done = true;
                }
            }
        }
    }
}
