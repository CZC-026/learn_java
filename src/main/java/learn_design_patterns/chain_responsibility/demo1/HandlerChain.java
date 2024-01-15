package learn_design_patterns.chain_responsibility.demo1;

import java.util.ArrayList;
import java.util.List;

public class HandlerChain {
    static List<IHandler> handlerList = new ArrayList<IHandler>();
    public void addHandler(IHandler handler){
        handlerList.add(handler);
    }
    public void addHandlers(List<IHandler> handlers){
        handlerList.addAll(handlers);
    }
    public void removeHandler(IHandler handler){
        handlerList.remove(handler);
    }
    public void removeHandlers(List<IHandler> handlers){
        handlerList.removeAll(handlers);
    }
    public void clear(){
        handlerList.clear();
    }

    public void handle(){
        handlerList.forEach(IHandler::handle);
    }

}

