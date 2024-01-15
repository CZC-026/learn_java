package learn_design_patterns.chain_responsibility.demo2;

public class HandlerC implements IHandler{
    @Override
    public boolean handle() {
        System.out.println("HandlerC handle");
        return true;
    }
}
