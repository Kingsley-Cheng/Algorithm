package structures;
import java.util.Iterator;

/**
 * @description: 算法1.1 下压堆栈（数组实现，可动态调整大小）
 * @author: kingsleycheng
 * @date: 2026/8/20 15:34
 * @version: 1.0
 */
public class ResizingArrayStack<Item> implements Iterable<Item> {
    private Item[] a = (Item[]) new Object[1]; // 栈元素
    private int N = 0; // 元素数量

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    private void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        if (N >= 0) System.arraycopy(a, 0, temp, 0, N);
        a = temp;
    }

    public void push(Item item) {
        if (N == a.length) resize(2 * a.length);
        a[N++] = item;
    }

    public Item pop() {
        Item item = a[--N];
        a[N] = null;
        if (N > 0 && N == a.length / 4) {
            resize(a.length / 2);
        }
        return item;
    }

    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item> {
        private int i = N;

        public boolean hasNext() {
            return i > 0;
        }

        public Item next() {
            return a[--i];
        }

        public void remove() {
        }
    }

    // 打印内容
    @Override
    public String toString() {
        String result = "ResizingArrayStack(" + N + "):[";
        for (int i = 0; i < N - 1; i++) {
            result = result + a[i] + ",";
        }
        return result + a[N - 1] + "]";
    }

    public Item[] getElement() {
        return a;
    }
}
