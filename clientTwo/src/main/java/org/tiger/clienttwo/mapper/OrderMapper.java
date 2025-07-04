package org.tiger.clienttwo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.tiger.common.pojo.po.OrderPO;
@Mapper
public interface OrderMapper extends BaseMapper<OrderPO> {
}
