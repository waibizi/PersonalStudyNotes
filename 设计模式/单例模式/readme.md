#单例设计模式
@tags: 单例设计模式有饿汉式写法与懒汉式的两种写法，饿汉式与懒汉式的写法有以下几种
    1.  饿汉式（静态常量）   <br/>
    2.  饿汉式（静态代码块） <br/>
    3.  懒汉式（线程不安全） <br/>
    4.  懒汉式（线程安全、同步方法）<br/>
    5.  懒汉式（线程安全、同步代码块） （这种没用的，这里不写了）<br/>  
    6.  双重检查    <br/>
    7.  静态内部类   <br/>
    8.  枚举  <br/>
    
##  饿汉式（静态常量）
步骤: <br/>
    1.构造器私有化（防止new）<br/>
    2.类的内部创建对象 <br/>
    3.向外暴露一个静态的公共方法<br/>
  
  优缺点说明 <br/>
  优点： 这种写法最为简单，就是类加载的时候就开始实例化了，避免了线程同步问题
  缺点： 在类加载的时候就完成了实例化，没有达到懒加载的效果;如果从始至终没有使用过这个实例的话，会导致内存的浪费 <br/>
 
##  饿汉式（静态代码块）

这种其实与静态常量的形式是类似的，也是会造成内存浪费，但是类加载的时候时机我们是知道的，静态常量的实例化，类加载时机究竟在哪个时机进行实例化，我们不可控 <br/>

##  懒汉式（线程不安全）
    
    