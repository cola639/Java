在这个 `ClassLoadingExample` 代码中，**JVM 类加载过程** 分为 **加载（Loading）**、**链接（Linking）** 和 **初始化（Initialization）** 三个阶段。我们可以通过具体代码分析它们的执行过程。

---

## **1. Loading（加载阶段）**
**概念**：JVM 将 `ClassLoadingExample.class` 文件读入内存，并为其创建对应的 **`java.lang.Class` 对象**。

**在代码中的体现**：
- 类加载器（Application ClassLoader）加载 `ClassLoadingExample` 类。
- `ClassLoadingExample.class` 字节码文件被读取到内存中。

**结果**：
- 此时，`ClassLoadingExample` 类的结构被加载到 JVM 中，但静态变量的值还未进行赋值，静态代码块还未执行。

---

## **2. Linking（链接阶段）**
链接阶段包含 **验证、准备、解析** 三个子阶段。

### **a. Verification（验证阶段）**
**概念**：验证类的字节码是否符合 JVM 规范，确保安全性。

**在代码中的体现**：
- JVM 验证类文件的结构、字节码指令、常量池等。
- 确保没有非法操作，比如方法调用的类型匹配。

**示例**：
JVM 会验证：
- `staticVar` 是一个合法的 `String` 类型。
- `System.out.println` 是合法的标准输出调用。

---

### **b. Preparation（准备阶段）**
**概念**：为类的**静态变量**分配内存，并设置其默认值（不是程序员赋的值）。

**在代码中的体现**：
- `static String staticVar` 分配内存空间，初始值为 `null`（引用类型的默认值）。
- 此时，静态变量 **还未被显式赋值**。

---

### **c. Resolution（解析阶段）**
**概念**：将类、方法、字段等的 **符号引用** 转换为实际的 **直接引用**（内存地址）。

**在代码中的体现**：
- `System.out` 是 `java.lang.System` 类的静态字段，它的符号引用会被解析为方法区中的直接引用。
- `System.out.println` 方法的调用符号也被解析为内存地址。

解析阶段是 JVM 内部完成的，你看不到直接的结果，但可以推断 `System.out.println` 调用已经成功解析。

---

## **3. Initialization（初始化阶段）**
**概念**：执行类的静态代码块和静态变量的赋值操作。按代码中的顺序执行。

### **在代码中的体现**：

#### **第一步：静态变量显式初始化**
```java
static String staticVar = "Static Variable";
```
- `staticVar` 被显式赋值为 `"Static Variable"`。

#### **第二步：静态代码块执行**
```java
static {
    System.out.println("Static Block: Initializing staticVar...");
    staticVar = "Static Variable Initialized";
}
```
- 输出：`Static Block: Initializing staticVar...`
- `staticVar` 的值被更新为 `"Static Variable Initialized"`。

---

## **总结执行顺序**

当程序运行到 `main` 方法时：

1. **类加载触发**：
   - `ClassLoadingExample` 类被加载到内存中（**加载阶段**）。
2. **链接阶段**：
   - **验证** 类的合法性。
   - **准备** 静态变量 `staticVar`，初始值为 `null`。
   - **解析** 符号引用（如 `System.out.println`）。
3. **初始化阶段**：
   - 执行 `staticVar` 的显式初始化 → `staticVar = "Static Variable"`。
   - 执行静态代码块，将 `staticVar` 更新为 `"Static Variable Initialized"`。
   - 输出：`Static Block: Initializing staticVar...`。

4. **执行 main 方法**：
   - 输出：`Main Method: Program starts`。
   - 输出：`Accessing staticVar: Static Variable Initialized`。
   - 执行构造函数：输出 `Constructor: Creating an instance of ClassLoadingExample`。

---

## **最终程序输出**
```text
Static Block: Initializing staticVar...
Main Method: Program starts
Accessing staticVar: Static Variable Initialized
Constructor: Creating an instance of ClassLoadingExample
```

---

### **总结概述**

| **阶段**          | **代码执行体现**                                                                 |
|--------------------|-------------------------------------------------------------------------------|
| **加载 (Loading)**   | `ClassLoadingExample` 类加载到内存，生成 `Class` 对象。                                |
| **链接 (Linking)**   | **验证** 字节码合法性；**准备** `staticVar` 初始值为 `null`；**解析** 方法与字段的符号引用。    |
| **初始化 (Initialization)** | 先执行 `staticVar` 的显式初始化，再执行静态代码块。                                      |

静态代码块和静态变量的初始化顺序，严格遵循定义顺序。这使得类加载的过程可预测且易于理解。