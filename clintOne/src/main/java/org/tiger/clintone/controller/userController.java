package org.tiger.clintone.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tiger.common.pojo.dto.UserBaseInfoDTO;
import org.tiger.common.pojo.vo.Result;
import org.tiger.common.pojo.vo.UserFavorVO;
import org.tiger.clintone.config.PatternProperties;
import org.tiger.clintone.service.UserService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/userOne")
@Slf4j
public class userController {

    @Autowired
    private UserService userService;

    @Autowired
    private PatternProperties patternProperties;

    @GetMapping("/test")
    public String test() {
        log.info("用户服务收到请求");
        // 从nacos配置中获取配置参数dateformat
        log.info("当前时间{}", LocalDateTime.now().format(DateTimeFormatter.ofPattern(patternProperties.getDateformat())));
        return "clientOne response";
    }

    /* 获取用户喜好*/
    @GetMapping("/favor/{id}")
    public Result getUserFavorById(@PathVariable Integer id) {
        UserFavorVO vo = userService.getUserFavorById(id);
        return vo != null ? Result.success(vo) : Result.failed("用户不存在");
    }

    /* 测试微服务调用*/
    @GetMapping("/baseInfo/{id}")
    public Result getUserBaseInfo(@PathVariable Integer id) {
        log.info("远程服务调用");
        UserBaseInfoDTO dto = userService.getUserBaseInfoById(id);
        if (dto != null){
            return Result.success(dto);
        }else {
            return Result.failed("用户不存在");
        }
    }
}
