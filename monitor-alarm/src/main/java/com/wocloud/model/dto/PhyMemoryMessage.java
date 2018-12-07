package com.wocloud.model.dto;

/**
 * @Auther: apple0mas
 * @Date: 2018/9/18 12:30
 * @Description:
 */
public class PhyMemoryMessage extends KafkaMessage{

    /**
     * fields : {"active":1355468800,"available":535157182464,"available_percent":98.98214468253401,"buffered":966656,"cached":1554464768,"free":535470559232,"inactive":304680960,"slab":180588544,"total":540660322304,"used":5503139840,"used_percent":1.0178553174659857}
     * name : phy_mem
     * tags : {"available_zone_id":"f00caf31-daaf-40f3-9ef3-a8c123f532d7","device_ip":"10.4.127.214","device_name":"AZ02HCI03.TMP.XX-MSS","device_uuid":"d1189bc1-f6cf-4a3e-bd7a-3761a8dde170","host":"template","manage_ip":"10.4.123.137","phy_uuid":"e3f98634-577f-4ab6-846f-7fafb5aefe82","resource_pool":"xxmss"}
     * timestamp : 1537272361
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
        return this.fields.getUsed_percent();
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public static class FieldsBean {
        /**
         * active : 1355468800
         * available : 535157182464
         * available_percent : 98.98214468253401
         * buffered : 966656
         * cached : 1554464768
         * free : 535470559232
         * inactive : 304680960
         * slab : 180588544
         * total : 540660322304
         * used : 5503139840
         * used_percent : 1.0178553174659857
         */

        private Long active;
        private Long available;
        private Double available_percent;
        private Long buffered;
        private Long cached;
        private Long free;
        private Long inactive;
        private Long slab;
        private Long total;
        private Long used;
        private Double used_percent;

        public Long getActive() {
            return active;
        }

        public void setActive(Long active) {
            this.active = active;
        }

        public Long getAvailable() {
            return available;
        }

        public void setAvailable(Long available) {
            this.available = available;
        }

        public Double getAvailable_percent() {
            return available_percent;
        }

        public void setAvailable_percent(Double available_percent) {
            this.available_percent = available_percent;
        }

        public Long getBuffered() {
            return buffered;
        }

        public void setBuffered(Long buffered) {
            this.buffered = buffered;
        }

        public Long getCached() {
            return cached;
        }

        public void setCached(Long cached) {
            this.cached = cached;
        }

        public Long getFree() {
            return free;
        }

        public void setFree(Long free) {
            this.free = free;
        }

        public Long getInactive() {
            return inactive;
        }

        public void setInactive(Long inactive) {
            this.inactive = inactive;
        }

        public Long getSlab() {
            return slab;
        }

        public void setSlab(Long slab) {
            this.slab = slab;
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
