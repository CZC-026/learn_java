package learn_design_patterns.chain_responsibility.demo2;

public class HandlerA implements IHandler{
    @Override
    public boolean handle() {
        System.out.println("HandlerA handle");
        return true;
    }
}
