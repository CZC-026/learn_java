package learn_design_patterns.chain_responsibility.demo2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HandlerChainTest {
    IHandler handlerA = new HandlerA();
    IHandler handlerB = new HandlerB();
    IHandler handlerC = new HandlerC();
    HandlerChain handlerChain = new HandlerChain();



    @Test
    void handle() {
        handlerChain.addHandlers(List.of(handlerA, handlerB, handlerC));

        handlerChain.handle();
    }
}