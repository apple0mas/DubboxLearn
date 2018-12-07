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
 * @Date: 2018/9/18 11:14
 * @Description:
 */
@Slf4j
public class CpuListener {

    @Autowired
    private ConditionAlarmController alarmController;

    @KafkaListener(topics = {Constants.Topic.VM_LINUX_CPU},id = "vm_linux_cpu")
    public void vmLinuxCpuConsume(ConsumerRecord<?, ?> record){
        String topic = record.topic();
        String msg = record.value().toString();
        VmLinuxCpuMessage vmLinuxCpuMessage = JSONObject.parseObject(msg, VmLinuxCpuMessage.class);
        vmLinuxCpuMessage.setTopic(topic);
        alarmController.conditionAlarm(vmLinuxCpuMessage);
    }

    @KafkaListener(topics = { Constants.Topic.VM_WIN_CPU },id = "vm_win_cpu")
    public void vmWinCpuConsume(ConsumerRecord<?, ?> record){
        String topic = record.topic();
        String msg = record.value().toString();
        VmWinCpuMessage vmWinCpuMessage = JSONObject.parseObject(msg, VmWinCpuMessage.class);
        if(vmWinCpuMessage.getFields().getPercent_Idle_Time() == null){
            return;
        }
        vmWinCpuMessage.setTopic(topic);
        alarmController.conditionAlarm(vmWinCpuMessage);
    }

    @KafkaListener(topics = { Constants.Topic.HYPERVISOR_CPU },id = "hypervisor_cpu")
    public void hypervisorCpuConsume(ConsumerRecord<?, ?> record){
        String msg = record.value().toString();
        String topic = record.topic();
        HCpuMessage hCpuMessage = JSONObject.parseObject(msg, HCpuMessage.class);
        hCpuMessage.setTopic(topic);
        alarmController.conditionAlarm(hCpuMessage);
    }

    @KafkaListener(topics = { Constants.Topic.PHY_CPU },id = "phy_cpu")
    public void phyCpuConsume(ConsumerRecord<?, ?> record){
        String msg = record.value().toString();
        String topic = record.topic();
        PhyCpuMessage phyCpuMessage = JSONObject.parseObject(msg, PhyCpuMessage.class);
        phyCpuMessage.setTopic(topic);
        alarmController.conditionAlarm(phyCpuMessage);
    }

    @KafkaListener(topics = { Constants.Topic.MANAGEMENT_CPU },id = "management_cpu")
    public void manageCpuConsume(ConsumerRecord<?, ?> record){
        String msg = record.value().toString();
        String topic = record.topic();
        ManageCpuMessage manageCpuMessage = JSONObject.parseObject(msg, ManageCpuMessage.class);
        manageCpuMessage.setTopic(topic);
        alarmController.conditionAlarm(manageCpuMessage);
    }
}
