package structures;

import java.util.Iterator;

/**
 * @description: 算法1.2 下压堆栈（链表实现）
 * @author: kingsleycheng
 * @date: 2026/8/20 16:14
 * @version: 1.0
 */
public class Stack<Item> implements Iterable<Item> {
    private Node first; // 栈顶
    private int N; // 元素数量

    public boolean isEmpty() {
        return N == 0 && first == null;
    }

    public int size() {
        return N;
    }

    // 向栈顶添加元素
    public void push(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
    }

    // 从栈顶删除元素
    public Item pop() {
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    public Iterator<Item> iterator() {
        return new StackIterator();
    }

    // 定义节点嵌套类
    private class Node {
        Item item; // 元素
        Node next; // 下一节点
    }

    private class StackIterator implements Iterator<Item> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }

        public void remove() {
        }
    }

}
