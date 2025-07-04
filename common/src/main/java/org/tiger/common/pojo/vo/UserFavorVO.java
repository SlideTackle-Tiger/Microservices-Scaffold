package org.tiger.common.pojo.vo;

import lombok.Data;
import org.tiger.common.pojo.po.UserPO;

/**
  *@ClassName UserFavorVO
  *@Description 用于返回前端结果
  *@Author tiger
  *@Date 2025/6/30 16:10
  */
@Data
public class UserFavorVO {
    private String sport;
    private String fruit;
    public UserFavorVO(UserPO userPo) {
        this.sport = userPo.getSport();
        this.fruit = userPo.getFruit();
    }
}
