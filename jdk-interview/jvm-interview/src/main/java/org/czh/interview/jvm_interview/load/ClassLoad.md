## 类加载器

    BootstrapClassLoader
        JVM内核中的加载器，C++语言编写
        加载 JAVA_HOME/lib 目录下的类库

    ExtClassLoader
        Java语言编写，父类是BootstrapClassLoader
        加载 java_home/lib/ext 目录下的类库
        系统属性 -Djava.ext.dirs 指定该加载器加载的目录

    AppClassLoader
        Java语言编写，父类是 ExtClassLoader
        加载 应用程序 classpath 目录下的所有jar和class文件

    自定义类加载器
        继承 java.lang.ClassLoader
        重写父类的 findClass() 方法


[自定义类加载器示例](MyClassLoader.java)