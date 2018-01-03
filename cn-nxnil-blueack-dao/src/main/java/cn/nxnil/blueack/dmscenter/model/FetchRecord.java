package cn.nxnil.blueack.dmscenter.model;

import lombok.Data;

import java.util.Date;

@Data
public class FetchRecord {
    private Long id;

    private String shopId;//门店编码

    private String code;//接口状态码

    private String message;//接口返回信息

    private String lastSerialId;//增量标识

    private Boolean fullFlag;//全量更新完毕判断

    private Integer random;//全量更新至第几页

    private Integer status;

    private Integer createdDate;//查询专用

    private Date createdTime;

    private Date updatedTime;
}