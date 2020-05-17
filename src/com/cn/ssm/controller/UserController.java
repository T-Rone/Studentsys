/*     */ package com.cn.ssm.controller;
/*     */ 
/*     */ import java.util.List;
/*     */ import javax.servlet.http.HttpSession;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.beans.factory.annotation.Qualifier;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.ui.Model;
/*     */ import org.springframework.web.bind.annotation.ModelAttribute;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cn.ssm.model.User;
import com.cn.ssm.service.StuService;
import com.cn.ssm.util.tag.PageModel;
/*     */ 
/*     */ 
/*     */ @Controller
/*     */ public class UserController
/*     */ {
/*     */   @Autowired
/*     */   @Qualifier("stuService")
//			两者配合注解，表明说需要的类 名字需要与接口实现类一致 @Service("stuService")
/*     */   private StuService stuService;
/*     */   
/*     */   @RequestMapping({"/login.do"})
/*获取参数 */   public ModelAndView login(@RequestParam(value="name",required=false) String name, @RequestParam(value="password",required=false) String password, HttpSession session, ModelAndView mv) {
				User user = this.stuService.login(name, password);
/*  44 */     if (user != null) {
/*     */       
/*  46 */       session.setAttribute("user_session", user);
/*   session.removeAttribute("user");   */      
/*  48 */       mv.setViewName("forward:index.jsp");
/*     */     } else {
/*  51 */       mv.addObject("message", "登录名或密码错误！请重新输入");
/*     */       
/*  53 */       mv.setViewName("forward:loginForm.jsp");
/*     */     } 
/*  55 */     return mv;
/*     */   }
/*     */ 
	@RequestMapping({"/logout.do"})	  
	public  ModelAndView logout(HttpSession session, ModelAndView mv){	   
		
		//清除session	  
//	session.removeAttribute("user");	
	session.invalidate();
	mv.setViewName("forward:loginForm.jsp");
	return mv;
	}

	/*@ModelAttribute
	 * 负责绑定请求参数到指定对象  
	 * eg 查询 name和password--》user   */ 
/*     */   
/*     */   @RequestMapping({"/view/selectUser.do"})
/*     */   public String selectUser(Integer pageIndex, @ModelAttribute User user, Model model) {
/*  69 */     System.out.println("user = " + user);
/*  70 */     PageModel pageModel = new PageModel();
/*  71 */     if (pageIndex != null) {
/*  72 */       pageModel.setPageIndex(pageIndex.intValue());
/*     */     }
/*     */     
/*  75 */     List<User> users = this.stuService.findUser(user, pageModel);
/*  76 */     model.addAttribute("users", users);
/*  77 */     model.addAttribute("pageModel", pageModel);
/*  78 */     return "view/selectUser";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @RequestMapping({"/view/removeUser.do"})
/*     */   public ModelAndView removeUser(@RequestParam("id")String ids, ModelAndView mv) {
	   
			String[] idArray = ids.split(",");
			for(String idd : idArray){  
	   
				this.stuService.removeUserById(Integer.valueOf(Integer.parseInt(idd)));
/*     */       }
/*     */     
/*  96 */     mv.setViewName("redirect:/view/selectUser.do");
/*     */     
/*  98 */     return mv;
/*     */   }
/*     */ 
/*     */ 

/*     */ 
/*     */ 
/*     */   
/*     */   @RequestMapping({"/view/updateUser.do"})
/*     */   public ModelAndView updateUser(String flag, @ModelAttribute User user, ModelAndView mv) {
/* 113 */     if (flag.equals("1")) {
/*     */       
/* 115 */       User target = this.stuService.findUserById(user.getId());
/*     */       
/* 117 */       mv.addObject("user", target);
/*     */       
/* 119 */       mv.setViewName("view/updateUser");
/*     */     } else {
/*     */       
/* 122 */       this.stuService.modifyUser(user);
/*     */       
/* 124 */       mv.setViewName("redirect:/view/selectUser.do");
/*     */     } 
/*     */     
/* 127 */     return mv;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @RequestMapping({"/view/insertUser.do"})
/*     */   public ModelAndView addUser(@RequestParam(value="name",required=false) String name, @RequestParam(value="password",required=false) String password,String flag, @ModelAttribute User user, ModelAndView mv) {
/* 142 */     if (flag.equals("1")) {
/*     */       
/* 144 */       mv.setViewName("view/insertUser");
/*     */     } else {
/*     */       
/* 147 */       this.stuService.addUser(user);
/*     */       
/* 149 */       mv.setViewName("redirect:/login.do");
/*     */     } 
/*     */     
/* 152 */     return mv;
/*     */   }
/*     */ }

