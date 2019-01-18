<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
<base href="<%=basePath%>">
<!-- jsp文件头和头部 -->
<%@ include file="../index/top.jsp"%>
</head>
<body class="no-skin">
<!-- /section:basics/navbar.layout -->
<div class="main-container" id="main-container">
	<!-- /section:basics/sidebar -->
	<div class="main-content">
		<div class="main-content-inner">
			<div class="page-content">
				<div class="row">
					<div class="col-xs-12">
					<div style="margin-left:20px;margin-top:20px;">
					<span style="font-weight: bold;color:red;">
					<button style="border-radius: 20px;" type="button" class="btn btn-primary btn-sm btn-success">
					已关联的活动类别</button></span>
										       <c:forEach items="${listHobbyAndactivitycategory}" var="ts" varStatus="vs">
												
												<span class="badge" style="color:red;">${ts.activityCategoryName}</span>
											   </c:forEach>
						</div>
						<form action="#" name="form1" id="form1"  method="post">
						<%-- <input type="hidden" name="p_id" id="tid" value="${pd.p_id}"/>--%>
						<input type="hidden" name="hobby_id" id="hobby_id" value="${pd.hobby_id}"/> 
							<div id="zhongxin" style="padding-top:13px;">
							<table id="table_report" class="table table-striped table-bordered table-hover">
										
										<tr>
											<td style="width:140px;text-align: center;font-weight:bold;padding-top: 13px;">兴趣爱好名称:</td>
											<td><input style="width:98%;" type="text" name="hobby_name" id="hobby_name"  value="${tdUhobby.hobbyName }"  maxlength="32" placeholder="这里输入活动类型名称" title="活动类型名称"  /></td>
										</tr>
										<tr>
										<!-- 活动类型 -->
					                    <td colspan="2">
						
										       <c:forEach items="${allTdActivitycategoryList}" var="ts" varStatus="vs">
												
												<span class="badge">${ts.activitycategoryName}<input type='checkbox' name='ids' value="${ts.activitycategoryId }" class="ace"  /><span class="lbl"  ></span></span>
											   </c:forEach>
					                  	</td>
										</tr>
										<tr>
											<td style="width:140px;text-align: center;font-weight:bold;padding-top: 13px;">备注:</td>
											<td><textarea name="remark" id="remark" rows="5" cols="45">${tdUhobby.remark }</textarea></td>
										</tr>
										<tr>
											<td style="text-align: center;" colspan="10">
											<!-- 	<a class="btn btn-mini btn-primary" onclick="save();">保存</a>
												<a class="btn btn-mini btn-danger" onclick="top.Dialog.close();">取消</a> -->
<!-- 										<a title="修改兴趣爱好" class="btn btn-mini btn-danger" onclick="makeAll('确定要添加选中的数据吗?');" >修改爱好</a>
 -->									<a title="保存爱好" class="btn btn-mini btn-danger" onclick="makeAll('确定要添加选中的数据吗?');" >保存爱好</a>
											
											
											</td>
										</tr>
										
							</table>
							
							</div>
						</form>
					
					<div id="zhongxin2" class="center" style="display:none"><img src="static/images/jzx.gif" style="width: 50px;" /><br/><h4 class="lighter block green"></h4></div>
					</div>
					<!-- /.col -->
				</div>
				<!-- /.row -->
			</div>
			<!-- /.page-content -->
		</div>
	</div>
	<!-- /.main-content -->
