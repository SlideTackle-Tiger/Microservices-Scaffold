package org.tiger.clintone.service;


import org.tiger.common.pojo.dto.UserBaseInfoDTO;
import org.tiger.common.pojo.vo.UserFavorVO;

public interface UserService {
    UserFavorVO getUserFavorById(int id);

    UserBaseInfoDTO getUserBaseInfoById(int id);
}
