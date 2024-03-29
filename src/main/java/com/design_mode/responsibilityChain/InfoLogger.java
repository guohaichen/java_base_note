package com.design_mode.responsibilityChain;

/**
 * @author cgh
 * @create 2022-09-02 9:42
 */
public class InfoLogger extends AbstractLogger {
    public InfoLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Info Console :: logger:" + message);
    }
}
