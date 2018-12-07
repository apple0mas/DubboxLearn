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
public class MemoryListener {

    @Autowired
    private ConditionAlarmController alarmController;

    @KafkaListener(topics = Constants.Topic.VM_LINUX_MEM, id = "vm_linux_mem")
    public void vmLinuxMemoryConsume(ConsumerRecord<?, ?> record) {
        String msg = record.value().toString();
        String topic = record.topic();
        VmLinuxMemoryMessage vmLinuxMemoryMessage = JSONObject.parseObject(msg, VmLinuxMemoryMessage.class);
        vmLinuxMemoryMessage.setTopic(topic);
        alarmController.conditionAlarm(vmLinuxMemoryMessage);
    }

    @KafkaListener(topics = Constants.Topic.VM_WIN_MEM, id = "vm_win_mem")
    public void vmWinMemoryConsume(ConsumerRecord<?, ?> record) {
        String msg = record.value().toString();
        String topic = record.topic();
        VmWinMemoryMessage vmWinMemoryMessage = JSONObject.parseObject(msg, VmWinMemoryMessage.class);
        if (vmWinMemoryMessage.getFields().getAvailable_bytes() == null) {
            return;
        }
        vmWinMemoryMessage.setTopic(topic);
        alarmController.conditionAlarm(vmWinMemoryMessage);
    }

    @KafkaListener(topics = Constants.Topic.HYPERVISOR_MEM, id = "hypervisor_mem")
    public void hypervisorMemoryConsume(ConsumerRecord<?, ?> record) {
        String msg = record.value().toString();
        String topic = record.topic();
        HMemoryMessage hMemoryMessage = JSONObject.parseObject(msg, HMemoryMessage.class);
        hMemoryMessage.setTopic(topic);
        alarmController.conditionAlarm(hMemoryMessage);
    }

    @KafkaListener(topics = Constants.Topic.PHY_MEM, id = "phy_mem")
    public void phyMemoryConsume(ConsumerRecord<?, ?> record) {
        String msg = record.value().toString();
        String topic = record.topic();
        PhyMemoryMessage phyMemoryMessage = JSONObject.parseObject(msg, PhyMemoryMessage.class);
        phyMemoryMessage.setTopic(topic);
        alarmController.conditionAlarm(phyMemoryMessage);
    }

    @KafkaListener(topics = Constants.Topic.MANAGEMENT_MEM, id = "management_mem")
    public void manageMemoryConsume(ConsumerRecord<?, ?> record) {
        String msg = record.value().toString();
        String topic = record.topic();
        ManageMemoryMessage manageMemoryMessage = JSONObject.parseObject(msg, ManageMemoryMessage.class);
        manageMemoryMessage.setTopic(topic);
        alarmController.conditionAlarm(manageMemoryMessage);
    }
}
