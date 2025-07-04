package org.tiger.common.pojo.dto;

import lombok.Data;
import org.tiger.common.pojo.po.UserPO;

@Data
public class UserBaseInfoDTO {
    private Integer id;
    private String username;
    private String account;

    public UserBaseInfoDTO(){}// 无参构造方法
    public UserBaseInfoDTO(UserPO userPo){
        this.id = userPo.getId();
        this.username = userPo.getUsername();
        this.account = userPo.getAccount();
    }
}
