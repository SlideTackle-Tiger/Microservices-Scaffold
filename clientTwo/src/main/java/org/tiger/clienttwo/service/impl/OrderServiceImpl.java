package org.tiger.clienttwo.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import org.tiger.common.pojo.dto.UserBaseInfoDTO;
import org.tiger.common.pojo.po.OrderPO;
import org.tiger.common.pojo.vo.OrderInfoVO;
import org.tiger.feign.client.UserClient;
import org.tiger.clienttwo.mapper.OrderMapper;
import org.tiger.clienttwo.service.OrderService;

/**
 * @ClassName OrderServiceImpl
 * @Description
 * @Author tiger
 * @Date 2025/6/30 17:41
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserClient userClient;

    /* 获取订单信息实现类，微服务调用*/
    @Override
    public OrderInfoVO getOrderInfoById(Integer orderId) {
        OrderPO orderPO = orderMapper.selectById(orderId);
        if (orderPO == null){
            return null;
        }

        OrderInfoVO orderInfoVO = new OrderInfoVO();
        BeanUtils.copyProperties(orderPO, orderInfoVO);
        // 服务调用
        try {
            // 获取买家信息
            // 通过RestTemolate调用user-service
            /*
            String url = "http://user-service/userOne/baseInfo/" + orderPO.getBuyerId();
            Result<UserBaseInfoDTO> response = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<Result<UserBaseInfoDTO>>() {
            }).getBody();
            UserBaseInfoDTO userBaseInfo1 = response.getData();
            orderInfoVO.setBuyerName(userBaseInfo1.getUsername());*/

            // 通过Feign调用user-service服务
            UserBaseInfoDTO buyerBaseInfoDTO = userClient.getUserBaseInfo(orderPO.getBuyerId()).getData();
            orderInfoVO.setBuyerName(buyerBaseInfoDTO.getUsername());


            // 获取卖家信息
            UserBaseInfoDTO sellerBaseInfoDTO = userClient.getUserBaseInfo(orderPO.getSellerId()).getData();
            orderInfoVO.setSellerName(sellerBaseInfoDTO.getUsername());
        } catch (Exception e){
            log.info("user-service 连接失败");
            //throw new RuntimeException("user-service 连接失败");
        }
        return orderInfoVO;

    }
}
