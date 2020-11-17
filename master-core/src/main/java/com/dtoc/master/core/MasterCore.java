package com.dtoc.master.core;

import com.dtoc.common.param.Instance;
import com.dtoc.common.param.Task;
import com.dtoc.common.param.TaskPhase;

import java.util.List;
import java.util.Queue;

public class MasterCore {
    /**
     * File List On Disk
     */
    List<String> filelist;

    /**
     * Machine List
     */
    List<Task> taskList;

    /**
     * Number of Reduce Task
     */
    int nReduce;

    /**
     * Type of work
     */
    TaskPhase taskPhase;

    /**
     * All Task Finished
     */
    boolean done;

    /**
     * Identity of Machine
     */
    int workerSeq;

    /**
     * Task Queue
     */
    Queue<Instance> instanceQueue;

    /**
     * Global Lock
     */
    public static final Object lock = new Object();

    private static final MasterCore context = new MasterCore();

    private MasterCore(){}

    public static MasterCore getContextInstance(){
        return MasterCore.context;
    }

    public static void initMapTask(){
        getContextInstance().taskPhase = TaskPhase.MAP_PHASE;
    }

    public static void initReduceTask(){
        getContextInstance().taskPhase = TaskPhase.REDUCE_PHASE;
    }

}
