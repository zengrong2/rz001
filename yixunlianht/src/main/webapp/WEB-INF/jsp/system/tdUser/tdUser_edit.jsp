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
						<form action="clientUser/editTdUserByUid.do" name="form1" id="form1"  method="post">
						<%-- <input type="hidden" name="p_id" id="tid" value="${pd.p_id}"/>--%>
						<input type="hidden" name="userId" id="tid" value="${pd.user_id}"/> 
							<div id="zhongxin" style="padding-top:13px;">
							<table id="table_report" class="table table-striped table-bordered table-hover">
										
										<tr>
											<td style="width:200px;text-align: center;font-weight:bold;padding-top: 13px;">用户昵称:</td>
											<td><input style="width:80%;" type="text" name="uName" id="name"  value="${tdUser.uNickname }"  maxlength="32" placeholder="这里输入活动类型名称" title="活动类型名称"  /></td>
										</tr>
									
										<tr>
											<td style="width:200px;text-align: center;font-weight:bold;padding-top: 13px;">手机号码:</td>
											<td><input style="width:80%;" type="text" name="uPhone" id="name"  value="${tdUser.uPhone }"  maxlength="32" placeholder="请输入手机号码" title="手机号码"  /></td>
										</tr>
										<tr>
											<td style="width:200px;text-align: center;font-weight:bold;padding-top: 13px;">会员类型:</td>
											<td>
											
											
											 <select  name="utypeId" id="utypeId" data-placeholder="选择用户类型" style="vertical-align:top;width: 120px;">
														<c:forEach items="${listTdUtype}" var="u">				
																<option value="${u.utypeId}" <c:if test="${memberType.utypeId ==u.utypeId }">selected</c:if> >${u.userType }</option>								
														</c:forEach>	
														
										     </select>
										     </td>
									<%-- 		
											<input style="width:80%;" type="text" name="utypeId" id="name"  value="${memberType.userType }"  maxlength="32" placeholder="这里输入活动类型名称" title="活动类型名称"  /></td>--%>
										</tr>
									<%-- 	<tr>
											<td style="width:200px;text-align: center;font-weight:bold;padding-top: 13px;">行业:</td>
											<td><input style="width:80%;" type="text" name="egidId" id="name"  value="${tdUser.egidId }"  maxlength="32" placeholder="这里输入活动类型名称" title="活动类型名称"  /></td>
										</tr> --%>
										<tr>
											<td style="width:200px;text-align: center;font-weight:bold;padding-top: 13px;">会员号:</td>
											<td><input style="width:80%;" type="text" name="memberid" id="name"  value="${tdUser.memberid }"  maxlength="32" placeholder="请输入会员号" title="会员号"  /></td>
										</tr>
										<tr>
											<td style="width:200px;text-align: center;font-weight:bold;padding-top: 13px;">信用值:</td>
											<td><input style="width:80%;" type="text" name="creditrdNum" id="name"  value="${tdUser.creditrdNum }"  maxlength="32" placeholder="请设置会员值" title="会员值"  /></td>
										</tr>
										<tr>
											<td style="width:200px;text-align: center;font-weight:bold;padding-top: 13px;">推荐人会员号:</td>
											<td>
											<c:if test="${tdUser.userrefereememberid ==null||tdUser.userrefereememberid=='' }">
											<input style="width:30%;" type="text" name="userrefereeName" id="userrefereeName"  value="运营中心"  maxlength="32" placeholder="请输入推荐人会员号" title="推荐人会员号"  />
											</c:if>
											<c:if test="${tdUser.userrefereememberid !=null&&tdUser.userrefereememberid!='' }">
											<input style="width:30%;" type="text" name="userrefereeName" id="userrefereeName"  value="${tdUser.userrefereememberid }"  maxlength="32" placeholder="请输入推荐人会员号" title="推荐人会员号"  />
											</c:if><span id="showUserRefereeName">
											${tdUser.userrefereeName }</span>
                                         <select class="chosen-select form-control"   id="nav-search-input" name="USER_IDs" value=""  data-placeholder="选择运营中心" style="vertical-align:top;width: 150px;margin-top:-30px;margin-left:220px;">
															<option value="">选择运营中心</option>
															<c:forEach items="${listOperationCenter}" var="u">
																
															   <option value="${u.USER_ID}"  >${u.NAME }</option>
															</c:forEach>
															<i class="ace-icon fa fa-search nav-search-icon"></i>
														  	</select>
                                          </td>
										</tr>
										
										<tr>
											<td style="width:200px;text-align: center;font-weight:bold;padding-top: 13px;">归属人(即客户经理)会员号:</td>
											<td>
											<%-- <c:if test="${tdUser.usermanagermemberid ==null||tdUser.usermanagermemberid=='' }">
											<input style="width:30%;" type="text" name="usermanagerName" id="name"  value="运营中心"  maxlength="32" placeholder="请输入归属人会员号" title="归属人会员号"  />
											</c:if>
											<c:if test="${tdUser.usermanagermemberid !=null&&tdUser.usermanagermemberid!='' }">
											<input style="width:30%;" type="text" name="usermanagerName" id="name"  value="${tdUser.usermanagermemberid }"  maxlength="32" placeholder="请输入归属人会员号" title="归属人会员号"  />
											</c:if>
											<span style="color:red;">
											${tdUser.usermanagerName }											
											</span> --%>
											<input type="hidden" name="userManagerUids" value="" id="userManagerUids">
										 <input style="width:30%;" type="text" name="usermanagerName" id="usermanagerName"  value="${tdUser.usermanagerName }" readonly="readonly" maxlength="32" placeholder="归属人名称" title="归属人名称"  />
											
											 <span class="glyphicon glyphicon-zoom-in" style="color: rgb(255, 140, 60);" aria-hidden="true" id="findManager">点击查询归属人</span>
                                           
                                              </td>
										</tr>
										<%-- <tr>
											<td style="width:200px;text-align: center;font-weight:bold;padding-top: 13px;">个人或者企业:</td>
											<td><input style="width:80%;" type="text" name="userType" id="name"  value="${tdUser.userType }"  maxlength="32" placeholder="这里输入活动类型名称" title="活动类型名称"  /></td>
										</tr> --%>
										<%-- <tr>
											<td style="width:200px;text-align: center;font-weight:bold;padding-top: 13px;">用户是否激活:</td>
											<td><input style="width:80%;" type="text" name="userIsactivation" id="name"  value="${tdUser.userIsactivation }"  maxlength="32" placeholder="这里输入活动类型名称" title="活动类型名称"  /></td>
										</tr> --%>
										<tr>
											<td style="width:200px;text-align: center;font-weight:bold;padding-top: 13px;">会员天数:</td>
											<td><input style="width:80%;" type="number" name="memberDays" id="memberDays"  value="${tdUser.memberDays }" checked="checked"  maxlength="32" placeholder="这里输入活动类型名称" title="活动类型名称"  /></td>
										</tr>
										<tr>
											<td style="width:200px;text-align: center;font-weight:bold;padding-top: 13px;">授权特殊类别:</td>
											<td>
											<c:if test="${tdUser.isSpecialActivitytypeUser==0 }">
											<input type="radio" name="isSpecialActivitytypeUser" id="isSpecialActivitytypeUser" value="0" checked="checked" style="margin-left:40px;"/><span style="font-family: cursive;font-size: 16px;">否</span>
										    <input type="radio" name="isSpecialActivitytypeUser" id="isSpecialActivitytypeUser" value="1" style="margin-left:60px;"/><span style="font-family: cursive;">是</span>
										    </c:if>
										    <c:if test="${tdUser.isSpecialActivitytypeUser==1 }">
											<input type="radio" name="isSpecialActivitytypeUser" id="isSpecialActivitytypeUser" value="0"  style="margin-left:40px;"/><span style="font-family: cursive;">否</span>
										    <input type="radio" name="isSpecialActivitytypeUser" id="isSpecialActivitytypeUser" value="1" checked="checked" style="margin-left:60px;"/><span style="font-family: cursive;font-size: 16px;">是</span>
										    </c:if>
											</td>
										</tr>
										
										
										<tr>
											<td style="width:200px;text-align: center;font-weight:bold;padding-top: 13px;">备注:</td>
											<td><textarea name="remark" id="remark" rows="5" cols="45">${tdUser.remark }</textarea></td>
										</tr>
										<tr>
											<td style="text-align: center;" colspan="10">
												<a class="btn btn-mini btn-primary" onclick="save();">保存</a>
												<a class="btn btn-mini btn-danger" onclick="top.Dialog.close();">取消</a>
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
	<script type="text/javascript" src="static/js/jquery.tips.js"></script>
	<script type="text/javascript">
	top.hangge();

	$("#findManager").click(function () {
		//alert("asd");
		var userrefereeName = $("#userrefereeName").val();
		$.ajax({
			url : '<%=basePath%>clientUser/byRefereeMemberidFindUserManagerName.do',
			dataType:"json",
			data : {
				memberid : userrefereeName,
			},
			success : function(result) {
			if(result.uNickname!=""){
			//	alert("name"+result.uNickname);
              
				$("#usermanagerName").val(result.uNickname); 
			}else{
				//$("#userrefereeName").val("查无此人"); 
				
				$("#usermanagerName").val(result.uNickname);
			}
			if(result.ManagerUserId!=""){
                     // alert("ff"+result.ManagerUserId);
			  $("#userManagerUids").val(result.ManagerUserId); 
			}else{
			// alert("2ff"+result.ManagerUserId);
			  $("#userManagerUids").val(result.ManagerUserId); 
				
			}
			//userRefereeName
		//	alert("text"+result.userRefereeName);
		 $("#showUserRefereeName").text(result.userRefereeName); 
			if (!result.success) {
			valid = false;
			showError(login_userNameError, '*' + result.msg);
			}
			},
			error:function(){
			//	$("#userrefereeName").val("查无此人"); 
			}
			});
	})
	//保存
	function save(){
	
		if($("#utypeId").val()>1){			
		if ($("#memberDays").val() <=0) {
			$("#memberDays").tips({
				side : 3,
				msg : '请输入大于0的正确数字',
				bg : '#AE81FF',
				time : 2
			});
			$("#memberDays").focus();
			return false;
		}
		}
		if($("#utypeId").val()==1){			
			if ($("#memberDays").val() <0) {
				$("#memberDays").tips({
					side : 3,
					msg : '请输入大于等于0的正确数字',
					bg : '#AE81FF',
					time : 2
				});
				$("#memberDays").focus();
				return false;
			}
		}
		
		/* if ($("#name").val() == "") {
			$("#name").tips({
				side : 3,
				msg : '请输入职位名称',
				bg : '#AE81FF',
				time : 2
			});
			$("#name").focus();
			return false;
		}
		var myreg=/^[0-9]+([.]{1}[0-9]+){0,1}$/;
		var ph=$("#p_salary").val();
		if($("#p_salary").val()==""){
			
			$("#p_salary").tips({
				side:3,
	            msg:'输入职位薪资',
	            bg:'#AE81FF',
	            time:3
	        });
			$("#p_salary").focus();
			return false;
		}else if($("#p_salary").val().length > 15 ){
			$("#p_salary").tips({
				side:3,
	            msg:'数字过长',
	            bg:'#AE81FF',
	            time:3
	        });
			$("#p_salary").focus();
			return false;
		}else if(!myreg.test(ph)){
			$("#p_salary").tips({
				side:3,
	            msg:'请输入数字',
	            bg:'#AE81FF',
	            time:3
	        });
			$("#p_salary").focus();
			return false;
		}
		if ($("#p_content").val() == "") {
			$("#p_content").tips({
				side : 3,
				msg : '请输入工作详细内容',
				bg : '#AE81FF',
				time : 2
			});
			$("#p_content").focus();
			return false;
		}
		
		if ($("#p_requirement").val() == "") {
			$("#p_requirement").tips({
				side : 3,
				msg : '请输入职位需求',
				bg : '#AE81FF',
				time : 2
			});
			$("#p_requirement").focus();
			return false;
		}
		if ($("#work").val() == "") {
			$("#work").tips({
				side : 3,
				msg : '请输入工作职位',
				bg : '#AE81FF',
				time : 2
			});
			$("#work").focus();
			return false;
		}
		 */
		
		
			$("#form1").submit();
			$("#zhongxin").hide();
			$("#zhongxin2").show();
	}
	
	
	</script>
</body>
</html>

