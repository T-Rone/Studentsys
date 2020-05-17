package com.cn.ssm.mapper.provider;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.cn.ssm.model.User;

public class UserDynaSqlProvider {

	 public String selectWhitParam(final Map<String, Object> params) {
		   String sql = (new SQL()
		      {
		{
		    SELECT("*");
		     FROM("user");
		 if (params.get("user") != null) {
		    User user = (User)params.get("user");
		    if (user.getName() != null && !user.getName().equals("")) {
		 	        WHERE("  name LIKE CONCAT ('%',#{user.name},'%') ");
		    }
		}}
	}).toString();
		 if (params.get("pageModel") != null) {
		      sql = String.valueOf(sql) + " limit #{pageModel.firstLimitParam} , #{pageModel.pageSize}  ";
		     }
		      return sql;
		  }

	 
	    public String count(final Map<String, Object> params) { return (new SQL()
	   {
	 {
		 	/* 44 */     SELECT("count(*)");
		 	/* 45 */     FROM("user");
		 	/* 46 */     if (params.get("user") != null) {
		 	/* 47 */       User user = (User)params.get("user");
		 	/* 48 */       if (user.getName() != null && !user.getName().equals("")) {
		 	/* 49 */         WHERE(" name LIKE CONCAT ('%',#{user.name},'%') ");
		 	/*    */       }
		 	/*    */     } 
		 	/*    */   }
		 /*  56 */       }).toString(); }
		 /*     */ 
		 /*     */ 
		 /*     */   
		 /*  63 */   public String insertUser(final User user) { return (new SQL()
		 /*     */       {
		 /*     */ {
		 	/* 65 */     INSERT_INTO("user");
		 	/* 66 */     if (user.getName() != null && !user.getName().equals("")) {
		 	/* 67 */       VALUES("name", "#{name}");
		 	/*    */     }
		 	/* 75 */     if (user.getPassword() != null && !user.getPassword().equals("")){
		 	/* 76 */       VALUES("password", "#{password}"); 
		 	/*    */   }
		 	/*    */ }
		 /*  79 */       }).toString(); }
		 /*     */ 
		 /*     */ 
		 /*     */ 
		 /*     */   
		 /* 110 */   public String updateUser(final User user) { return (new SQL()
		 /*     */       {
		 /*     */ {
		      UPDATE("user");
		    if (user.getName() != null) {
		       SET(" name = #{name} ");
		      }
		    if(user.getPassword()!=null){  
		    SET(" password = #{password} ");
		     }
		      WHERE(" id = #{id} ");
		    }
		    }).toString(); }
	
}
