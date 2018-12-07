package com.wocloud.model.dto;

/**
 * @Auther: apple0mas
 * @Date: 2018/9/18 12:28
 * @Description:
 */
public class VmWinDiskMessage extends KafkaMessage{

    /**
     * fields : {"Current_Disk_Queue_Length":0}
     * name : win_disk
     * tags : {"available_zone_id":"bb84599f-477a-4944-a2fb-e9136744252c","device_name":"ECM03.DEV2.Guigu","device_uuid":"1780e06c-cb16-466f-9be9-db34fd14dba9","host":"fd7a39d6-275e-4b0f-957d-2f5379cb643b","instance":"C:","manage_ip":"172.20.5.104","objectname":"LogicalDisk","resource_pool":"ceshi","vm_os_type":"windows","vm_uuid":"fd7a39d6-275e-4b0f-957d-2f5379cb643b"}
     * timestamp : 1533722859
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
        return 100 - this.fields.getPercent_free_space();
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public static class FieldsBean {
        /**
         * Current_Disk_Queue_Length : 0
         */

        private Double Percent_free_space;

        public Double getPercent_free_space() {
            return Percent_free_space;
        }

        public void setPercent_free_space(Double Percent_free_space) {
            this.Percent_free_space = Percent_free_space;
        }
    }

}
