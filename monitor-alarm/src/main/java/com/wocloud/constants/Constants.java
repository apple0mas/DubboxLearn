package com.wocloud.constants;

/**
 * @Auther: apple0mas
 * @Date: 2018/10/30 11:14
 * @Description:
 */
public final class Constants {

    public static final class Topic {
        public static final String HYPERVISOR_CPU = "hypervisor_cpu";
        public static final String HYPERVISOR_DISK = "hypervisor_disk";
        public static final String HYPERVISOR_MEM = "hypervisor_mem";
        public static final String PHY_CPU = "hypervisor_phy_cpu";
        public static final String PHY_DISK = "hypervisor_phy_disk";
        public static final String PHY_MEM = "hypervisor_phy_mem";
        public static final String VM_LINUX_CPU = "hypervisor_vm_linux_cpu";
        public static final String VM_LINUX_DISK = "hypervisor_vm_linux_disk";
        public static final String VM_LINUX_MEM = "hypervisor_vm_linux_mem";
        public static final String VM_WIN_CPU = "hypervisor_vm_win_cpu";
        public static final String VM_WIN_DISK = "hypervisor_vm_win_disk";
        public static final String VM_WIN_MEM = "hypervisor_vm_win_mem";
        public static final String MANAGEMENT_CPU = "management_cpu";
        public static final String MANAGEMENT_DISK = "management_disk";
        public static final String MANAGEMENT_MEM = "management_mem";
    }

    public static final class InstanceType{
        public static final String HYPERVISOR = "hypervisor";
        public static final String VM_LINUX = "vm_linux";
        public static final String VM_WIN = "vm_win";
        public static final String MANAGEMENT = "management";
        public static final String PHYSICAL = "physical";
    }

    public static final class DictionaryType {

        /**
         * 指标类别
         */
        public static final String CONDITION = "condition";
        /**
         * 事件类别
         */
        public static final String EVENT = "event";
        /**
         * 操作符
         */
        public static final String OPERATOR = "operator";
        /**
         * 实例类别
         */
        public static final String INSTANCE_TYPE = "instanceType";
        /**
         * 告警状态
         */
        public static final String ALARM_STATUS = "alarmStatus";

    }

    public static final class ConditionType {
        public static final String CPU = "cpu";
        public static final String DISK = "disk";
        public static final String MEMORY = "memory";
    }

}
