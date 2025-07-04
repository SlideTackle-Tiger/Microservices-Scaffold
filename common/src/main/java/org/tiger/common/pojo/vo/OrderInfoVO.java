package org.tiger.common.pojo.vo;

import lombok.Data;

import java.util.Date;

/**
 * @ClassName OrderInfoVO
 * @Description
 * @Author tiger
 * @Date 2025/6/30 17:35
 */
@Data
public class OrderInfoVO {
    private Integer id;
    private Integer productId;
    private Integer amount;
    private Date createTime;
    private String buyerName;
    private String sellerName;
    private String getLocation;

}
