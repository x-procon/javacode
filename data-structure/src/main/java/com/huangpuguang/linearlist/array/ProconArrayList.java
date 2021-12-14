package com.huangpuguang.linearlist.array;

import com.huangpuguang.linearlist.ProconCollection;

/**
 * <p>动态数组</p>
 *
 * @author Procon
 * @since 2021/11/22
 */
public class ProconArrayList<E> implements ProconCollection<E> {


    /** 数组初始默认大小*/
    private static final int DEFAULT_CAPACITY = 10;
    private int size;
    private static final Object[] EMPTY_ELEMENT_DATA = {};
    transient Object[] elementData;

    public ProconArrayList(int capacity) {
        if(capacity > 0 ){
            this.elementData = new Object[capacity];
        }else if(capacity == 0){
            this.elementData = EMPTY_ELEMENT_DATA;
        }else{
            throw new IllegalArgumentException("参数错误:"+capacity);
        }
    }

    public ProconArrayList() {
        this.elementData = new Object[DEFAULT_CAPACITY];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public boolean add(Object o) {
        return false;
    }

    @Override
    public boolean add(int index, Object o) {
        // 0 1 2 3 4 5 6 7 8 9	(index)
        // 1 2 3 4 5 6 x x x x	(原数组)
        // 在index=2处，插入9，元素全部后移
        // 1 2 9 3 4 5 6 x x x	(add后数组)
        // 先从后往前开始, 将每个元素往后移一位, 然后再赋值
        if (size - 1 - index >= 0) {
            System.arraycopy(elementData, index + 1, elementData, index + 1 + 1, size - 1 - index);
        }
        //复制
        elementData[index] = o;
        size++;
        return true;
    }

    @Override
    public boolean set(int index, Object o) {
        return false;
    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public void clear() {

    }
}
