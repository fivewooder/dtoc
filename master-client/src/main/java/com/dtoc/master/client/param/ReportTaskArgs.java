package com.dtoc.master.client.param;

import com.dtoc.common.param.TaskPhase;
import lombok.Data;

/**
 * @author yang
 * @date 11/17/20 11:14 pm
 */
@Data
public class ReportTaskArgs {
    boolean done;
    int seq;
    TaskPhase taskPhase;
    int workerId;
}
