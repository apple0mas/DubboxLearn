package com.wocloud.core.scheduler;


import com.wocloud.core.dao.mongo.InstanceService;
import com.wocloud.model.po.Instance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;

/**
 * @Auther: apple0mas
 * @Date: 2018/9/21 16:21
 * @Description:
 */
@Service
public class CheckAlarmInstance {

    @Autowired
    private InstanceService instanceService;

    private final int SPACE_MINUTE_THRESHOLD = 30;//30分钟

    @Scheduled(cron = "0 0/30 * * * ?")
    public void checkInstance() {
        List<Instance> alarmInfoList = instanceService.findInstanceRunning();
        alarmInfoList.forEach(instance -> {
            boolean b = compareTime(instance.getUpdateTime());
            if (b) {
                //监控数据异常告警
            }
        });
    }

    @Scheduled(cron = "0 0/30 * * * ?")
    public void pingInstance() {
        List<String> instanceList = instanceService.findInstanceNonPing();


    }

    private boolean compareTime(long alarmTime) {
        long now = LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8"));
        return (now - alarmTime) > (SPACE_MINUTE_THRESHOLD * 60);
    }
}

