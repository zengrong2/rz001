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
						<form action="activity/goListactivity.do" method="post" name="userForm" id="userForm">
						
						<table style="margin-top:5px;">
							<tr>
								<td>
									<div class="nav-search">
									<span class="input-icon">
										<input class="nav-search-input" autocomplete="off" id="nav-search-input" type="text" name="keywords" value="${pd.keywords }" placeholder="这里输入活动名称" />
										
										<i class="ace-icon fa fa-search nav-search-icon"></i>
										
									</span>
									</div>
									</td>
								<td style="vertical-align:top;padding-left:2px;"><a class="btn btn-light btn-xs" onclick="searchs();"  title="检索"><i id="nav-search-icon" class="ace-icon fa fa-search bigger-110 nav-search-icon blue"></i></a></td>
								<td>
									<div class="nav-search">	
									<span class="input-icon">
										<input class="nav-search-input" autocomplete="off" id="nav-search-input" type="text" name="userName" value="${pd.user_name }"  placeholder="这里输入主办方名字" />										
										<i class="ace-icon fa fa-search nav-search-icon"></i>
										
									</span>
									</div>
									
								</td>
								<td style="vertical-align:top;padding-left:2px;"><a class="btn btn-light btn-xs" onclick="searchs();"  title="检索"><i id="nav-search-icon" class="ace-icon fa fa-search bigger-110 nav-search-icon blue"></i></a></td>
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
							</tr>
						</table>
						<!-- 检索  -->
						<table id="simple-table" class="table table-striped table-bordered table-hover"  style="margin-top:5px;">
							<thead>
								<tr>
									<th class="center" style="width:35px;">
									<label class="pos-rel"><input type="checkbox" class="ace" id="zcheckbox" /><span class="lbl"></span></label>
									</th>
									<th class="center" style="width:60px;">编号</th>
									    <th class='center'>活动名称</th>
									    <th class='center'>主办方</th> 
									    <th class='center'>活动类别</th>
									    <th class='center'>客户匹配</th>
									    <th class='center' style="width:120px;">活动区域</th>
									    <th class='center'>报名列表</th>
									    <th class='center'>成交金额</th>
									    <th class='center'>提成比例</th>
									    <th class='center'>应发提成</th>
									    <th class='center'>待发放提成</th>
									    <th class='center' style="width:120px;">活动状态</th>
									    <th class='center' style="width:120px;">备注</th>
									    <th class='center'>操作</th>
									 
								</tr>
							</thead>						
							<tbody>
							<!-- 开始循环 -->	
							<c:choose>
								<c:when test="${not empty listActivity}">
									<c:forEach items="${listActivity}" var="ts" varStatus="vs">
										<tr>
										
											<td class='center' style="width: 30px;">
												<label><input type='checkbox' name='ids' value="${ts.activity_id }"   class="ace"/><span class="lbl"></span></label>
											</td>
											<td class="center">${vs.index+1}</td>
											<td class='center'>
											<div style="cursor:pointer;color:blue;margin-left:10px;" onClick="toActivityDetail('${ts.activity_id}')">${ts.activity_name}</div></td>
											<td class='center'>
											
										   <div style="cursor:pointer;color:blue;margin-left:10px;" onClick="toOrganizerUserDetail('${ts.user_id}')"> ${ts.user_nick_name} </div></td>
											
											</td>
										    <td class='center'>${ts.activitycategory_name}</td>
										  <%--   <td class='center'>
										    <div style="cursor:pointer;color:blue;margin-left:10px;" onClick="toActivityDetail('${ts.activity_id}')">查看详情:</div>										
										    
										    </td>	 --%>									
										   <td class='center'>
										   <div style="cursor:pointer;color:blue;margin-left:10px;" onClick="toMatchUserList('${ts.activity_id}')">${ts.matchPersonCount}人</div></td>
										   
										   </td>
										   <td class='center'>
										   <c:if test="${ts.activity_type ==0}">
										        线上
										   </c:if>
										   <c:if test="${ts.activity_type ==1}">
										   <c:if test="${ts.address1!=null&&ts.address1!=''}"> 
										   ${ts.address1}<br/>
										   </c:if>
										    <c:if test="${ts.address2!=null&&ts.address2!=''}"> 
										   ${ts.address2}<br/>
										   </c:if>
										    <c:if test="${ts.address3!=null&&ts.address3!=''}"> 
										   ${ts.address3}
										   </c:if>
										   </c:if>
										  </td>
										   <td class="center" style="cursor:pointer;color:blue;" onClick="toActivityEnrollDetail('${ts.activity_id}')">${ts.countEnrollPerson }人</td>
										   <td class='center'>￥${ts.sumSoloActivityDealMoney }元</td>
										   <td class='center'>${ts.royalty_ratio }</td>
										   <td class='center'>${ts.shouldPubMoney }</td>
										   <td class='center'>
										   <div style="cursor:pointer;color:blue;margin-left:10px;" onClick="SoloActivityWaitPayExtract('${ts.activity_id}')">${ts.sumSoloActivityWaitPayExtract }</div></td>
										   
										   </td>
									   <td class='center'>
									   <c:if test="${ts.activity_signupstatus==0 }">
									       未开始
									   </c:if>
									   <c:if test="${ts.activity_signupstatus==1 }">
									       报名中
									   </c:if>
									     <c:if test="${ts.activity_signupstatus==2 }">
									      报名结束
									   </c:if>
									   <c:if test="${ts.activity_status==0 }">/未开始</c:if>
									   <c:if test="${ts.activity_status==1 }">/进行中</c:if>
									   <c:if test="${ts.activity_status==2 }">/已结束</c:if>
										 
									   </td>
										<td class="center">
										<c:if test="${ts.reportCount >0}">								
				<span style="cursor:pointer;color:blue;margin-left:10px;" onClick="SoloActivityReportList('${ts.activity_id}')">被举报</span>										   
										<br/>
										</c:if>
										<c:if test="${ts.complaintCount >0}">
				<span style="cursor:pointer;color:blue;margin-left:10px;" onClick="SoloActivityComplaintList('${ts.activity_id}')">被投诉</span>
										<br/>
										</c:if>
										<c:if test="${ts.online_status==1 }">
										
				<span style="cursor:pointer;color:blue;margin-left:10px;" onClick="SoloActivityUnderReasonList('${ts.activity_id}')">主办方下架</span>
										
										</c:if>
										<c:if test="${ts.online_status== 0 }">
			   <span style="cursor:pointer;margin-left:10px;" >已上架</span>
									
										</a>
										</c:if>
										<c:if test="${ts.online_status== 3 }">
			    <span style="cursor:pointer;color:blue;margin-left:10px;" onClick="SoloActivityUnderReasonList('${ts.activity_id}')">管理员下架</span>
										
										</a>
										</c:if>
										</td>
										
										
										<%-- <td class="center" >
										<div style="cursor:pointer;color:blue;margin-left:10px;" onClick="toActivityDetail('${ts.activity_id}')">查看活动详情:</div>										
										
										</td> --%>
										
