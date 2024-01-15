package learn_design_patterns.chain_responsibility.demo1;



import learn_design_patterns.chain_responsibility.demo1.HandlerA;
import learn_design_patterns.chain_responsibility.demo1.HandlerB;
import learn_design_patterns.chain_responsibility.demo1.HandlerChain;
import learn_design_patterns.chain_responsibility.demo1.IHandler;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class HandlerChainTest {
    IHandler handlerA;
    IHandler handlerB;
    HandlerChain handlerChain;
    @BeforeEach
    void setUp() {
        handlerA = new HandlerA();
        handlerB = new HandlerB();
        handlerChain = new HandlerChain();
    }

    @AfterEach
    void clear() {
        handlerChain.clear();
    }
    @Test
    void addHandler() {
        assert handlerChain.handlerList.size() == 0;
        handlerChain.addHandler(handlerA);
        assert handlerChain.handlerList.size() == 1;
        handlerChain.addHandler(handlerB);
        assert handlerChain.handlerList.size() == 2;

    }

    @Test
    void addHandlers() {
        System.out.println("*"+handlerChain.handlerList.size());
        assert handlerChain.handlerList.size() == 0;
        handlerChain.addHandlers(List.of(handlerA, handlerB));
        assert handlerChain.handlerList.size() == 2;
    }

    @Test
    void handle() {
        handlerChain.addHandlers(List.of(handlerA, handlerB));
        handlerChain.handle();
    }


    @Test
    void removeHandler() {
        handlerChain.removeHandler(handlerA);
        handlerChain.removeHandler(handlerB);
    }

    @Test
    void removeHandlers() {
        handlerChain.removeHandlers(List.of(handlerA, handlerB));
    }
}