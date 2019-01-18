<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
<base href="<%=basePath%>">
<!-- jsp文件头和头部 -->
<%@ include file="../index/top.jsp"%>

<style type="text/css">

#dialog-add, #dialog-message, #dialog-comment {
	width: 100%;
	height: 100%;
	position: fixed;
	top: 0px;
	z-index: 99999999;
	display: none;
}

.commitopacity {
	position: absolute;
	width: 100%;
	height: 10000px;
	background: #7f7f7f;
	filter: alpha(opacity = 50);
	-moz-opacity: 0.5;
	-khtml-opacity: 0.5;
	opacity: 0.5;
	top: 0px;
	z-index: 99999;
}

.commitbox {
	width: 100%;
	margin: 0px auto;
	position: absolute;
	top: 120px;
	z-index: 99999;
}

.commitbox_inner {
	width: 96%;
	height: 255px;
	margin: 6px auto;
	background: #efefef;
	border-radius: 5px;
}

.commitbox_top {
	width: 100%;
	height: 253px;
	margin-bottom: 10px;
	padding-top: 10px;
	background: #FFF;
	border-radius: 5px;
	box-shadow: 1px 1px 3px #e8e8e8;
}

.commitbox_top textarea {
	width: 95%;
	height: 195px;
	display: block;
	margin: 0px auto;
	border: 0px;
}

.commitbox_cen {
	width: 95%;
	height: 40px;
	padding-top: 10px;
}

.commitbox_cen div.left {
	float: left;
	background-size: 15px;
	background-position: 0px 3px;
	padding-left: 18px;
	color: #f77500;
	font-size: 16px;
	line-height: 27px;
}

.commitbox_cen div.left img {
	width: 30px;
}

.commitbox_cen div.right {
	float: right;
	margin-top: 7px;
}

.commitbox_cen div.right span {
	cursor: pointer;
}

.commitbox_cen div.right span.save {
	border: solid 1px #c7c7c7;
	background: #6FB3E0;
	border-radius: 3px;
	color: #FFF;
	padding: 5px 10px;
}

.commitbox_cen div.right span.quxiao {
	border: solid 1px #f77400;
	background: #f77400;
	border-radius: 3px;
	color: #FFF;
	padding: 4px 9px;
}

.uploadBtn {
	background: #ffffff;
	border: 1px solid #cfcfcf;
	color: #565656;
	padding: 0 18px;
	display: inline-block;
	border-radius: 3px;
	margin-left: 10px;
	cursor: pointer;
	font-size: 14px;
	float: left;
}

.uploadBtn:hover {
	background: #f0f0f0;
}

.uploadBtn {
	background: #00b7ee;
	color: #fff;
	border-color: transparent;
}

.uploadBtn:hover {
	background: #00a2d4;
}

.uploadBtn.disabled {
	pointer-events: none;
	opacity: 0.6;
}
</style>