<%-- 										<td class="center" style="cursor:pointer;color:blue;" onClick="toActivityProjectInfoDetail('${ts.activity_id}')">活动收费项目详情</td>
 --%>										<%-- <td class="center" style="cursor:pointer;color:blue;" onClick="toActivityExtractDetail('${ts.activity_id}')">活动提成项目详情</td> --%>
									
											<td class="center">
											
												<c:if test="${QX.edit != 1 && QX.del != 1 }">
												<span class="label label-large label-grey arrowed-in-right arrowed-in"><i class="ace-icon fa fa-lock" title="无权限"></i></span>
												
												</c:if>
												<div class="hidden-sm hidden-xs btn-group">
													<c:if test="${QX.del == 1 }">
													
													<%-- <a class="btn btn-xs btn-success" title="编辑" onclick="editT('${ts.p_id}');">
														<i class="ace-icon fa fa-pencil-square-o bigger-120" title="编辑"></i>
													</a> --%>
													<a class="btn btn-xs btn-danger" onclick="delActivity('${ts.activity_id}');">
														<i class="ace-icon fa fa-trash-o bigger-120" title="删除"></i>
													</a>
													<c:if test="${ts.online_status==3 ||ts.online_status==1 ||ts.online_status==null}">&nbsp;&nbsp;
										<a class="label label-error arrowed" onclick="changeState('${ts.activity_id}','${ts.online_status}');">上架</a></c:if>
										<c:if test="${ts.online_status==0}">
										&nbsp;&nbsp;<a class="label label-danger arrowed" onclick="changeStateAndUnderReason('${ts.activity_id}','${ts.online_status}');">下架</a>
											        </c:if>
													</c:if>
												</div>		
																										
											</td>										
										</tr>
										
									</c:forEach>

									<c:if test="${QX.cha == 0 }">
										<tr>
											<td colspan="11" class="center">您无权查看</td>
										</tr>
									</c:if>
								</c:when>
								<c:otherwise>
									<tr class="main_info">
										<td colspan="11" class="center">没有相关数据</td>
									</tr>
								</c:otherwise>
							</c:choose>
							</tbody>
						</table>
					 <div class="page-header position-relative">
					<table style="width:100%;">
						<tr>
						<td style="vertical-align:top;">
						<%-- 	<c:if test="${QX.add == 1 }">
								<a class="btn btn-mini btn-success" onclick="add();">新增</a>
								</c:if> --%>
							<c:if test="${QX.del == 1 }">
								<a title="批量删除" class="btn btn-mini btn-danger" onclick="makeAll('确定要删除选中的数据吗?');" >批量删除<i class='ace-icon fa fa-trash-o bigger-120'></i></a>
								</c:if>		
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
//下架理由

