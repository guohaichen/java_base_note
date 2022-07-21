package com.book.onJava.function;

/**
 * @author cgh
 * @create 2022-07-09 17:41
 */
public interface Strategy {
    String approach(String msg);
}

class Soft implements Strategy{
    @Override
    public String approach(String msg) {
        return msg.toLowerCase() +"?";
    }
}

class Unrelated{
    static String twice(String msg){
        return msg + "" + msg;
    }
}
class Strategize{
    Strategy strategy;
    String msg;
    Strategize (String msg){
        strategy = new Soft();
        this.msg = msg;
    }
    void communicate(){
        System.out.println(strategy.approach(msg));
    }

    void changeStrategy(Strategy strategy){
        this.strategy = strategy;
    }

    public static void main(String[] args) {
        Strategy[] strategies = {
                new Strategy() {
                    @Override
                    public String approach(String msg) {
                        return msg.toUpperCase() + "!";
                    }
                },
                msg -> msg.substring(0,5),
                Unrelated::twice
        };
        Strategize s = new Strategize("hello there");
        s.communicate();
        for (Strategy newStrategy : strategies) {
            s.changeStrategy(newStrategy);
            s.communicate();
        }
    }
}
