package utils;

/**
 * @description: 简单累加器
 * @author: kingsleycheng
 * @date: 2026/8/20 17:10
 * @version: 1.0
 */
public class Accumulator {
    private double total;
    private int N;
    public void addDataValue(double val){
        N++;
        total+=val;
    }

    public double mean(){
        return total/N;
    }

    public String toString() {
        return "Mean ("+ N +" values): "+String.format("%7.5f",mean());
    }
}
