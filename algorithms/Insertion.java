package algorithms;

import structures.ResizingArrayStack;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * @description: TODO
 * @author: kingsleycheng
 * @date: 2026/8/26 17:41
 * @version: 1.0
 */
public class Insertion implements Sort {
    private Comparable[] elem;

    public Insertion(Comparable[] a) {
        elem = a;
    }

    public static void main(String[] args) {
        String fileName = "./data/words3.txt";
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;
            ResizingArrayStack<String> words = new ResizingArrayStack<>();
            while ((line = br.readLine()) != null) {
                for (String elem : line.split(" "))
                    words.push(elem);
            }
            String[] sortItem = new String[words.size()];
            while (!words.isEmpty()) {
                sortItem[words.size() - 1] = words.pop();
            }
            Insertion insertion = new Insertion(sortItem);
            insertion.sort();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void sort() {
        int N = elem.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && less(elem[j], elem[j - 1]); j--)
                exch(elem, j, j - 1);
        }
        show(elem);
    }
}
