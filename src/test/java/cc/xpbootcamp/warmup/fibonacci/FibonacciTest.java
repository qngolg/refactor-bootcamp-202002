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

    @Test
    void should_return_1_when_calculate_given_position_is_2(){
        Fibonacci fibonacci = new Fibonacci();
        int result = fibonacci.calculate(2);
        Assert.assertEquals(1, result);
    }

    @Test
    void should_return_2_then_calculate_given_position_is_3(){
        Fibonacci fibonacci = new Fibonacci();
        int result = fibonacci.calculate(3);
        Assert.assertEquals(2, result);
    }
}
