package com.springboot.starter.base.implement;

import com.springboot.starter.base.repo.EntityRepo;
import org.hibernate.SessionFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

/*
    * Author: Sopheaktra Yorn
    * Date: 02-07-2019
*/
@ConditionalOnClass(value = {DataSource.class, SessionFactory.class})
@Repository
public class EntityRepoImpl extends BaseEntityRepoImp implements EntityRepo {

}
