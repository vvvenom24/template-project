package org.example.model;

import lombok.Getter;
import lombok.Setter;

/**
 * 通信数据包
 */
@Getter
@Setter
public class CommunicationPacket {

    /**
     * 应用领域（1byte）
     * 1-深圳行业监管数据Kafka对接
     */
    private String appField;

    /**
     * 数据消息标识（2byte）
     * 若应用领域为1，表示消息命令字U00、U01...
     */
    private String dataMessageId;

    /**
     * 流水号（4byte）
     * 按发送顺序从0开始循环累加，建议根据时间跨日归零
     */
    private String serialNum;

    /**
     * 时间戳（4byte）
     * 发送数据时的时间戳
     */
    private String timestamp;

    /**
     * 组织编码（4byte）
     */
    private String orgCoding;

    /**
     * 终端类型（1byte）
     * 1-平台；2-车载终端
     */
    private String terminalType;

    /**
     * 终端编号（4byte）
     * 若终端类型为平台,则为平台所在组织下唯一编号;
     * 若终端类型为车载机,则表示车载机通信号或SIM卡号
     */
    private String terminalNum;

    /**
     * 终端地址（4byte）
     */
    private String terminalAddress;

    /**
     * 数据内容长度（2byte）
     */
    private String dataLength;

    /**
     * 数据内容
     */
    private String dataContent;
}
