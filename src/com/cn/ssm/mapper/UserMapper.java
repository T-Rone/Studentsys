package com.cn.ssm.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.cn.ssm.model.User;

public interface UserMapper {
	  @Select({"select * from user where name = #{name} and password = #{password}"})
	  User selectByNameAndPassword(@Param("name") String paramString1, @Param("password") String paramString2);
	  
	  @Select({"select * from user where ID = #{id}"})
	  User selectById(Integer paramInteger);
	  
	  @Delete({" delete from user where id = #{id} "})
	  void deleteById(Integer paramInteger);
	  
	  @SelectProvider(type = com.cn.ssm.mapper.provider.UserDynaSqlProvider.class, method = "updateUser")
	  void update(User paramUser);
	  
	  @SelectProvider(type = com.cn.ssm.mapper.provider.UserDynaSqlProvider.class, method = "selectWhitParam")
	  List<User> selectByPage(Map<String, Object> paramMap);
	  
	  @SelectProvider(type = com.cn.ssm.mapper.provider.UserDynaSqlProvider.class, method = "count")
	  Integer count(Map<String, Object> paramMap);
	  
	  @SelectProvider(type = com.cn.ssm.mapper.provider.UserDynaSqlProvider.class, method = "insertUser")
	  void save(User paramUser);

}
