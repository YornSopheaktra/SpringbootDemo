package com.springboot.starter.base.implement;

import com.springboot.starter.base.repo.BaseEntityRepo;
import com.springboot.starter.base.tools.*;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.*;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;
import org.hibernate.transform.Transformers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/*
 * Author: Sopheaktra Yorn
 * Date: 02-07-2019
 */
@Repository
public abstract class BaseEntityRepoImp implements BaseEntityRepo {

    @Autowired
    SessionFactory sessionFactory;

    private Session current;

    private Logger logger = LoggerFactory.getLogger(BaseEntityRepoImp.class);

    @Override
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    protected Session getCurrentSession(){
        try {
            if (null==current){
                current= getSessionFactory().getCurrentSession();
            }
        }catch (HibernateException E){
            logger.warn("============ unable to get current connection \n so obtained the new one");
            current= getSessionFactory().openSession();
        }
        return current;
    }

    @Override
    public Connection getConnection() throws SQLException {
        return getSessionFactory().getSessionFactoryOptions().getServiceRegistry().getService(ConnectionProvider.class).getConnection();
    }

    @Override
    public DatabaseMetaData getDatabaseMetaData() throws SQLException {
        return getConnection().getMetaData();
    }

    @Override
    public String getUserName() throws SQLException {
        return getConnection().getMetaData().getUserName();
    }

    @Override
    public String getDatabaseName() throws SQLException {
        return getConnection().getMetaData().getDatabaseProductName();
    }

    @Override
    public String getDriverName() throws SQLException {
        return getConnection().getMetaData().getDriverName();
    }

    @Override
    public <T> List<T> list(Class<T> clazz, Order order) {
        return getCurrentSession().createCriteria(clazz).addOrder(order).list();
    }

    @Override
    public <T> List<T> list(BaseCriteria<T> criteria) {
        List<T> list = list(criteria.getEntityClass(),
                criteria.isDistinctRootEntity(),
                criteria.isResultTransformer(),
                criteria.getAssociations(),
                criteria.getAssociationFilters(),
                criteria.getCriterions(),
                criteria.getProjections(),
                criteria.getAliases(),
                criteria.getFirstResult(),
                criteria.getMaxResults(),
                criteria.getOrders(),
                criteria.getLockType());
        return list;
    }

    @Override
    public <T> List<T> list(Class<T> clazz) {
        return getCurrentSession().createCriteria(clazz).list();
    }

    @Override
    public <T> List<T> listByPage(Class<T> clazz, int pageNum, int pageSize) {
        return getCurrentSession().createCriteria(clazz).setFirstResult(pageNum).setMaxResults(pageSize).list();
    }

    @Override
    public <T> List<T> listByPage(BaseCriteria<T> criteria, int pageNum, int pageSize) {
        return null;
    }

    @Override
    public <T extends Entity> Map<Integer, T> map(Class<T> clazz) {
        return null;
    }

    @Override
    public <T extends Entity> Map<Integer, T> map(Class<T> clazz, Order order) {
        return null;
    }

    @Override
    public <T extends Entity> Map<Integer, T> map(BaseCriteria<T> criteria) {
        return null;
    }

    @Override
    public <T extends Entity> Map<Integer, T> mapByPage(BaseCriteria<T> criteria, int pageNum, int pageSize) {
        return null;
    }

    @Override
    public <T> T getEntityByProperty(String property, Object value, Class<T> clazz) {
        return null;
    }

    @Override
    public <T> T getEntityByProperties(String[] properties, Object[] values, Class<T> clazz) {
        return null;
    }

    @Override
    public <T> List<T> getEntitiesByProperty(String property, Object value, Class<T> clazz) {
        return null;
    }

    @Override
    public <T> List<T> getEntitiesByProperties(String[] properties, Object[] values, Class<T> clazz) {
        return null;
    }

    @Override
    public <T> List<T> getEntitiesByProperty(String property, Object value, Order order, Class<T> clazz) {
        return null;
    }

    @Override
    public <T> List<T> getEntitiesByProperties(String[] properties, Object[] values, Order order, Class<T> clazz) {
        return null;
    }

    @Override
    public <T> T getEntityById(Serializable id, Class<T> clazz) {
        return null;
    }

    @Override
    public <T> T loadEntityById(Serializable id, Class<T> clazz) {
        return null;
    }

    @Override
    public int executeUpdate(String sql) {
        return 0;
    }

    @Override
    public Object uniqueResult(String sql) {
        return null;
    }

    @Override
    public <T> List<T> resultList(String sql) {
        return null;
    }

    @Override
    public <T> List<T> sqlQuery(String sql, Map<String, Object> parameter, Class<T> clazz) {
        return null;
    }

    @Override
    public List hsqlQuery(String hsql, Map<String, Object> parameter) {
        return null;
    }

    @Override
    public <T> void save(T entity) {

    }

    @Override
    public <T> void saveOrUpdate(T entity) {

    }

    @Override
    public <T> void save(List<T> entities) {

    }

    @Override
    public <T> void saveOrUpdate(List<T> entities) {

    }

    @Override
    public <T> void delete(Serializable id, Class<T> clazz) {

    }

    @Override
    public <T> void delete(T entity) {

    }

    @Override
    public <T> void delete(List<T> entities) {

    }

    @Override
    public <T> void delete(BaseCriteria<T> criteria) {

    }

    @Override
    public <T> void evict(T entity) {

    }

    @Override
    public <T> void merge(T entity) {

    }

    @Override
    public <T> void persist(T entity) {

    }

    @Override
    public <T extends Entity> List<T> serializeMap(BaseCriteria<T> criteria) {
        return null;
    }

    @Override
    public <T> List<T> list(BaseCriteria criteria, Class<T> clazz) {
        return null;
    }

    @Override
    public <T> T getEntityByCriteria(BaseCriteria criteria) {
        return null;
    }

    private <T> List<T> list(Class<T> clazz, boolean isDistinctRootEntity, boolean isResultTransformer, List<Association> associations, List<AssociationFilter> associationFilters, List<Criterion> criterions, List<Projection> projections, List<AliasField> aliases, Integer firstResult, Integer maxResults, List<Order> orders, LockType lockType) {

        Criteria criteria = getCurrentSession().createCriteria(clazz);

        if (isDistinctRootEntity)
            criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

        if (associations != null) {
            for (Association association : associations) {
                if (association != null) {
                    criteria.createAlias(
                            association.getAssociationPath(),
                            association.getAlias(),
                            association.getJoinType(),
                            association.getWithClause());
                }
            }
        }

        if (criterions != null) {
            for (Criterion criterion : criterions) {
                if (criterion != null) {
                    criteria = criteria.add(criterion);
                }
            }
        }

        if (projections != null) {
            ProjectionList projList = Projections.projectionList();
            for (Projection proj : projections) {
                if (proj != null) {
                    projList.add(proj);
                }
            }
            if (projList != null && projList.getLength() > 0) {
                criteria.setProjection(projList);
                if (isResultTransformer)
                    criteria.setResultTransformer(Transformers.aliasToBean(clazz));

            }
        }

        if (orders != null) {
            for (Order order : orders) {
                if (order != null) {
                    criteria = criteria.addOrder(order);
                }
            }
        }

        if (firstResult != null)
            criteria.setFirstResult(firstResult);

        if (maxResults != null)
            criteria.setMaxResults(maxResults);

        if (lockType.getMode() != null) {
            if (lockType.getName() != null && !lockType.getName().isEmpty())
                criteria.setLockMode(lockType.getName(), lockType.getMode());
            else
                criteria.setLockMode(lockType.getMode());
        }

        return criteria.list();
    }

}
