在 Java 中，`String`、`StringBuffer` 和 `StringBuilder` 都是用来处理字符串的类，但它们之间有一些显著的差异，特别是在 **不可变性**、**线程安全性** 和 **性能** 方面。下面我将详细解释这三者的区别，并给出相关的代码示例。

### **1. String**
- **不可变**：`String` 是不可变的（immutable），意味着一旦创建，它的内容就不能更改。如果对 `String` 进行修改操作，会创建一个新的 `String` 对象。
- **性能**：由于是不可变的，每次修改字符串都会创建新的对象，因此在频繁修改字符串的情况下，`String` 的性能较差。

#### **示例：使用 `String`**
```java
public class StringExample {
    public static void main(String[] args) {
        String str = "Hello";
        str = str + " World";  // 创建新的 String 对象
        System.out.println(str);  // 输出: Hello World
    }
}
```

**解释**：
- 每次使用 `+` 运算符时，会创建一个新的 `String` 对象，导致内存和性能浪费。

### **2. StringBuffer**
- **可变**：`StringBuffer` 是可变的（mutable），意味着可以在原有的对象上修改字符串内容，不会每次修改都创建新的对象。
- **线程安全**：`StringBuffer` 是 **线程安全** 的，它的操作是同步的（使用 `synchronized`），因此适用于多线程环境。但由于线程安全的开销，单线程环境下的性能较低。

#### **示例：使用 `StringBuffer`**
```java
public class StringBufferExample {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("Hello");
        sb.append(" World");  // 修改 StringBuffer 内部的字符串
        System.out.println(sb);  // 输出: Hello World
    }
}
```

**解释**：
- 使用 `StringBuffer`，修改操作是直接在对象内部进行的，不会产生新的对象，适用于需要频繁修改字符串的情况。

### **3. StringBuilder**
- **可变**：`StringBuilder` 也是可变的，和 `StringBuffer` 类似，可以在原对象上修改字符串内容。
- **线程不安全**：`StringBuilder` 不是线程安全的，因此性能上比 `StringBuffer` 要好，适合单线程环境下使用。

#### **示例：使用 `StringBuilder`**
```java
public class StringBuilderExample {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Hello");
        sb.append(" World");  // 修改 StringBuilder 内部的字符串
        System.out.println(sb);  // 输出: Hello World
    }
}
```

**解释**：
- 和 `StringBuffer` 一样，`StringBuilder` 也可以修改字符串内容，但它没有同步，因此适合单线程场景下的高效字符串操作。

### **区别总结**：
| 特性                | **String**                                      | **StringBuffer**                               | **StringBuilder**                              |
|---------------------|-------------------------------------------------|-----------------------------------------------|------------------------------------------------|
| **不可变性**        | 不可变（immutable）                             | 可变（mutable）                               | 可变（mutable）                                |
| **线程安全**        | 线程安全（不可变的特性）                        | 线程安全（同步方法）                          | 线程不安全                                      |
| **性能**            | 性能较差（频繁修改会创建新对象）                | 性能较低（因为线程安全的开销）                | 性能最佳（适合单线程使用）                     |
| **适用场景**        | 不需要频繁修改的字符串（例如常量字符串）        | 多线程环境下需要修改字符串的情况              | 单线程环境下频繁修改字符串的情况               |

### **选择建议**：
- 如果字符串内容不需要修改，使用 `String`。
- 如果需要频繁修改字符串，且考虑到线程安全，使用 `StringBuffer`（多线程环境下）。
- 如果是单线程环境下进行字符串修改，使用 `StringBuilder`，因为它没有线程安全的开销，性能更好。

### **代码对比总结**：

#### 1. **String 的使用：**
```java
String str = "Hello";
str = str + " World";  // 每次修改都创建新的对象
```

#### 2. **StringBuffer 的使用：**
```java
StringBuffer sb = new StringBuffer("Hello");
sb.append(" World");  // 在原对象上修改，线程安全
```

#### 3. **StringBuilder 的使用：**
```java
StringBuilder sb = new StringBuilder("Hello");
sb.append(" World");  // 在原对象上修改，不是线程安全
```

**总结**：
- **`String`** 是不可变的，适用于需要常量或不频繁修改的字符串。
- **`StringBuffer`** 和 **`StringBuilder`** 都是可变的，但 `StringBuffer` 是线程安全的，适合多线程环境，而 `StringBuilder` 是不线程安全的，适合单线程环境，性能更优。