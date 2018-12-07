package com.wocloud.core.dao.mongo;

import com.wocloud.model.po.InstanceGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

/**
 * @Auther: apple0mas
 * @Date: 2018/11/20 14:37
 * @Description:
 */
@Service
public class GroupService {

    @Autowired
    private MongoOperations mongoOperations;

    @Cacheable(value = "group", key = "#groupId", sync = true)
    public InstanceGroup findGroupById(String groupId) {
        InstanceGroup instanceGroup = mongoOperations.findById(groupId, InstanceGroup.class);
        return instanceGroup;
    }
}
