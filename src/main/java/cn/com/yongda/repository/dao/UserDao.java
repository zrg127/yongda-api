package cn.com.yongda.repository.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.com.yongda.repository.entity.UserInfo;
/**
 * 用户信息
 * @author Administrator
 *
 */
@Repository
public interface UserDao {
	public UserInfo queryUserInfo(@Param("yongdaName") String yongdaName);
}
