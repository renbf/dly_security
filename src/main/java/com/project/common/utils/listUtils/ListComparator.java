package com.project.common.utils.listUtils;


/**
 * lambda类的接口定义..
 * 用于ListUtils中的所有比较内存储类相同的集合.
 * 一般情况下,我们是调用 Object中的equals 进行比较的,
 * 当然可能存在没有重写equals的情况或者equals会比较每一个成员属性.
 * 但是我们未必需要对比每一个属性来判断两个对象是否相等.
 * 可能只是对比一个id什么的,于是就用这个接口写lambda自定义比较规则.
 * @param <T>
 */
@FunctionalInterface
public interface ListComparator<T> {


    boolean equals(T l, T r);

}
