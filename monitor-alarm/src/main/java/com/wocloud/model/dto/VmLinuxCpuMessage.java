package com.wocloud.model.dto;

/**
 * @Auther: admin
 * @Date: 2018/9/14 09:36
 * @Description:
 */
public class VmLinuxCpuMessage extends KafkaMessage{

    /**
     * fields : {"usage_guest":0,"usage_guest_nice":0,"usage_idle":99.86787778692606,"usage_iowait":0,"usage_irq":0,"usage_nice":0,"usage_softirq":0,"usage_steal":0.049545829892632426,"usage_system":0.033030553261751035,"usage_user":0.04954582989263829}
     * name : vm_cpu
     * tags : {"available_zone_id":"d465f75c-0e54-4867-9f0e-2f48e001bf99","cpu":"cpu-total","device_name":"AZ01HCI03.TMP.XX-MSS","device_uuid":"eca2f405-d675-454e-b949-13c44cae1789","host":"0a323b0e-6935-4b3f-87bc-08b1f2c4758b","manage_ip":"10.4.123.134","resource_pool":"xxmss","vm_os_type":"linux","vm_uuid":"0a323b0e-6935-4b3f-87bc-08b1f2c4758b"}
     * timestamp : 1536821101
     */

    private FieldsBean fields;
    private String name;
    private Long timestamp;

    @Override
    public String getInstanceId() {
        return this.tags.getInstanceId();
    }

    public FieldsBean getFields() {
        return fields;
    }

    public void setFields(FieldsBean fields) {
        this.fields = fields;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Long getTimestamp() {
        return timestamp;
    }

    @Override
    public Double getTarget() {
        return 100 - this.fields.getUsage_idle();
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public static class FieldsBean {
        /**
         * usage_guest : 0
         * usage_guest_nice : 0
         * usage_idle : 99.86787778692606
         * usage_iowait : 0
         * usage_irq : 0
         * usage_nice : 0
         * usage_softirq : 0
         * usage_steal : 0.049545829892632426
         * usage_system : 0.033030553261751035
         * usage_user : 0.04954582989263829
         */

        private Double usage_guest;
        private Double usage_guest_nice;
        private Double usage_idle;
        private Double usage_iowait;
        private Double usage_irq;
        private Double usage_nice;
        private Double usage_softirq;
        private Double usage_steal;
        private Double usage_system;
        private Double usage_user;

        public Double getUsage_guest() {
            return usage_guest;
        }

        public void setUsage_guest(Double usage_guest) {
            this.usage_guest = usage_guest;
        }

        public Double getUsage_guest_nice() {
            return usage_guest_nice;
        }

        public void setUsage_guest_nice(Double usage_guest_nice) {
            this.usage_guest_nice = usage_guest_nice;
        }

        public Double getUsage_idle() {
            return usage_idle;
        }

        public void setUsage_idle(Double usage_idle) {
            this.usage_idle = usage_idle;
        }

        public Double getUsage_iowait() {
            return usage_iowait;
        }

        public void setUsage_iowait(Double usage_iowait) {
            this.usage_iowait = usage_iowait;
        }

        public Double getUsage_irq() {
            return usage_irq;
        }

        public void setUsage_irq(Double usage_irq) {
            this.usage_irq = usage_irq;
        }

        public Double getUsage_nice() {
            return usage_nice;
        }

        public void setUsage_nice(Double usage_nice) {
            this.usage_nice = usage_nice;
        }

        public Double getUsage_softirq() {
            return usage_softirq;
        }

        public void setUsage_softirq(Double usage_softirq) {
            this.usage_softirq = usage_softirq;
        }

        public Double getUsage_steal() {
            return usage_steal;
        }

        public void setUsage_steal(Double usage_steal) {
            this.usage_steal = usage_steal;
        }

        public Double getUsage_system() {
            return usage_system;
        }

        public void setUsage_system(Double usage_system) {
            this.usage_system = usage_system;
        }

        public Double getUsage_user() {
            return usage_user;
        }

        public void setUsage_user(Double usage_user) {
            this.usage_user = usage_user;
        }
    }


}
