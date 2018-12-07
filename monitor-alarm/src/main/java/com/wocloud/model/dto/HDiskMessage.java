package com.wocloud.model.dto;

/**
 * @Auther: apple0mas
 * @Date: 2018/9/18 12:29
 * @Description:
 */
public class HDiskMessage extends KafkaMessage {

    /**
     * fields : {"free":9829076992,"inodes_free":655342,"inodes_total":655360,"inodes_used":18,"total":10425225216,"used":42975232,"used_percent":0.4353221703540291}
     * name : disk
     * tags : {"available_zone_id":"f00caf31-daaf-40f3-9ef3-a8c123f532d7","device":"md127","device_name":"AZ02HCI02.TMP.XX-MSS","device_uuid":"4b8d0f0d-a715-44fd-9340-bce2c16b7dde","fstype":"ext4","host":"AZ02HCI02.TMP.XX-MSS","manage_ip":"10.4.123.136","mode":"rw","path":"/var/lib/zookeeper","resource_pool":"xxmss"}
     * timestamp : 1537243101
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
        return this.fields.getUsed_percent();
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public static class FieldsBean {
        @Override
        public String toString() {
            return "FieldsBean{" +
                    "used_percent=" + used_percent +
                    '}';
        }

        /**
         * free : 9829076992
         * inodes_free : 655342
         * inodes_total : 655360
         * inodes_used : 18
         * total : 10425225216
         * used : 42975232
         * used_percent : 0.4353221703540291
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

    @Override
    public String toString() {
        return "HDiskMessage{" +
                "fields=" + fields +
                ", timestamp=" + timestamp +
                ", tags=" + tags +
                ", topic='" + topic + '\'' +
                '}';
    }
}
