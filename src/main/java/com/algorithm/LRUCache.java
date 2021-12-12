package com.algorithm;

import java.util.HashMap;

/**
 * Created by yuntao.wu on 2020/5/14.
 * LRU 实现
 */
public class LRUCache {

    private int capacity = 0;
    private HashMap<String,Node> map = new HashMap<>();
    private Node tail;
    private Node head;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return map.size();
    }

    public boolean put(String key, int val) {
        Node node = map.get(key);
        if (node != null) {
            node.setVal(val);
            remove(node);
            return addHead(node);
        }
        if (getSize() >= capacity) {
            System.out.println("踢出 " + tail.getKey());
            map.remove(tail.getKey());
            remove(tail);
        }
        node = new Node(key, val);
        map.put(key, node);
        return addHead(node);
    }


    public int get(String key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        remove(node);
        addHead(node);
        return node.getVal();
    }

    public void remove(String key) {
        Node node = map.get(key);
        if (node == null) {
            return ;
        }
        map.remove(key);
        remove(node);
    }

    public void clean() {
        map.clear();
        head = null;
        tail = null;
    }

    private boolean addHead(Node node) {
        if (node == null) {
            return false;
        }
        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.setNext(head);
            head.setPrev(node);
            head = node;
        }
        print();
        return true;
    }

    private boolean remove(Node node) {
        if (node == null) {
            return false;
        }
        if (head == tail) {
            if (head == node) {
                head = null;
                tail = null;
            }
        } else if (head == node) {
            head = node.getNext();
        } else if (tail == node) {
            tail = node.getPrev();
            tail.setNext(null);
        } else {
            Node prev = node.getPrev();
            prev.setNext(node.getNext());
            node.getNext().setPrev(prev);
        }
        return true;
    }


    private void print() {
        Node cur = head;
        while(cur != null) {
            System.out.print(cur.getVal() + " ");
            cur = cur.getNext();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(4);
        cache.put("1", 1);
        cache.put("2", 2);
        cache.put("3", 3);
        System.out.println("size: " + cache.getSize());
        cache.put("4",4);
        cache.put("5",5);
        System.out.println("size: " +cache.getSize());
        System.out.println("1: " + cache.get("1"));
        System.out.println("2: " + cache.get("2"));
        cache.put("6",6);
        System.out.println("2: " + cache.get("2"));
        System.out.println("3: " + cache.get("3"));
        cache.remove("5");
        cache.print();
        cache.put("7",7);
        cache.clean();
        cache.print();

    }

}

class Node {
    private int val;
    private String key;
    private Node prev;
    private Node next;

    public Node(String key,int val) {
        this.key = key;
        this.val = val;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
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
