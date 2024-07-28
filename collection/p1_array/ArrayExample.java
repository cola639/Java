package p1_array;

public class ArrayExample {
    public static void main(String[] args) {

        // 创建数组
        // dataType[] arrayRefVar = new dataType[arraySize];
        double[] myList = new double[10];
        myList[0] = 5.6;
        myList[1] = 4.5;
        myList[2] = 3.3;
        myList[3] = 13.2;
        myList[4] = 4.0;
        myList[5] = 34.33;
        myList[6] = 34.0;
        myList[7] = 45.45;
        myList[8] = 99.993;
        myList[9] = 11123;

        // 多维数组的动态初始化（以二维数组为例）
        // dataType[][] arrayRefVar = new dataType[arraySize][arraySize];
        int[][] a = new int[2][3];

        // 1 打印所有数组元素
        for (int i = 0; i < myList.length; i++) {
            System.out.println(myList[i] + " ");
        }

        // 2 计算所有元素的总和
        double total = 0;
        for (int i = 0; i < myList.length; i++) {
            total += myList[i];
        }
        System.out.println("Total is " + total);

        // 3 查找最大元素
        double max = myList[0];
        for (int i = 1; i < myList.length; i++) {
            if (myList[i] > max) max = myList[i];
        }
        System.out.println("Max is " + max);

        // 4 使用增强for循环 打印所有数组元素（ for : arr形式 ）
        for (double element : myList) {
            System.out.println(element);
        }

        int[] exampleArray = {1, 2, 3, 4, 5};

        // 5 作为函数的参数 (将数组作为参数传递给函数)
        printArray(exampleArray);

        // 6 作为函数的返回值 (将数组作为返回值返回给调用者)
        int[] reversedArray = reverse(exampleArray);

        // 打印二维数组的元素
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static int[] reverse(int[] list) {
        int[] result = new int[list.length];

        for (int i = 0, j = result.length - 1; i < list.length; i++, j--) {
            result[j] = list[i];
        }
        return result;
    }
}

