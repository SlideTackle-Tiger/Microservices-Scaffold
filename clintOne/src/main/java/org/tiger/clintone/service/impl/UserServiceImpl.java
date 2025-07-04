package org.tiger.clintone.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tiger.common.pojo.dto.UserBaseInfoDTO;
import org.tiger.common.pojo.po.UserPO;
import org.tiger.common.pojo.vo.UserFavorVO;
import org.tiger.clintone.mapper.UserMapper;
import org.tiger.clintone.service.UserService;

/**
 * @ClassName UserServiceImpl
 * @Description
 * @Author tiger
 * @Date 2025/6/30 16:43
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserFavorVO getUserFavorById(int id) {
        UserPO userPo = userMapper.selectById(id);
        return userPo != null ? new UserFavorVO(userPo) : null;
    }

    @Override
    public UserBaseInfoDTO getUserBaseInfoById(int id) {
        UserPO userPO = userMapper.selectById(id);
        if (userPO == null) {
            return null;
        }
        return new UserBaseInfoDTO(userPO);
    }
}
