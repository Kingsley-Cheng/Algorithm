package utils;

import algorithms.Insertion;
import algorithms.Selection;

/**
 * @description: TODO
 * @author: kingsleycheng
 * @date: 2026/8/26 17:50
 * @version: 1.0
 */
public class SortCompare {
    public static double time(String alg, Double[] a) {
        Stopwatch timer = new Stopwatch();
        if (alg.equals("Insertion")) new Insertion(a).sort();
        if (alg.equals("Selection")) new Selection(a).sort();
        return timer.elapsedTime();
    }
}
