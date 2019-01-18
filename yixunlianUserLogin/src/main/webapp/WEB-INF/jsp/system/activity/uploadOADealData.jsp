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
					<div class="col-xs-12" style="top:40px;">
						<form action="#" name="form1" id="form1"  method="post">
						<input type="hidden" name="activityId" id="activityId" value="${pd.activityId}"/>
						<input type="hidden" name="userId" id="userId" value="${pd.userId}"/>
						<input type="hidden" name="uandactivityenrollId" id="uandactivityenrollId" value="${pd.uandactivityenrollId}"/>
						
						
							<div id="zhongxin" style="padding-top:13px;">
							<table id="table_report" class="table table-striped table-bordered table-hover">
										
										<tr>
											<td style="color: red;"><input style="width:50%;" type="radio" name="dealStatus" id="dealStatu1"  value=""   />未成交</td>
											<td><input style="width:50%;" type="radio" name="dealStatus" id="dealStatu2"  value="1" checked="checked"    />已成交</td>
										</tr>
										<!-- 设置成交时，显示的填写框 -->
										<table id="newTable" class="dealProject table table-striped table-bordered table-hover">
										<tr id="showDealProject">
										<td style="text-align: right;width: 50%;">
										<input type="text" name="dealProjectName" value="" id="dealProjectName" placeholder="请输入成交项目名称" title="成交项目名称" maxlength="32" style="width:80%;">										
										</td>
										<td style="width: 50%;">
										<input type="number" name="dealProjectMoney" value="" id="dealProjectMoney" placeholder="请输入成交费用" title="成交费用" maxlength="32" style="width:60%;">										
										<a  style="border-radius: 40%;"class="btn btn-mini btn-primary "   id="addDealProject"><span style="font-size: 16px;">+</span></a>
										</td>
										</tr>
										
										</table>
										<%-- <tr>
											<td style="width:140px;text-align: center;font-weight:bold;padding-top: 13px;">活动主办方:</td>
											<td><input type="text" name="p_salary" id="p_salary"  value="${pd.p_salary }"  maxlength="32" placeholder="这里活动主办方" title="活动主办方" style="width:98%;"/></td>
										</tr> --%>
						
							</table>
										<div style="margin-left:240px;">
											<td style="text-align: center;" colspan="10" >
												<a class="btn btn-mini btn-primary" onclick="save();">保存</a>
												<a class="btn btn-mini btn-danger" onclick="top.Dialog.close();">取消</a>
											</td>
										</div>
							
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
	<script src="static/ace/js/ace/ace.js"></script>
	<script src="static/ace/js/chosen.jquery.js"></script>
