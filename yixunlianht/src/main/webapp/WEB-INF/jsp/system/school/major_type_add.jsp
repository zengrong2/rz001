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
									新增
								</small>
							</h1>
					</div><!-- /.page-header -->

					<div class="row">
						<div class="col-xs-12">

						<form  action="<%=basePath%>major/type/add.do" name="menuForm" id="menuForm" method="post" class="form-horizontal">
							<input type="hidden" name="type_id" id="type_id" value="${ser.type_id }"/>
							<input type="hidden" name="pid" id="pid" value="${null == ser.pid ? type_id:ser.pid}"/>
							<input type="hidden" name="type" id="type" value="${null == pds.type ? 0:pds.type}"/>
							<input type="hidden" name="img_url" id="img_url"  value="${pds.img_url }" />
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
								<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 专业名称 :</label>
								<div class="col-sm-9">
									<input type="text" name="type_name" id="type_name" value="${ser.type_name}" placeholder="这里输入名称" class="col-xs-10 col-sm-5" />
								</div>
							</div>
							<c:if test="${pds==null }">
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 专业小图 : </label>
								<div class="col-sm-9">
										<input type="file" onchange="choose()" style="display:none" id="imgFile"/>
										<label for="imgFile" class="btn btn-mini btn-primary" style="margin-left: 15px;">上传专业小图</label>
								<div><img id="picture" height="120px" width="120px"/></div>
								</div>
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


		//返回
		function goback(id){
			console.log(123)
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
		
		 function toImgEdit() {
			 top.jzts();
			 var diag = new top.Dialog();
			 diag.Drag=true;
			 diag.Title ="编辑项目小图";
			 diag.URL = '<%=basePath%>page/pdt/product/userphoto_edit';
			 diag.Width = 800;
			 diag.Height = 755;
			 diag.Modal = true;				//有无遮罩窗口
			 diag. ShowMaxButton = true;	//最大化按钮
		     diag.ShowMinButton = true;		//最小化按钮
			 diag.CancelEvent = function(){ //关闭事件
		        var pdtMinImg=localStorage.getItem("pdtMinImg");
		        var strs= new Array(); //定义一数组
				strs=pdtMinImg.split(",");
				pdtBanner.imgUrl.push(strs[0]);
				//var imgUrl=strs[0];
				//imgUrldd=imgUrl;
				//$("#pdtMinImg").attr('src',tupianIp+imgUrl);
				//$("#PDT_MIN_IMG").val(tupianIp+imgUrl);
			  diag.close();
			 };
			 diag.show();
		}

	</script>


</body>
</html>