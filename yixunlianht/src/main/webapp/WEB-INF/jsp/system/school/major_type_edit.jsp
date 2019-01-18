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

<!-- jsp文件头和头部 -->
<%@ include file="../index/top.jsp"%>
<script type="text/javascript" src="static/js/myjs/commonUrl.js"></script>
</head>
<body class="no-skin">

	<!-- /section:basics/navbar.layout -->
	<div class="main-container" id="main-container">
		<!-- /section:basics/sidebar -->
		<div class="main-content">
			<div class="main-content-inner">
				<div class="page-content">
				
					<div class="page-header">
							<h1>
								<small>
									<i class="ace-icon fa fa-angle-double-right"></i>
									编辑
								</small>
							</h1>
					</div><!-- /.page-header -->

					<div class="row">
						<div class="col-xs-12">

						<form  action="<%=basePath%>major/type/edit.do" name="menuForm" id="menuForm" method="post" class="form-horizontal">
							<input type="hidden" name="type_id" id="type_id" value="${pd.type_id }"/>
			                <input type="hidden" name="img_url" id="img_url"  value="${pd.img_url }" />
							<input type="hidden" name="pid" id="pid" value="${null == pd.pid ? type_id:pd.pid}"/>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 上级 :</label>
								<div class="col-sm-9">
									<div style="padding-top:5px;">
										<div class="col-xs-4 label label-lg label-light arrowed-in arrowed-right">
											<b>${null == pds.type_name ?'(无) 此项为顶级菜单':pds.type_name}</b>
										</div>
									</div>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 名称 :</label>
								<div class="col-sm-9">
									<input type="text" name="type_name" id="type_name" value="${pd.type_name}" placeholder="这里输入名称" class="col-xs-10 col-sm-5" />
								</div>
							</div>
						
							<c:if test="${pd.pid==0 }">
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 图片 : </label>
								 专业小图:
										<input type="file" onchange="choose()" style="display:none" id="imgFile"/>
											<label for="imgFile" class="btn btn-mini btn-primary" style="margin-left: 15px;">上传专业小图</label>
							<div>专业图片:<img id="picture" height="120px" width="120px"/></div>
							</div>
							</c:if>
							<div class="clearfix form-actions">
								<div class="col-md-offset-3 col-md-9">
									<a class="btn btn-mini btn-primary" onclick="save();">保存</a>
									<a class="btn btn-mini btn-danger" onclick="goback('${type_id}');">取消</a>
								</div>
							</div>
							<div class="hr hr-18 dotted hr-double"></div>
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
		<a href="#" id="btn-scroll-up"
			class="btn-scroll-up btn btn-sm btn-inverse"> <i
			class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
		</a>

	</div>
	<!-- /.main-container -->

	<!-- basic scripts -->
	<!-- 页面底部js¨ -->
	<%@ include file="../index/foot.jsp"%>
	<!--提示框-->
	<script type="text/javascript" src="static/js/jquery.tips.js"></script>
	<!-- inline scripts related to this page -->
	<script type="text/javascript">
		//$(top.hangge());
		var a=tupianIp+"${pd.img_url}";

	$('#picture').attr("src",a);
		//返回
		function goback(id){
			
			window.location.href="<%=basePath%>major/type/list.do?type_id="+id;
		}
		
		//保存
		function save(){
			var s=$("#picture").attr("src");
			if($("#type_name").val()==""){
				$("#type_name").tips({
					side:3,
		            msg:'请输入名称',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#type_name").focus();
				return false;
			}
			if(s!=null){
			if(($("#picture").attr("src")).indexOf("base64") !=-1){
				var formData=new FormData();			
				formData.append('file',dataURLtoFile($('#picture').attr("src")));
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
			}
			$("#menuForm").submit();
		}
		function choose(){
			var file = $("#imgFile")[0].files[0]
			var reader = new FileReader();
			reader.readAsDataURL(file);
			 reader.onloadend = function () {			 
			  $('#picture').attr('src',this.result);
			 }		 
		}
		function dataURLtoFile(dataurl, filename) {
	        var arr = dataurl.split(','), mime = arr[0].match(/:(.*?);/)[1],bstr = atob(arr[1]), n = bstr.length, u8arr = new Uint8Array(n);
	        while(n--){
	            u8arr[n] = bstr.charCodeAt(n);
	        }
	        return new File([u8arr], filename, {type:mime});
	    }
	
	</script>


</body>
</html>