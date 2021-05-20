# javac

## javac -version

    javac 1.8.0_281

## javac -help

    用法: javac <options> <source files>
    其中, 可能的选项包括:
    -g                         生成所有调试信息
    -g:none                    不生成任何调试信息
    -g:{lines,vars,source}     只生成某些调试信息
    -nowarn                    不生成任何警告
    -verbose                   输出有关编译器正在执行的操作的消息
    -deprecation               输出使用已过时的 API 的源位置
    -classpath <路径>            指定查找用户类文件和注释处理程序的位置
    -cp <路径>                   指定查找用户类文件和注释处理程序的位置
    -sourcepath <路径>           指定查找输入源文件的位置
    -bootclasspath <路径>        覆盖引导类文件的位置
    -extdirs <目录>              覆盖所安装扩展的位置
    -endorseddirs <目录>         覆盖签名的标准路径的位置
    -proc:{none,only}          控制是否执行注释处理和/或编译。
    -processor <class1>[,<class2>,<class3>...] 要运行的注释处理程序的名称; 绕过默认的搜索进程
    -processorpath <路径>        指定查找注释处理程序的位置
    -parameters                生成元数据以用于方法参数的反射
    -d <目录>                    指定放置生成的类文件的位置
    -s <目录>                    指定放置生成的源文件的位置
    -h <目录>                    指定放置生成的本机标头文件的位置
    -implicit:{none,class}     指定是否为隐式引用文件生成类文件
    -encoding <编码>             指定源文件使用的字符编码
    -source <发行版>              提供与指定发行版的源兼容性
    -target <发行版>              生成特定 VM 版本的类文件
    -profile <配置文件>            请确保使用的 API 在指定的配置文件中可用
    -version                   版本信息
    -help                      输出标准选项的提要
    -A关键字[=值]                  传递给注释处理程序的选项
    -X                         输出非标准选项的提要
    -J<标记>                     直接将 <标记> 传递给运行时系统
    -Werror                    出现警告时终止编译
    @<文件名>                     从文件读取选项和文件名

## javac CompilerLearn.java

    编译生成字节码文件

# javap

## javap -version

    1.8.0_281

## javap -help

    用法: javap <options> <classes>
    其中, 可能的选项包括:
    -help  --help  -?        输出此用法消息
    -version                 版本信息
    -v  -verbose             输出附加信息
    -l                       输出行号和本地变量表
    -public                  仅显示公共类和成员
    -protected               显示受保护的/公共类和成员
    -package                 显示程序包/受保护的/公共类
    和成员 (默认)
    -p  -private             显示所有类和成员
    -c                       对代码进行反汇编
    -s                       输出内部类型签名
    -sysinfo                 显示正在处理的类的
    系统信息 (路径, 大小, 日期, MD5 散列)
    -constants               显示最终常量
    -classpath <path>        指定查找用户类文件的位置
    -cp <path>               指定查找用户类文件的位置
    -bootclasspath <path>    覆盖引导类文件的位置

