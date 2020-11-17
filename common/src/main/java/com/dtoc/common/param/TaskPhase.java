package com.dtoc.common.param;

public enum TaskPhase {
    MAP_PHASE("MapPhase", 0),
    REDUCE_PHASE("RducePhase", 1)
    ;
    private String name;
    private Integer code;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    TaskPhase(String name, Integer code) {
        this.name = name;
        this.code = code;
    }
}
