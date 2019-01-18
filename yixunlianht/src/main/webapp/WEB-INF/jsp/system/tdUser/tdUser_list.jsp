<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
<!-- 日期框 -->
<link rel="stylesheet" href="static/ace/css/datepicker.css" />
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
						
						<!-- 检索  -->
						<form action="clientUser/goListClientUser.do" method="post" name="userForm" id="userForm">
						
						<table style="margin-top:5px;" class="table table-striped table-bordered table-hover">
						<thead>
								<tr>
								<th style="text-align: center;">用户总人数</th>
								<th style="text-align: center;">未激活用户</th>
								<th style="text-align: center;">即普通用户</th>
								<th style="text-align: center;">普通客户经理</th>
								<th style="text-align: center;">Vip体验人数</th>
								<th style="text-align: center;">Vip试用人数</th>
								
								<th style="text-align: center;">Vip客户经理</th>
								<th style="text-align: center;">钻石客户经理</th>
								<th style="text-align: center;">未参加应用培训</th>
								</tr>
						<tr>
						<tbody>
						<td style="text-align: center;">
						<span style="width:120px;font-weight: bold;">
							
							${tdUserCount.memberCount }</span>
						</td>
						<td style="text-align: center;">
						<span style="width:120px;font-weight: bold;">
														
							${tdUserCount.notActiveCount }</span>
						</td>
						<td style="text-align: center;">
						<span style="width:120px;font-weight: bold;">
							
							${tdUserCount.primaryCount }</span>
						</td>
						<td style="text-align: center;">
						<span style="width:120px;font-weight: bold;">
							
						    ${tdUserCount.customerManagerCount }</span>
						</td>
						<td style="text-align: center;">
						<span style="width:120px;font-weight: bold;">
							
							${tdUserCount.VIPExperienceCount }</span>
						</td>
						<td style="text-align: center;">
						<span style="width:120px;font-weight: bold;">
							
							${tdUserCount.VIPTryCount }</span>
						</td>
						<td style="text-align: center;">
						<span style="width:120px;font-weight: bold;">		
							${tdUserCount.vipcusManagerCount}</span>
						</td>
						<td style="text-align: center;">
						<span style="width:120px;font-weight: bold;">
						${tdUserCount.diamondsCustomerManagerCount }
							</span> 
						</td>
						<td style="text-align: center;">
						<span style="width:120px;font-weight: bold;color:red;">
							<span   onclick="showNotJoinIsSpecialActivitytypeUser()">
							${tdUserCount.countNotJoinIsSpecialActivitytypeUser }</span></span>

						</td>
						</tr>
						</tbody>
						</table>
						<table style="margin-top:-15px;">
							<tr>
								<td>
									<div class="nav-search">
									<span >
										<input class="nav-search-input" autocomplete="off" id="nav-search-input" type="text" name="keywords" value="${pd.keywords }" placeholder="用户姓名" style="width:80px;"/>
									
									</span>
									</div>
									</td>
<!-- 								<td style="vertical-align:top;padding-left:2px;"><a class="btn btn-light btn-xs" onclick="searchs();"  title="检索"><i id="nav-search-icon" class="ace-icon fa fa-search bigger-110 nav-search-icon blue"></i></a></td>
 -->								<td>
									<div class="nav-search">	
									<span >
										<input class="nav-search-input" autocomplete="off" id="nav-search-input" type="text" name="memberid" value="${pd.memberid }"  placeholder="会员号" style="width:80px;" />										
														
									</span>
									</div>
									
								</td>
								
<!-- 								<td style="vertical-align:top;padding-left:2px;"><a class="btn btn-light btn-xs" onclick="searchs();"  title="检索"><i id="nav-search-icon" class="ace-icon fa fa-search bigger-110 nav-search-icon blue"></i></a></td>
 -->					  <td>
									<div class="nav-search">	
									<span >
										<input class="nav-search-input" autocomplete="off" id="nav-search-input" type="text" name="userRefereeNameNum" value="${pd.userRefereeNameNum }"   placeholder="推荐人会员号"  style="width:100px;"/>										
																
									</span>
									</div>
									
								</td>
								
