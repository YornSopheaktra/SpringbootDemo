package com.springboot.starter.base.tools;

import org.hibernate.criterion.Criterion;
import org.hibernate.sql.JoinType;

import java.io.Serializable;

/*
 * Author: Sopheaktra Yorn
 * Date: 02-07-2019
 */
public class Association<T> implements Serializable {
    private static final long serialVersionUID = 2204191232367985114L;

    private String associationPath;
    private String alias;
    private JoinType joinType;
    private Criterion withClause;

    public Association(Class<T> entityClass) {
        this(entityClass, JoinType.INNER_JOIN);
    }

    public Association(Class<T> entityClass, JoinType joinType) {
        this(entityClass.getSimpleName().substring(0, 1).toLowerCase() + entityClass.getSimpleName().substring(1),
                entityClass.getSimpleName().substring(0, 1).toLowerCase() + entityClass.getSimpleName().substring(1),
                joinType);
    }

    public Association(String associationPath, String alias, JoinType joinType) {
        this(associationPath, alias, joinType, null);
    }

    public Association(String associationPath, String alias, JoinType joinType, Criterion withClause) {
        this.associationPath = associationPath;
        this.joinType = joinType;
        this.alias = alias;
        this.withClause = withClause;
    }

    public Association(Class<T> entityClass, String alias, JoinType joinType) {
        this(entityClass, alias, joinType, null);
    }

    public Association(Class<T> entityClass, String alias, JoinType joinType, Criterion withClause) {
        this.associationPath = entityClass.getSimpleName().toLowerCase();
        this.joinType = joinType;
        this.alias = alias;
        this.withClause = withClause;
    }

    public String getAssociationPath() {
        return associationPath;
    }

    public void setAssociationPath(String associationPath) {
        this.associationPath = associationPath;
    }

    public String getAlias() {
        return alias;
    }


    public void setAlias(String alias) {
        this.alias = alias;
    }


    public JoinType getJoinType() {
        return joinType;
    }


    public void setJoinType(JoinType joinType) {
        this.joinType = joinType;
    }

    @Override
    public boolean equals(Object obj) {
        Association assoc = (Association) obj;
        if (obj == null)
            return false;
        return assoc.getAlias().equals(alias);
    }

    public Criterion getWithClause() {
        return withClause;
    }

    public void setWithClause(Criterion withClause) {
        this.withClause = withClause;
    }

}
