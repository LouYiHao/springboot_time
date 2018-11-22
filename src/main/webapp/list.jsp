<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'myorder.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
	<script type="text/javascript" src="easyui/jquery.min.js"></script>
	<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript">
	
	var url;
		$(function(){
			$("#my").treegrid({
				idField:"orderNumber",
			    url:"orders/list",
  		  	    columns:[[
  		  	        {field:'orderNumber',title:'orderNumber',width:100},    
  		  	        {field:'orderDate',title:'orderDate',width:100},    
  		  	        {field:'requiredDate',title:'requiredDate',width:100},    
  		  	        {field:'shippedDate',title:'shippedDate',width:100,align:'left'}, 
  		  	        {field:'status',title:'status',width:100,align:'left'},  
  		  	        {field:'comments',title:'comments',width:100,align:'left'},  
  		  	        {field:'customerNumber',title:'customerNumber',width:100,align:'left'}
  		  	    ]],
  		     	rownumbers:true,
		    	pagination:true,
		    	fitColumns:true	
			})
			$("#au").dialog('close');
			$("#edit").linkbutton({
				onClick:function(){
				 	$("#ad").css('display','none');
				 	$("#up").css('display','block');
					//获取选中项
					var b=$("#my").datagrid("getSelections");
					if(b.length==1){
						 $("#fm").form('reset'); 
						/* location.reload(); */
						$("#au").dialog('open').dialog('setTitle','修改');
						//在id为fm加载时 把选中第一项的值赋给表单
						$("#fm").form('load',b[0]);	
						url="orders/update";
					}else if(b.length>1){
						$.messager.show({
							title:"提示",
							msg:"只能修改一条数据"
						})
					}	
					else{
						$.messager.show({
							title:"提示",
							msg:"请选择你要修改的信息"
						});
					}
				}
			});
			$("#del").linkbutton({
				onClick:function(){
					var rows = $("#my").datagrid("getSelections");
					if(rows.length>0){
						$.messager.confirm('提示','确实删除?',function(r){
							if(r){
								checkVal=[];
								for(var i = 0;i<rows.length;i++){
									checkVal.push(rows[i].orderNumber);
								}
								alert(checkVal)
								 $.ajax({
									url:"orders/del",
									type:"post",
									traditional:true,
									data:{orderNumbers:checkVal},
									success:function(data){
										if(data=="true"){
											alert("删除成功");
											 $("#my").datagrid('reload');
											/* location.reload(); */
										}else{
											alert("删除失败");
										}
									},
									datatype:"text",
								}); 	
							}
						});
					}else{
						$.messager.show({
							title:"提示",
							msg:"请选择要删除的信息"	
							});
						}
					}
			});
	
		});
		function add(){
			$("#ad").css('display','block');
			$("#up").css('display','none');
			url="orders/add";
			 $("#fm").form('reset'); 
			 $("#my").datagrid('reload')
		    /* 	location.reload(); */
			$("#au").dialog('open');
			$("#au").dialog('open').dialog('setTitle','添加');
			
		}
		function submit(){
			alert(url)
			$("#fm").form('submit',{
				url:url,
				success: function(data){
					alert(data)
					$("#my").datagrid('reload');
					$("#au").dialog('close');
					/* $("#fm").form('reset'); */
					location.reload();
				}		
			});
		}
		function close(){	
			$("#au").dialog('close');
			/* $("#fm").form('reset'); */
			location.reload();
		}
	</script>
  </head>
  
  <body>
  	<!-- fitColumns:true 自动铺满 -->
  	<!-- toolbar:'#tbTools'绑定 -->
  	<!-- singleSelect:true  只能选中一项 -->     
  	<!-- pagination:true 显示页数 -->
  	<!-- rownumbers:true 显示行数 -->
    <table id="my" class="easyui-datagrid" data-options="toolbar:'#tbTools'">	
    </table>
    <div id="tbTools">
      	<a href="Elist.jsp">E查询</a>
    	<a href="javascript:add()" class="easyui-linkbutton" data-options="iconCls:'icon-add'">新增</a>  
    	<a id="edit" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">修改</a>  
    	<a id="del" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-remove'">删除</a> 
    </div>
  
     <!--  modal:true 模态框 -->
    <div id="au" class="easyui-dialog" style="width: 400px;height: 400px;padding:30px 60px;"
    data-options="modal:true,buttons:'#bu'">
    	<form  method="post"  class="easyui-form" id="fm">
	    	<div style="margin-bottom:20px">
				<input class="easyui-textbox" style="width:100%" name="orderNumber"
				data-options="buttonText:'orderNumber',buttonAlign:'left'" />
			</div>
			<div style="margin-bottom:20px">
				<input class="easyui-textbox" name="orderDate" type="date"
					style="width:100%" data-options="buttonText:'orderDate',buttonAlign:'left'"/>
			</div>
			<div style="margin-bottom:20px">
				<input class="easyui-textbox" name="requiredDate"type="date"
					style="width:100%" data-options="buttonText:'requiredDate',buttonAlign:'left'"/>
			</div>
			<div style="margin-bottom:20px">
				<input class="easyui-textbox" name="shippedDate"type="date"
					style="width:100%" data-options="buttonText:'shippedDate',buttonAlign:'left'"/>
			</div>
			<div style="margin-bottom:20px">
				<input class="easyui-textbox" name="status"
					style="width:100%" data-options="buttonText:'status',buttonAlign:'left'"/>
			</div>
			<div style="margin-bottom:20px">
				<input class="easyui-textbox" name="comments"
					style="width:100%" data-options="buttonText:'comments',buttonAlign:'left'"/>
			</div>
			<div style="margin-bottom:20px">
				<input class="easyui-textbox" name="customerNumber"
					style="width:100%" data-options="buttonText:'customerNumber',buttonAlign:'left'"/>
			</div>
    	</form>
    </div>
    <div id="bu">
    	<a href="javascript:submit()" class="easyui-linkbutton" data-options="iconCls:'icon-save'">保存</a>
    	<a href="javascript:close()" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'">关闭</a>
    </div> 
  </body>
</html>