</div>
<!-- /.main-container -->


	<!-- 页面底部js¨ -->
	<%@ include file="../index/foot.jsp"%>
	<!--提示框-->
		<!-- 添加时确认窗口 -->
	<script src="static/ace/js/bootbox.js"></script>
	<!-- ace scripts -->
	<script src="static/ace/js/ace/ace.js"></script>
	<script type="text/javascript" src="static/js/jquery.tips.js"></script>
	<script type="text/javascript">

	top.hangge();
	//保存
	function makeAll(msg){
	if($("#hobby_name").val().length > 5 ){
		$("#hobby_name").tips({
			side:3,
            msg:'长度过长，五个字之内',
            bg:'#AE81FF',
            time:2
        });
		$("#hobby_name").focus();
		return false;
	}
	if($("#hobby_name").val()=="" ){
		$("#hobby_name").tips({
			side:3,
            msg:'请输入兴趣爱好',
            bg:'#AE81FF',
            time:2
        });
		$("#hobby_name").focus();
		return false;
	} 
	
	bootbox.confirm(msg, function(result) {
		
		if(result) {
		
			var str = '';
			
			for(var i=0;i < document.getElementsByName('ids').length;i++)
			{
				  if(document.getElementsByName('ids')[i].checked){
				  	if(str=='') str += document.getElementsByName('ids')[i].value;
				  	else str += ',' + document.getElementsByName('ids')[i].value;
				  	
				  	
				  }
			}
			/* if(str==''){
				 bootbox.dialog({
					message: "<span class='bigger-110'>您没有选择任何内容!，请选择</span>",
					buttons: 			
					{ "button":{ "label":"确定", "className":"btn-sm btn-success"}}
				}); 
				$("#zcheckbox").tips({
					side:3,
		            msg:'点这里全选',
		            bg:'#AE81FF',
		            time:8
		        });
				
				return;
			}else */
		/* 	if(str!=''&&str!=null){ */
				if(msg == '确定要添加选中的数据吗?'){
				var hobby_name =document.getElementById("hobby_name").value;
				var hobby_id =document.getElementById("hobby_id").value;
				var remark =document.getElementById("remark").value;

				/*if ($("#hobbyName").val() == "") {
					$("#hobbyName").tips({
						side : 3,
						msg : '请输入兴趣爱好类型',
						bg : '#AE81FF',
						time : 2
					});
					$("#hobbyName").focus();
					return false;
				}	 */
					
					$.ajax({
						type: "POST",
						url: '<%=basePath%>hobby/editHobbyById.do?tm='+new Date().getTime(),
				    	data: {
				    		Activitycategory_IDS:str,
				    		hobby_name:hobby_name,
				    		remark:remark,
				    		hobby_id:hobby_id
				    		},
						dataType:'json',
						//beforeSend: validateData,
						cache: false,
						success: function(data){
							
							
							 alert("保存成功");
							 window.opener=null;
								window.open('','_self');
								window.close();

						},
						error:function(){	
							alert("添加成功");
							 var diag = new top.Dialog();
							
					         diag.close();
					       
						}
						
						
					});
				}
			/* } */
		}
	});
}
	<%-- function makeAll(){
	
		/* 	if($("#hobby_name").val().length > 5 ){
				$("#hobby_name").tips({
					side:3,
		            msg:'长度过长，五个字之内',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#hobby_name").focus();
				return false;
			}
			if($("#hobby_name").val()!=null ){
				$("#hobby_name").tips({
					side:3,
		            msg:'请输入兴趣爱好',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#hobby_name").focus();
				return false;
			} */
			alert("a");
			var msg = '确定要添加选中的数据吗?';
			bootbox.confirm(msg, function(result) {
				alert("b");
				if(result) {
					var str = '';
					
					for(var i=0;i < document.getElementsByName('ids').length;i++)
					{
						  if(document.getElementsByName('ids')[i].checked){
						  	if(str=='') str += document.getElementsByName('ids')[i].value;
						  	else str += ',' + document.getElementsByName('ids')[i].value;
						  	
						  	
						  }
					}
					if(str==''){
						bootbox.dialog({
							message: "<span class='bigger-110'>您没有选择任何内容!</span>",
							buttons: 			
							{ "button":{ "label":"确定", "className":"btn-sm btn-success"}}
						});
						$("#zcheckbox").tips({
							side:3,
				            msg:'点这里全选',
				            bg:'#AE81FF',
				            time:8
				        });
						
						return;
					}else{
						if(msg == '确定要添加选中的数据吗?'){
						var hobby_name =document.getElementById("hobby_name").value;
						if ($("#hobby_name").val() == "") {
							$("#hobby_name").tips({
								side : 3,
								msg : '请输入兴趣爱好类型',
								bg : '#AE81FF',
								time : 2
							});
							$("#hobby_name").focus();
							return false;
						}	
							
							$.ajax({
								type: "POST",
								url: '<%=basePath%>hobby/editHobbyById.do?tm='+new Date().getTime(),
						    	data: {
						    		Activitycategory_IDS:str,
						    		hobby_name:hobby_name,
						    		remark:remark,
						    		hobby_id:hobby_id
						    		},
								dataType:'json',
								//beforeSend: validateData,
								cache: false,
								success: function(data){
									
									
									 alert("保存成功");
									 window.opener=null;
										window.open('','_self');
										window.close();

								},
								error:function(){	
									alert("添加成功");
									 var diag = new top.Dialog();
									
							         diag.close();
							       
								}
								
								
							});
						}
					}
				}
			});
	
		
		
			
			$("#zhongxin").hide();
			$("#zhongxin2").show();
	}
	 --%>
	
	</script>
</body>
</html>

