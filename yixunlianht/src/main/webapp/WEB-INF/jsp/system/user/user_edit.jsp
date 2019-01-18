<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
<base href="<%=basePath%>">
<!-- 下拉框 -->
<link rel="stylesheet" href="static/ace/css/chosen.css" />
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
								<form action="user/${msg }.do" name="userForm" id="userForm" method="post">
									<input type="hidden" name="USER_ID" id="user_id" value="${pd.USER_ID }"/>
									<div id="zhongxin" style="padding-top: 13px;">
									<table id="table_report" class="table table-striped table-bordered table-hover">
										<c:if test="${fx != 'head'}">
										<tr>
											<td style="width:79px;text-align: right;padding-top: 13px;">角色:</td>
											<td id="juese">
											<select class="chosen-select form-control" name="ROLE_ID" id="role_id" data-placeholder="请选择角色" style="vertical-align:top;" style="width:98%;" >
											<option value=""></option>
											<c:forEach items="${roleList}" var="role">
												<option value="${role.ROLE_ID }" <c:if test="${role.ROLE_ID == pd.ROLE_ID }">selected</c:if>>${role.ROLE_NAME }</option>
											</c:forEach>
											</select>
											</td>
                                            </tr>

									</c:if>
										<c:if test="${fx == 'head'}">
											<input name="ROLE_ID" id="role_id" value="${pd.ROLE_ID }" type="hidden" />
										</c:if>
										<tr>
										<td colspan="2" style="width:79px;text-align: right;padding-top: 13px;">
										<span style="position:absolute; left:20px;">选择地区:</span>
										<span style="position:absolute; left:120px;">省份:</span><select id="pid" name="citycode1" style="width:100px;position:absolute;left:150px;top:68px;">
　                                                                                           　<option value="">请选择省</option>
　　                                                                                           </select>
　　                                                                                            <span style="position:absolute; left:250px;">城市:</span><select id="cid" name="citycode2" style="width:100px;position:absolute;left:290px; top:68px; ">
　　                                                                                             <option value="">请选择市</option>
　　                                                                                               </select>
　　　                                                                                   <!--     <span style="position:absolute; left:290px;">区县:</span><select id="did" name="citycode3" style="width:100px;position:absolute;left:340px;top:68px; ">
　                                                                                           　<option value="-1">请选择地区</option>
　　                                                                                           </select>
                                      -->
										</td>	</tr>
										<tr>
											<td style="width:79px;text-align: right;padding-top: 13px;">手机号:</td>
											<td><input type="text" name="PHONE" id="PHONE"  value="${pd.PHONE }"  maxlength="32" placeholder="这里输入手机号" title="手机号" style="width:98%;" /></td>
										</tr>
										<tr>
											<td style="width:79px;text-align: right;padding-top: 13px;">密码:</td>
											<td><input type="password" name="PASSWORD" id="password"  maxlength="32" placeholder="输入密码" title="密码" style="width:98%;"/></td>
										</tr>
										<tr>
											<td style="width:79px;text-align: right;padding-top: 13px;">确认密码:</td>
											<td><input type="password" name="chkpwd" id="chkpwd"  maxlength="32" placeholder="确认密码" title="确认密码" style="width:98%;"/></td>
										</tr>
										<tr>
											<td style="width:79px;text-align: right;padding-top: 13px;">姓名:</td>
											<td><input type="text" name="NAME" id="name"  value="${pd.NAME }"  maxlength="32" placeholder="这里输入姓名" title="姓名" style="width:98%;"/></td>
										</tr>
										
										<tr>
											<td style="width:79px;text-align: right;padding-top: 13px;">性别:</td>
											<td><input type="text" name="sex" id="sex"  value="${pd.sex }" maxlength="32" placeholder="这里输入性别" title="性别"  style="width:98%;"/></td>
										</tr>
										
										<tr>
											<td style="width:79px;text-align: right;padding-top: 13px;">备注:</td>
											<td><input type="text" name="remark" id="remark"value="${pd.remark }" placeholder="这里输入备注" maxlength="64" title="备注" style="width:98%;"/></td>
										</tr>
										
							
										
										<tr>
											<td style="text-align: center;" colspan="10">
												<a class="btn btn-mini btn-primary" onclick="save();">保存</a>
												<a class="btn btn-mini btn-danger" onclick="top.Dialog.close();">取消</a>
											</td>
										</tr>
							<!--			
										<c:choose>
								<c:when test="${not empty listAddress}">
									
									<c:forEach items="${listAddress}" var="ts" varStatus="vs">
										<tr>	
										<td class="center">${ts.cityname }</td>
										</tr>
									</c:forEach>
									</c:when>
									</c:choose>
										-->						
									
									</table>
									</div>
									<div id="zhongxin2" class="center" style="display:none"><br/><br/><br/><br/><img src="static/images/jiazai.gif" /><br/><h4 class="lighter block green"></h4></div>
								</form>
						</div>
						<!-- /.col -->
					</div>
					<!-- /.row -->
				</div>
				<!-- /.page-content -->
			</div>
		</div>
		<!-- main-content -->
	</div>
	<!-- main-container -->
	<!-- basic scripts -->
	<!-- 页面底部js¨ -->
	<%@ include file="../index/foot.jsp"%>
	<!-- ace scripts -->
	<script src="static/ace/js/ace/ace.js"></script>
	<!-- inline scripts related to this page -->
	<!-- 下拉框 -->
	<script src="static/ace/js/chosen.jquery.js"></script>
	<!--提示框-->
	<script type="text/javascript" src="static/js/jquery.tips.js"></script>
