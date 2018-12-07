package com.wocloud.model.dto;

/**
 * @Auther: apple0mas
 * @Date: 2018/9/18 12:31
 * @Description:
 */
public class ManageDiskMessage extends KafkaMessage{

    /**
     * fields : {"free":11783846494208,"inodes_free":2343728880,"inodes_total":2343749184,"inodes_used":20304,"total":11994136313856,"used":210289819648,"used_percent":1.7532718834041152}
     * name : disk
     * tags : {"device":"localhost:/volume_glance","device_name":"RGCC03.TMP.XX-MSS","device_uuid":"84b40ea3-1f7f-439f-a337-0a9fd669dd8f","fstype":"fuse.glusterfs","host":"RGCC03.TMP.XX-MSS","manage_ip":"10.4.123.131","mode":"rw","path":"/var/lib/cinder/glance_shares","resource_pool":"xxmss"}
     * timestamp : 1537244480
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
         * free : 11783846494208
         * inodes_free : 2343728880
         * inodes_total : 2343749184
         * inodes_used : 20304
         * total : 11994136313856
         * used : 210289819648
         * used_percent : 1.7532718834041152
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
