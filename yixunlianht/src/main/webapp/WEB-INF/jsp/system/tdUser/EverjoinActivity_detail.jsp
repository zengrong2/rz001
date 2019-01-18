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
							<span style="font-weight: bold;margin-top:40px;">
							<button style="border-radius: 20px;" type="button" class="btn btn-primary btn-sm btn-danger">
							曾经参与的活动类型和次数：</button></span>
							<c:forEach items="${tdOverJoinActivityTempList}" var="activityType" varStatus="vs">
							
								<a class="label label-success arrowed" style="margin-left:10px;margin-top:10px;" >${activityType.activityCategoryName }&nbsp;&nbsp;${activityType.joinCount }</a>
								
							
								
							</c:forEach>
								
							
						</table>
						<!-- 检索  -->
						<table id="simple-table" class="table table-striped table-bordered table-hover"  style="margin-top:5px;">
							<thead>
								<tr>
									<!-- <th class="center" style="width:35px;">
									<label class="pos-rel"><input type="checkbox" class="ace" id="zcheckbox" /><span class="lbl"></span></label>
									</th> -->
									<th class="center" style="width:60px;">编号</th>
									   <th class='center'>活动名称</th>
									   <th class='center'>主办方</th>
										<th class='center'>活动详情</th>
										<th class='center'>活动开始时间</th>
									    <th class='center'>活动结束时间</th>
									    <th class='center'>活动收费项目</th>
									    <th class='center'>活动提成项目</th>
									    <th class='center'>活动开始报名时间</th>
										<th class='center'>活动结束报名时间</th>
										<th class='center'>活动报名情况</th> 
										<th class='center'>活动在线情况</th>
										<!-- <th class='center'>操作</th> -->
								</tr>
							</thead>						
							<tbody>
							<!-- 开始循环 -->	
							<c:choose>
								<c:when test="${not empty listTdActivity}">
									<c:forEach items="${listTdActivity}" var="ts" varStatus="vs">
										<tr>
										
											<%-- <td class='center' style="width: 30px;">
												<label><input type='checkbox' name='ids' value="${ts.activityId }"   class="ace"/><span class="lbl"></span></label>
											</td> --%>
											<td class="center">${vs.index+1}</td>
											<td class='center'>${ts.activityName}</td>
											<td class='center'>${ts.userName}</td>
										
										<td class="center" >
										<div style="cursor:pointer;color:blue;margin-left:10px;" onClick="toActivityDetail('${ts.activityId}')">查看活动详情:</div>										
										
										</td>
										<td class='center'>${ts.activitystartTime }</td>
										<td class='center'>${ts.activitystartTime }</td>
										<td class="center" style="cursor:pointer;color:blue;" onClick="toActivityProjectInfoDetail('${ts.activityId}')">活动收费项目详情</td>
										<td class="center" style="cursor:pointer;color:blue;" onClick="toActivityExtractDetail('${ts.activityId}')">活动提成项目详情</td>
										
										<td class='center'>${ts.activitysignStarttime}</td>
										<td class='center'>${ts.activitysignEndtime}</td>
										<td class="center" style="cursor:pointer;color:blue;" onClick="toActivityEnrollDetail('${ts.activityId}')">活动报名详情</td>
										
										<td class="center">
										<c:if test="${ts.onlineStatus==1 ||ts.onlineStatus==null}">
										已下架
										</c:if>
										<c:if test="${ts.onlineStatus== 0 }">
										已上架</a>
											</c:if>
										</td>
											<%-- <td class="center">
											
												<c:if test="${QX.edit != 1 && QX.del != 1 }">
												<span class="label label-large label-grey arrowed-in-right arrowed-in"><i class="ace-icon fa fa-lock" title="无权限"></i></span>
												
												</c:if>
												<div class="hidden-sm hidden-xs btn-group">
													<c:if test="${QX.del == 1 }">
													
													<a class="btn btn-xs btn-success" title="编辑" onclick="editT('${ts.p_id}');">
														<i class="ace-icon fa fa-pencil-square-o bigger-120" title="编辑"></i>
													</a>
													<a class="btn btn-xs btn-danger" onclick="delActivity('${ts.activityId}');">
														<i class="ace-icon fa fa-trash-o bigger-120" title="删除"></i>
													</a>
													<c:if test="${ts.onlineStatus==1 ||ts.onlineStatus==null}">&nbsp;&nbsp;
										<a class="label label-error arrowed" onclick="changeState('${ts.activityId}','${ts.onlineStatus}');">上架</a></c:if>
										<c:if test="${ts.onlineStatus==0}">
										&nbsp;&nbsp;<a class="label label-danger arrowed" onclick="changeState('${ts.activityId}','${ts.onlineStatus}');">下架</a>
											        </c:if>
													</c:if>
												</div>		
																										
											</td>			 --%>							
										</tr>
										
									</c:forEach>

									<c:if test="${QX.cha == 0 }">
										<tr>
											<td colspan="12" class="center">您无权查看</td>
										</tr>
									</c:if>
								</c:when>
								<c:otherwise>
									<tr class="main_info">
										<td colspan="12" class="center">没有相关数据</td>
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
							<%-- <c:if test="${QX.del == 1 }">
								<a title="批量删除" class="btn btn-mini btn-danger" onclick="makeAll('确定要删除选中的数据吗?');" >批量删除<i class='ace-icon fa fa-trash-o bigger-120'></i></a>
								</c:if>		 --%>
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
function toActivityDetail(activityId){
   top.jzts();
	 var diag = new top.Dialog();
	 diag.Drag=true;
	 diag.Title ="活动详情";
	 diag.URL = '<%=basePath%>activity/showActivityDetailById?activityId='+activityId;
	 diag.Width =800;
	 diag.Height=600;
	 diag.CancelEvent = function(){ //关闭事件
		diag.close();
	 };
	 diag.show();
 }
