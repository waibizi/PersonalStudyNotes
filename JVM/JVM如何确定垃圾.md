# JVM如何确定垃圾

## 1.引用计数算法

​	Java中，对象与引用都是有关联的。如果要操作对象的话则必须使用引用去执行。因此，很显然一个简单办法是通过引用计数来判断一个对象是否可以被回收。简单说，即一个对象如果没有任何与之关联的引用，即他们的引用计数为0，则说明对象不太可能会被再次使用到，那么这个对象就是可回收对象。

但是使用引用计数算法有一个缺点，两个对象不可能再被访问了，但是彼此之间相互引用着对方，导致引用计数都不为零，引用计数算法也就无法回收它们。