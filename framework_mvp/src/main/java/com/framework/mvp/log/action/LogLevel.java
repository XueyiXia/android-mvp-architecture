package com.framework.mvp.log.action;

/**
 * 日志等级
 */

public enum LogLevel {
    v, d, i, w, e;
    public String toHtmlColor() {
        switch(this) {
            case v:
                return "grey";
            case i:
                return "black";
            case w:
                return "purple";
            case e:
                return "red";
            case d:
            default:
                return "teal";
        }
    }
}
