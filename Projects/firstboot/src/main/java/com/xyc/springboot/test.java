package com.xyc.springboot;

/**
 * @author ：xuyichao
 * @description：
 * @date ：2021/7/9 17:29
 */
public enum test {
    a("jj"), b("xx"), c("ll");

    private String dd;

    test(String value) {
        this.dd = value;
    }

    public String getVaule() {
        return this.dd;
    }
}
