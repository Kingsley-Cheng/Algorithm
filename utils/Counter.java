package utils;

/**
 * @description: 简单计数器
 * @author: kingsleycheng
 * @date: 2026/8/20 17:00
 * @version: 1.0
 */
public class Counter {
    private final String name;
    private int count;
    public Counter(String id){
        name=id;
    }
    // 将计数器的值加一
    public void increment(){
        count++;
    }
    // 获取计数器的值
    public int tally(){
        return count;
    }
    public String toString(){
        return count + " " + name;
    }
    // 将计数器重置
    public void reset(){
        count=0;
    }
}
