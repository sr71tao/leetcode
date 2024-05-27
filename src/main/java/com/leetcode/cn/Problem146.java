package com.leetcode.cn;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by wuyuntao on 2024/5/26
 * 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行
 *
 */
public class Problem146 {


//["LRUCache","put","put","get","put","get","put","get","get","get"]
//[[2],[1,0],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
    public static void main(String[] args) {
        LRUCache obj = new LRUCache(1);
        obj.put(2,1);
//        obj.put(2,2);
//        obj.put(3,3);
//        obj.get(2);
//        obj.put(4,4);
//        obj.get(1);
//        obj.get(3);
//        obj.get(4);

        LRUCache2 obj2 = new LRUCache2(1);
        obj2.put(2,1);
        System.out.println(obj2.get(2));

    }

}

class LRUCache {
    private int capacity = 0;
    private Map<String, Node> map = new HashMap<>();
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        String strK = "" + key;
        Node node = this.map.get(strK);
        if (node == null) {
            return -1;
        }
        remove(node);
        addHead(node);
        return node.getVal();
    }

    public void put(int key, int value) {
        String strK = "" + key;
        Node node = this.map.get(strK);
        if (node != null) {
            node.setVal(value);
            remove(node);
            addHead(node);
            return;
        }
        if (this.map.size() >= this.capacity) {
            map.remove(""+this.tail.getKey());
            remove(this.tail);
        }
        Node newNode = new Node(key, value);
        this.map.put(strK, newNode);
        addHead(newNode);
    }


    private boolean remove(Node node){
        if (node == null) {
            return false;
        }
        if (this.tail == this.head) {
            if (this.head == node) {
                this.head = null;
                this.tail = null;
                return true;
            }
        } else if (this.head == node) {
            Node nxt = node.getNext();
            nxt.setPrev(null);
            node.setNext(null);
            this.head = nxt;
        } else if (this.tail == node) {
            Node prev = tail.getPrev();
            prev.setNext(null);
            node.setPrev(null);
            this.tail = prev;
        } else {
            Node prev = node.getPrev();
            Node nxt = node.getNext();
            prev.setNext(nxt);
            node.setPrev(null);
            node.setNext(null);
            if (nxt != null) {
                nxt.setPrev(prev);
            }

        }
        return true;
    }

    private boolean addHead(Node node) {
        if (node == null) {
            return false;
        }
        if (this.head == null && this.tail == null) {
            this.head = node;
            this.tail = node;
            return true;
        }
        node.setNext(this.head);
        this.head.setPrev(node);
        this.head = node;
        return true;
    }
}

class Node {
    private int key;
    private int val;
    private Node prev;
    private Node next;

    Node(int k , int v) {
        this.key = k;
        this.val = v;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}

class LRUCache2 extends LinkedHashMap<Integer, Integer> {
    private int capacity = 0;

    public LRUCache2(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return this.size() > capacity;
    }
}