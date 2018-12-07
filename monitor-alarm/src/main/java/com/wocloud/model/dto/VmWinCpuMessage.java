package com.wocloud.model.dto;

/**
 * @Auther: apple0mas
 * @Date: 2018/9/18 12:28
 * @Description:
 */
public class VmWinCpuMessage extends KafkaMessage{

    /**
     * fields : {"Percent_Idle_Time":99.95903015136719}
     * name : win_cpu
     * tags : {"available_zone_id":"bb84599f-477a-4944-a2fb-e9136744252c","device_name":"ECM03.DEV2.Guigu","device_uuid":"1780e06c-cb16-466f-9be9-db34fd14dba9","host":"fd7a39d6-275e-4b0f-957d-2f5379cb643b","instance":"1","manage_ip":"172.20.5.104","objectname":"Processor","resource_pool":"ceshi","vm_os_type":"windows","vm_uuid":"fd7a39d6-275e-4b0f-957d-2f5379cb643b"}
     * timestamp : 1533722864
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
        return 100 - this.fields.getPercent_Idle_Time();
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public static class FieldsBean {
        /**
         * Percent_Idle_Time : 99.95903015136719
         */

        private Double Percent_Idle_Time;

        public Double getPercent_Idle_Time() {
            return Percent_Idle_Time;
        }

        public void setPercent_Idle_Time(Double Percent_Idle_Time) {
            this.Percent_Idle_Time = Percent_Idle_Time;
        }
    }


}
