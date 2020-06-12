//package com.waibizi.test1;
//
//import java.util.Iterator;
//import java.util.Objects;
//import java.util.Spliterator;
//import java.util.Spliterators;
//import java.util.function.Consumer;
//
///**
// * @author 歪鼻子
// * @version 1.0
// * @date 2020/4/30 10:08
// */
//public interface Iterable<T> {
//
//    Iterable<T> iterator();
//    default Spliterator<T> spliterator() {
//        return Spliterators.spliteratorUnknownSize(iterator(), 0);
//    }
//
//    default void forEach(Consumer<? super T> action) {
//        Objects.requireNonNull(action);
//        for (T t : this) {
//            action.accept(t);
//        }
//    }
//}
