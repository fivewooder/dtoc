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
    private List<String> filelist;

    /**
     * Machine List
     */
    private List<Task> taskList;

    /**
     * Number of Reduce Task
     */
    private int nReduce;

    /**
     * Type of work
     */
    private TaskPhase taskPhase;

    /**
     * All Task Finished
     */
    private boolean done;

    /**
     * Identity of Machine
     */
    public static int workerSeq;

    /**
     * Task Queue
     */
    private Queue<Instance> instanceQueue;

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

    public List<String> getFilelist() {
        return filelist;
    }

    public void setFilelist(List<String> filelist) {
        this.filelist = filelist;
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }

    public int getnReduce() {
        return nReduce;
    }

    public void setnReduce(int nReduce) {
        this.nReduce = nReduce;
    }

    public TaskPhase getTaskPhase() {
        return taskPhase;
    }

    public void setTaskPhase(TaskPhase taskPhase) {
        this.taskPhase = taskPhase;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public Queue<Instance> getInstanceQueue() {
        return instanceQueue;
    }

    public void setInstanceQueue(Queue<Instance> instanceQueue) {
        this.instanceQueue = instanceQueue;
    }
}