<!-- 								<td style="vertical-align:top;padding-left:2px;"><a class="btn btn-light btn-xs" onclick="searchs();"  title="检索"><i id="nav-search-icon" class="ace-icon fa fa-search bigger-110 nav-search-icon blue"></i></a></td>
 -->					  <td>
									<div class="nav-search">	
									<span >
										<input class="nav-search-input" autocomplete="off" id="nav-search-input" type="text" name="userManagerNameNum"  value="${pd.userManagerNameNum }"   placeholder="归属人会员号" style="width:100px;"/>										
														
									</span>
									</div>
									
								</td>
								
<!-- 								<td style="vertical-align:top;padding-left:2px;"><a class="btn btn-light btn-xs" onclick="searchs();"  title="检索"><i id="nav-search-icon" class="ace-icon fa fa-search bigger-110 nav-search-icon blue"></i></a></td>
 -->					  <td>
									<div class="nav-search">	
									<%-- <span class="input-icon">
										<input class="nav-search-input" autocomplete="off" id="nav-search-input" type="text" name="userManagerNameNum"  value="${pd.userManagerNameNum }"   placeholder="请输入经理人会员号" />										
										<i class="ace-icon fa fa-search nav-search-icon"></i>						
									</span> --%>
									
									<span class="input-icon">
										<select class="chosen-select form-control"   id="nav-search-input" name="USER_IDs" id="w_id" data-placeholder="运营中心" style="vertical-align:top;width: 130px;">
															<option value="">选择运营中心</option>
															<c:forEach items="${listOperationCenter}" var="u">
																
															   <option value="${u.USER_ID}" <c:if test="${pd.USER_IDs == u.USER_ID }">selected</c:if>>${u.NAME }</option>
															</c:forEach>
															<i class="ace-icon fa fa-search nav-search-icon"></i>
														  	</select>
										
									</span>
									</div>
									
								</td>
								
					<!--			<td style="vertical-align:top;padding-left:2px;"><a class="btn btn-light btn-xs" onclick="searchs();"  title="检索"><i id="nav-search-icon" class="ace-icon fa fa-search bigger-110 nav-search-icon blue"></i></a></td>-->
					<td>
									<div class="nav-search">	
									<%-- <span class="input-icon">
										<input class="nav-search-input" autocomplete="off" id="nav-search-input" type="text" name="userManagerNameNum"  value="${pd.userManagerNameNum }"   placeholder="请输入经理人会员号" />										
										<i class="ace-icon fa fa-search nav-search-icon"></i>						
									</span> --%>
									
									<span class="input-icon">
										<select class="chosen-select form-control"   id="nav-search-input" name="UType_IDs" id="UType_IDs" data-placeholder="选择会员等级" style="vertical-align:top;width: 130px;">
															<option value="">选择会员等级</option>
															<c:forEach items="${listTdUtype}" var="u">
																
															   <option value="${u.utypeId}" <c:if test="${pd.UType_IDs == u.utypeId }">selected</c:if>>${u.userType }</option>
															</c:forEach>
															<i class="ace-icon fa fa-search nav-search-icon"></i>
														  	</select>
										
									</span>
									</div>
									
								</td>
								
								<!--选择搜索区域-->
								<td>
									<div class="nav-search">	
								
									<span class="input-icon">
										<select class="chosen-select form-control"   id="nav-search-input" name="cityCode_IDs" id="cityCode_IDs" data-placeholder="选择区域" style="vertical-align:top;width: 130px;">
															<option value="">选择区域</option>
															<c:forEach items="${listTdAddress}" var="u">
																
															   <option value="${u.citycode}" <c:if test="${pd.cityCode_IDs == u.citycode }">selected</c:if>>${u.cityname }</option>
															</c:forEach>
															<i class="ace-icon fa fa-search nav-search-icon"></i>
														  	</select>
										
									</span>
									</div>
									
								</td>
								
								
								<td style="vertical-align:top;padding-left:2px;"><a class="btn btn-light btn-xs" onclick="searchs();"  title="检索"><i id="nav-search-icon" class="ace-icon fa fa-search bigger-110 nav-search-icon blue"></i></a></td>
					
					  </tr>
				
						</table>
							<div style="margin-top:0px;">
					<table style="margin-top:10px;">
					<td><span style="font-family: cursive;">按注册时间搜索</span></td>
							<td style="vertical-align:top;padding-left:2px;">
							
									<div class="nav-search">
									<span class="input-icon">
										<input class="nav-search-input" autocomplete="off" id="start" type="date" name="start"  placeholder="这里输入开始时间" value="${pd.start}" />
									</span>
									</div>
								</td>
								<td>——</td>
								<td style="vertical-align:top;padding-left:2px;">
									<div class="nav-search">
									<span class="input-icon">
										<input class="nav-search-input" autocomplete="off" id="end" type="date" name="end"  value="${pd.end}" placeholder="这里输入结束时间" />
									</span>
									</div>
								</td>
								
								<td style="vertical-align:top;padding-left:2px;"><a class="btn btn-light btn-xs" onclick="searchs();"  title="检索"><i id="nav-search-icon" class="ace-icon fa fa-search bigger-110 nav-search-icon blue"></i></a></td>
							
							<td><span style="font-family: cursive;">按升级时间搜索</span></td>
							<td style="vertical-align:top;padding-left:2px;">
							
									<div class="nav-search">
									<span class="input-icon">
										<input class="nav-search-input" autocomplete="off" id="start" type="date" name="memberStart"  placeholder="这里输入开始时间" value="${pd.memberStart}" />
									</span>
									</div>
								</td>
								<td>——</td>
								<td style="vertical-align:top;padding-left:2px;">
									<div class="nav-search">
									<span class="input-icon">
										<input class="nav-search-input" autocomplete="off" id="end" type="date" name="memberEnd"  value="${pd.memberEnd}" placeholder="这里输入结束时间" />
									</span>
									</div>
								</td>
								
								<td style="vertical-align:top;padding-left:2px;"><a class="btn btn-light btn-xs" onclick="searchs();"  title="检索"><i id="nav-search-icon" class="ace-icon fa fa-search bigger-110 nav-search-icon blue"></i></a></td>
								<!-- 高级搜索 -->
							<td>
							<span style="width:150px;font-weight: bold;">
							<button style="border-radius: 20px;" type="button" class="btn btn-primary btn-sm btn-warning">
							高级搜索</button></span>
							</td>
							<td>
							<span style="width:150px;font-weight: bold;">
							<button style="border-radius: 20px;" type="button" class="btn btn-primary btn-sm btn-warning">
							配置列表</button></span>
							</td>
							
					 </table>
							
						<!--
							<span style="width:150px;margin-left:630px;font-weight: bold;">
							<button style="border-radius: 20px;" type="button" class="btn btn-primary btn-sm btn-warning">
							高级搜索</button></span>
							<span style="width:150px;margin-left:30px;font-weight: bold;">
							<button style="border-radius: 20px;" type="button" class="btn btn-primary btn-sm btn-warning">
							配置列表</button></span>
							-->
							</div>
							
						<!-- 检索  -->
						<table id="simple-table" class="table table-striped table-bordered table-hover"  style="margin-top:5px;">
							<thead>
								<tr>
									<!-- <th class="center" style="width:35px;">
									<label class="pos-rel"><input type="checkbox" class="ace" id="zcheckbox" /><span class="lbl"></span></label>
									</th> -->
								<!--	<th class="center" style="width:60px;">编号</th>-->
									    <th class='center'>用户名称</th>
									    <th class='center'>性别</th>
									    <th class='center' style="width:60px;">区域</th>
										<th class='center' style="width:60px;">会员号</th>
									<!--	<th class='center'>手机号</th>-->
									    <th class='center' style="width:80px;">级别</th>
									    <th class='center' style="width:85px;">升级时间</th>
									     <th class='center' style="width:40px;">有效期</th>
									    <th class='center'>推荐人</th>
									    <th class='center'>归属人</th>
									    <!--
									     <th class='center'>曾经参与</th>
									     <th class='center'>兴趣爱好</th>
									  
									     <th class='center'>个人需求</th>-->
									      <th class='center' style="width:50px;">应用培训</th>
									      <th class='center'>状态</th>
									    <th class='center' style="width:85px;">注册时间</th>
										
										
										<th class='center' style="width:200px;" >操作</th>
								</tr>
							</thead>						
							<tbody>
							<!-- 开始循环 -->	
							<c:choose>
								<c:when test="${not empty listTdUser}">
									<c:forEach items="${listTdUser}" var="ts" varStatus="vs">
										<tr>
										
											<%-- <td class='center' style="width: 30px;">
												<label><input type='checkbox' name='ids' value="${ts.activity_id }"   class="ace"/><span class="lbl"></span></label>
											</td> --%>
										<!--	<td class="center">${vs.index+1}</td> -->
											<td class='center'>${ts.u_nickname}</td>
										<td class='center'>
                                     	<c:if test="${ts.u_sex==0 }">
										女
										</c:if>	
										<c:if test="${ts.u_sex==1 }">
										男
										</c:if>	
                                        </td>
										<td class='center'>
                                        <c:if test="${ts.ProvCityName!=null&&ts.ProvCityName!='' }">
										${ts.ProvCityName}<br/>
										</c:if>
                                        <c:if test="${ts.CityCityName!=null&&ts.CityCityName!='' }">
										${ts.CityCityName}<br/>
										</c:if>	
                                        <c:if test="${ts.AreaCityName!=null&&ts.AreaCityName!='' }">
										${ts.AreaCityName}
										</c:if>		
                                         </td>
										<td class='center'>${ts.memberid }</td>
								<!--		<td class='center'>${ts.u_phone }</td>-->
										
										<td class='center'>${ts.userType}</td>
                                        <td class='center'>
                                        <c:if test="${ts.utype_id!=1&&ts.utype_id!=4 }">
										${ts.member_start_time}
										</c:if>	
                                        <c:if test="${ts.utype_id!=1&&ts.utype_id==4 }">
										${ts.experience_time}
										</c:if>	
                                        </td>
                                         <td class='center'>${ts.member_days}</td>
										<td class='center'>${ts.userRefereeName}</td>
										<td class='center'>${ts.userManagerName}</td>
                                     <!--
										<td class="center" >
										<div style="cursor:pointer;color:blue;margin-left:10px;" onClick="toUserOverJoinDetail('${ts.user_id}')">查阅</div>										
										
										</td>
										<td class="center" >
										<div style="cursor:pointer;color:blue;margin-left:10px;" onClick="toUserHobbyDetail('${ts.user_id}')">查阅</div>										
										
										</td>
										<td class="center" >
										<div style="cursor:pointer;color:blue;margin-left:10px;" onClick="toUserneedDetail('${ts.user_id}')">查阅</div>										
										
										</td>
										-->
                                        <td class='center'>
                                      	
                                        <c:if test="${ts.isJoinTrain==1 }">
										未参加
										</c:if>	
                                        <c:if test="${ts.isJoinTrain==2 }">
										已参加
										</c:if>	
                                        </td>

                                      
                                        <td class='center'>
                                        <c:if test="${ts.user_isactivation!=2 }">
										未激活
										</c:if>	
                                        <c:if test="${ts.user_isactivation==2 }">
									     <c:if test="${ts.closed_user_status==0 }">
										正常
										</c:if>	
                                        <c:if test="${ts.closed_user_status==1 }">
										冻结
										</c:if>	
										</c:if>	
                                       
                                        </td>
										<td class='center'>${ts.register_time}</td>
									
										</td>
											<td class="center">
										<!--	<div class="hidden-sm hidden-xs btn-group">-->
                                         <span>
											     <a class="btn btn-xs btn-info" title="查看个人资料" onclick="showUserDetail('${ts.user_id}');">						
											     <span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>
												 </a>
											</span>
												<c:if test="${QX.edit != 1 && QX.del != 1 }">
												<span class="label label-large label-grey arrowed-in-right arrowed-in"><i class="ace-icon fa fa-lock" title="无权限"></i></span>
												
												</c:if>
											<!--	<div class="hidden-sm hidden-xs btn-group">-->
                                            <span>
													<c:if test="${QX.del == 1 }">
													
													<a class="btn btn-xs btn-success" title="编辑" onclick="editT('${ts.user_id}');">
														<i class="ace-icon fa fa-pencil-square-o bigger-120" title="编辑"></i>
													</a>
												
												<%--  <a class="btn btn-xs btn-warning" title="封户" onclick="changeStatusClosedDoorById('${ts.user_id}');">						
											     <span class="glyphicon glyphicon-minus-sign" aria-hidden="true"></span>
												 </a> --%>
													
												 	<a class="btn btn-xs btn-danger" onclick="delUser('${ts.user_id}');">
														<i class="ace-icon fa fa-trash-o bigger-120" title="删除"></i>
													</a> 
													<c:if test="${ts.closed_user_status==0 }">
													<a class="label label-error arrowed" onclick="changeStatusClosedDoorById('${ts.user_id}','${ts.closed_user_status}');">查封用户</a>
													</c:if>
													<c:if test="${ts.closed_user_status!=0 }">
													<a class="label label-info arrowed" onclick="changeStatusClosedDoorById('${ts.user_id}','${ts.closed_user_status}');">解封用户</a>
													</c:if>
													</c:if>
													
													
												</span>		
																										
											</td>										
										</tr>
										
									</c:forEach>

									<c:if test="${QX.cha == 0 }">
										<tr>
											<td colspan="15" class="center">您无权查看</td>
										</tr>
									</c:if>
								</c:when>
								<c:otherwise>
									<tr class="main_info">
										<td colspan="15" class="center">没有相关数据</td>
									</tr>
								</c:otherwise>
							</c:choose>
							</tbody>
						</table>
					 <div class="page-header position-relative">
					<table style="width:100%;">
						<tr>
						<td style="vertical-align:top;">
							<%-- <c:if test="${QX.add == 1 }">
								<a class="btn btn-mini btn-success" onclick="add();">新增</a>
								</c:if>
							<c:if test="${QX.del == 1 }">
								<a title="批量删除" class="btn btn-mini btn-danger" onclick="makeAll('确定要删除选中的数据吗?');" >批量删除<i class='ace-icon fa fa-trash-o bigger-120'></i></a>
								</c:if> --%>		
						</td>
							<td style="vertical-align:top;"><div class="pagination" style="float: right;padding-top: 0px;margin-top: 0px;">${page.pageStr}</div></td>
						</tr>
					</table>
					</div>
					</form>
						</div>
						<!-- /.col -->
					</div>
					<!-- /.row -->
				</div>
				<!-- /.page-content -->
			</div>
		</div>
		<!-- /.main-content -->

		<!-- 返回顶部 -->
		<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
			<i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
		</a>

	</div>
	<!-- /.main-container -->
	<!-- basic scripts -->
	<!-- 页面底部js¨ -->
	<%@ include file="../index/foot.jsp"%>
	<!-- 删除时确认窗口 -->
	<script src="static/ace/js/bootbox.js"></script>
	<!-- ace scripts -->
	<script src="static/ace/js/ace/ace.js"></script>
	<!-- 日期框 -->
	<script src="static/ace/js/date-time/bootstrap-datepicker.js"></script>
	<!-- 下拉框 -->
	<script src="static/ace/js/chosen.jquery.js"></script>
	<!--提示框-->
	<script type="text/javascript" src="static/js/jquery.tips.js"></script>
	</body>