<!--提示框-->

	<script type="text/javascript" src="static/js/jquery.tips.js"></script>
	<script type="text/javascript">
	/* top.hangge(); */
	$(top.hangge());
	var i=1;
	
	
	$("#addDealProject").click(function() {
		if ($("#dealProjectName").val() == "") {
			$("#dealProjectName").tips({
				side : 3,
				msg : '请输入成交项目名称',
				bg : '#AE81FF',
				time : 2
			});
			$("#dealProjectName").focus();
			return false;
		}
		if ($("#dealProjectMoney").val() == "") {
			$("#dealProjectMoney").tips({
				side : 3,
				msg : '请输入成交费用',
				bg : '#AE81FF',
				time : 2
			});
			$("#dealProjectMoney").focus();
			return false;
		}else if ($("#dealProjectMoney").val() <=0) {
			$("#dealProjectMoney").tips({
				side : 3,
				msg : '请输入正确的成交费用',
				bg : '#AE81FF',
				time : 2
			});
			$("#dealProjectMoney").focus();
			return false;
		}
		var m=i-1;
		if($("#dealProjectName"+m).val()==""){
			$("#dealProjectName"+m).tips({
				side:3,
	            msg:'请输入成交项目名称',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#dealProjectName"+m).focus();
			return false;
		}
		if($("#dealProjectMoney"+m).val()==""){
			$("#dealProjectMoney"+m).tips({
				side:3,
	            msg:'请输入成交金额',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#dealProjectMoney"+m).focus();
			return false;
		}else if($("#dealProjectMoney"+m).val()<=0){
			$("#dealProjectMoney"+m).tips({
				side:3,
	            msg:'请输入正确成交金额',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#dealProjectMoney"+m).focus();
			return false;
		}
		
		var createTr1 = $("<tr>");
		createTr1.attr({"id":"createTr"+i});
		var createTd1 = $("<td>");
		createTd1.css({"text-align":"right","width":"50%"});		
		var createInput1 = $("<input>");
		createInput1.attr({"type":"text","name":"dealProjectName"+i,"value":"","id":"dealProjectName"+i,"placeholder":"请输入成交项目名称","title":"成交项目名称","maxlength":"32"});
		createInput1.css({"width":"80%"});
		
		
		var createTd2 = $("<td>");
		createTd2.css({"width":"50%"});
		var createInput2 = $("<input>");
		createInput2.attr({"type":"number","name":"dealProjectMoney"+i,"value":"","id":"dealProjectMoney"+i,"placeholder":"请输入成交费用","title":"成交费用","maxlength":"32"});
		createInput2.css({"width":"60%"});
		
        var createA = $("<a>");
        createA.attr({"class":"btn btn-mini btn-primary","id":"removeDealProject"+i,"onClick":"removeDealProject("+i+")"})
		createA.css({"border-radius":"40%","width":"26px"});
        var ccreateSpan = $("<span>");
        ccreateSpan.css({"font-size":"16px"});
        ccreateSpan.text("-");
        
		createTd1.append(createInput1);
		createTd2.append(createInput2);
		createA.append(ccreateSpan);
		createTd2.append(createA);
		
		createTr1.append(createTd1);
		createTr1.append(createTd2);
		$("#newTable").append(createTr1);
		
		i++;
		
	});
	
	//去除输入框
	
	function removeDealProject(num) {
		
		$("#createTr"+num).remove();			
	
	}
	//选择框
	$("#dealStatu1").click(function () {
		$("#newTable").css({"visibility":"hidden"});
		$("#dealProjectName").val("");
		$("#dealProjectMoney").val("");
		$("#dealStatu1").attr({"value":"0"});
		$("#dealStatu2").attr({"value":""});
		for(var j=i;j>0;j--){
			$("#createTr"+j).remove();	
		}
	});
	$("#dealStatu2").click(function () {
		$("#newTable").css({"visibility":"visible"});
		$("#dealStatu1").attr({"value":""});
		$("#dealStatu2").attr({"value":"1"});
	});
	//保存
	function save(){
		alert("d"+$("#dealStatu2").val()+"v"+$("#dealStatu1").val());
		if($("#dealStatu2").val()=="1"){			
			if ($("#dealProjectName").val() == "") {
				$("#dealProjectName").tips({
					side : 3,
					msg : '请输入成交项目名称',
					bg : '#AE81FF',
					time : 2
				});
				$("#dealProjectName").focus();
				return false;
			}
			if ($("#dealProjectMoney").val() == "") {
				$("#dealProjectMoney").tips({
					side : 3,
					msg : '请输入成交金额',
					bg : '#AE81FF',
					time : 2
				});
				$("#dealProjectMoney").focus();
				return false;
			}
			else if ($("#dealProjectMoney").val() <=0) {
				$("#dealProjectMoney").tips({
					side : 3,
					msg : '请输入正确的成交金额',
					bg : '#AE81FF',
					time : 2
				});
				$("#dealProjectMoney").focus();
				return false;
			}
		for(var m=i;m>0;m--){
			if($("#dealProjectName"+m).val()==""){
				$("#dealProjectName"+m).tips({
					side:3,
		            msg:'请输入成交项目名称',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#dealProjectName"+m).focus();
				return false;
			}
			if($("#dealProjectMoney"+m).val()==""){
				$("#dealProjectMoney"+m).tips({
					side:3,
		            msg:'请输入成交金额',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#dealProjectMoney"+m).focus();
				return false;
			}else if($("#dealProjectMoney"+m).val()<=0){
				$("#dealProjectMoney"+m).tips({
					side:3,
		            msg:'请输入正确成交金额',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#dealProjectMoney"+m).focus();
				return false;
			}
			
		}
			
			
		}
		
		/* var myreg=/^[0-9]+([.]{1}[0-9]+){0,1}$/;
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
		
		 */
		var activityId = $("#activityId").val();
		var userId = $("#userId").val();
		var dealStatu1 = $("#dealStatu1").val();
		var dealStatu2 = $("#dealStatu2").val();
		var uandactivityenrollId = $("#uandactivityenrollId").val();
		var dealProjectmInfoSaveArray = "";
		if(dealStatu2==1){
		var dealProjectName = $("#dealProjectName").val();
		var dealProjectMoney = $("#dealProjectMoney").val();
		
		dealProjectmInfoSaveArray=dealProjectName+":"+dealProjectMoney+",";
		for(var j=i;j>0;j--){
			var dealProjectNames = $("#dealProjectName"+j).val();
			var dealProjectMoneys =  $("#dealProjectMoney"+j).val();
			dealProjectmInfoSaveArray+=dealProjectNames+":"+dealProjectMoneys+",";
		}
		}	
		 $.ajax({        	 
             type:'POST',
             url:'<%=basePath%>activity/setUploadOADealData.do',
             data:{
              activityId:activityId,
              userId:userId,
              dealStatu1:dealStatu1,
              dealStatu2:dealStatu2,
              uandactivityenrollId:uandactivityenrollId,
              dealProjectmInfoSaveArray:dealProjectmInfoSaveArray           	  
                  },
            success:function(data){
            	alert("设置成功");
            	diag.close();
           /*   window.location.reload(); */
            
	        /*  window.location.reload(); */
            },
            error:function(data){
            	alert("设置失败");
            	diag.close();
           	/*  bootbox.confirm("设置失败"); */
     		  
            }      
		});
		
			/* $("#form1").submit(); */
		/* 	$("#zhongxin").hide();
			$("#zhongxin2").show(); */
	}
	
	
	</script>
</body>
</html>

