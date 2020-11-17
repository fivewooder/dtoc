package com.dtoc.master.service;

import com.dtoc.master.client.param.*;

public interface MasterService {

    /**
     * Machine Identity Register
     * @param registerArgs
     * @param registerReply
     */
    void registerWorker(RegisterArgs registerArgs, RegisterReply registerReply);

    /**
     * Task Register
     * @param taskArgs
     * @param taskReply
     */
    void registerTask(TaskArgs taskArgs, TaskReply taskReply);

    /**
     * 报告任务完成情况
     * @param reportTaskArgs
     */
    void reportTask(ReportTaskArgs reportTaskArgs);

}
