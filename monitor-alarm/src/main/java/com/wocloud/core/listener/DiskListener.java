package com.wocloud.core.listener;

import com.alibaba.fastjson.JSONObject;
import com.wocloud.constants.Constants;
import com.wocloud.core.controller.ConditionAlarmController;
import com.wocloud.model.dto.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

/**
 * @Auther: apple0mas
 * @Date: 2018/9/18 11:15
 * @Description:
 */
@Slf4j
public class DiskListener {

    @Autowired
    private ConditionAlarmController alarmController;

    @KafkaListener(topics = Constants.Topic.VM_LINUX_DISK, id = "vm_linux_disk")
    public void vmLinuxDiskConsume(ConsumerRecord<?, ?> record) {
        String msg = record.value().toString();
        String topic = record.topic();
        VmLinuxDiskMessage vmLinuxDiskMessage = JSONObject.parseObject(msg, VmLinuxDiskMessage.class);
        vmLinuxDiskMessage.setTopic(topic);
        alarmController.conditionAlarm(vmLinuxDiskMessage);
    }

    @KafkaListener(topics = Constants.Topic.VM_WIN_DISK, id = "vm_win_disk")
    public void vmWinDiskConsume(ConsumerRecord<?, ?> record) {
        String msg = record.value().toString();
        String topic = record.topic();
        VmWinDiskMessage vmWinDiskMessage = JSONObject.parseObject(msg, VmWinDiskMessage.class);
        if (vmWinDiskMessage.getFields().getPercent_free_space() == null) {
            return;
        }
        vmWinDiskMessage.setTopic(topic);
        alarmController.conditionAlarm(vmWinDiskMessage);
    }

    @KafkaListener(topics = Constants.Topic.HYPERVISOR_DISK, id = "hypervisor_disk")
    public void hypervisorDiskConsume(ConsumerRecord<?, ?> record) {
        String msg = record.value().toString();
        String topic = record.topic();
        HDiskMessage hDiskMessage = JSONObject.parseObject(msg, HDiskMessage.class);
        hDiskMessage.setTopic(topic);
        alarmController.conditionAlarm(hDiskMessage);
    }

    @KafkaListener(topics = Constants.Topic.PHY_DISK, id = "phy_disk")
    public void phyDiskConsume(ConsumerRecord<?, ?> record) {
        String msg = record.value().toString();
        String topic = record.topic();
        PhyDiskMessage phyDiskMessage = JSONObject.parseObject(msg, PhyDiskMessage.class);
        phyDiskMessage.setTopic(topic);
        alarmController.conditionAlarm(phyDiskMessage);
    }

    @KafkaListener(topics = Constants.Topic.MANAGEMENT_DISK, id = "management_disk")
    public void manageDiskConsume(ConsumerRecord<?, ?> record) {
        String msg = record.value().toString();
        String topic = record.topic();
        ManageDiskMessage manageDiskMessage = JSONObject.parseObject(msg, ManageDiskMessage.class);
        manageDiskMessage.setTopic(topic);
        alarmController.conditionAlarm(manageDiskMessage);
    }
}
