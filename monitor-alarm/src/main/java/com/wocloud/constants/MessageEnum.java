package com.wocloud.constants;


import com.wocloud.model.dto.KafkaMessage;

/**
 * @Auther: apple0mas
 * @Date: 2018/11/14 11:21
 * @Description:
 */
public enum MessageEnum {

    hypervisor_cpu(Constants.Topic.HYPERVISOR_CPU, Constants.ConditionType.CPU, Constants.InstanceType.HYPERVISOR),
    hypervisor_disk(Constants.Topic.HYPERVISOR_DISK, Constants.ConditionType.DISK, Constants.InstanceType.HYPERVISOR),
    hypervisor_mem(Constants.Topic.HYPERVISOR_MEM, Constants.ConditionType.MEMORY, Constants.InstanceType.HYPERVISOR),
    hypervisor_phy_cpu(Constants.Topic.PHY_CPU, Constants.ConditionType.CPU, Constants.InstanceType.PHYSICAL),
    hypervisor_phy_disk(Constants.Topic.PHY_DISK, Constants.ConditionType.DISK, Constants.InstanceType.PHYSICAL),
    hypervisor_phy_mem(Constants.Topic.PHY_MEM, Constants.ConditionType.MEMORY, Constants.InstanceType.PHYSICAL),
    hypervisor_vm_linux_cpu(Constants.Topic.VM_LINUX_CPU, Constants.ConditionType.CPU, Constants.InstanceType.VM_LINUX),
    hypervisor_vm_linux_disk(Constants.Topic.VM_LINUX_DISK, Constants.ConditionType.DISK, Constants.InstanceType.VM_LINUX),
    hypervisor_vm_linux_mem(Constants.Topic.VM_LINUX_MEM, Constants.ConditionType.MEMORY, Constants.InstanceType.VM_LINUX),
    hypervisor_vm_win_cpu(Constants.Topic.VM_WIN_CPU, Constants.ConditionType.CPU, Constants.InstanceType.VM_WIN),
    hypervisor_vm_win_disk(Constants.Topic.VM_WIN_DISK, Constants.ConditionType.DISK, Constants.InstanceType.VM_WIN),
    hypervisor_vm_win_mem(Constants.Topic.VM_WIN_MEM, Constants.ConditionType.MEMORY, Constants.InstanceType.VM_WIN),
    management_cpu(Constants.Topic.MANAGEMENT_CPU, Constants.ConditionType.CPU, Constants.InstanceType.MANAGEMENT),
    management_disk(Constants.Topic.MANAGEMENT_DISK, Constants.ConditionType.DISK, Constants.InstanceType.MANAGEMENT),
    management_mem(Constants.Topic.MANAGEMENT_MEM, Constants.ConditionType.MEMORY, Constants.InstanceType.MANAGEMENT);

    private String topic;
    private String conditionType;
    private String instanceType;

    MessageEnum(String topic, String conditionType, String instanceType) {
        this.topic = topic;
        this.conditionType = conditionType;
        this.instanceType = instanceType;
    }


    public String getTopic() {
        return topic;
    }

    public String getConditionType() {
        return conditionType;
    }

    public String getInstanceType() {
        return instanceType;
    }

    public static String getConditionType(KafkaMessage message) {
        MessageEnum messageEnum = MessageEnum.valueOf(message.getTopic());
        String conditionType = messageEnum.getConditionType();
        return conditionType;
    }

    public static String getInstanceType(KafkaMessage message){
        MessageEnum messageEnum = MessageEnum.valueOf(message.getTopic());
        String instanceType = messageEnum.getInstanceType();
        return instanceType;
    }
}
