package com.wocloud.model.dto;

/**
 * @Auther: admin
 * @Date: 2018/9/14 09:59
 * @Description:
 */
public class VmLinuxDiskMessage extends KafkaMessage{


    /**
     * fields : {"free":349470720,"inodes_free":255670,"inodes_total":256000,"inodes_used":330,"total":520785920,"used":171315200,"used_percent":32.89551299697196}
     * name : vm_disk
     * tags : {"available_zone_id":"d465f75c-0e54-4867-9f0e-2f48e001bf99","device":"vda1","device_name":"AZ01HCI03.TMP.XX-MSS","device_uuid":"eca2f405-d675-454e-b949-13c44cae1789","fstype":"xfs","host":"0a323b0e-6935-4b3f-87bc-08b1f2c4758b","manage_ip":"10.4.123.134","mode":"rw","path":"/boot","resource_pool":"xxmss","vm_os_type":"linux","vm_uuid":"0a323b0e-6935-4b3f-87bc-08b1f2c4758b"}
     * timestamp : 1536823804
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
    public Object getTarget() {
        return this.fields.used_percent;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public static class FieldsBean {
        /**
         * free : 349470720
         * inodes_free : 255670
         * inodes_total : 256000
         * inodes_used : 330
         * total : 520785920
         * used : 171315200
         * used_percent : 32.89551299697196
         */

        private Long free;
        private Long inodes_free;
        private Long inodes_total;
        private Long inodes_used;
        private Long total;
        private Long used;
        private Double used_percent;

        public Long getFree() {
            return free;
        }

        public void setFree(Long free) {
            this.free = free;
        }

        public Long getInodes_free() {
            return inodes_free;
        }

        public void setInodes_free(Long inodes_free) {
            this.inodes_free = inodes_free;
        }

        public Long getInodes_total() {
            return inodes_total;
        }

        public void setInodes_total(Long inodes_total) {
            this.inodes_total = inodes_total;
        }

        public Long getInodes_used() {
            return inodes_used;
        }

        public void setInodes_used(Long inodes_used) {
            this.inodes_used = inodes_used;
        }

        public Long getTotal() {
            return total;
        }

        public void setTotal(Long total) {
            this.total = total;
        }

        public Long getUsed() {
            return used;
        }

        public void setUsed(Long used) {
            this.used = used;
        }

        public Double getUsed_percent() {
            return used_percent;
        }

        public void setUsed_percent(Double used_percent) {
            this.used_percent = used_percent;
        }
    }



}
