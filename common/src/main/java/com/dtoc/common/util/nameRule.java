package com.dtoc.common.util;

public class nameRule {

    public static String reduceName(int mapIdx, int reduceIdx){
        return "mr" + "-" + mapIdx + "#" + reduceIdx;
    }

    public static String mapName(int mapIdx, int reduceIdx){
        return "mr" + "-" + reduceIdx;
    }
}