<script type="text/javascript">
$(top.hangge());
$(function (){  
    $("div").tooltip();  //初始化      
});  

function delschool(bespokeId){
	bootbox.confirm("确定要删除吗?", function(result) {
		if(result) {
				top.jzts();
				var url = "<%=basePath%>bespoke/deleteB.do?bespoke_id="+bespokeId;
				$.get(url,function(data){
					window.location.reload();
				});
			};
	});
}
function showUserDetail(user_id){
   top.jzts();
	 var diag = new top.Dialog();
	 diag.Drag=true;
	 diag.Title ="用户详情";
	 diag.URL = '<%=basePath%>clientUser/showTdUserDetailById?user_id='+user_id;
	 diag.Width =800;
	 diag.Height=600;
	 diag.CancelEvent = function(){ //关闭事件
		diag.close();
	 };
	 diag.show();
 }
//未参加应用培训的用户列表
function showNotJoinIsSpecialActivitytypeUser(){
	   top.jzts();
		 var diag = new top.Dialog();
		 diag.Drag=true;
		 diag.Title ="未参加应用培训的用户";
		 diag.URL = '<%=basePath%>activityType/showNotJoinIsSpecialActivitytypeUser';
		 diag.Width = 1000;
		 diag.Height=600;
		 diag.CancelEvent = function(){ //关闭事件
			diag.close();
		 };
		 diag.show();
	 }
