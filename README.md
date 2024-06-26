### 创建新模块

1. **打开 IntelliJ IDEA，选择项目**：
    - 打开已经存在的 Java 项目（如你的 `java-fundamental` 项目）。

2. **添加新模块**：
    - 右键点击项目的根目录（`java-fundamental`），选择 `New -> Module...`。

3. **选择模块类型**：
    - 在弹出的对话框中，左侧选择 `New Module` 作为模块类型。
    - 点击 `Next`。

4. **修改iml**：
    -   <sourceFolder url="file://$MODULE_DIR$/src" isTestSource="false" />。
    -    修改为 <sourceFolder url="file://$MODULE_DIR$" isTestSource="false" />。


### 添加 Java 文件

1. **创建 Java 文件**：
    - 在新创建的模块目录下，右键点击 `src` 文件夹，选择 `New -> Java Class`。
    - 输入类名（如 `Main`），点击 `OK`。

### 检查和管理 .iml 文件

1. **检查 .iml 文件**：
    - 在新创建的模块目录下，确认是否生成了 `.iml` 文件。
    - `.iml` 文件包含了模块的配置信息，通常会自动生成。

### 确认项目结构

你应该能看到类似以下的项目结构：

```

└── new-module/
    ├── src/
    │   └── Main.java
    └── new-module.iml
```

这样你就成功创建了一个新的模块，并且该模块包含一个 Java 文件和一个 `.iml` 文件。
