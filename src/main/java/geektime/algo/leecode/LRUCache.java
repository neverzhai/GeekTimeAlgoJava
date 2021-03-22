package geektime.algo.leecode;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: zhaixiaoshuang
 * @date: 2021-03-03 21:37
 * @description: 146. LRU 缓存机制
 */
public class LRUCache {
    class DLinkNode {
        int key;
        int value;
        DLinkNode pre;
        DLinkNode next;

        public DLinkNode(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public DLinkNode() {
        }
    }

    private Map<Integer, DLinkNode> cache = new HashMap<Integer, DLinkNode>();
    private int capacity;
    private int size;
    private DLinkNode head;
    private DLinkNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        head = new DLinkNode();
        tail = new DLinkNode();
        head.next = tail;
        tail.pre = head;

        new ReentrantLock();
    }

    public int get(int key) {
        DLinkNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkNode node = cache.get(key);
        if (node == null) {
            DLinkNode linkNode = new DLinkNode(key, value);
            cache.put(key, linkNode);
            addToHead(linkNode);
            size++;
            if (size > capacity) {
                DLinkNode tail = removeTail();
                cache.remove(tail.key);
                size--;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }

    }

    private void moveToHead(DLinkNode node) {
        removeNode(node);
        addToHead(node);

    }

    private void removeNode(DLinkNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void addToHead(DLinkNode linkNode) {
        linkNode.pre = head;
        linkNode.next = head.next;
        head.next.pre = linkNode;
        head.next = linkNode;

    }

    private DLinkNode removeTail() {
        DLinkNode result = tail.pre;

        removeNode(result);
        return result;
    }


}