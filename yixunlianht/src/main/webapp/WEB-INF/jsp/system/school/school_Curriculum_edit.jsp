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
						<form action="train/editSchoolCurriculum.do" name="form1" id="form1"  method="post">
						<input type="hidden" name="curriculum_id" id="tid" value="${pd.curriculum_id}"/>
							<div id="zhongxin" style="padding-top:13px;">
							<table id="table_report" class="table table-striped table-bordered table-hover">
										
										<tr>
											<td style="width:140px;text-align: center;padding-top: 13px;">课程名字:</td>
											<td><input style="width:98%;" type="text" name="curriculum_name" id="name"  value="${pd.curriculum_name }"  maxlength="32" placeholder="这里输入课程名字" title="课程名字"  /></td>
										</tr>
										<tr>
											<td style="width:140px;text-align: center;padding-top: 13px;">课程介绍:</td>
											<td><input type="text" name="curriculum_introduce" id="curriculum_introduce"  value="${pd.curriculum_introduce }"  maxlength="250" placeholder="这里输入课程介绍" title="课程介绍" /></td>
										</tr>
								
										
										<tr>
											<td style="width:140px;text-align: center;padding-top: 13px;">课程适用人群:</td>
											<td><input type="text" name="curriculum_people" id="curriculum_people"  value="${pd.curriculum_people }"  maxlength="32" placeholder="课程适用人群" title="课程适用人群" style="width:98%;"/></td>
										</tr>
										<tr>
											<td style="width:140px;text-align: center;padding-top: 13px;">课程就业工资:</td>
											<td><input type="text" name="curriculum_salary" id="curriculum_salary"  value="${pd.curriculum_salary }"  maxlength="32" placeholder="输入课程就业工资" title="课程就业工资" style="width:98%;"/></td>
										</tr>
										
											<tr>
															<td style="width:140px;text-align: center;padding-top: 13px;">课程所属学科:</td>
													<td>	    <select  name="major_id" id="major_id"   data-placeholder="选择学科" style="vertical-align:top;width: 120px;">
															<option value="${pd.major_id }">${major_name }</option>
															<c:forEach items="${listMajor}" var="schoolMajor">
																<option value="${schoolMajor.major_id}">${schoolMajor.major_name }</option>
															</c:forEach>
														  	</select>
																
															</td>
														</tr>
										
										<tr>
											<td style="width:140px;text-align: center;padding-top: 13px;">备注:</td>
											<td><textarea name="remark" id="remark" rows="5" cols="45">${pd.remark }</textarea></td>
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
	//保存
	function save(){
		if ($("#name").val() == "") {
			$("#name").tips({
				side : 3,
				msg : '请输入课程名称',
				bg : '#AE81FF',
				time : 2
			});
			$("#name").focus();
			return false;
		}
		if( $("#curriculum_introduce").val()==""){
			$("#curriculum_introduce").tips({
				side:3,
	            msg:'请输入课程介绍',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#password").focus();
			return false;
		}
		
		
		if ($("#curriculum_people").val() == "") {
			$("#curriculum_people").tips({
				side : 3,
				msg : '请输入适用人群',
				bg : '#AE81FF',
				time : 2
			});
			$("#curriculum_people").focus();
			return false;
		}
		
		
		var myreg=/^[0-9]+([.]{1}[0-9]+){0,1}$/;
		var ph=$("#curriculum_salary").val();
		if($("#curriculum_salary").val()==""){
			
			$("#curriculum_salary").tips({
				side:3,
	            msg:'输入升学费用',
	            bg:'#AE81FF',
	            time:3
	        });
			$("#curriculum_salary").focus();
			return false;
		}else if($("#curriculum_salary").val().length > 10 ){
			$("#curriculum_salary").tips({
				side:3,
	            msg:'数字过长',
	            bg:'#AE81FF',
	            time:3
	        });
			$("#curriculum_salary").focus();
			return false;
		}else if(!myreg.test(ph)){
			$("#curriculum_salary").tips({
				side:3,
	            msg:'请输入数字',
	            bg:'#AE81FF',
	            time:3
	        });
			$("#curriculum_salary").focus();
			return false;
		}
		
		if ($("#major_id").val() == "") {
			$("#major_id").tips({
				side : 3,
				msg : '请选择学科类型',
				bg : '#AE81FF',
				time : 2
			});
			$("#major_id").focus();
			return false;
		}
		
			$("#form1").submit();
			$("#zhongxin").hide();
			$("#zhongxin2").show();
	}
	
	
	</script>
</body>
</html>

