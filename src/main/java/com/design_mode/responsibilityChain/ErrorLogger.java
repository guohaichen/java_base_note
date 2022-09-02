package com.design_mode.responsibilityChain;

/**
 * @author cgh
 * @create 2022-09-02 9:41
 */
public class ErrorLogger extends AbstractLogger {

    public ErrorLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Error Console :: logger:" + message);
    }
}
