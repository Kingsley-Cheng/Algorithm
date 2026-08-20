package utils;

/**
 * @description: 计时器
 * @author: kingsleycheng
 * @date: 2026/8/20 17:16
 * @version: 1.0
 */
public class Stopwatch {
    private final long start;
    // 创建计时器
    public Stopwatch(){
        start = System.currentTimeMillis();
    }
    // 返回经过的时间
    public double elapsedTime(){
        long now = System.currentTimeMillis();
        return (now-start) / 1000.0;
    }
}
