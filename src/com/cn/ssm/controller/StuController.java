/*     */ package com.cn.ssm.controller;
/*    ${} 纯占位字符替换    */ 
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

import com.cn.ssm.model.Student;
import com.cn.ssm.service.StuService;
/*  #{}预处理 接受参数   */ 
		  @Controller
/*     */ public class StuController { 
	
/*     */   @Autowired
/*  */      @Qualifier("stuService")
/*     */   private StuService stuService;
/*     */   
			@RequestMapping({"/view/selectStudent.do"})
			public String selectStu(Model model, Integer pageIndex, @ModelAttribute Student student) {
				PageModel pageModel = new PageModel();
				if (pageIndex != null) {
				      pageModel.setPageIndex(pageIndex.intValue());
			    }
				
				List<Student> students = this.stuService.selectAllStu(student,pageModel);
				model.addAttribute("students", students);
				model.addAttribute("pageModel", pageModel);
				return "view/selectStudent";
   }
 
   @RequestMapping({"/view/removeStudent.do"})
   // @RequestParam("id") 接受url中id得值 并将值 给 后面得  ids 即 参数绑定 默认必须有参数
   public ModelAndView removeStu(@RequestParam("id")String ids, ModelAndView mv) {
	   
	   String[] idArray = ids.split(",");
     for(String idd : idArray){  
	   
       this.stuService.removeStuById(Integer.parseInt(idd));
       }
    mv.setViewName("redirect:/view/selectStudent.do");
     return mv;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @RequestMapping({"/view/insertStudent.do"})
/*     */   public ModelAndView addStu(@RequestParam("flag")String flag, @ModelAttribute Student student, ModelAndView mv) {
/*  87 */     if (flag.equals("1")) {
/*   
 * 通过 这个flag 标志 判断是否需要添加  left.jsp 中 和dept/showAddDept.jsp 都传给 @RequestMapping({"/dept/addDept"})
 *   */       
/*  89 */       mv.setViewName("view/insertStudent");
/*     */     } else {
/*     */       
/*  92 */       this.stuService.insertStudent(student); //这就真添加了
/*     */       
/*  94 */       mv.setViewName("redirect:/view/selectStudent.do");//又通过控制器 跳到 查询页面
/*     */     } 
/*     */     
/*  97 */     return mv;
/*     */   }
/*     */ 
/*     */   
  @RequestMapping({"/view/updateStudent.do"})
  public ModelAndView updateStu(String flag, @ModelAttribute Student student, ModelAndView mv) {
     if (flag.equals("1")) {
    	
      Student target = this.stuService.findStuById(student.getId()); 
      
      mv.addObject("student", target);
      mv.setViewName("view/updateStudent");
    } else {
       
      this.stuService.modifyStu(student);
       
     mv.setViewName("redirect:/view/selectStudent.do");
     } 
     
   return mv;
  }
 }