</body>
<script type="text/javascript">
$(function(){
　　$.ajax({
　　type:"post",
　　url: "<%=basePath%>tdAddress/province.do?time="+Math.random(),
　　dataType:"json",//指定返回的格式
　　success:function(data){
     for(var i=0;i<data.length;i++){

　　　　var pid=data[i].citycode//返回对象的一个属性
　　　　var pname=data[i].cityname;
　　　　$("<option value='"+pid+"'>"+pname+"</option>").appendTo($("#pid"));//添加下拉列表
　　}
}
});

$(function(){
　　$("#pid").change(function(){
　　//清空下面两个子下拉列表(option中value值大于0的删除)
　　$("#cid option:gt(0)").remove();
　　$("#did option:gt(0)").remove();

　　if($("#pid").val()==-1){
　　return;//没有选择的就不去调用
}
//使用post方式

  $.post(
　　　　"<%=basePath%>tdAddress/city.do?time="+Math.random(),
　　　　{"pid":$("#pid").val()},//参数
　　　　function(data){
　　　　for(var i=0;i<data.length;i++){
　　　　var cid=data[i].citycode;
　　　　var cname=data[i].cityname;
　　　　$("<option value='"+cid+"'>"+cname+"</option>").appendTo($("#cid"));//添加下拉列表
　　}
},
　　"json"//指定返回类型
　　);
}); 
});
 
$(function(){
　　$("#cid").change(function(){
　　$("#did option:gt(0)").remove();
　　if($("#cid").val()==-1){
　　　　return;
　　}
　　$.getJSON(//这种访问方式返回的就是JSON格式数据
　　"<%=basePath%>tdAddress/district.do?time="+Math.random(),
　　{"cid":$("#cid").val()},
　　function(data){
　　　　for(var i=0;i<data.length;i++){
　　　　var did=data[i].citycode;
　　　　var dname=data[i].cityname;
　　　　$("<option value='"+did+"'>"+dname+"</option>").appendTo($("#did"));
　　}
}
);
});
});
});



	$(top.hangge());
	$(document).ready(function(){
		if($("#user_id").val()!=""){
			$("#loginname").attr("readonly","readonly");
			$("#loginname").css("color","gray");
		}
	});
	//保存
	function save(){
		if($("#role_id").val()==""){
			$("#juese").tips({
				side:3,
	            msg:'选择角色',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#role_id").focus();
			return false;
		}
		
		
		if($("#user_id").val()=="" && $("#password").val()==""){
			$("#password").tips({
				side:3,
	            msg:'输入密码',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#password").focus();
			return false;
		}
		if($("#password").val()!=$("#chkpwd").val()){
			
			$("#chkpwd").tips({
				side:3,
	            msg:'两次密码不相同',
	            bg:'#AE81FF',
	            time:3
	        });
			$("#chkpwd").focus();
			return false;
		}
		if($("#name").val()==""){
			$("#name").tips({
				side:3,
	            msg:'输入姓名',
	            bg:'#AE81FF',
	            time:3
	        });
			$("#name").focus();
			return false;
		}
		var ph=$("#PHONE").val();
		if($("#PHONE").val()==""){ 
			
			$("#PHONE").tips({
				side:3,
	            msg:'输入手机号',
	            bg:'#AE81FF',
	            time:3
	        });
			$("#PHONE").focus();
			return false;
		}
			$("#userForm").submit();
			$("#zhongxin").hide();
			$("#zhongxin2").show();

	}
	
	
	//判断用户名是否存在
	function hasU(){
		var USERNAME = $.trim($("#loginname").val());
		$.ajax({
			type: "POST",
			url: '<%=basePath%>user/hasU.do',
	    	data: {USERNAME:USERNAME,tm:new Date().getTime()},
			dataType:'json',
			cache: false,
			success: function(data){
				 if("success" == data.result){
					$("#userForm").submit();
					$("#zhongxin").hide();
					$("#zhongxin2").show();
				 }else{
					$("#loginname").css("background-color","#D16E6C");
					setTimeout("$('#loginname').val('此用户名已存在!')",500);
				 }
			}
		});
	}
	

	
	//判断编码是否存在
	function hasN(USERNAME){
		var NUMBER = $.trim($("#NUMBER").val());
		$.ajax({
			type: "POST",
			url: '<%=basePath%>user/hasN.do',
	    	data: {NUMBER:NUMBER,USERNAME:USERNAME,tm:new Date().getTime()},
			dataType:'json',
			cache: false,
			success: function(data){
				 if("success" != data.result){
					 $("#NUMBER").tips({
							side:3,
				            msg:'编号 '+NUMBER+' 已存在',
				            bg:'#AE81FF',
				            time:3
				        });
					 $("#NUMBER").val('');
				 }
			}
		});
	}
	$(function() {
		//下拉框
		if(!ace.vars['touch']) {
			$('.chosen-select').chosen({allow_single_deselect:true}); 
			$(window)
			.off('resize.chosen')
			.on('resize.chosen', function() {
				$('.chosen-select').each(function() {
					 var $this = $(this);
					 $this.next().css({'width': $this.parent().width()});
				});
			}).trigger('resize.chosen');
			$(document).on('settings.ace.chosen', function(e, event_name, event_val) {
				if(event_name != 'sidebar_collapsed') return;
				$('.chosen-select').each(function() {
					 var $this = $(this);
					 $this.next().css({'width': $this.parent().width()});
				});
			});
			$('#chosen-multiple-style .btn').on('click', function(e){
				var target = $(this).find('input[type=radio]');
				var which = parseInt(target.val());
				if(which == 2) $('#form-field-select-4').addClass('tag-input-style');
				 else $('#form-field-select-4').removeClass('tag-input-style');
			});
		}
	});
</script>
</html>