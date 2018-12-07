package com.wocloud.core.dao.mongo;

import com.wocloud.model.po.InstanceGroupRelation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: apple0mas
 * @Date: 2018/11/20 14:37
 * @Description:
 */
@Service
public class GroupRelationService {

    @Autowired
    private MongoOperations mongoOperations;

    public List<InstanceGroupRelation> findGroupByInstanceId(String instanceId) {
        return mongoOperations.find(new Query(Criteria.where("instanceId").is(instanceId)), InstanceGroupRelation.class);
    }
}
