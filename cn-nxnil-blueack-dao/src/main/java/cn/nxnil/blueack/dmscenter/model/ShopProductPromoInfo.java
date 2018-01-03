package cn.nxnil.blueack.dmscenter.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class ShopProductPromoInfo {
    @JsonIgnore
    private Long id;

    private String shopCode;

    private String productCode;

    private BigDecimal price;

    private BigDecimal promoPrice;

    private String promoNo;

    private Date startDate;

    private Date endDate;

    @JsonIgnore
    private Date createdTime;

    @JsonIgnore
    private String createdBy;

    @JsonIgnore
    private Date updatedTime;

    @JsonIgnore
    private String updatedBy;
}