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

import com.cn.ssm.model.Department;
import com.cn.ssm.service.StuService;
/*  #{}预处理 接受参数   */ @Controller
/*     */ public class SpeController { 
	
/*     */   @Autowired
/*  */      @Qualifier("stuService")
/*     */   private StuService stuService;
/*     */   
			@RequestMapping({"/view/selectDepartment.do"})
			public String selectSpe(Model model, Integer pageIndex, @ModelAttribute Department department) {
				PageModel pageModel = new PageModel();
				if (pageIndex != null) {
				      pageModel.setPageIndex(pageIndex.intValue());
			    }
				
				List<Department> departments = this.stuService.selectAllDepartment(department,pageModel);
				model.addAttribute("departments", departments);
				model.addAttribute("pageModel", pageModel);
				return "view/selectDepartment";
   }
 
   @RequestMapping({"/view/removeDepartment.do"})
   // @RequestParam("id") 接受url中id得值 并将值 给 后面得  ids 即 参数绑定 默认必须有参数
   public ModelAndView removeSpe(@RequestParam("id")String ids, ModelAndView mv) {
	   
	   String[] idArray = ids.split(",");
     for(String idd : idArray){  
	   
       this.stuService.removeDepartById(Integer.parseInt(idd));
       }
    mv.setViewName("redirect:/view/selectDepartment.do");
     return mv;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @RequestMapping({"/view/insertDepartment.do"})
/*     */   public ModelAndView addSpe(String flag, @ModelAttribute Department department, ModelAndView mv) {
/*  87 */     if (flag.equals("1")) {
/*   
 * 通过 这个flag 标志 判断是否需要添加  left.jsp 中 和dept/showAddDept.jsp 都传给 @RequestMapping({"/dept/addDept"})
 *   */       
/*  89 */       mv.setViewName("view/insertDepartment");
/*     */     } else {
/*     */       
/*  92 */       this.stuService.insertDepartment(department); //这就真添加了
/*     */       
/*  94 */       mv.setViewName("redirect:/view/selectDepartment.do");//又通过控制器 跳到 查询页面
/*     */     } 
/*     */     
/*  97 */     return mv;
/*     */   }
/*     */ 
/*     */   
  @RequestMapping({"/view/updateDepartment.do"})
  public ModelAndView updateSpe(String flag, @ModelAttribute Department department, ModelAndView mv) {
     if (flag.equals("1")) {
    	
      Department target = this.stuService.findDepartById(department.getId()); //改成1 测试对的  莫非 页面department对象 shutdown?
      
      mv.addObject("department", target);
      mv.setViewName("view/updateDepartment");
    } else {
       
      this.stuService.modifyDepart(department);
       
     mv.setViewName("redirect:/view/selectDepartment.do");
     } 
     
   return mv;
  }
 }

