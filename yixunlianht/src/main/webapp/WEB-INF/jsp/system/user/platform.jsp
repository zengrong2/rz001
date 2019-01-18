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
								<form action="platform/edit.do" name="userForm" id="userForm" method="post">
									<div id="zhongxin" style="padding-top: 13px;">
									<input hidden="hidden" text="text" name="ptjj_id" id="ptjj_id" value="${pd.ptjj_id}">
									<table id="table_report" class="table table-striped table-bordered table-hover">
										<tr>
											<td style="width:79px;text-align: right;padding-top: 13px;">标题:</td>
											<td><input type="text" name="title" id="title"  value="${pd.title}"  maxlength="32" placeholder="这里输入标题" title="标题"  style="width: 430px; margin-left: 20px;"/></td>
										</tr>
										<tr>
											<td style="width:79px;text-align: right;padding-top: 13px;">图片:</td>
											<td><input type="hidden" name="img_url" id="img_url"  value="${pd.img_url }" />
										    <input type="file" onchange="choose()" style="display:none" id="imgFile"/>
										<label for="imgFile" class="btn btn-mini btn-primary" style="margin-left: 15px;">上传图片</label>
										<img id="pic" height="100px" width="100px"/></td>
										</tr>
										<tr>
											<td style="width:79px;text-align: right;padding-top: 13px;">简介:</td>
											<td><input type="file" onchange="toXx()" style="display:none" id="xxFile"/>
										<label for="xxFile" class="btn btn-mini btn-primary" style="margin-left: 15px;">上传平台简介</label>
										<input type="text" name="html_url" id="html_url"  value="${pd.html_url }"  style="width: 430px; margin-left: 20px;"/></td>
										</tr>
										<tr>
											<td style="text-align: center;" colspan="10">
												<a class="btn btn-mini btn-primary" onclick="save();">保存</a>
											</td>
										</tr>
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
	<script type="text/javascript" src="static/js/myjs/commonUrl.js"></script>
</body>
<script type="text/javascript">
	$(top.hangge());
	var a=tupianIp+"${pd.img_url}";
	$('#pic').attr("src",a);
	//保存
	function save(){
		if($("#title").val()==""){
			$("#title").tips({
				side:3,
	            msg:'输入标题',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#title").focus();
			return false;
		}
		
		if(($("#pic").attr("src")).indexOf("base64") !=-1){
			var formData=new FormData();			
			formData.append('file',dataURLtoFile($('#pic').attr("src")));
			$.ajax({
				url:'<%=basePath%>file/onefile',
				type:'POST',
				data:formData,
				processData: false,
				contentType:false,
				traditional:true,
				async:false,
				success:function(data){
					$('#img_url').attr("value",data)
				}
			})
			}
		if ($("#img_url").val() == "") {
			alert("请上传图片")
		return false;
	}
		if($("#html_url").val()==""){
			$("#html_url").tips({
				side:3,
	            msg:'上传简介',
	            bg:'#AE81FF',
	            time:3
	        });
			$("#html_url").focus();
			return false;
		}
		
		
			$("#userForm").submit();
			$("#zhongxin").hide();
			$("#zhongxin2").show();
		}
	function choose(){
		var file = $("#imgFile")[0].files[0]
		var reader = new FileReader();
		reader.readAsDataURL(file);
		 reader.onloadend = function () {			 
		  $('#pic').attr('src',this.result);
		 }		 
	}
	function dataURLtoFile(dataurl, filename) {
        var arr = dataurl.split(','), mime = arr[0].match(/:(.*?);/)[1],bstr = atob(arr[1]), n = bstr.length, u8arr = new Uint8Array(n);
        while(n--){
            u8arr[n] = bstr.charCodeAt(n);
        }
        return new File([u8arr], filename, {type:mime});
    }
	function toXx(){
		 var formdatas = new FormData();
		 formdatas.append("file",$('#xxFile')[0].files[0]);
		 $.ajax({
				url:'<%=basePath%>file/xxFileUpload',
				type:'POST',
				data:formdatas,
				processData: false,
				contentType:false,
				traditional:true,
				async:false,
				success:function(data){
					$('#html_url').attr("value",data);
					alert("上传成功")
					
				}
			}) 
		}
</script>
</html>