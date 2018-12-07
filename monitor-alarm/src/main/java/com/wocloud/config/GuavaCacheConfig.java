package com.wocloud.config;

import com.google.common.cache.CacheBuilder;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.guava.GuavaCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: apple0mas
 * @Date: 2018/10/25 16:54
 * @Description:
 */
@Configuration
@EnableCaching
public class GuavaCacheConfig {

    private static final int DEFAULT_MAXSIZE = 1000;
    private static final int DEFAULT_TTL = 3600;

    /**
     * 定义cache名称、超时时长秒、最大个数
     * 每个cache缺省3600秒过期，最大个数1000
     */
    public enum Caches {
        policy(2 * 60, 1000), group(3 * 60, 100),
        dictionary(60*60,100);

        Caches() {
        }

        Caches(int ttl) {
            this.ttl = ttl;
        }

        Caches(int ttl, int maxSize) {
            this.ttl = ttl;
            this.maxSize = maxSize;
        }

        private int maxSize = DEFAULT_MAXSIZE; //最大數量
        private int ttl = DEFAULT_TTL; //过期时间（秒）

        public int getMaxSize() {
            return maxSize;
        }

        public void setMaxSize(int maxSize) {
            this.maxSize = maxSize;
        }

        public int getTtl() {
            return ttl;
        }

        public void setTtl(int ttl) {
            this.ttl = ttl;
        }
    }

    /**
     * 个性化配置缓存
     */
    @Bean
    public CacheManager cacheManagers() {
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        //把各个cache注册到cacheManager中，GuavaCache实现了org.springframework.cache.Cache接口
        ArrayList<GuavaCache> caches = new ArrayList<>();
        for (Caches c : Caches.values()) {
            caches.add(new GuavaCache(c.name(), CacheBuilder.newBuilder().recordStats().expireAfterWrite(c.getTtl(), TimeUnit.SECONDS).maximumSize(c.getMaxSize()).build()));
        }
        cacheManager.setCaches(caches);
        return cacheManager;
    }

//    @Bean
//    public CacheManager cacheManager() {
//        GuavaCacheManager cacheManager = new GuavaCacheManager();
//        cacheManager.setCacheBuilder(CacheBuilder.newBuilder().expireAfterWrite(2, TimeUnit.MINUTES).maximumSize(1000));
//        return cacheManager;
//    }
}
