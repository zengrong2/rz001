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
						<form action="train/goListTrainingCourse.do" method="post" name="userForm" id="userForm">
						<table style="margin-top:5px;">
							<tr>
								<td>
									<div class="nav-search">
									<span class="input-icon">
										<input class="nav-search-input" autocomplete="off" id="nav-search-input" type="text" name="keywords" value="${pd.keywords }" placeholder="这里输入课程名称" />
										
										<i class="ace-icon fa fa-search nav-search-icon"></i>
										
									</span>
									
									</div>
								</td>
								<td style="vertical-align:top;padding-left:2px;"><a class="btn btn-light btn-xs" onclick="searchs();"  title="检索"><i id="nav-search-icon" class="ace-icon fa fa-search bigger-110 nav-search-icon blue"></i></a></td>
					 
									
					    <td style="vertical-align:top;padding-left:2px;">
					    <td>
									<div class="nav-search">
									<span class="input-icon">
									
										<input class="nav-search-input" autocomplete="off" id="nav-search-input" type="text" name="major_name"  placeholder="输入课程所属学科" />
										
										<i class="ace-icon fa fa-search nav-search-icon"></i>
										
									</span>
									
									</div>
								</td>
								<td style="vertical-align:top;padding-left:2px;"><a class="btn btn-light btn-xs" onclick="searchs();"  title="检索"><i id="nav-search-icon" class="ace-icon fa fa-search bigger-110 nav-search-icon blue"></i></a></td>
					    <td style="vertical-align:top;padding-left:2px;">
					    
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
									<th class='center'>课程名</th>
										<th class='center'>课程介绍</th>
										<th class='center'>课程详细信息</th>
									    <th class='center'>课程课时</th>
									    <th class='center'>课程就业薪资</th>
										<th class='center'>课程所属学科</th>
									    <th class='center'>课程所属学校</th>
										<th class='center'>操作</th>
								</tr>
							</thead>						
							<tbody>
							<!-- 开始循环 -->	
							<c:choose>
								<c:when test="${not empty CurriculumList}">
									<c:forEach items="${CurriculumList}" var="ts" varStatus="vs">
										<tr>
										<td class='center' style="width: 30px;">
												<label><input type='checkbox' name='ids' value="${ts.curriculum_id }" id="${ts.curriculum_id }"  class="ace"/><span class="lbl"></span></label>
											</td>
											<td class="center">${vs.index+1}</td>
											<td class='center'>${ts.curriculum_name}
											<br/>
											<a class="label label-success arrowed" onclick="addChapter('${ts.curriculum_id}');">上传课程详细信息</a>
											
											</td>
										<td class='center' style="width:40%;">${ts.curriculum_introduce}</td>
										
										<td class="center" style="cursor:pointer;color:blue;" onClick="toChapterDetail('${ts.curriculum_id}')">课程目录详情
										
										</td>

										<td class='center'>${ts.curriculum_people }</td>
										<td class='center'>${ts.curriculum_salary}</td>
										
										<td class="center" style="cursor:pointer;color:blue;" onClick="toCurriculumMajorDetail('${ts.major_id}')">课程学科详情</td>
										
										
										<td class="center" style="cursor:pointer;color:blue;" onClick="toCurriculumSchoolDetail('${ts.school_id}')">课程学校详情</td>
										
											<td class="center">
											
												
												<div class="hidden-sm hidden-xs btn-group">
													
													
													<a class="btn btn-xs btn-success" title="编辑" onclick="editT('${ts.curriculum_id}');">
														<i class="ace-icon fa fa-pencil-square-o bigger-120" title="编辑"></i>
													</a>
													<a class="btn btn-xs btn-danger" onclick="delSchoolCurriculum('${ts.curriculum_id}');">
														<i class="ace-icon fa fa-trash-o bigger-120" title="删除"></i>
													</a>
												
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
										<td colspan="10" class="center">没有相关数据</td>
									</tr>
								</c:otherwise>
							</c:choose>
							</tbody>
						</table>
					 <div class="page-header position-relative">
					<table style="width:100%;">
						<tr>
						<td style="vertical-align:top;">
							
								<a class="btn btn-mini btn-success" onclick="add('${school_id }');">新增</a>
								
								
								<a title="批量删除" class="btn btn-mini btn-danger" onclick="makeAll('确定要删除选中的数据吗?');" >批量删除<i class='ace-icon fa fa-trash-o bigger-120'></i></a>
								
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
function toChapterDetail(curriculum_id){
   top.jzts();
	 var diag = new top.Dialog();
	 diag.Drag=true;
	 diag.Title ="课程章节详情";
	 diag.URL = '<%=basePath%>train/showCurriculumChapterInfo?curriculum_id='+curriculum_id;
	 diag.Width = 800;
	 diag.Height=350;
	 diag.CancelEvent = function(){ //关闭事件
		diag.close();
	 };
	 diag.show();
 }

function toCurriculumMajorDetail(major_id){
	   top.jzts();
		 var diag = new top.Dialog();
		 diag.Drag=true;
		 diag.Title ="课程学科详情";
		 diag.URL = '<%=basePath%>train/showCurriculumMajorInfo?major_id='+major_id;
		 diag.Width = 382;
		 diag.Height=283;
		 diag.CancelEvent = function(){ //关闭事件
			diag.close();
		 };
		 diag.show();
	 }
	 

function toCurriculumSchoolDetail(school_id){
	   top.jzts();
		 var diag = new top.Dialog();
		 diag.Drag=true;
		 diag.Title ="课程学科详情";
		 diag.URL = '<%=basePath%>train/showCurriculumSchoolInfo?school_id='+school_id;
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
function delSchoolCurriculum(SchoolCurriculumId){
	bootbox.confirm("确定要删除吗?", function(result) {
		if(result) {
			top.jzts();
			var url = "<%=basePath%>train/delSchoolCurriculumByCid.do?curriculum_id="+SchoolCurriculumId;
			$.get(url,function(data){
				window.location.reload();
			});
		};
	});
}
//课程添加章节

function addChapter(curriculum_id){
	 top.jzts();
	 var diag = new top.Dialog();
	 diag.Drag=true;
	 diag.Title ="新增";
	 diag.URL = '<%=basePath%>train/curriculum/goAddCurriculumChapter.do?curriculum_id='+curriculum_id;
	 diag.Width = 650;
	 diag.Height = 350;
	 diag.CancelEvent = function(){ //关闭事件
		 window.location.reload();
        diag.close();
	 };
	 diag.show();
}
//新增
function add(school_id){
	 top.jzts();
	 var diag = new top.Dialog();
	 diag.Drag=true;
	 diag.Title ="新增";
	 diag.URL = '<%=basePath%>train/goAddSchoolCurriculum.do?school_id='+school_id;
	 diag.Width = 650;
	 diag.Height = 350;
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
function editT(curriculum_id){
	 top.jzts();
	 var diag = new top.Dialog();
	 diag.Drag=true;
	 diag.Title ="修改";

	 diag.URL = '<%=basePath%>train/goEditSchoolCurriculum.do?curriculum_id='+curriculum_id;
	 diag.Width = 550;
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
						url: '<%=basePath%>train/deleteAllCurriculum.do?tm='+new Date().getTime(),
				    	data: {Curriculum_IDS:str},
						dataType:'json',
						//beforeSend: validateData,
						cache: false,
						success: function(data){
							 $.each(data.list, function(i, list){
									nextPage(${page.currentPage});
							 });
						}
					});
				}
			}
		}
	});
}
</script>
</html>
