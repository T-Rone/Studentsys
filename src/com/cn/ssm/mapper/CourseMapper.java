package com.cn.ssm.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.cn.ssm.model.Course;


public  interface CourseMapper {
	@SelectProvider(type = com.cn.ssm.mapper.provider.CourseDynaSqlProvider.class, method = "insertCourse")
	void insertCourse(Course paramCourse);
	
	@Select({"select * from kc "})
	List<Course> selectAllCourse();
	
	@SelectProvider(type = com.cn.ssm.mapper.provider.CourseDynaSqlProvider.class, method = "selectWhitParam")
	List<Course> selectByPage(Map<String, Object> paramMap);

	@SelectProvider(type = com.cn.ssm.mapper.provider.CourseDynaSqlProvider.class, method = "count")
	Integer count(Map<String, Object> paramMap);
	
	@Select({"select * from kc where id = #{id}"})
	Course selectById(int paramInt);

	@Select({"select *from kc where cid=#{cid}"})
	Course selectByCid(int paramInt);
	
	 @SelectProvider(type = com.cn.ssm.mapper.provider.CourseDynaSqlProvider.class, method = "updateCourse")
	 void update(Course paramCourse);

	 @Delete({" delete from kc where id = #{id} "})
	 void deleteById(Integer paramInteger);
}
