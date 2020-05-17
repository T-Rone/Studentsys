/**
 * Created with JetBrains PhpStorm.
 * User: kk
 * Date: 13-8-28
 * Time: 涓嬪崍4:44
 */
function U() {
    var url = arguments[0] || [];
    var param = arguments[1] || {};
    var url_arr = url.split('/');

    if (!$.isArray(url_arr) || url_arr.length < 2 || url_arr.length > 3) {
        return '';
    }

    if (url_arr.length == 2)
        url_arr.unshift(_GROUP_);

    var pre_arr = ['g', 'm', 'a'];

    var arr = [];
    for (d in pre_arr)
        arr.push(pre_arr[d] + '=' + url_arr[d]);

    for (d in param)
        arr.push(d + '=' + param[d]);

    return _APP_+'?'+arr.join('&');
}

$(function(){
	   /** 获取上一次选中的部门数据 */
	   var boxs  = $("input[type='checkbox'][id^='box_']");
	   
	  /** 给全选按钮绑定点击事件  */
 	$("#checkAll").click(function(){
 		// this是checkAll  this.checked是true
 		// 所有数据行的选中状态与全选的状态一致
 		boxs.attr("checked",this.checked);
 	})
 	
	  /** 给数据行绑定鼠标覆盖以及鼠标移开事件  */
 	$("tr[id^='data_']").hover(function(){
 		$(this).css("backgroundColor","#eeccff");
 	},function(){
 		$(this).css("backgroundColor","#ffffff");
 	})
 	
 	
	   /** 删除员工绑定点击事件 */
	   $("#delete").click(function(){
		   /** 获取到用户选中的复选框  */
		   var checkedBoxs = boxs.filter(":checked");
		   if(checkedBoxs.length < 1){
			   $.ligerDialog.error("请选择一个需要删除的专业！");
		   }else{
			   /** 得到用户选中的所有的需要删除的ids */
			   var ids = checkedBoxs.map(function(){
				   return this.value;
			   })
			   
			   $.ligerDialog.confirm("确认要删除吗?","删除专业",function(r){
				   if(r){
					   // alert("删除："+ids.get());
					   // 发送请求
					   window.location = "${ctx}/view/removeDepartment.do?ids=" + ids.get();
				   }
			   });
		   }
	   })
 })
