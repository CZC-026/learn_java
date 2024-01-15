package learn_design_patterns.chain_responsibility.demo2;

import java.util.ArrayList;
import java.util.List;

public class HandlerChain {
    static List<IHandler> handlerList = new ArrayList<>();

    public void addHandlers(List<IHandler> handlers){
        handlerList.addAll(handlers);
    }
    public void handle(){
        for (IHandler handler : handlerList) {
            if(!handler.handle()){
                break;
            }
        }
    }
}