</head>
<body>
	<!-- /section:basics/navbar.layout -->
	<div class="main-container" id="main-container">
		<!-- /section:basics/sidebar -->
		<div class="main-content">
			<div class="main-content-inner">
				<div class="page-content">
					<div class="row">
						<div class="col-xs-12">
							<div class="span12">
								<div class="widget-box">
									<div class="widget-body">
										<div class="widget-main">
											<div class="step-content row-fluid position-relative">
												<div id="zhongxin">
												<form  action="<%=basePath%>school/teacher/saveSt.do" name="menuForm" id="menuForm" method="post" class="form-horizontal">
													<textarea name="CONTENT" id="CONTENT" style="display: none"></textarea>
													<table style="width: 100%;" id="xtable">
														<tr id="users">
															<td style="padding-top: 10px;">
															<input type="hidden" name="teacher_id" id="teacher_id"  value="${pd.teacher_id }" />
															教师姓名:
															<input type="text" name="name" id="name" value="${pd.name }" maxlength="50" placeholder="这里输入姓名" title="教师姓名"  style="width: 240px; margin-left: 20px; margin-right: 10px;" />
																
															</td>
														</tr>				
										              <tr>
										               <td style="padding-top: 10px;">
										                                  教师图:<input type="hidden" name="head_portrait" id="head_portrait" value="${pd.head_portrait}" maxlength="150" style="width: 200px; margin-left: 20px;" />
																<input type="file" onchange="choose()" style="display:none" id="imgFile"/>
										                         <label for="imgFile" class="btn btn-mini btn-primary" style="margin-left: 15px;">上传学校小图</label>
										                          <img id="pic" height="100px" width="100px"/>
															</td>
														</tr>
														<tr id="users">
															<td style="padding-top: 10px;">
															是否名师:
															<input id="type" type="radio" name="type" value="1" checked="checked"/>  是 &nbsp;&nbsp;
															<input id="type" type="radio" name="type" value="0"/>  否
																
															</td>
														</tr>
														<tr id="users">
															<td style="padding-top: 10px;">
															教师简介:
															<textarea rows="5" cols="50" id="profile" name="profile"></textarea>
															</td>
														</tr>
													
														<tr>
															<td style="text-align: center;padding-top: 10px;" colspan="10"><a
																class="btn btn-mini btn-primary" onclick="save();">保存</a>
																<a class="btn btn-mini btn-danger"
																onclick="top.Dialog.close();">取消</a></td>
														</tr>
													</table>
													</form>
												</div>
												<div id="zhongxin2" class="center" style="display: none">
													<br />
													<img src="static/images/jiazai.gif" /><br />
													<h4 class="lighter block green">提交中...</h4>
												</div>
											</div>
										</div>
										<!--/widget-main-->
									</div>
									<!--/widget-body-->
								</div>
							</div>
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
	<!-- ace scripts -->
	<!-- 编辑框-->

	<script type="text/javascript" charset="utf-8"
		src="plugins/ueditor/ueditor.config.js"></script>
	<script type="text/javascript" charset="utf-8"
		src="plugins/ueditor/ueditor.all.js"></script>
	<!-- 编辑框-->
	<script src="static/vue.js"></script>
	<script src="static/vue-resource.js"></script>
	<script type="text/javascript" src="static/js/jquery.tips.js"></script>
	<script src="static/ace/js/ace/ace.js"></script>
	<!--引入属于此页面的js -->
	
	<script type="text/javascript" src="static/js/myjs/toolEmail.js"></script>
	<script type="text/javascript" src="plugins/webuploader/webuploader.js"></script>
	<script type="text/javascript" src="plugins/webuploader/upload.js"></script>
	<script type="text/javascript" src="static/js/myjs/commonUrl.js"></script>
	<script type="text/javascript">	  
	
   	//保存
		function save() {
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
						$('#head_portrait').attr("value",data)
					}
				})
				}
			console.log($("#head_portrait").val())
			if ($("#name").val() == "") {
				$("#name").tips({
					side : 3,
					msg : '请输入教师姓名',
					bg : '#AE81FF',
					time : 2
				});
				$("#name").focus();
				return false;
			}
			
			$("#menuForm").submit();
			$("#zhongxin").hide();
			$("#zhongxin2").show();

		}
	   
		function getLocalTimeHMS(date2) {
			var date = new Date(date2);
			var Y = date.getFullYear() + '-';
			var M = (date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1)
					: date.getMonth() + 1)
					+ '-';
			var D = date.getDate() + ' ';
			var h = date.getHours() + ':';
			var m = date.getMinutes() + ':';
			var s = date.getSeconds();
			return Y + M + D + h + m + s;

		}
		/*关闭窗口*/
		function CloseWebPage() {     
		    if (navigator.userAgent.indexOf("MSIE") > 0) {     
		        if (navigator.userAgent.indexOf("MSIE 6.0") > 0) {     
		            window.opener = null; window.close();     
		        }     
		        else {     
		            window.open('', '_top'); window.top.close();     
		        }     
		    }     
		    else if (navigator.userAgent.indexOf("Firefox") > 0) {     
		        window.location.href = 'about:blank '; //火狐默认状态非window.open的页面window.close是无效的    
		        //window.history.go(-2);     
		    }     
		    else {     
		        window.opener = null;      
		        window.open('', '_self', '');     
		        window.close();     
		    }     
		}  
		
		var pdtid2= localStorage.getItem("pdtId");
		 function toImgEdit() {
			 top.jzts();
			 var diag = new top.Dialog();
			 diag.Drag=true;
			 diag.Title ="新增";
			 diag.URL = '<%=basePath%>page/system/school/userphoto_edit';
			 diag.Width = 800;
			 diag.Height = 755;
			 diag.Modal = true;				//有无遮罩窗口
			 diag. ShowMaxButton = true;	//最大化按钮
		     diag.ShowMinButton = true;		//最小化按钮
			 diag.CancelEvent = function(){ //关闭事件
				 var pdtMinImg=localStorage.getItem("pdtMinImg");
				 if(pdtMinImg!=1){
					 localStorage.setItem("pdtMinImg","1");    
				        var strs= new Array(); //定义一数组
						strs=pdtMinImg.split(",");
						//var imgUrl=strs[0];				
						buzhidao.imgUrl.push(strs[0]);
						console.log(buzhidao.imgUrl)
						diag.close();
				 }else{
					diag.close();
				 }  
				 };
			 diag.show();
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
		
	</script>
</body>
</html>