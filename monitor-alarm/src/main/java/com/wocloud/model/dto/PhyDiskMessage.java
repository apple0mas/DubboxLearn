package com.wocloud.model.dto;

/**
 * @Auther: apple0mas
 * @Date: 2018/9/18 12:30
 * @Description:
 */
public class PhyDiskMessage extends KafkaMessage{

    /**
     * fields : {"free":0,"inodes_free":0,"inodes_total":2,"inodes_used":2,"total":8192,"used":8192,"used_percent":100}
     * name : phy_disk
     * tags : {"available_zone_id":"f00caf31-daaf-40f3-9ef3-a8c123f532d7","device":"sr0","device_ip":"10.4.127.214","device_name":"AZ02HCI03.TMP.XX-MSS","device_uuid":"d1189bc1-f6cf-4a3e-bd7a-3761a8dde170","fstype":"udf","host":"template","manage_ip":"10.4.123.137","mode":"ro","path":"/mnt/cdrom","phy_uuid":"e3f98634-577f-4ab6-846f-7fafb5aefe82","resource_pool":"xxmss"}
     * timestamp : 1537272301
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
    public Object getTarget() {
        return this.fields.used_percent;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public static class FieldsBean {
        /**
         * free : 0
         * inodes_free : 0
         * inodes_total : 2
         * inodes_used : 2
         * total : 8192
         * used : 8192
         * used_percent : 100
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
