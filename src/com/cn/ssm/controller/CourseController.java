/*     */ package com.cn.ssm.controller;
		import java.util.List;
		import com.cn.ssm.util.tag.PageModel;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.beans.factory.annotation.Qualifier;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.ui.Model;
/*     */ import org.springframework.web.bind.annotation.ModelAttribute;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cn.ssm.model.Course;
import com.cn.ssm.service.StuService;;
/*  #{}Ԥ���� ���ܲ���   */ @Controller
/*     */ public class CourseController { 
	
/*     */   @Autowired
/*  */      @Qualifier("stuService")
/*     */   private StuService stuService;
/*     */   
			@RequestMapping({"/view/selectCourse.do"})
			public String selectCourse(Model model, Integer pageIndex, @ModelAttribute Course course) {
				PageModel pageModel = new PageModel();
				if (pageIndex != null) {
				      pageModel.setPageIndex(pageIndex.intValue());
			    }
				
				List<Course> courses = this.stuService.selectAllCourse(course,pageModel);
				model.addAttribute("courses", courses);
				model.addAttribute("pageModel", pageModel);
				return "view/selectCourse";
   }
 
   @RequestMapping({"/view/removeCourse.do"})
   // @RequestParam("id") ����url��id��ֵ ����ֵ �� �����  ids �� ������ Ĭ�ϱ����в���
   public ModelAndView removeCourse(@RequestParam("id")String ids, ModelAndView mv) {
	   
	   String[] idArray = ids.split(",");
     for(String idd : idArray){  
	   
       this.stuService.removeCourseById(Integer.parseInt(idd));
       }
    mv.setViewName("redirect:/view/selectCourse.do");
     return mv;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @RequestMapping({"/view/insertCourse.do"})
/*     */   public ModelAndView addCourse(String flag, @ModelAttribute Course course, ModelAndView mv) {
/*  87 */     if (flag.equals("1")) {
/*   
 * ͨ�� ���flag ��־ �ж��Ƿ���Ҫ���  left.jsp �� ��dept/showAddDept.jsp ������ @RequestMapping({"/dept/addDept"})
 *   */       
/*  89 */       mv.setViewName("view/insertCourse");
/*     */     } else {
/*     */       
/*  92 */       this.stuService.insertCourse(course); //����������
/*     */       
/*  94 */       mv.setViewName("redirect:/view/selectCourse.do");//��ͨ�������� ���� ��ѯҳ��
/*     */     } 
/*     */     
/*  97 */     return mv;
/*     */   }
/*     */ 
/*     */   
  @RequestMapping({"/view/updateCourse.do"})
  public ModelAndView updateCourse(String flag, @ModelAttribute Course course, ModelAndView mv) {
     if (flag.equals("1")) {
    	
      Course target = this.stuService.findCourseById(course.getId()); //�ĳ�1 ���ԶԵ�  Ī�� ҳ��course���� shutdown?
      
      mv.addObject("course", target);
      mv.setViewName("view/updateCourse");
    } else {
       
      this.stuService.modifyCourse(course);
       
     mv.setViewName("redirect:/view/selectCourse.do");
     } 
     
   return mv;
  }
 }

