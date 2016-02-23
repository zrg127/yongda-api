package cn.com.yongda.repository.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.com.yongda.repository.entity.GatewayItf;

@Repository
public interface GatewayItfDao {
	public GatewayItf  queryGatewayItf(@Param("itfId") String itfId);
}
