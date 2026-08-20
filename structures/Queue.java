package structures;

import java.util.Iterator;

/**
 * @description: 算法1.3 先进先出队列
 * @author: kingsleycheng
 * @date: 2026/8/20 16:29
 * @version: 1.0
 */
public class Queue<Item> implements Iterable<Item> {
    int N; // 队列中的元素数量
    private Node first; // 最早添加的节点
    private Node last; // 最晚添加的节点

    public boolean isEmpty() {
        return first == null && N == 0;
    }

    public int size() {
        return N;
    }

    // 从队尾添加元素
    public void enqueue(Item item) {
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else oldlast.next = last;
        N++;
    }

    // 从队首删除元素
    public Item dequeue() {
        Item item = first.item;
        first = first.next;
        if (isEmpty()) last = null;
        N--;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new QueueIterator();
    }

    // 定义节点嵌套类
    private class Node {
        Item item; // 元素
        Node next; // 下一节点
    }

    private class QueueIterator implements Iterator<Item> {
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

        @Override
        public void remove() {
        }
    }
}
