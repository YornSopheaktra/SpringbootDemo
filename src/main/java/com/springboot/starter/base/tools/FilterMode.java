package com.springboot.starter.base.tools;


/*
 * Author: Sopheaktra Yorn
 * Date: 02-07-2019
 */
public class FilterMode {
    public static final FilterMode EQUALS = new FilterMode(0);
    public static final FilterMode GREATER_THAN = new FilterMode(1);
    public static final FilterMode GREATER_OR_EQUALS = new FilterMode(2);
    public static final FilterMode LESS_THAN = new FilterMode(3);
    public static final FilterMode LESS_OR_EQUALS = new FilterMode(4);
    public static final FilterMode BETWEEN = new FilterMode(5);
    public static final FilterMode NULL = new FilterMode(6);
    public static final FilterMode BLANK = new FilterMode(7);
    public static final FilterMode EMPTY = new FilterMode(8);
    public static final FilterMode NOT_EMPTY = new FilterMode(9);
    public static final FilterMode IN = new FilterMode(10);
    public static final FilterMode NOT_EQUALS = new FilterMode(11);
    public static final FilterMode NOT_NULL = new FilterMode(12);

    protected int value;

    public FilterMode() {

    }

    protected FilterMode(int value) {
        this.value = value;
    }


    public FilterMode getDefaultFilterMode() {
        return EQUALS;
    }


    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        return obj != null && obj instanceof FilterMode &&
                ((FilterMode) obj).value == this.value;
    }
}
