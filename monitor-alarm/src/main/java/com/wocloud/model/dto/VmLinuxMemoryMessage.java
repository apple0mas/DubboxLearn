package com.wocloud.model.dto;

/**
 * @Auther: apple0mas
 * @Date: 2018/9/18 12:27
 * @Description:
 */
public class VmLinuxMemoryMessage extends KafkaMessage{

    /**
     * fields : {"active":122904576,"available":1762938880,"available_percent":84.20326714271741,"buffered":970752,"cached":157405184,"free":1754959872,"inactive":110977024,"slab":52523008,"total":2093670400,"used":330731520,"used_percent":15.796732857282597}
     * name : vm_linux_mem
     * tags : {"available_zone_id":"d465f75c-0e54-4867-9f0e-2f48e001bf99","device_name":"AZ01HCI02.TMP.XX-MSS","device_uuid":"30c013eb-7b17-4a61-96c9-85aa4c92d24f","host":"7ca68a97-4fd5-4d63-ab4e-846e2ffcadac","manage_ip":"10.4.123.133","resource_pool":"xxmss","vm_os_type":"linux","vm_uuid":"7ca68a97-4fd5-4d63-ab4e-846e2ffcadac"}
     * timestamp : 1537242844
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
         * active : 122904576
         * available : 1762938880
         * available_percent : 84.20326714271741
         * buffered : 970752
         * cached : 157405184
         * free : 1754959872
         * inactive : 110977024
         * slab : 52523008
         * total : 2093670400
         * used : 330731520
         * used_percent : 15.796732857282597
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
