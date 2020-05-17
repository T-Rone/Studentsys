package com.cn.ssm.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.cn.ssm.model.Department;

public interface SpeMapper {
	@SelectProvider(type = com.cn.ssm.mapper.provider.SpeDynaSqlProvider.class, method = "insertDepartment")
	void insertDepartment(Department paramDepartment);
	
	@Select({"select * from department "})
	List<Department> selectAllDept();

	@SelectProvider(type = com.cn.ssm.mapper.provider.SpeDynaSqlProvider.class, method = "selectWhitParam")
	  List<Department> selectByPage(Map<String, Object> paramMap);

	@SelectProvider(type = com.cn.ssm.mapper.provider.SpeDynaSqlProvider.class, method = "count")
	Integer count(Map<String, Object> paramMap);
	
	@Select({"select * from department where id = #{id}"})
	Department selectById(int paramInt);

	
	 @SelectProvider(type = com.cn.ssm.mapper.provider.SpeDynaSqlProvider.class, method = "updateDepart")
	 void update(Department paramDept);

	 @Delete({" delete from department where id = #{id} "})
	 void deleteById(Integer paramInteger);
}
