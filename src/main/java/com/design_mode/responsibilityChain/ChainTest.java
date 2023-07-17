package com.design_mode.responsibilityChain;

/**
 * @author cgh
 * @create 2022-09-02 9:43
 * 责任链测试类
 * 责任链模式，为了避免请求发送这与多个请求处理者耦合在一起，将所有请求者通过迁移对象记住其下一个对象的引用而练成一条链；当有请求发生时，可将请求沿着这条链传递，知道有对象处理它；
 * 包含以下角色：
 *  - 抽象处理者角色：定义一个处理请求的接口，包含抽象处理方法和一个后继连接。
 *  - 具体处理者：实现抽象处理者的处理方法，判断能否处理本次请求，如果可以处理请求则处理，否则将该请求转发给他的后继者。
 *  - 客户类：船舰处理链，并向链头的具体处理者对象提交请求，他不关心处理细节和请求的传递过程。
 */
public class ChainTest {
    //创建不用的记录器，并在每个记录器中设置下一个记录器。每个记录器中的下一个记录器代表的是链的一部分。
    private static AbstractLogger getChainOfLoggers() {
        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
        AbstractLogger debugLogger = new DebugLogger(AbstractLogger.DEBUG);
        AbstractLogger infoLogger = new InfoLogger(AbstractLogger.INFO);
        errorLogger.setNextLogger(debugLogger);
        debugLogger.setNextLogger(infoLogger);
        return errorLogger;
    }

    public static void main(String[] args) {
        AbstractLogger loggerChain = getChainOfLoggers();
        loggerChain.logMessage(AbstractLogger.INFO, "this is an information");
        System.out.println("--------------------");
        loggerChain.logMessage(AbstractLogger.DEBUG, "this is a debug levelQuery information");
        System.out.println("--------------------");
        loggerChain.logMessage(AbstractLogger.ERROR, "this is an error information");
    }
}
