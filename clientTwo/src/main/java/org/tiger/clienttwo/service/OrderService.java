package org.tiger.clienttwo.service;


import org.tiger.common.pojo.vo.OrderInfoVO;


public interface OrderService {
    OrderInfoVO getOrderInfoById(Integer id);
}