## javap -v CompilerLearn.class

    Classfile /Users/czh/project/java/own/interview/jdk-interview/jvm-interview/src/main/java/org/czh/interview/jvm_interview/compiler/CompilerLearn.class
    Last modified 2021-5-20; size 830 bytes
    MD5 checksum 7371d02d28ab7ab4b64ab0a31fff2c47
    Compiled from "CompilerLearn.java"
    public class org.czh.interview.jvm_interview.compiler.CompilerLearn
    minor version: 0
    major version: 52
    flags: ACC_PUBLIC, ACC_SUPER
    Constant pool:
    #1 = Class              #28            // org/czh/interview/jvm_interview/compiler/CompilerLearn
    #2 = String             #29            // TOM
    #3 = Methodref          #1.#30         // org/czh/interview/jvm_interview/compiler/CompilerLearn."<init>":(Ljava/lang/String;)V
    #4 = Fieldref           #31.#32        // java/lang/System.out:Ljava/io/PrintStream;
    #5 = Methodref          #1.#33         // org/czh/interview/jvm_interview/compiler/CompilerLearn.toString:()Ljava/lang/String;
    #6 = Methodref          #34.#35        // java/io/PrintStream.println:(Ljava/lang/String;)V
    #7 = Methodref          #15.#36        // java/lang/Object."<init>":()V
    #8 = Fieldref           #1.#37         // org/czh/interview/jvm_interview/compiler/CompilerLearn.name:Ljava/lang/String;
    #9 = Class              #38            // java/lang/StringBuilder
    #10 = Methodref          #9.#36         // java/lang/StringBuilder."<init>":()V
    #11 = String             #39            // Animal{name='
    #12 = Methodref          #9.#40         // java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
    #13 = Methodref          #9.#41         // java/lang/StringBuilder.append:(C)Ljava/lang/StringBuilder;
    #14 = Methodref          #9.#33         // java/lang/StringBuilder.toString:()Ljava/lang/String;
    #15 = Class              #42            // java/lang/Object
    #16 = Utf8               name
    #17 = Utf8               Ljava/lang/String;
    #18 = Utf8               main
    #19 = Utf8               ([Ljava/lang/String;)V
    #20 = Utf8               Code
    #21 = Utf8               LineNumberTable
    #22 = Utf8               <init>
    #23 = Utf8               (Ljava/lang/String;)V
    #24 = Utf8               toString
    #25 = Utf8               ()Ljava/lang/String;
    #26 = Utf8               SourceFile
    #27 = Utf8               CompilerLearn.java
    #28 = Utf8               org/czh/interview/jvm_interview/compiler/CompilerLearn
    #29 = Utf8               TOM
    #30 = NameAndType        #22:#23        // "<init>":(Ljava/lang/String;)V
    #31 = Class              #43            // java/lang/System
    #32 = NameAndType        #44:#45        // out:Ljava/io/PrintStream;
    #33 = NameAndType        #24:#25        // toString:()Ljava/lang/String;
    #34 = Class              #46            // java/io/PrintStream
    #35 = NameAndType        #47:#23        // println:(Ljava/lang/String;)V
    #36 = NameAndType        #22:#48        // "<init>":()V
    #37 = NameAndType        #16:#17        // name:Ljava/lang/String;
    #38 = Utf8               java/lang/StringBuilder
    #39 = Utf8               Animal{name='
    #40 = NameAndType        #49:#50        // append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
    #41 = NameAndType        #49:#51        // append:(C)Ljava/lang/StringBuilder;
    #42 = Utf8               java/lang/Object
    #43 = Utf8               java/lang/System
    #44 = Utf8               out
    #45 = Utf8               Ljava/io/PrintStream;
    #46 = Utf8               java/io/PrintStream
    #47 = Utf8               println
    #48 = Utf8               ()V
    #49 = Utf8               append
    #50 = Utf8               (Ljava/lang/String;)Ljava/lang/StringBuilder;
    #51 = Utf8               (C)Ljava/lang/StringBuilder;
    {
    public static void main(java.lang.String[]);
    descriptor: ([Ljava/lang/String;)V
    flags: ACC_PUBLIC, ACC_STATIC
    Code:
    stack=3, locals=2, args_size=1
    0: new           #1                  // class org/czh/interview/jvm_interview/compiler/CompilerLearn
    3: dup
    4: ldc           #2                  // String TOM
    6: invokespecial #3                  // Method "<init>":(Ljava/lang/String;)V
    9: astore_1
    10: getstatic     #4                  // Field java/lang/System.out:Ljava/io/PrintStream;
    13: aload_1
    14: invokevirtual #5                  // Method toString:()Ljava/lang/String;
    17: invokevirtual #6                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
    20: return
    LineNumberTable:
    line 12: 0
    line 13: 10
    line 14: 20
    
    public org.czh.interview.jvm_interview.compiler.CompilerLearn(java.lang.String);
    descriptor: (Ljava/lang/String;)V
    flags: ACC_PUBLIC
    Code:
    stack=2, locals=2, args_size=2
    0: aload_0
    1: invokespecial #7                  // Method java/lang/Object."<init>":()V
    4: aload_0
    5: aload_1
    6: putfield      #8                  // Field name:Ljava/lang/String;
    9: return
    LineNumberTable:
    line 18: 0
    line 19: 4
    line 20: 9
    
    public java.lang.String toString();
    descriptor: ()Ljava/lang/String;
    flags: ACC_PUBLIC
    Code:
    stack=2, locals=1, args_size=1
    0: new           #9                  // class java/lang/StringBuilder
    3: dup
    4: invokespecial #10                 // Method java/lang/StringBuilder."<init>":()V
    7: ldc           #11                 // String Animal{name='
    9: invokevirtual #12                 // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
    12: aload_0
    13: getfield      #8                  // Field name:Ljava/lang/String;
    16: invokevirtual #12                 // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
    19: bipush        39
    21: invokevirtual #13                 // Method java/lang/StringBuilder.append:(C)Ljava/lang/StringBuilder;
    24: bipush        125
    26: invokevirtual #13                 // Method java/lang/StringBuilder.append:(C)Ljava/lang/StringBuilder;
    29: invokevirtual #14                 // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
    32: areturn
    LineNumberTable:
    line 24: 0
    }
    SourceFile: "CompilerLearn.java"