function SoloActivityUnderReasonList(activity_id){
	   top.jzts();
		 var diag = new top.Dialog();
		 diag.Drag=true;
		 diag.Title ="活动下架理由";
		 diag.URL = '<%=basePath%>activity/SoloActivityUnderReasonList?activity_id='+activity_id;
		 diag.Width = 600;
		 diag.Height =400;
		 diag.CancelEvent = function(){ //关闭事件
			diag.close();
			window.location.reload();
		 };
		 diag.show();
	 }
//被投诉列表

function SoloActivityComplaintList(activity_id){
	   top.jzts();
		 var diag = new top.Dialog();
		 diag.Drag=true;
		 diag.Title ="投诉列表";
		 diag.URL = '<%=basePath%>complaint/SoloActivityComplaintList?activity_id='+activity_id;
		 diag.Width = 800;
		 diag.Height =400;
		 diag.CancelEvent = function(){ //关闭事件
			diag.close();
			window.location.reload();
		 };
		 diag.show();
	 }
//被举报列表

function SoloActivityReportList(activity_id){
	   top.jzts();
		 var diag = new top.Dialog();
		 diag.Drag=true;
		 diag.Title ="被举报列表";
		 diag.URL = '<%=basePath%>report/SoloActivityReportList?activity_id='+activity_id;
		 diag.Width = 800;
		 diag.Height =400;
		 diag.CancelEvent = function(){ //关闭事件
			diag.close();
			window.location.reload();
		 };
		 diag.show();
	 }
//待发放提成列表

function SoloActivityWaitPayExtract(activity_id){
	   top.jzts();
		 var diag = new top.Dialog();
		 diag.Drag=true;
		 diag.Title ="待发放提成列表";
		 diag.URL = '<%=basePath%>activityUenrollAndActivity/SoloActivityWaitPayExtract?activity_id='+activity_id;
		 diag.Width = 1200;
		 diag.Height =400;
		 diag.CancelEvent = function(){ //关闭事件
			diag.close();
			window.location.reload();
		 };
		 diag.show();
	 }
//匹配用户
function toMatchUserList(activity_id){
	   top.jzts();
		 var diag = new top.Dialog();
		 diag.Drag=true;
		 diag.Title ="精准客户资源匹配";
		 diag.URL = '<%=basePath%>activity/MatchUserList?activity_id='+activity_id;
		 diag.Width = 800;
		 diag.Height =400;
		 diag.CancelEvent = function(){ //关闭事件
			diag.close();
			window.location.reload();
		 };
		 diag.show();
	 }
