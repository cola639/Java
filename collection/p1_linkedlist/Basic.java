package p1_linkedlist;

import java.util.LinkedList;

/**
 * 链表可分为单向链表和双向链表。
 * <p>
 * 一个单向链表包含两个值: 当前节点的值和一个指向下一个节点的链接。
 * <p>
 * 一个双向链表有三个整数值: 数值、向后的节点链接、向前的节点链接。
 * <p>
 * 使用场景
 * <p>
 * 你需要通过循环迭代来访问列表中的某些元素。
 * 需要频繁的在列表开头、中间、末尾等位置进行添加和删除元素操作。
 */
public class Basic {

    public static void main(String[] args) {
        // Create an instance of the Basic class
        Basic basic = new Basic();

        createLinkedList();
        addFirstElement();
        addLastElement();
        removeFirstElement();
        removeLastElement();
        getFirstElement();
        getLastElement();
        iterativeSize();
        iterativeEach();
    }

    /**
     * create linkedlist
     */
    public static void createLinkedList() {
        LinkedList<String> sites = new LinkedList<String>();
        sites.add("Google");
        sites.add("Runoob");
        sites.add("Taobao");
        sites.add("Weibo");
        System.out.println(sites);
    }

    /**
     * add First element to linkedlist
     */
    public static void addFirstElement() {
        LinkedList<String> sites = new LinkedList<String>();
        sites.add("Google");
        sites.add("Runoob");
        sites.add("Taobao");
        sites.add("Weibo");
        sites.addFirst("Baidu");
        System.out.println(sites);
    }

    /**
     * add Last element to linkedlist
     */
    public static void addLastElement() {
        LinkedList<String> sites = new LinkedList<String>();
        sites.add("Google");
        sites.add("Runoob");
        sites.add("Taobao");
        sites.add("Weibo");
        sites.addLast("Baidu");
        System.out.println(sites);
    }

    /**
     * remove First element to linkedlist
     */
    public static void removeFirstElement() {
        LinkedList<String> sites = new LinkedList<String>();
        sites.add("Google");
        sites.add("Runoob");
        sites.add("Taobao");
        sites.add("Weibo");
        sites.removeFirst();
        System.out.println(sites);
    }

    /**
     * remove Last element to linkedlist
     */
    public static void removeLastElement() {
        LinkedList<String> sites = new LinkedList<String>();
        sites.add("Google");
        sites.add("Runoob");
        sites.add("Taobao");
        sites.add("Weibo");
        sites.removeLast();
        System.out.println(sites);
    }

    /**
     * get First element to linkedlist
     */
    public static void getFirstElement() {
        LinkedList<String> sites = new LinkedList<String>();
        sites.add("Google");
        sites.add("Runoob");
        sites.add("Taobao");
        sites.add("Weibo");
        System.out.println(sites.getFirst());
    }

    /**
     * get Last element to linkedlist
     */
    public static void getLastElement() {
        LinkedList<String> sites = new LinkedList<String>();
        sites.add("Google");
        sites.add("Runoob");
        sites.add("Taobao");
        sites.add("Weibo");
        System.out.println(sites.getLast());
    }

    /**
     * for size iterative linkedlst
     */
    public static void iterativeSize() {
        LinkedList<String> sites = new LinkedList<String>();
        sites.add("Google");
        sites.add("Runoob");
        sites.add("Taobao");
        sites.add("Weibo");

        // Using for loop
        for (int i = 0; i < sites.size(); i++) {
            System.out.println(sites.get(i));
        }
    }

    /**
     * for-each iterative linkedlst
     */
    public static void iterativeEach() {
        LinkedList<String> sites = new LinkedList<String>();
        sites.add("Google");
        sites.add("Runoob");
        sites.add("Taobao");
        sites.add("Weibo");

        for (String site : sites) {
            System.out.println(site);
        }
    }
}
