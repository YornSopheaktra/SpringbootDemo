package com.springboot.starter.base.implement;

import com.springboot.starter.base.repo.EntityRepo;
import org.hibernate.SessionFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@ConditionalOnClass(value = {DataSource.class, SessionFactory.class})
@ConditionalOnMissingBean(EntityRepoImpl.class)
@Repository
public class EntityRepoImpl extends BaseEntityRepoImp implements EntityRepo {
}
