package com.springboot.starter.base.tools;

/*
 * Author: Sopheaktra Yorn
 * Date: 02-07-2019
 */
public class AssociationFilter {
    private String associationPath;
    private FieldFilter fieldFilter;

    private AssociationFilter(String associationPath, FieldFilter fieldFilter) {
        this.associationPath = associationPath;
        this.fieldFilter = fieldFilter;
    }

    public String getAssociationPath() {
        return associationPath;
    }

    public void setAssociationPath(String associationPath) {
        this.associationPath = associationPath;
    }

    public FieldFilter getFieldFilter() {
        return fieldFilter;
    }

    public void setFieldFilter(FieldFilter fieldFilter) {
        this.fieldFilter = fieldFilter;
    }

    public static AssociationFilter eq(String associationPath, String property, Object... values) {
        return new AssociationFilter(associationPath, new FieldFilter(property, FilterMode.EQUALS, values));
    }

    public static AssociationFilter ne(String associationPath, String property, Object... values) {
        return new AssociationFilter(associationPath, new FieldFilter(property, FilterMode.NOT_EQUALS, values));
    }

    public static AssociationFilter isNull(String associationPath, String property, Object... values) {
        return new AssociationFilter(associationPath, new FieldFilter(property, FilterMode.NULL, values));
    }

    public static AssociationFilter isNotNull(String associationPath, String property, Object... values) {
        return new AssociationFilter(associationPath, new FieldFilter(property, FilterMode.NOT_NULL, values));
    }
}
