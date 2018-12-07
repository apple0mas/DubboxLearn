package com.wocloud.core.dao.mongo;

import com.wocloud.model.po.AlarmPolicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

/**
 * @Auther: apple0mas
 * @Date: 2018/11/20 14:37
 * @Description:
 */
@Service
public class PolicyService {

    @Autowired
    private MongoOperations mongoOperations;

    @Cacheable(value = "policy", key = "#policyId", sync = true)
    public AlarmPolicy findPolicyById(String policyId) {
        return mongoOperations.findById(policyId, AlarmPolicy.class);
    }

    public AlarmPolicy findDefaultAlarmPolicy() {
        return mongoOperations.findOne(new Query(Criteria.where("policyType").is("default")), AlarmPolicy.class);
    }

}
