package cc.xpbootcamp.warmup.fibonacci;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class FibonacciTest {

    @Test
    void should_return_1_when_calculate_given_position_is_1(){
        Fibonacci fibonacci = new Fibonacci();
        int result = fibonacci.calculate(1);
        Assert.assertEquals(1, result);
    }
}
