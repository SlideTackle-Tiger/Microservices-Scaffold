package org.tiger.common.pojo.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName(value = "tb_user")
@Data
public class UserPO {

    private Integer id;
    private String username;
    private String sport;
    private String fruit;

    private String email;
    private String password;
    private String account;

}