function toActivityProjectInfoDetail(activityId){
	   top.jzts();
		 var diag = new top.Dialog();
		 diag.Drag=true;
		 diag.Title ="活动收费项目详情";
		 diag.URL = '<%=basePath%>activityProject/ActivityProjectInfoDetail?activityId='+activityId;
		 diag.Width = 800;
		 diag.Height=600;
		 diag.CancelEvent = function(){ //关闭事件
			diag.close();
		 };
		 diag.show();
	 }

function toActivityExtractDetail(activityId){
	   top.jzts();
		 var diag = new top.Dialog();
		 diag.Drag=true;
		 diag.Title ="活动提成项目详情";
		 diag.URL = '<%=basePath%>activityExtractProject/ActivityExtractProjectInfoDetail?activityId='+activityId;
		 diag.Width = 800;
		 diag.Height=600;
		 diag.CancelEvent = function(){ //关闭事件
			diag.close();
		 };
		 diag.show();
	 }
function toActivityEnrollDetail(activityId){
	   top.jzts();
		 var diag = new top.Dialog();
		 diag.Drag=true;
		 diag.Title ="活动报名详情";
		 diag.URL = '<%=basePath%>activitySign/ActivityEnrollInfoDetail?activityId='+activityId;
		 diag.Width = 1200;
		 diag.Height=600;
		 diag.CancelEvent = function(){ //关闭事件
			diag.close();
		 };
		 diag.show();
	 }
function toActivityProjectDealDetail(activityId){
	   top.jzts();
		 var diag = new top.Dialog();
		 diag.Drag=true;
		 diag.Title ="活动提成项目成交详情";
		 diag.URL = '<%=basePath%>activity/ActivityProjectDealDetail?activityId='+activityId;
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
function changeState(activityId,onlineStatus){	
	bootbox.confirm("确定要进行此操作吗?", function(result) {
		    if(result){
		    	top.jzts();
		    	
		    	if(""==onlineStatus||null==onlineStatus){
		    		onlineStatus = "1";
		    	}
		    	
	          $.ajax({
	        	 
                  type:'POST',
                  url:'<%=basePath%>activity/updateActivityState.do',
                  data:{
                	  activityId:activityId,
                	  onlineStatus:onlineStatus
                	  
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
function delActivity(activityId){
	bootbox.confirm("确定要删除吗?", function(result) {
		if(result) {
			top.jzts();
			var url = "<%=basePath%>activity/delActivityByAid.do?activityId="+activityId;
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
function editT(activityId){
	 top.jzts();
	 var diag = new top.Dialog();
	 diag.Drag=true;
	 diag.Title ="修改";
	 diag.URL = '<%=basePath%>activity/goEditActivity.do?activityId='+activityId;
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
				    	data: {activityIdS:str},
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
