package com.dtoc.master.serviceImpl;

import com.dtoc.common.param.Instance;
import com.dtoc.common.param.Task;
import com.dtoc.master.client.param.*;
import com.dtoc.master.core.MasterCore;
import com.dtoc.master.param.TaskStatus;
import com.dtoc.master.service.MasterService;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author yang
 * @date 11/18/20 9:02 am
 */

@Service
public class MasterServiceImpl implements MasterService {
    public void registerWorker(RegisterArgs registerArgs, RegisterReply registerReply) {
        synchronized (MasterCore.lock){
            MasterCore.getContextInstance().workerSeq = MasterCore.getContextInstance().workerSeq + 1;
            registerReply.setWorkerSeq(MasterCore.getContextInstance().workerSeq);
        }
    }

    public void registerTask(TaskArgs taskArgs, TaskReply taskReply) {
        synchronized (MasterCore.lock){
            Instance instance = MasterCore.getContextInstance().getInstanceQueue().poll();
            if (instance.isAlive()){
                if (!instance.getTaskPhase().getCode().equals(MasterCore.getContextInstance().getTaskPhase().getCode())){
                    return;
                }
                MasterCore.getContextInstance().getTaskList().get(instance.getSeq()).setStatus(TaskStatus.TASK_STATUS_RUNNING.getStatus());
                MasterCore.getContextInstance().getTaskList().get(instance.getSeq()).setWorkId(taskArgs.getWorkId());
                MasterCore.getContextInstance().getTaskList().get(instance.getSeq()).setStartTime(new Date());
                taskReply.setInstance(instance);
            }
        }
    }

    public void reportTask(ReportTaskArgs reportTaskArgs) {

    }

}
