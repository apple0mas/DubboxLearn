package com.wocloud.config;

import com.wocloud.core.dao.mongo.AlarmMongoService;
import com.wocloud.model.po.AlarmDictionary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Auther: apple0mas
 * @Date: 2018/10/29 16:32
 * @Description:
 */
@Component
public class MyCommandLineRunner implements CommandLineRunner {

    @Autowired
    private AlarmMongoService mongoService;

    @Autowired
    private CacheManager cacheManager;

    @Override
    public void run(String... strings) throws Exception {
        List<AlarmDictionary> dictionaryList = mongoService.findAllDictionary();
        Cache cache = cacheManager.getCache(GuavaCacheConfig.Caches.dictionary.name());
        for (AlarmDictionary dictionary : dictionaryList) {
            cache.put(dictionary.getType() + "-" + dictionary.getName(), dictionary);
        }
    }
}
