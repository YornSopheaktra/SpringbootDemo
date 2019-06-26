package com.springboot.starter.base.tools;

import java.util.Objects;

public class AliasField {
    private String fieldName;
    private String aliasName;

    public AliasField() {
    }

    public AliasField(String fieldName, String aliasName) {
        this.fieldName = fieldName;
        this.aliasName = aliasName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getAliasName() {
        return aliasName;
    }

    public void setAliasName(String aliasName) {
        this.aliasName = aliasName;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fieldName, aliasName);
    }

    @Override
    public boolean equals(Object obj) {
        return obj != null && obj instanceof AliasField
                && ((AliasField) obj).aliasName.equals(this.aliasName)
                && ((AliasField) obj).fieldName.equals(this.fieldName);
    }
}
