package com.springboot.starter.base.tools;

import org.hibernate.LockMode;
import org.hibernate.criterion.*;
import org.hibernate.sql.JoinType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.Serializable;
import java.util.*;

/*
 * Author: Sopheaktra Yorn
 * Date: 02-07-2019
 */
public class BaseCriteria<T> implements Serializable {

    protected static Logger logger = LoggerFactory.getLogger(BaseCriteria.class);
    protected static final String DOT = ".";

    private Class<T> entityClass;
    private List<ColumnInfo> columnInfo = new ArrayList();
    private List<Association> associations = new ArrayList();
    private List<Criterion> criterions = new ArrayList();
    private Integer firstResult;
    private Integer maxResults;
    private List<Order> orders = new ArrayList();
    private List<AssociationFilter> associationFilters = new ArrayList();
    private Map<String, Object> criterias = new HashMap();
    private Map<String, FieldFilter> aliasJson = new HashMap();
    private List<Projection> projections = new ArrayList();
    private List<AliasField> aliases = new ArrayList();
    private boolean isDistinctRootEntity = false;
    private boolean isIgnoreMandatoryField = false;
    private boolean isResultTransformer = false;
    private LockType lockType = new LockType();

    public BaseCriteria(Class<T> clazz) {
        entityClass = clazz;
    }

    public <T> Association addAssociation(Class<T> entityClass) {
        Association assoc = new Association(entityClass);
        if (associations.contains(assoc)) {
            throw new IllegalArgumentException("The alias [" + assoc.getAlias() + "] is already used.");
        }
        associations.add(assoc);
        return assoc;
    }

    public <T> Association addAssociation(Class<T> entityClass, String alias, JoinType joinType) {
        Association assoc = new Association(entityClass, alias, joinType);
        if (associations.contains(assoc)) {
            throw new IllegalArgumentException("The alias [" + alias + "] is already used.");
        }
        associations.add(assoc);
        return assoc;
    }


    public Association addAssociation(String associationPath) {
        return addAssociation(associationPath, associationPath, JoinType.INNER_JOIN);
    }

    public Association addAssociation(String associationPath, JoinType joinType) {
        return addAssociation(associationPath, associationPath, joinType);
    }

    public Association addAssociation(String associationPath, String alias) {
        Association assoc = new Association(associationPath, alias, JoinType.INNER_JOIN);
        if (associations.contains(assoc)) {
            logger.warn("The alias [" + alias + "] has been already added.");
        } else {
            associations.add(assoc);
        }
        return assoc;
    }

    public Association addAssociation(String associationPath, String alias, JoinType joinType) {
        Association assoc = new Association(associationPath, alias, joinType);
        if (associations.contains(assoc)) {
            logger.warn("The alias [" + alias + "] has been already added.");
        } else {
            associations.add(assoc);
        }
        return assoc;
    }

    public Association addAssociation(String associationPath, String alias, JoinType joinType, Criterion withClause) {
        Association assoc = new Association(associationPath, alias, joinType, withClause);
        if (associations.contains(assoc)) {
            logger.warn("The alias [" + alias + "] has been already added.");
        } else {
            associations.add(assoc);
        }
        return assoc;
    }

    public <T> Association addAssociation(Class<T>... entityClasses) {
        return addAssociation(entityClasses[entityClasses.length - 1].getSimpleName().toLowerCase(), JoinType.INNER_JOIN, entityClasses);
    }

    public <T> Association addAssociation(String alias, Class<T>... entityClasses) {
        return addAssociation(alias, JoinType.INNER_JOIN, entityClasses);
    }

    public <T> Association addAssociation(String alias, JoinType joinType, Class<T>... entityClasses) {
        String associationPath = entityClasses[0].getSimpleName().toLowerCase();
        for (int i = 1; i < entityClasses.length; i++) {
            associationPath += DOT + entityClasses[i].getSimpleName().toLowerCase();
        }
        Association assoc = new Association(associationPath, alias, joinType);
        if (associations.contains(assoc)) {
            throw new IllegalArgumentException("The alias [" + alias + "] is already used.");
        }
        associations.add(assoc);
        return assoc;
    }

    public BaseCriteria<T> addCriterion(Criterion criterion) {
        criterions.add(criterion);
        return this;
    }

    public Class<T> getEntityClass() {
        return entityClass;
    }

