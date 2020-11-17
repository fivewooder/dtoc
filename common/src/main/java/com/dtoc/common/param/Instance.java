package com.dtoc.common.param;

import lombok.Data;

@Data
public class Instance {
    String fileName;
    int nReduce;
    int nMap;
    int Seq; //机器的身份证号码
    TaskPhase taskPhase;
    boolean alive;
}
