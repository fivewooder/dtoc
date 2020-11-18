package com.dtoc.master.core;

import com.dtoc.common.param.Instance;
import com.dtoc.common.param.TaskPhase;
import org.springframework.stereotype.Component;

/**
 * @author yang
 * @date 11/18/20 12:43 am
 */
@Component
public class TaskFacade {
    public Instance getTask(int seq){
        Instance instance = new Instance();
        instance.setNMap(MasterCore.getContextInstance().getFilelist().size());
        instance.setNReduce(MasterCore.getContextInstance().getnReduce());
        instance.setSeq(seq);
        instance.setTaskPhase(MasterCore.getContextInstance().getTaskPhase());
        instance.setAlive(true);
        if (instance.getTaskPhase().getCode().equals(TaskPhase.MAP_PHASE.getCode())){
            instance.setFileName(MasterCore.getContextInstance().getFilelist().get(seq));
        }
        return instance;
    }
}
