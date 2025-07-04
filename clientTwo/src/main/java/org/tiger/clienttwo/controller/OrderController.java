package org.tiger.clienttwo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tiger.common.pojo.vo.OrderInfoVO;
import org.tiger.common.pojo.vo.Result;
import org.tiger.clienttwo.service.OrderService;

/**
 * @ClassName OrderController
 * @Description
 * @Author tiger
 * @Date 2025/6/30 17:37
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/info/{id}")
    public Result getOrderInfoById(@PathVariable Integer id){
        OrderInfoVO orderInfoVO = orderService.getOrderInfoById(id);
        return Result.success(orderInfoVO);
    }

}
