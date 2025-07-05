package org.tiger.common.pojo.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @ClassName OrderPO
 * @Description 订单实体类
 * @Author tiger
 * @Date 2025/6/30 17:35
 */
@Data
@TableName(value = "tb_order")
public class OrderPO {
    private Integer id;
    private Date createTime;
    private Integer status;
    private Integer productId;
    private Integer sellerId;
    private Integer buyerId;
    private Integer amount;
    private String getLocation;
}