function toOrganizerUserDetail(user_id){
	   top.jzts();
		 var diag = new top.Dialog();
		 diag.Drag=true;
		 diag.Title ="主办方详情";
		 diag.URL = '<%=basePath%>organizerInfo/showOrganizerInfoDatailById?user_id='+user_id;
		 diag.Width = 800;
		 diag.Height =450;
		 diag.CancelEvent = function(){ //关闭事件
			diag.close();
		 };
		 diag.show();
	 }
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
function toActivityDetail(activity_id){
   top.jzts();
	 var diag = new top.Dialog();
	 diag.Drag=true;
	 diag.Title ="活动详情";
	 diag.URL = '<%=basePath%>activity/showActivityDetailById?activity_id='+activity_id;
	 diag.Width =800;
	 diag.Height=600;
	 diag.CancelEvent = function(){ //关闭事件
		diag.close();
	 };
	 diag.show();
 }
function toActivityProjectInfoDetail(activity_id){
	   top.jzts();
		 var diag = new top.Dialog();
		 diag.Drag=true;
		 diag.Title ="活动收费项目详情";
		 diag.URL = '<%=basePath%>activityProject/ActivityProjectInfoDetail?activity_id='+activity_id;
		 diag.Width = 800;
		 diag.Height=600;
		 diag.CancelEvent = function(){ //关闭事件
			diag.close();
		 };
		 diag.show();
	 }

function toActivityExtractDetail(activity_id){
	   top.jzts();
		 var diag = new top.Dialog();
		 diag.Drag=true;
		 diag.Title ="活动提成项目详情";
		 diag.URL = '<%=basePath%>activityExtractProject/ActivityExtractProjectInfoDetail?activity_id='+activity_id;
		 diag.Width = 800;
		 diag.Height=600;
		 diag.CancelEvent = function(){ //关闭事件
			diag.close();
		 };
		 diag.show();
	 }
function toActivityEnrollDetail(activity_id){
	   top.jzts();
		 var diag = new top.Dialog();
		 diag.Drag=true;
		 diag.Title ="活动报名详情";
		 diag.URL = '<%=basePath%>activityUenrollAndActivity/ActivityEnrollInfoDetail?activity_id='+activity_id;
		 diag.Width = 1200;
		 diag.Height=600;
		 diag.CancelEvent = function(){ //关闭事件
			diag.close();
		 };
		 diag.show();
	 }
function toActivityProjectDealDetail(activity_id){
	   top.jzts();
		 var diag = new top.Dialog();
		 diag.Drag=true;
		 diag.Title ="活动提成项目成交详情";
		 diag.URL = '<%=basePath%>activity/ActivityProjectDealDetail?activity_id='+activity_id;
		 diag.Width = 382;
		 diag.Height=283;
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
 //下架活动
 
function changeStateAndUnderReason(activity_id,online_status){
			 top.jzts();
			 var diag = new top.Dialog();
			 diag.Drag=true;
			 diag.Title ="下架活动备注原因";
			 diag.URL = '<%=basePath%>activity/goEditActivityUnderReason.do?activity_id='+activity_id;
			 diag.Width = 600;
			 diag.Height = 310;
			 diag.CancelEvent = function(){ //关闭事件
				 window.location.reload();
				diag.close();
			 };
			 diag.show();
		}
 //上架活动
function changeState(activity_id,online_status){	
	bootbox.confirm("确定要进行此操作吗?", function(result) {
		    if(result){
		    	top.jzts();
		    	
		    	if(""==online_status||null==online_status){
		    		online_status = "1";
		    	}
		    	
	          $.ajax({
	        	 
                  type:'POST',
                  url:'<%=basePath%>activity/updateActivityState.do',
                  data:{
                	  activity_id:activity_id,
                	  online_status:online_status
                	  
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
function delActivity(activity_id){
	bootbox.confirm("确定要删除吗?", function(result) {
		if(result) {
			top.jzts();
			var url = "<%=basePath%>activity/delActivityByAid.do?activity_id="+activity_id;
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
function editT(activity_id){
	 top.jzts();
	 var diag = new top.Dialog();
	 diag.Drag=true;
	 diag.Title ="修改";
	 diag.URL = '<%=basePath%>activity/goEditActivity.do?activity_id='+activity_id;
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
