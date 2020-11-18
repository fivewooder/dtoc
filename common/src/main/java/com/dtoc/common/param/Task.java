package com.dtoc.common.param;

import lombok.Data;

import java.util.Date;

@Data
public class Task {
    int status;
    int workId;
    Date startTime;
}
