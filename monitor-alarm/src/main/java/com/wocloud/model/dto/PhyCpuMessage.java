package com.wocloud.model.dto;

/**
 * @Auther: apple0mas
 * @Date: 2018/9/18 12:30
 * @Description:
 */
public class PhyCpuMessage extends KafkaMessage {

    /**
     * fields : {"usage_guest":0,"usage_guest_nice":0,"usage_idle":99.99529984385815,"usage_iowait":0,"usage_irq":0,"usage_nice":0,"usage_softirq":0,"usage_steal":0,"usage_system":0.003133437433085083,"usage_user":0.0015667187165425416}
     * name : phy_cpu
     * tags : {"available_zone_id":"d465f75c-0e54-4867-9f0e-2f48e001bf99","cpu":"cpu-total","device_name":"AZ01HCI01.TMP.XX-MSS","device_uuid":"f91c9168-ec5a-4d20-90ff-1bfa49aac214","host":"d78f45c8-bc22-40df-9bbd-c46b4384c602","manage_ip":"10.4.123.132","phy_os_type":"linux","phy_uuid":"d78f45c8-bc22-40df-9bbd-c46b4384c602","resource_pool":"xxmss"}
     * timestamp : 1537272302
     */

    private FieldsBean fields;
    private String name;
    private Long timestamp;

    public FieldsBean getFields() {
        return fields;
    }

    public void setFields(FieldsBean fields) {
        this.fields = fields;
    }

    public String getName() {
        return name;
    }

    @Override
    public String getInstanceId() {
        return this.tags.getInstanceId();
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
         * usage_idle : 99.99529984385815
         * usage_iowait : 0
         * usage_irq : 0
         * usage_nice : 0
         * usage_softirq : 0
         * usage_steal : 0
         * usage_system : 0.003133437433085083
         * usage_user : 0.0015667187165425416
         */

        private Long usage_guest;
        private Long usage_guest_nice;
        private Double usage_idle;
        private Long usage_iowait;
        private Long usage_irq;
        private Long usage_nice;
        private Long usage_softirq;
        private Long usage_steal;
        private Double usage_system;
        private Double usage_user;

        public Long getUsage_guest() {
            return usage_guest;
        }

        public void setUsage_guest(Long usage_guest) {
            this.usage_guest = usage_guest;
        }

        public Long getUsage_guest_nice() {
            return usage_guest_nice;
        }

        public void setUsage_guest_nice(Long usage_guest_nice) {
            this.usage_guest_nice = usage_guest_nice;
        }

        public Double getUsage_idle() {
            return usage_idle;
        }

        public void setUsage_idle(Double usage_idle) {
            this.usage_idle = usage_idle;
        }

        public Long getUsage_iowait() {
            return usage_iowait;
        }

        public void setUsage_iowait(Long usage_iowait) {
            this.usage_iowait = usage_iowait;
        }

        public Long getUsage_irq() {
            return usage_irq;
        }

        public void setUsage_irq(Long usage_irq) {
            this.usage_irq = usage_irq;
        }

        public Long getUsage_nice() {
            return usage_nice;
        }

        public void setUsage_nice(Long usage_nice) {
            this.usage_nice = usage_nice;
        }

        public Long getUsage_softirq() {
            return usage_softirq;
        }

        public void setUsage_softirq(Long usage_softirq) {
            this.usage_softirq = usage_softirq;
        }

        public Long getUsage_steal() {
            return usage_steal;
        }

        public void setUsage_steal(Long usage_steal) {
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
