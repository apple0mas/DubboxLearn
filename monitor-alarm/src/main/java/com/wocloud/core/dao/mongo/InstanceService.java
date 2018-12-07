package com.wocloud.core.dao.mongo;

import com.google.common.collect.Lists;
import com.wocloud.model.po.Instance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: apple0mas
 * @Date: 2018/11/20 14:37
 * @Description:
 */
@Service
public class InstanceService {

    @Autowired
    private MongoOperations mongoOperations;

    public List<String> findInstanceNonPing(){
        ArrayList<String> list = Lists.newArrayList();
//        List<String> list = mongoOperations.find(new Query(), String.class, "");
        return list;
    }

    public List<Instance> findInstanceRunning(){
        ArrayList<Instance> list = Lists.newArrayList();
        //运行中虚拟机
        List<Instance> vmInstanceList = mongoOperations.find(
                new Query(
                        Criteria.where("vm_state").is("running")),
                Instance.class, "vm_info");
        //运行中物理机
        List<Instance> HyInstanceList = mongoOperations.find(
                new Query(
                        Criteria.where("state").is("running")),
                Instance.class, "hypervisor_host");
        list.addAll(vmInstanceList);
        list.addAll(HyInstanceList);
        return list;
    }
}
