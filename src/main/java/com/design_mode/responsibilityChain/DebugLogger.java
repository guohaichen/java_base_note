package com.design_mode.responsibilityChain;

/**
 * @author cgh
 * @create 2022-09-02 9:39
 * 扩展该记录类的实体类
 */
public class DebugLogger extends AbstractLogger {

    public DebugLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Debug Console :: logger:" + message);
    }
}
