<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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

<script type="text/javascript" src="static/js/myjs/commonUrl.js"></script>
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
													<input hidden="hidden" type="text" name="id" id="id" value="${pd.id }" maxlength="50" placeholder="网页" title="网页"/>
													
													<table style="width: 100%;" id="xtable">
													<!-- <tr id="users">
															<td style="padding-top: 10px;">广告名称:
															<input
																type="text" name="egid_name" id="name" value=""
																maxlength="50" placeholder="这里广告名称" title="广告名称"
																style="width: 350px; margin-left: 20px; margin-right: 10px;" />
												
															</td>
														</tr> -->
													<tr>
															<td style="padding-top: 10px;">上传广告图片:<input
																type="hidden" name="img_url" id="img_url"  value=""
																 maxlength="150"
																style="width: 200px; margin-left: 20px;" />
																<div class="btn btn-mini btn-primary"
																	style="margin-left: 15px;" onclick="toImgEdit();">上传广告图</div>
															</td>
														</tr>
														<c:if test="${img_url!=null }">
														<tr id="buzhidao">
															<td style="padding-top: 10px;">
																<div v-for="(x,index) in imgUrl"
																	style="position: relative; display: inline-block">
																	<img :src="aa+x" id="pdtImgMin" width="100" height="100"
																		style="margin-left: 20px;"> <a
																		@click="del(index)"
																		style="position: absolute; top: 0; right: 0"
																		class="btn btn-mini btn-danger"> <i
																		class="ace-icon fa fa-trash-o bigger-120"></i>
																	</a>
																</div>
															</td>
														</tr>
														</c:if>
														<tr>
															<td style="text-align: center;" colspan="10"><a class="btn btn-mini btn-primary" onclick="save();">保存</a> </td>
														</tr>
													</table>
												</div>
												<div id="zhongxin2" class="center" style="display: none">
													<br/><br/><br/><br/><br/><img src="static/images/jiazai.gif" /><br/><h4 class="lighter block green">提交中...</h4>
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
		<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
			<i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
		</a>
	</div>
	<!-- /.main-container -->
	<!-- basic scripts -->
	<!-- 页面底部js¨ -->
	<%@ include file="../../system/index/foot.jsp"%>
	<!-- ace scripts -->
	<!-- 编辑框-->
	<script type="text/javascript" charset="utf-8">window.UEDITOR_HOME_URL = "<%=path%>/plugins/ueditor/";
	</script>
	<script type="text/javascript" charset="utf-8" src="plugins/ueditor/ueditor.config.js"></script>
	<script type="text/javascript" charset="utf-8" src="plugins/ueditor/ueditor.all.js"></script>
	<!-- 编辑框-->
	<script src="static/vue.js"></script>
	<script src="static/vue-resource.js"></script>
	<script type="text/javascript" src="static/js/jquery.tips.js"></script>
	<script src="static/ace/js/ace/ace.js"></script>
	<!--引入属于此页面的js -->
	<script type="text/javascript" src="static/js/myjs/toolEmail.js"></script>
	<script type="text/javascript" src="plugins/webuploader/webuploader.js"></script>
	<script type="text/javascript" src="plugins/webuploader/upload.js"></script>
	
	<script type="text/javascript">
	var buzhidao = new Vue({
		   el:'#buzhidao',
		   data:{
			   imgUrl:[],
			   aa:tupianIp,
		   },
		   methods:{
			   del(index){
				   this.imgUrl.splice(index,1)
			   }
		   }
	   });
	    var img = "";
        img ='${pd.img_url }';
		buzhidao.imgUrl=img.split(",");
		function toImgEdit() {
			 top.jzts();
			 var diag = new top.Dialog();
			 diag.Drag=true;
			 diag.Title ="新增";
			 diag.URL = '<%=basePath%>page/system/systemManager/advertisementPhoto_edit';
			 diag.Width = 800;
			 diag.Height = 900;
			 diag.Modal = true;				//有无遮罩窗口
			 diag. ShowMaxButton = true;	//最大化按钮
		     diag.ShowMinButton = true;		//最小化按钮
			 diag.CancelEvent = function(){ //关闭事件
				 var pdtMinImg=localStorage.getItem("pdtMinImg");
				 if(pdtMinImg!=1){
					 localStorage.setItem("pdtMinImg","1"); 
			        var strs= new Array(); //定义一数组
					strs=pdtMinImg.split(",");		
					buzhidao.imgUrl.push(strs[0]);
					diag.close();
				 }else{
						diag.close();
					 }  
				 };
			 diag.show();
		}
   	//保存
		function save() {
			var id=$("#id").val();
			var a = buzhidao.imgUrl;
			var pdtMinImg=a.join(",");
			console.log(pdtMinImg)
			$("#img_url").val(pdtMinImg);
			
			if (pdtMinImg == "") {
				$("#img_url").tips({
					side : 3,
					msg : '请上传轮播图',
					bg : '#AE81FF',
					time : 2
				});
				$("#img_url").focus();
				return false;
			}
			console.log($("#img_url").val())
			$.ajax({
				url:'<%=basePath%>advertisement/edit',
				type : 'POST',
				data : {
					id:id,
					img_url:pdtMinImg,
				},
				success : function() {
					 alert('修改成功')
					 window.location.href="<%=basePath%>advertisement/toEdit";
					/* $("#zhongxin").hide();
					$("#zhongxin2").show(); */
				},
				error : function() {
					alert('修改失败')

				}
			})
		}
	</script>
</body>
</html>