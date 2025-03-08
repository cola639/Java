import java.util.Arrays;
import java.util.ArrayList;

public class ArrayExpansion {
    public static void main(String[] args) {
        // 1 手动扩容
        int[] originalArray = {1, 2, 3, 4, 5};
        // 扩容后的新长度
        int newLength = originalArray.length * 2;
        // 使用 Arrays.copyOf 方法进行扩容
        int[] newArray = Arrays.copyOf(originalArray, newLength);
        // 输出扩容后的数组
        System.out.println(Arrays.toString(newArray));

        // 2 ArrayList扩容
        ArrayList<Integer> arrayList = new ArrayList<>();
        // 添加元素到ArrayList
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);

        // 打印ArrayList
        System.out.println("ArrayList: " + arrayList);

        // 扩展ArrayList
        for (int i = 4; i <= 10; i++) {
            arrayList.add(i);
        }

        // 打印扩展后的ArrayList
        System.out.println("扩展后的ArrayList: " + arrayList);
    }
}