package com.wocloud.model.dto;

/**
 * @Auther: apple0mas
 * @Date: 2018/9/18 12:25
 * @Description:
 */
public class VmWinMemoryMessage extends KafkaMessage{

    /**
     * fields : {"Standby_Cache_Core_Bytes":0}
     * name : win_mem
     * tags : {"available_zone_id":"bb84599f-477a-4944-a2fb-e9136744252c","device_name":"ECM03.DEV2.Guigu","device_uuid":"1780e06c-cb16-466f-9be9-db34fd14dba9","host":"fd7a39d6-275e-4b0f-957d-2f5379cb643b","manage_ip":"172.20.5.104","objectname":"Memory","resource_pool":"ceshi","vm_os_type":"windows","vm_uuid":"fd7a39d6-275e-4b0f-957d-2f5379cb643b"}
     * timestamp : 1534320585
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
        return null;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public static class FieldsBean {
        /**
         * Standby_Cache_Core_Bytes : 0
         */

        private Long Available_bytes;

        public Long getAvailable_bytes() {
            return Available_bytes;
        }

        public void setAvailable_bytes(Long Standby_Cache_Core_Bytes) {
            this.Available_bytes = Standby_Cache_Core_Bytes;
        }
    }

}
