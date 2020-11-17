package com.dtoc.master.param;


public enum TaskStatus {
    TASK_STATUS_READY("TaskStatusReady", 0),
    TASK_STATUS_QUEUE("TaskStatusQueue", 1),
    TASK_STATUS_RUNNING("TaskStatusRunning", 2),
    TASK_STATUS_FINISH("TaskStatusFinish", 3),
    TASK_STATUS_ERR("TaskStatusErr", 4)
    ;

    private String name;
    private int status;

    TaskStatus(String name, int status) {
        this.name = name;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public static int fetchStatus(TaskStatus taskStatus){
        if (taskStatus.getName().equals("TaskStatusReady")){
            return 0;
        }else if (taskStatus.getName().equals("TaskStatusQueue")){
            return 1;
        }else if (taskStatus.getName().equals("TaskStatusRunning")){
            return 2;
        }else if (taskStatus.getName().equals("TaskStatusFinish")){
            return 3;
        }else if (taskStatus.getName().equals("TaskStatusErr")){
            return 4;
        }
        return -1;
    }
}
