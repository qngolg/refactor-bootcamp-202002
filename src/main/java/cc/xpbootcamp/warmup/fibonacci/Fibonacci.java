package cc.xpbootcamp.warmup.fibonacci;

public class Fibonacci {
    public int calculate(int i) {
        if (i > 2) {
            return calculate(i - 1) + calculate(i - 2);
        }
        return 1;
    }
}
