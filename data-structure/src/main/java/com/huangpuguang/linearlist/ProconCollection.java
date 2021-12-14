package com.huangpuguang.linearlist;

/**
 * <p>自定义集合接口</p>
 *
 * @author Procon
 * @since 2021/11/16
 */
public interface ProconCollection<E> {
    /**
     * 元素数量
     * @return 元素数量
     */
    int size();

    /**
     * 是否为空
     * @return 是否为空
     */
    boolean isEmpty();

    /**
     * 是否包含指定元素
     * @param e 元素
     * @return 是否包含指定元素
     */
    boolean contains(E e);

    /**
     * 添加元素到尾部
     * @param e 元素
     * @return  添加结果
     */
    boolean add(E e);

    /**
     * 指定位置添加元素
     * @param index 索引
     * @param e 元素
     * @return 添加结果
     */
    boolean add(int index,E e);

    /**
     * 设置指定索引的元素值
     * @param index 索引
     * @param e 元素
     * @return 设置结果
     */
    boolean set(int index,E e);

    /**
     * 获取指定索引位置元素
     * @param index 索引
     * @return  获取的元素
     */
    E get(int index);

    /**
     * 删除指定位置元素
     * @param index 索引
     * @return 删除的元素
     */
    E remove(int index);

    /**
     * 获取元素所在索引
     * @param e 元素
     * @return 元素所在的索引位置
     */
    int indexOf(E e);

    /**
     * 数组清空
     */
    void clear();
}