    public void setEntityClass(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public List<Association> getAssociations() {
        return associations;
    }

    public void setAssociations(List<Association> associations) {
        this.associations = associations;
    }

    public List<Criterion> getCriterions() {
        return criterions;
    }

    public void setCriterions(List<Criterion> criterions) {
        this.criterions = criterions;
    }

    public Integer getFirstResult() {
        return firstResult;
    }

    public void setFirstResult(Integer firstResult) {
        this.firstResult = firstResult;
    }

    public Integer getMaxResults() {
        return maxResults;
    }

    public void setMaxResults(Integer maxResults) {
        this.maxResults = maxResults;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public BaseCriteria<T> addOrder(Order order) {
        orders.add(order);
        return this;
    }

    public BaseCriteria<T> setOrder(Order order) {
        orders.add(order);
        return this;
    }

    public Order getOrder() {
        return orders.isEmpty() ? null : orders.get(0);
    }

    public BaseCriteria<T> addCriterion(String columname, FilterMode comparator, Object... values) {
        criterias.put(columname, new Object[]{comparator, values});
        return this;
    }

    public BaseCriteria<T> addCriterion(String columname, Serializable... values) {
        FilterMode comparator = new FilterMode();
        criterias.put(columname, new Object[]{comparator.getDefaultFilterMode(), values});
        return this;
    }

    private BaseCriteria<T> addCriterion(FieldFilter filter) {
        Criterion criterion = null;
        if (filter.getFilterMode().equals(FilterMode.BETWEEN)) {
            criterion = Restrictions.between(filter.getFieldName(), filter.getFieldValue(), filter.getField2Value());
            criterions.add(criterion);
        } else if (filter.getFilterMode().equals(FilterMode.IN)) {
            if (filter.getFieldValues()[0] instanceof Collection) {
                criterion = Restrictions.in(filter.getFieldName(), (Collection) filter.getFieldValues()[0]);
            } else if (filter.getFieldValues()[0] instanceof Object[]) {
                criterion = Restrictions.in(filter.getFieldName(), (Object[]) filter.getFieldValues()[0]);
            } else {
                criterion = Restrictions.in(filter.getFieldName(), filter.getFieldValues());
            }
            criterions.add(criterion);
        } else if (filter.getFilterMode().equals(FilterMode.BLANK)) {
            criterion = Restrictions.eq(filter.getFieldName(), "");
            criterions.add(criterion);
        } else if (filter.getFilterMode().equals(FilterMode.NULL)) {
            criterion = Restrictions.isNull(filter.getFieldName());
            criterions.add(criterion);
        } else if (filter.getFilterMode().equals(FilterMode.EMPTY)) {
            criterion = Restrictions.isEmpty(filter.getFieldName());
            criterions.add(criterion);
        } else if (filter.getFilterMode().equals(FilterMode.NOT_EMPTY)) {
            criterion = Restrictions.isNotEmpty(filter.getFieldName());
            criterions.add(criterion);
        } else {
            Criterion[] criteria = new Criterion[filter.getFieldValues().length];
            for (int i = 0; i < filter.getFieldValues().length; i++) {
                criterion = null;
                Object value = filter.getFieldValues()[i];

                if (filter.getFilterMode().equals(FilterMode.EQUALS)) {
                    criterion = Restrictions.eq(filter.getFieldName(), value);
                } else if (filter.getFilterMode().equals(FilterMode.GREATER_THAN)) {
                    criterion = Restrictions.gt(filter.getFieldName(), value);
                } else if (filter.getFilterMode().equals(FilterMode.GREATER_OR_EQUALS)) {
                    criterion = Restrictions.ge(filter.getFieldName(), value);
                } else if (filter.getFilterMode().equals(FilterMode.LESS_THAN)) {
                    criterion = Restrictions.lt(filter.getFieldName(), value);
                } else if (filter.getFilterMode().equals(FilterMode.LESS_OR_EQUALS)) {
                    criterion = Restrictions.le(filter.getFieldName(), value);
                } else if (filter.getFilterMode().equals(FilterMode.BLANK)) {
                    criterion = Restrictions.eq(filter.getFieldName(), "");
                } else if (filter.getFilterMode().equals(FilterMode.NULL)) {
                    criterion = Restrictions.isNull(filter.getFieldName());
                } else if (filter.getFilterMode().equals(FilterMode.EMPTY)) {
                    criterion = Restrictions.isEmpty(filter.getFieldName());
                } else if (filter.getFilterMode().equals(FilterMode.NOT_EMPTY)) {
                    criterion = Restrictions.isNotEmpty(filter.getFieldName());
                } else if (filter.getFilterMode().equals(StringFilterMode.CONTAINS)) {
                    criterion = Restrictions.ilike(filter.getFieldName(), (String) value, MatchMode.ANYWHERE);
                } else if (filter.getFilterMode().equals(StringFilterMode.START_WITH)) {
                    criterion = Restrictions.ilike(filter.getFieldName(), (String) value, MatchMode.START);
                } else if (filter.getFilterMode().equals(StringFilterMode.END_WITH)) {
                    criterion = Restrictions.ilike(filter.getFieldName(), (String) value, MatchMode.END);
                } else if (filter.getFilterMode().equals(StringFilterMode.DOES_NOT_CONTAIN)) {
                    criterion = Restrictions.not(Restrictions.ilike(filter.getFieldName(), (String) value, MatchMode.ANYWHERE));
                }
                criteria[i] = criterion;
            }

            criterions.add(Restrictions.or(criteria));
        }
        return this;
    }

    public LockType getLockType() {
        return lockType;
    }

    public BaseCriteria setLockMode(LockMode mode) {
        return setLockMode(null, mode);
    }

    public BaseCriteria setLockMode(String name, LockMode mode) {
        this.lockType.setName(name);
        this.lockType.setMode(mode);
        return this;
    }

    public List<Projection> getProjections() {
        return projections;
    }

    public void setProjections(List<Projection> projections) {
        this.projections = projections;
    }

    public BaseCriteria<T> addProjection(Projection projection) {
        this.projections.add(projection);
        return this;
    }

    public BaseCriteria<T> column(String... columns) {
        for (String column : columns) {
            addAliasJson(column, new FieldFilter(column, null, null));
            addProjection(Projections.projectionList().add(Projections.property(column).as(column)));
        }
        return this;
    }

    public BaseCriteria<T> createAlias(String fieldName, String aliasName) {
        aliases.add(new AliasField(fieldName, aliasName));
        return this;
    }

    public List<AliasField> getAliases() {
        return aliases;
    }

    public void setAliases(List<AliasField> aliases) {
        this.aliases = aliases;
    }

    public boolean isDistinctRootEntity() {
        return isDistinctRootEntity;
    }

    public void setDistinctRootEntity(boolean isDistinctRootEntity) {
        this.isDistinctRootEntity = isDistinctRootEntity;
    }

    public List<ColumnInfo> getColumnInfo() {
        return columnInfo;
    }

    public BaseCriteria<T> addColumn(ColumnInfo colInfo) {
        columnInfo.add(colInfo);
        return this;
    }

    public boolean isResultTransformer() {
        return isResultTransformer;
    }

    public void setResultTransformer(boolean resultTransformer) {
        isResultTransformer = resultTransformer;
    }

    public boolean isIgnoreMandatoryField() {
        return isIgnoreMandatoryField;
    }

    public void setIgnoreMandatoryField(boolean ignoreMandatoryField) {
        isIgnoreMandatoryField = ignoreMandatoryField;
    }

    public List<AssociationFilter> getAssociationFilters() {
        return associationFilters;
    }

    public void setAssociationFilters(List<AssociationFilter> associationFilters) {
        this.associationFilters = associationFilters;
    }

    public BaseCriteria<T> addAssociationFilter(AssociationFilter associationFilter) {
        this.associationFilters.add(associationFilter);
        return this;
    }

    public Map<String, FieldFilter> getAliasJson() {
        if (aliasJson.isEmpty())
            aliasJson = FieldFilter.aliasField(entityClass);
        if (isIgnoreMandatoryField)
            excludeAliasJson("createdAt", "updatedAt", "createdBy", "updatedBy");
        return aliasJson;
    }

    public void setAliasJson(Map<String, FieldFilter> aliasJson) {
        this.aliasJson = aliasJson;
    }

    public BaseCriteria<T> addAliasJson(String[] keys, String[] properties) {
        if (keys.length > properties.length || properties.length > keys.length)
            throw new IllegalArgumentException("Alias json keys and properties are not equal");
        for (int i = 0; i < keys.length; i++)
            addAliasJson(keys[i], new FieldFilter(properties[i], null, null));
        return this;
    }

    public BaseCriteria<T> addAliasJson(String key, String property) {
        return addAliasJson(key, new FieldFilter(property, null, null));
    }

    public BaseCriteria<T> excludeAliasJson(String... properties) {
        for (String field : properties)
            aliasJson.remove(field);
        return this;
    }

    private BaseCriteria<T> addAliasJson(String key, FieldFilter fieldFilter) {
        aliasJson.put(key, fieldFilter);
        return this;
    }

}

