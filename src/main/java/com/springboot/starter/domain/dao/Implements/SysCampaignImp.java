package com.springboot.starter.domain.dao.Implements;

import com.springboot.starter.base.implement.BaseEntityRepoImp;
import com.springboot.starter.base.tools.BaseCriteria;
import com.springboot.starter.base.repo.EntityRepo;
import com.springboot.starter.domain.Entity.SysCampaign;
import com.springboot.starter.domain.dao.SysCampaignDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysCampaignImp implements SysCampaignDao {

    @Autowired
    private SessionFactory sessionFactory;

   /* @Autowired
    BaseEntityRepoImp repo;*/

    @Override
    public SysCampaign getSysCampaignById(Integer id) {
        Session session = sessionFactory.openSession();
        try {
            BaseCriteria<SysCampaign> criteria = new BaseCriteria<>(SysCampaign.class);
            //return (SysCampaign) repo.list(criteria);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return new SysCampaign();
    }
}
