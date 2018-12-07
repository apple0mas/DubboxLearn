package com.wocloud.model.dto;

import com.wocloud.model.po.AlarmInfo;
import lombok.Data;
import org.springframework.util.StringUtils;

/**
 * @Auther: apple0mas
 * @Date: 2018/9/18 17:11
 * @Description:
 */
@Data
public class TagsBean {
    private String device_uuid;
    private String host;
    private String instanceId;
    private String resource_pool;
    private String device_name;
    private String vm_os_type;
    private String manage_ip;
    private String available_zone_id;
    private String vm_uuid;

    public String getInstanceId(){
      return StringUtils.isEmpty(this.vm_uuid) ? this.device_uuid : this.vm_uuid;
    }

    public AlarmInfo tagsBeanToAlarmInfo() {
        AlarmInfo alarmInfo = AlarmInfo.builder()
                .vmUUID(this.vm_uuid)
                .availableZoneId(this.available_zone_id)
                .manageIp(this.manage_ip)
                .osType(this.vm_os_type)
                .deviceName(this.device_name)
                .resourcePool(this.resource_pool)
                .deviceUUID(this.device_uuid)
                .host(this.host)
                .instanceId(getInstanceId())
                .build();
//        AlarmInfo alarmInfo = new AlarmInfo();
//        alarmInfo.setVmUUID(this.vm_uuid);
//        alarmInfo.setAvailableZoneId(this.available_zone_id);
//        alarmInfo.setManageIp(this.manage_ip);
//        alarmInfo.setOsType(this.vm_os_type);
//        alarmInfo.setDeviceName(this.device_name);
//        alarmInfo.setResourcePool(this.resource_pool);
//        alarmInfo.setDeviceUUID(this.device_uuid);
//        alarmInfo.setHost(this.host);
//        alarmInfo.setInstanceId(getInstanceId());
        return alarmInfo;
    }

    @Override
    public String toString() {
        return "TagsBean{" +
                "host='" + host + '\'' +
                ", device_uuid='" + device_uuid + '\'' +
                ", resource_pool='" + resource_pool + '\'' +
                ", device_name='" + device_name + '\'' +
                ", vm_os_type='" + vm_os_type + '\'' +
                ", manage_ip='" + manage_ip + '\'' +
                ", available_zone_id='" + available_zone_id + '\'' +
                ", vm_uuid='" + vm_uuid + '\'' +
                '}';
    }
}
