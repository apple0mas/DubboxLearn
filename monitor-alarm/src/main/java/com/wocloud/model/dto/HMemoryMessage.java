package com.wocloud.model.dto;

/**
 * @Auther: apple0mas
 * @Date: 2018/9/18 12:29
 * @Description:
 */
public class HMemoryMessage extends KafkaMessage{

    /**
     * fields : {"active":31429959680,"available":507791970304,"available_percent":93.95545633421958,"buffered":47587328,"cached":50450554880,"free":459993157632,"inactive":42916843520,"slab":2272354304,"total":540460331008,"used":32668360704,"used_percent":6.044543665780428}
     * name : mem
     * tags : {"available_zone_id":"d465f75c-0e54-4867-9f0e-2f48e001bf99","device_name":"AZ01HCI02.TMP.XX-MSS","device_uuid":"30c013eb-7b17-4a61-96c9-85aa4c92d24f","host":"AZ01HCI02.TMP.XX-MSS","manage_ip":"10.4.123.133","resource_pool":"xxmss"}
     * timestamp : 1537243151
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
         * active : 31429959680
         * available : 507791970304
         * available_percent : 93.95545633421958
         * buffered : 47587328
         * cached : 50450554880
         * free : 459993157632
         * inactive : 42916843520
         * slab : 2272354304
         * total : 540460331008
         * used : 32668360704
         * used_percent : 6.044543665780428
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
