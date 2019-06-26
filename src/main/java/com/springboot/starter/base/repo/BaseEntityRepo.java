package com.springboot.starter.base.repo;


import com.springboot.starter.base.tools.BaseCriteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Entity;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Transactional(propagation = Propagation.NESTED, isolation = Isolation.READ_COMMITTED)
public interface BaseEntityRepo {

    SessionFactory getSessionFactory();

    Connection getConnection() throws SQLException;

    DatabaseMetaData getDatabaseMetaData() throws SQLException;

    String getUserName() throws SQLException;

    String getDatabaseName() throws SQLException;

    String getDriverName() throws SQLException;

/*
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    <T> List<T> list(Class<T> clazz, boolean distinctRootEntity, boolean resultTransformer, List<Association> associations, List<AssociationFilter> associationFilters, List<Criterion> criterions, List<Projection> projections, List<AliasField> aliases, Integer firstResult, Integer maxResults, List<Order> orders, LockType lockType);
*/

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    <T> List<T> list(Class<T> clazz, Order order);

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    <T> List<T> list(BaseCriteria<T> criteria);

    <T> List<T> list(Class<T> clazz);

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    <T> List<T> listByPage(Class<T> clazz, int pageNum, int pageSize);

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    <T> List<T> listByPage(BaseCriteria<T> criteria, int pageNum, int pageSize);

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    <T extends Entity> Map<Integer, T> map(Class<T> clazz);

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    <T extends Entity> Map<Integer, T> map(Class<T> clazz, Order order);

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    <T extends Entity> Map<Integer, T> map(BaseCriteria<T> criteria);

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    <T extends Entity> Map<Integer, T> mapByPage(BaseCriteria<T> criteria, int pageNum, int pageSize);

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    <T> T getEntityByProperty(String property, Object value, Class<T> clazz);

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    <T> T getEntityByProperties(String[] properties, Object[] values, Class<T> clazz);

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    <T> List<T> getEntitiesByProperty(String property, Object value, Class<T> clazz);

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    <T> List<T> getEntitiesByProperties(String[] properties, Object[] values, Class<T> clazz);

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    <T> List<T> getEntitiesByProperty(String property, Object value, Order order, Class<T> clazz);

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    <T> List<T> getEntitiesByProperties(String[] properties, Object[] values, Order order, Class<T> clazz);

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    <T> T getEntityById(Serializable id, Class<T> clazz);

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    <T> T loadEntityById(Serializable id, Class<T> clazz);

    @Transactional(rollbackFor = Throwable.class, propagation = Propagation.REQUIRED)
    int executeUpdate(String sql);

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    Object uniqueResult(String sql);

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    <T> List<T> resultList(String sql);

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    <T> List<T> sqlQuery(String sql, Map<String, Object> parameter, Class<T> clazz);

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    List hsqlQuery(String hsql, Map<String, Object> parameter);

    @Transactional(rollbackFor = Throwable.class, propagation = Propagation.REQUIRED)
    <T> void save(T entity);

    @Transactional(rollbackFor = Throwable.class, propagation = Propagation.REQUIRED)
    <T> void saveOrUpdate(T entity);

    @Transactional(rollbackFor = Throwable.class, propagation = Propagation.REQUIRED)
    <T> void save(List<T> entities);

    @Transactional(rollbackFor = Throwable.class, propagation = Propagation.REQUIRED)
    <T> void saveOrUpdate(List<T> entities);

    @Transactional(rollbackFor = Throwable.class, propagation = Propagation.REQUIRED)
    <T> void delete(Serializable id, Class<T> clazz);

    @Transactional(rollbackFor = Throwable.class, propagation = Propagation.REQUIRED)
    <T> void delete(T entity);

    @Transactional(rollbackFor = Throwable.class, propagation = Propagation.REQUIRED)
    <T> void delete(List<T> entities);

    @Transactional(rollbackFor = Throwable.class, propagation = Propagation.REQUIRED)
    <T> void delete(BaseCriteria<T> criteria);

    <T> void evict(T entity);

    <T> void merge(T entity);

    <T> void persist(T entity);

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    <T extends Entity> List<T> serializeMap(BaseCriteria<T> criteria);

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    <T> List<T> list(BaseCriteria criteria, Class<T> clazz);

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    <T> T getEntityByCriteria(BaseCriteria criteria);

}
