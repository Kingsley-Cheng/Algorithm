package structures;

import java.util.Iterator;

/**
 * @description: 算法1.4 背包（只进不出）
 * @author: kingsleycheng
 * @date: 2026/8/20 16:52
 * @version: 1.0
 */
public class Bag<Item> implements Iterable<Item> {
    private Node first; // 链表的首节点

    public void add(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
    }

    @Override
    public Iterator<Item> iterator() {
        return new BagIterator();
    }

    // 定义节点嵌套类
    private class Node {
        Item item; // 元素
        Node next; // 下一节点
    }

    private class BagIterator implements Iterator<Item> {
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
