package com.cn.ssm.service;

import com.cn.ssm.model.Course;
import com.cn.ssm.model.Department;
import com.cn.ssm.model.Grade;
import com.cn.ssm.model.Student;
import com.cn.ssm.util.tag.PageModel;

import java.util.List;

import com.cn.ssm.model.User;;



public interface StuService {
    
	//专业 增删改查
	public void insertDepartment(Department paramDepartment);
    public List<Department> selectAllDepartment(Department department, PageModel pageModel);
    public Department findDepartById(Integer paramInteger);
	public void modifyDepart(Department department);
	public void removeDepartById(int parseInt);

	//学生 增删改查
	public void insertStudent(Student paramStudent);
    public List<Student> selectAllStu(Student student, PageModel pageModel);
    public Student findStuById(Integer paramInteger);
	public void modifyStu(Student student);
	public void removeStuById(int parseInt);
	List<Student> findAllStudent();
	
	//课程 增删改查
	public void insertCourse(Course paramCourse);
	public List<Course> selectAllCourse(Course course, PageModel pageModel);
	public Course findCourseById(Integer paramInteger);
	public void modifyCourse(Course course);
	public void removeCourseById(int parseInt);
	List<Course> findAllCourse();

	//成绩 增删改查
	public void insertGrade(Grade paramGrade);
	public List<Grade> selectAllGrade(Grade grade, PageModel pageModel);
	public Grade findGradeById(Integer paramInteger);
	public void modifyGrade(Grade grade);
	public void removeGradeById(int parseInt);
	
	//用户
	public User login(String paramString1, String paramString2);
	public  User findUserById(Integer paramInteger);
	public List<User> findUser(User paramUser, PageModel paramPageModel);
	public void removeUserById(Integer paramInteger);
	public void modifyUser(User paramUser);
	public void addUser(User paramUser);
	
}