function toUserOverJoinDetail(user_id){
	   top.jzts();
		 var diag = new top.Dialog();
		 diag.Drag=true;
		 diag.Title ="曾经参与详情";
		 diag.URL = '<%=basePath%>everjoinActivity/listUserOverJoinDetail?user_id='+user_id;
		 diag.Width = 1000;
		 diag.Height=600;
		 diag.CancelEvent = function(){ //关闭事件
			diag.close();
		 };
		 diag.show();
	 }

function toUserHobbyDetail(user_id){
	   top.jzts();
		 var diag = new top.Dialog();
		 diag.Drag=true;
		 diag.Title ="兴趣爱好";
		 diag.URL = '<%=basePath%>clientUserAndHobbyController/listUserAndHobbyDetail?user_id='+user_id;
		 diag.Width = 600;
		 diag.Height=400;
		 diag.CancelEvent = function(){ //关闭事件
			diag.close();
		 };
		 diag.show();
	 }

function toUserneedDetail(user_id){
	   top.jzts();
		 var diag = new top.Dialog();
		 diag.Drag=true;
		 diag.Title ="个人需求";
		 diag.URL = '<%=basePath%>clientUserAndPersonalNeeds/listUserUserAndPersonalNeedsDetail?user_id='+user_id;
		 diag.Width = 600;
		 diag.Height=400;
		 diag.CancelEvent = function(){ //关闭事件
			diag.close();
		 };
		 diag.show();
	 }
