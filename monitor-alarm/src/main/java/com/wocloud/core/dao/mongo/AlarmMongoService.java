package com.wocloud.core.dao.mongo;


import com.wocloud.model.po.AlarmDictionary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: apple0mas
 * @Date: 2018/10/19 11:31
 * @Description:
 */
@Service
public class AlarmMongoService {

    @Autowired
    private MongoOperations mongoOperations;

    public List<AlarmDictionary> findAllDictionary() {
        List<AlarmDictionary> dictionaryList = mongoOperations.findAll(AlarmDictionary.class);
        return dictionaryList;
    }

    @Cacheable(value = "dictionary", sync = true, key = "#alarmDictionary.type.concat('-').concat(#alarmDictionary.name)")
    public AlarmDictionary findOneDictionary(AlarmDictionary alarmDictionary) {
        AlarmDictionary dictionary = mongoOperations.findOne(
                new Query(Criteria.where("name").is(alarmDictionary.getName())), AlarmDictionary.class);
        return dictionary;
    }

    public List<AlarmDictionary> findDictionaryByType(String type) {
        List<AlarmDictionary> dictionaryList = mongoOperations.find(
                new Query(Criteria.where("type").is(type)), AlarmDictionary.class);
        return dictionaryList;
    }

}
