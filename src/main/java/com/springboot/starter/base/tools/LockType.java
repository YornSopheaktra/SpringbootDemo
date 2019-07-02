package com.springboot.starter.base.tools;

import org.hibernate.LockMode;

import java.util.Objects;


/*
 * Author: Sopheaktra Yorn
 * Date: 02-07-2019
 */
public class LockType {
    private LockMode mode;
    private String name;

    public LockType() {
    }

    public LockType(LockMode mode, String name) {
        this.mode = mode;
        this.name = name;
    }

    public LockMode getMode() {
        return mode;
    }

    public void setMode(LockMode mode) {
        this.mode = mode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(mode, name);
    }

    @Override
    public boolean equals(Object obj) {
        return obj != null && obj instanceof LockType
                && ((LockType) obj).name.equals(this.name)
                && ((LockType) obj).mode.equals(mode);
    }
}