function toUserDetail(oId){
   top.jzts();
	 var diag = new top.Dialog();
	 diag.Drag=true;
	 diag.Title ="用户详情";
	 diag.URL = '<%=basePath%>school/goFindUser?USER_ID='+oId;
	 diag.Width = 500;
	 diag.Height =264;
	 diag.CancelEvent = function(){ //关闭事件
		diag.close();
	 };
	 diag.show();
 }
function changeStatusClosedDoorById(user_id,closed_user_status){	
	bootbox.confirm("确定要进行此操作吗?", function(result) {
		    if(result){
		    	top.jzts();
	          $.ajax({
                  type:'POST',
                  url:'<%=basePath%>clientUser/updateUserClosedDoorState.do',
                  data:{
                	  user_id:user_id,
                	  closed_user_status:closed_user_status
                	  
                       },
                 success:function(data){
		         window.location.reload();
                 },
                 error:function(data){
                	 bootbox.confirm("修改失败");
          		  
                 }      
			})
		    }
	});
}
 
function toMajor(oId){
	   top.jzts();
		 var diag = new top.Dialog();
		 diag.Drag=true;
		 diag.Title ="专业列表";
		 diag.URL = '<%=basePath%>school/goMajor?school_id='+oId;
		 diag.Width = 780;
		 diag.Height=500;
		 diag.CancelEvent = function(){ //关闭事件
			diag.close();
		 };
		 diag.show();
	 }
