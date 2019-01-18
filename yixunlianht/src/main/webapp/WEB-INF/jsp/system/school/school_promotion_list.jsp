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
						<form action="school/listSchoolPromotion.do" method="post" name="userForm" id="userForm">
						
						<table style="margin-top:5px;">
							<tr>
								<td>
									<div class="nav-search">
									<span class="input-icon">
										<input class="nav-search-input" autocomplete="off" id="nav-search-input" type="text" name="keywords" value="${pd.keywords }" placeholder="这里输入培训机构名称" />
										
										<i class="ace-icon fa fa-search nav-search-icon"></i>
										
									</span>
									</div>
								</td>
								<td style="vertical-align:top;padding-left:2px;"><a class="btn btn-light btn-xs" onclick="searchs();"  title="检索"><i id="nav-search-icon" class="ace-icon fa fa-search bigger-110 nav-search-icon blue"></i></a></td>
					    
					<td style="vertical-align:top;padding-left:2px;">
					   	<div class="nav-search">
									<span class="input-icon">
										<select class="chosen-select form-control"  id="nav-search-input" name="schoolType" id="schoolType" data-placeholder="学校类型查找" style="vertical-align:top;width: 120px;">
															<option value="">学校类型查找</option>														
															
														<option value="公办" <c:if test="${pd.schoolType == '公办' }">selected</c:if>>公办</option>
														<option value="民办" <c:if test="${pd.schoolType == '民办' }">selected</c:if>>民办</option>
														<option value="培训" <c:if test="${pd.schoolType == '培训' }">selected</c:if>>培训</option>															
														
															<i class="ace-icon fa fa-search nav-search-icon"></i>
														  	</select>									
									</span>
									</div>					   
                        </td>
                        <td style="vertical-align:top;padding-left:2px;"><a class="btn btn-light btn-xs" onclick="searchs();"  title="检索"><i id="nav-search-icon" class="ace-icon fa fa-search bigger-110 nav-search-icon blue"></i></a></td>
                        <td style="vertical-align:top;padding-left:2px;">
                        	<div class="nav-search">
									<span class="input-icon">
										<select class="chosen-select form-control"  id="nav-search-input" name="is_check" id="is_check" data-placeholder="学校审核状态" style="vertical-align:top;width: 120px;">
															<option value="">审核状态</option>														
															
														<option value="0" <c:if test="${pd.is_check == '0' }">selected</c:if>>待审核</option>
														<option value="1" <c:if test="${pd.is_check == '1' }">selected</c:if>>已审核</option>
														
															<i class="ace-icon fa fa-search nav-search-icon"></i>
														  	</select>									
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
								<!-- 
									<th class="center" style="width:35px;">
									<label class="pos-rel"><input type="checkbox" class="ace" id="zcheckbox" /><span class="lbl"></span></label>
									</th>-->
									<th class="center" style="width:60px;">编号</th>
									
									 <th class="center">培训机构名称</th>
									<th class="center">培训类型</th>
									<th class="center">负责人</th>				
									<th class="center">类型</th>
									<th class="center">专业</th>
									<th class="center">机构等级</th>
									<th class="center">报名费</th>
									<th class="center">试读天数</th>
									<th class="center">机构地址</th>
									<th class="center">管理员</th>
									<th class="center">更新时间</th>
									<th class="center">收藏数量</th>
									<th class="center">关注人数</th>
									<th class="center">升学类别</th>									
									<th class="center">审核</th>
									<th class="center">操作</th>
								</tr>
							</thead>						
							<tbody>
							<!-- 开始循环 -->	
							<c:choose>
								<c:when test="${not empty promotionSchoolList}">
									<c:forEach items="${promotionSchoolList}" var="school" varStatus="vs">
										<tr>
										<!-- 
										<td class='center' style="width: 30px;">
												<label><input type='checkbox' name='ids' value="${t.school_id }" id="${t.school_id }"  class="ace"/><span class="lbl"></span></label>
											</td>-->
											<td class="center">${vs.index+1}</td>
											<td class="center">${school.name }</td>
											<td class="center" style="cursor:pointer;color:blue;" onClick="toQualified('${school.school_id}')">${school.stype}--资质</td>
											<td class="center">${school.principal }</td>
											<td class="center">${school.type }</td>
											<td class="center" style="cursor:pointer;color:blue;" onClick="toMajor('${school.school_id}')">查看</td>
											<td class="center">${school.grade }</td>
											<td class="center">${school.enroll_cost/100 }</td>
											<td class="center">${school.probation_day }</td>
										    <td class="center" style="cursor:pointer;color:blue;" onClick="toAddressDetail('${school.school_id}')">查看地址</td>
										    <td class="center" style="cursor:pointer;color:blue;" onClick="toUserDetail('${school.user_id}')">查看</td>
											<td class="center">${school.update_time}</td>
										<td class='center'>${school.collection }</td>
										<td class='center'>${school.follow_num }</td>
										<td class="center" style="cursor:pointer;color:blue;" onClick="toProSchoolTypeDetail('${school.school_id}')">类别详情</td>
										<td class="center">
											<c:if test="${school.is_check==1 }">已审核&nbsp;&nbsp;</c:if>
											<c:if test="${school.is_check==0 }">待审核
											&nbsp;&nbsp;<a class="label label-success arrowed" onclick="changeState('${school.school_id}',1);">审核</a>
											</c:if>													
											</td>	
											<td class="center" style="width:80px;">
											
												<c:if test="${QX.edit != 1 && QX.del != 1 }">
												<span class="label label-large label-grey arrowed-in-right arrowed-in"><i class="ace-icon fa fa-lock" title="无权限"></i></span>
												</c:if>
												<div class="hidden-sm hidden-xs btn-group">
													<c:if test="${QX.del == 1 }">
													<a class="btn btn-xs btn-success" title="编辑" onclick="editT('${school.school_id}');">
														<i class="ace-icon fa fa-pencil-square-o bigger-120" title="编辑"></i>
													</a>
													<a class="btn btn-xs btn-danger" onclick="delCompany('${school.school_id}');">
														<i class="ace-icon fa fa-trash-o bigger-120" title="删除"></i>
													</a>
													</c:if>
												</div>																	
											</td>										
										</tr>
										
									</c:forEach>

									<c:if test="${QX.cha == 0 }">
										<tr>
											<td colspan="10" class="center">您无权查看</td>
										</tr>
									</c:if>
								</c:when>
								<c:otherwise>
									<tr class="main_info">
										<td colspan="18" class="center">没有相关数据</td>
									</tr>
								</c:otherwise>
							</c:choose>
							</tbody>
						</table>
					 <div class="page-header position-relative">
					<table style="width:100%;">
						<tr>
						<td style="vertical-align:top;">
							<c:if test="${QX.add == 1 }">
								<a class="btn btn-mini btn-success" onclick="add();">新增</a>
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
function toAddressDetail(oId){
   top.jzts();
	 var diag = new top.Dialog();
	 diag.Drag=true;
	 diag.Title ="地址详情";
	 diag.URL = '<%=basePath%>school/listAddress?school_id='+oId;
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

function toProSchoolTypeDetail(school_id){
	   top.jzts();
		 var diag = new top.Dialog();
		 diag.Drag=true;
		 diag.Title ="学历提升类别详情";
		 diag.URL = '<%=basePath%>schoolProType/goFindProSchoolType?es_id='+school_id;
		 diag.Width = 700;
		 diag.Height =264;
		 diag.CancelEvent = function(){ //关闭事件
			diag.close();
		 };
		 diag.show();
	 }
function changeState(cid,state){	
	bootbox.confirm("确定要进行此操作吗?", function(result) {
		    if(result){
		    	top.jzts();
	          $.ajax({
                  type:'POST',
                  url:'<%=basePath%>school/updateState.do',
                  data:{
                	  is_check:state,
                	  school_id:cid,
                       },
                 success:function(data){
		         window.location.reload();
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
function delCompany(school_id){
	bootbox.confirm("确定要删除吗?", function(result) {
		if(result) {
			top.jzts();
			var url = "<%=basePath%>train/deleteTrainSchoolBysid.do?school_id="+school_id;
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
	 diag.URL = '<%=basePath%>train/goAddTrainSchool.do';
	 diag.Width = 850;
	 diag.Height = 650;
	 diag.CancelEvent = function(){ //关闭事件
		 window.location.reload();
         diag.close();
	 };
	 diag.show();
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
function editT(school_id){
	 top.jzts();
	 var diag = new top.Dialog();
	 diag.Drag=true;
	 diag.Title ="修改";
	 diag.URL = '<%=basePath%>train/goEditTrainSchool.do?school_id='+school_id;
	 diag.Width = 850;
	 diag.Height = 650;
	 diag.CancelEvent = function(){ //关闭事件
		 window.location.reload();
		diag.close();
	 };
	 diag.show();
}
</script>
</html>
