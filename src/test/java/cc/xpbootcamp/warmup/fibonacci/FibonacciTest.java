package cc.xpbootcamp.warmup.fibonacci;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class FibonacciTest {

    @Test
    void should_return_1_when_calculate_given_position_is_1(){
        Fibonacci fibonacci = new Fibonacci();
        long result = fibonacci.calculate(1);
        Assert.assertEquals(1, result);
    }

    @Test
    void should_return_1_when_calculate_given_position_is_2(){
        Fibonacci fibonacci = new Fibonacci();
        long result = fibonacci.calculate(2);
        Assert.assertEquals(1, result);
    }

    @Test
    void should_return_2_then_calculate_given_position_is_3(){
        Fibonacci fibonacci = new Fibonacci();
        long result = fibonacci.calculate(3);
        Assert.assertEquals(2, result);
    }

    @Test
    void should_return_3_then_calculate_given_position_is_4(){
        Fibonacci fibonacci = new Fibonacci();
        long result = fibonacci.calculate(4);
        Assert.assertEquals(3, result);
    }

    @Test
    void should_return_12586269025L_then_calculate_given_position_is_50(){
        Fibonacci fibonacci = new Fibonacci();
        long result = fibonacci.calculate(50);
        Assert.assertEquals(12586269025L, result);
    }
}
