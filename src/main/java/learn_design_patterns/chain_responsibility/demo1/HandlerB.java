package learn_design_patterns.chain_responsibility.demo1;

public class HandlerB implements IHandler{
    @Override
    public void handle() {
        System.out.println("HandlerB");
    }
}