function toQualified(oId){
	   top.jzts();
		 var diag = new top.Dialog();
		 diag.Drag=true;
		 diag.Title ="资质列表";
		 diag.URL = '<%=basePath%>school/goQualified?school_id='+oId;
		 diag.Width = 561;
		 diag.Height=500;
		 diag.CancelEvent = function(){ //关闭事件
			diag.close();
		 };
		 diag.show();
	 }
function toTeacher(oId){
	   top.jzts();
		 var diag = new top.Dialog();
		 diag.Drag=true;
		 diag.Title ="教师列表";
		 diag.URL = '<%=basePath%>school/goTeacher?school_id='+oId;
		 diag.Width = 780;
		 diag.Height=500;
		 diag.CancelEvent = function(){ //关闭事件
			diag.close();
		 };
		 diag.show();
	 }
//检索
function searchs(){
	top.jzts();
	$("#userForm").submit();
}
//删除
function delUser(user_id){
	bootbox.confirm("确定要删除吗?", function(result) {
		if(result) {
			top.jzts();
			var url = "<%=basePath%>clientUser/delUserByUid.do?user_id="+user_id;
			$.get(url,function(data){
				window.location.reload();
			});
		};
	});
}

//新增
function add(){
	 top.jzts();
	 var diag = new top.Dialog();
	 diag.Drag=true;
	 diag.Title ="新增";
	 diag.URL = '<%=basePath%>activity/goAddActivity.do';
	 diag.Width = 600;
	 diag.Height = 300;
	 diag.CancelEvent = function(){ //关闭事件
		 window.location.reload();
         diag.close();
	 };
	 diag.show();
}
function editT(user_id){
	 top.jzts();
	 var diag = new top.Dialog();
	 diag.Drag=true;
	 diag.Title ="修改";
	 diag.URL = '<%=basePath%>clientUser/goEditUser.do?user_id='+user_id;
	 diag.Width = 600;
	 diag.Height = 510;
	 diag.CancelEvent = function(){ //关闭事件
		 window.location.reload();
		diag.close();
	 };
	 diag.show();
}
//批量操作
function makeAll(msg){
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
				if(msg == '确定要删除选中的数据吗?'){
					top.jzts();
					$.ajax({
						type: "POST",
						url: '<%=basePath%>activity/deleteAllActivity.do?tm='+new Date().getTime(),
				    	data: {Activity_IDS:str},
						dataType:'json',
						//beforeSend: validateData,
						cache: false,
						success: function(data){
							 $.each(data.list, function(i, list){
									nextPage(${page.currentPage});
							 });
							 alert("删除成功");
						}
					});
				}
			}
		}
	});
}

$(function() {
	//日期框
	$('.date-picker').datepicker({autoclose: true,todayHighlight: true});
	
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
	//复选框全选控制
	var active_class = 'active';
	$('#simple-table > thead > tr > th input[type=checkbox]').eq(0).on('click', function(){
		var th_checked = this.checked;//checkbox inside "TH" table header
		$(this).closest('table').find('tbody > tr').each(function(){
			var row = this;
			if(th_checked) $(row).addClass(active_class).find('input[type=checkbox]').eq(0).prop('checked', true);
			else $(row).removeClass(active_class).find('input[type=checkbox]').eq(0).prop('checked', false);
		});
	});
});

</script>
</html>
