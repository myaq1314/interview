# Java编译器（javac）

Java 编译器（`javac`）是 Java 语言编程的关键组件之一，
    负责将 Java 源代码（`.java` 文件）编译成字节码（`.class` 文件），供 JVM 执行。

它是 Java 编译过程中的前端部分，
    也是在你敲完代码后“把代码变成能跑的东西”的第一步。

## Java编译器整体工作流程（javac）

        Java源文件 (.java)
                │
                ▼
        词法分析（Lexer）
                │
                ▼
        语法分析（Parser）
                │
                ▼
        抽象语法树（AST）
                │
                ▼
        语义分析（语法检查、类型推断、符号解析）
                │
                ▼
        中间表示（IR）构建
                │
                ▼
        字节码生成（生成 .class 文件）

## 编译过程各阶段详解

### 1. 词法分析（Lexical Analysis）

将源代码转为一串Token（词法单元），如关键字、标识符、常量、运算符等。

示例：`int a = 3 + b;` --> `int`, `a`, `=`, `3`, `+`, `b`, `;`

 工具：JDK的`javac`使用了`java.util.regex`和内部`Scanner`类进行词法拆解。

### 2. 语法分析（Parsing）

根据Java语言的语法规则，将token序列转换成抽象语法树（AST）。

AST是一个树形结构，表示程序的语法结构。

如果代码语法有错误，会在此阶段报错。

### 3. 语义分析（Semantic Analysis）

在AST上进行变量类型检查、作用域检查、方法调用合法性等。

检查如：

> 变量是否已定义？
>
> 类型是否兼容？
>
> 方法参数是否匹配？
> 
> 是否有未处理的异常？

### 4. 注解处理（Annotation Processing）

编译器扫描并处理注解（如`@Override`，`@Entity`，自定义注解等）。

如果存在注解处理器（APT），会在这一步生成新的代码。

使用`javax.annotation.processing`包。

### 5. 字节码生成（Bytecode Generation）

将AST转换为`.class`文件格式，包含JVM可识别的字节码指令。

字节码独立于平台，可以在任何安装了JVM的设备上运行。

## javac 编译器的常用参数

| 命令行参数                | 含义                        |
|----------------------|---------------------------|
| `javac Hello.java`   | 编译一个源文件                   |
| `-d ./out`           | 指定编译输出目录                  |
| `-classpath` / `-cp` | 指定依赖库路径                   |
| `-source`            | 指定 Java 语言版本              |
| `-target`            | 指定生成的字节码版本                |
| `-encoding UTF-8`    | 设置源代码文件编码                 |
| `-verbose`           | 输出详细编译信息                  |
| `-Xlint`             | 显示编译器警告                   |
| `-parameters`        | 保留参数名到 .class 文件（Java 8+） |

### 示例：

    javac -d out -encoding UTF-8 -source 17 -target 17 -classpath lib/* src/com/example/*.java

## javac 的结构组成（模块化视角）

Java 编译器并不是一个“黑盒”，
    它是由多个 Java 类构成的，
    包含在 tools.jar（Java 8及之前）或 jdk.compiler 模块中。

关键组件如下：

| 模块/类                       | 功能         |
|----------------------------|------------|
| `com.sun.tools.javac.Main` | 命令行入口      |
| `JavaCompiler`             | 编译主类，调用各阶段 |
| `Scanner`                  | 词法分析       |
| `Parser`                   | 语法分析       |
| `Attr`                     | 类型检查       |
| `Flow`                     | 数据流分析      |
| `Gen`                      | 字节码生成      |
| `JCTree`                   | AST 结构表示   |
| `JavaFileObject`           | 源文件抽象表示    |

这些类可以被外部工具调用，比如构建代码分析器、静态检查工具（如 ErrorProne）。

## 编译器的高级功能（面试常问）

### 增量编译

`javac` 在一些 IDE（如 IntelliJ IDEA、Eclipse）中支持增量编译，只编译被修改过的类。

### JSR 199 编译器 API

   可以通过 Java 代码动态调用编译器：

```java
JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
int result = compiler.run(null, null, null, "Hello.java");
```

### 注解处理器（APT）

通过实现 `AbstractProcessor`，可以在编译时生成代码（如 Dagger、Lombok 的实现）。

## 常见编译错误举例

| 错误信息                                 | 原因说明      |
|--------------------------------------|-----------|
| `cannot find symbol`                 | 未导入类或拼写错误 |
| `incompatible types`                 | 类型不兼容     |
| `';' expected`                       | 少了分号      |
| `class, interface, or enum expected` | 花括号位置错误   |

## 编译器 vs 解释器

| 编译器（javac）      | 解释器（JVM执行字节码）  |
|-----------------|----------------|
| 把 Java 源码编译成字节码 | 把字节码翻译成机器指令    |
| 编译一次运行多次        | 每次运行都解释执行      |
| 编译阶段可优化（如死代码移除） | JIT 可进一步优化热点代码 |

## 总结

`javac` 编译器是 Java 程序的“第一步转换器”，
它将人类可读的 `.java` 文件分析、处理、优化并最终生成跨平台 `.class` 字节码文件，
是 JVM 运行 Java 程序的前置步骤。



















