package com.wocloud.config;


import com.wocloud.core.listener.CpuListener;
import com.wocloud.core.listener.DiskListener;
import com.wocloud.core.listener.MemoryListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;


/**
 * Created by shg on 2018/2/22.
 */
@Configuration
@EnableKafka
public class KafkaConfig {


//    @Bean
//    public Listener listener() {
//        return new Listener();
//    }

    @Bean
    public CpuListener cpuListener(){
        return new CpuListener();
    }

    @Bean
    public DiskListener diskListener(){
        return new DiskListener();
    }

    @Bean
    public MemoryListener memoryListener(){
        return new MemoryListener();
    }
}
