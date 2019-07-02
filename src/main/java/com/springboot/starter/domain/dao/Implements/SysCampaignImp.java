package com.springboot.starter.domain.dao.Implements;

import com.springboot.starter.base.repo.EntityRepo;
import com.springboot.starter.base.tools.BaseCriteria;
import com.springboot.starter.domain.Entity.SysCampaign;
import com.springboot.starter.domain.dao.SysCampaignDao;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * Author: Sopheaktra Yorn
 * Date: 02-07-2019
 */

@Service
public class SysCampaignImp implements SysCampaignDao {

    @Autowired
    EntityRepo repo;

    @Override
    public SysCampaign getSysCampaignById(Integer id) {
        try {
            BaseCriteria<SysCampaign> criteria = new BaseCriteria<>(SysCampaign.class);
            criteria.addCriterion(Restrictions.eq("id",id));
            criteria.setMaxResults(1);
            return repo.list(criteria).get(0);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
