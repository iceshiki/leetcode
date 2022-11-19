package subject;

import model.BiLinkListNode;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: chen.jc
 * @createDate: 2022/11/19
 */
public class Subject146 {
    private int cap;
    private Map<Integer, Integer> map = new LinkedHashMap<>();  // 保持插入顺序

    public Subject146(int capacity) {
        this.cap = capacity;
    }

    public int get(int key) {
        if (map.keySet().contains(key)) {
            int value = map.get(key);
            map.remove(key);
            // 保证每次查询后，都在末尾
            map.put(key, value);
            return value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.keySet().contains(key)) {
            map.remove(key);
        } else if (map.size() == cap) {
            Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
            iterator.next();
            iterator.remove();
        }
        map.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
class LRUCache {
    BiLinkListNode head;
    /**
     * 增加一个队尾指针提高性能
     */
    BiLinkListNode tail;
    int size = 0;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (head == null) {
            return -1;
        }
        BiLinkListNode node = head;
        BiLinkListNode tmp = updateNode(key, node);
        if (tmp.key == key) {
            return tmp.val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        BiLinkListNode newNode = new BiLinkListNode(key, value);
        newNode.key = key;
        if (size < capacity) {
            // 有空位
            size++;
            if (head == null) {
                head = newNode;
            } else {
                headInsert(newNode);
            }
        } else {
            // 没空位
            BiLinkListNode node = head;
            if (capacity == 1) {
                // 只有一个容量
                head = newNode;
            } else {
                BiLinkListNode tmp = updateNode(key, node);
                if (tmp.key != key) {
                    // 新key
                    tmp.prev.next = null;
                    tmp.prev = null;
                    headInsert(newNode);
                }
            }
        }
    }

    private BiLinkListNode updateNode(int key, BiLinkListNode headNode) {
        while (headNode != null) {
            if (headNode.key != key) {
                if (headNode.next != null) {
                    headNode = headNode.next;
                    continue;
                } else {
                    break;
                }
            }
            if (headNode.prev == null) {
                // 队头
                break;
            } else if (headNode.next != null) {
                // 中间
                headNode.next.prev = headNode.prev;
                headNode.prev.next = headNode.next;
                headNode.next = head;
                head.prev = headNode;
                head = headNode;
                break;
            } else {
                // 队尾
                headNode.prev.next = null;
                headNode.prev = null;
                headNode.next = head;
                head.prev = headNode;
                head = headNode;
                break;
            }
        }
        // 找不到返回队尾指针
        return headNode;
    }

    private void headInsert(BiLinkListNode newNode) {
        // 头插法
        head.prev = newNode;
        newNode.next = head;
        head = newNode;
    }


    public static void main(String[] args) {
//        test1();
//        test2();
//        test3();
        test4();
    }

    private static void test1() {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1);// 缓存是 {1=1}
        lRUCache.put(2, 2);// 缓存是 {1=1, 2=2}
        System.out.println(lRUCache.get(1));// 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        System.out.println(lRUCache.get(2));// 返回 -1 (未找到)
        lRUCache.put(4, 4);// 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        System.out.println(lRUCache.get(1));// 返回 -1 (未找到)
        System.out.println(lRUCache.get(3));// 返回 3
        System.out.println(lRUCache.get(4));// 返回 4
    }

    private static void test2() {
        LRUCache lRUCache = new LRUCache(1);
        lRUCache.put(2, 1);
        System.out.println(lRUCache.get(2));
        lRUCache.put(3, 2);
        System.out.println(lRUCache.get(2));
        System.out.println(lRUCache.get(3));
    }

    private static void test3() {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(2, 1);
        lRUCache.put(1, 1);
        lRUCache.put(2, 3);
        lRUCache.put(4, 1);
        System.out.println(lRUCache.get(1));
        System.out.println(lRUCache.get(2));
    }

    private static void test4() {
        LRUCache lRUCache = new LRUCache(3);
        lRUCache.put(1, 1);
        lRUCache.put(2, 2);
        lRUCache.put(3, 3);
        lRUCache.put(4, 4);
        System.out.println(lRUCache.get(4));
        System.out.println(lRUCache.get(3));
        System.out.println(lRUCache.get(2));
        System.out.println(lRUCache.get(1));
        lRUCache.put(5, 5);
        System.out.println(lRUCache.get(1));
        System.out.println(lRUCache.get(2));
        System.out.println(lRUCache.get(3));
        System.out.println(lRUCache.get(4));
        System.out.println(lRUCache.get(5));
    }
}

