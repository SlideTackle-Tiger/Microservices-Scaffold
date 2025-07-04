package org.tiger.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.tiger.common.pojo.dto.UserBaseInfoDTO;

import org.tiger.common.pojo.vo.Result;
/* feign接口将url封装为接口便于调用*/
@FeignClient("user-service") // 这里的值是服务在nacos中的注册名称
public interface UserClient {
    @GetMapping("/userOne/baseInfo/{id}")
    Result<UserBaseInfoDTO> getUserBaseInfo(@PathVariable("id") Integer id);
}
