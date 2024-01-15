package learn_design_patterns.chain_responsibility.demo2;

public class HandlerB implements IHandler{
    @Override
    public boolean handle() {
        System.out.println("HandlerB handle");
        return false;
    }
}
