package p2_hashset;

import java.util.HashSet;

/**
 * - `HashSet`基于`HashMap`实现，不允许有重复元素。
 * - `HashSet`允许`null`值。
 * - `HashSet`是无序的，不会记录插入的顺序。
 * - `HashSet`不是线程安全的，需在多线程环境中显式同步。
 * - `HashSet`实现了`Set`接口。
 */

public class Basic {

    public static void main(String[] args) {
        // 创建HashSet对象
        HashSet<String> sites = new HashSet<>();

        // 添加元素
        sites.add("Google");
        sites.add("Runoob");
        sites.add("Taobao");
        sites.add("Zhihu");
        sites.add("Runoob");  // 重复的元素不会被添加

        // 输出HashSet
        System.out.println("HashSet: " + sites);  // 输出: [Google, Runoob, Zhihu, Taobao]

        // 判断元素是否存在
        boolean containsTaobao = sites.contains("Taobao");
        System.out.println("是否包含Taobao: " + containsTaobao);  // 输出: true

        // 删除元素
        boolean isRemoved = sites.remove("Taobao");
        System.out.println("是否删除Taobao: " + isRemoved);  // 输出: true
        System.out.println("HashSet: " + sites);  // 输出: [Google, Runoob, Zhihu]

        // 删除所有元素
        sites.clear();
        System.out.println("清空后的HashSet: " + sites);  // 输出: []

        // 添加元素
        sites.add("Google");
        sites.add("Runoob");
        sites.add("Taobao");
        sites.add("Zhihu");

        // 计算大小
        int size = sites.size();
        System.out.println("HashSet大小: " + size);  // 输出: 4

        // 迭代HashSet
        System.out.println("迭代HashSet中的元素:");
        for (String site : sites) {
            System.out.println(site);
        }
        // 输出:
        // Google
        // Runoob
        // Zhihu
        // Taobao
    }
}

