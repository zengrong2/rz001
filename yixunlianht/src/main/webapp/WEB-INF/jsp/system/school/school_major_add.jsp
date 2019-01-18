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
								<form action="school/major/saveSm.do" name="menuForm" id="menuForm" method="post">
									<input type="hidden" name="major_id" id="major_id" value="${pd.major_id }"/>
									<div id="zhongxin" style="padding-top: 13px;">
									<table id="table_report" class="table table-striped table-bordered table-hover" >
										<tr>
											<td style="width:79px;text-align: right;padding-top: 13px;">学科分类:</td>
											<td id="st">
											<select class="selectpicker" name="stype" id="stype" data-placeholder="请选择学科分类" style="vertical-align:top;" style="width:98%;"  @change="selectSubject">
											 <option>请选择学科分类</option>
											<c:forEach items="${mtList}" var="mt">
												<option value="${mt.type_id }">${mt.type_name }</option>
											</c:forEach>
											</select>
											<input type="hidden" id="subject_type" name="subject_type" />
											
											</td>
                                         </tr>
                                         
                                         <tr>
											<td style="width:79px;text-align: right;padding-top: 13px;">二级分类:</td>
											<td id="ej">
											<input type="hidden" id="two_type" name="two_type" />
											 <select class="selectpicker" name="ttype" id="ttype" data-placeholder="请选择二级分类" style="vertical-align:top;" style="width:98%;" v-model="typeId" @change="selectTtype(typeId)">
								                   <option v-for="c in ej" :value="c.type_id">{{c.type_name}}</option>
							              </select>
											</td>
                                         </tr>
                                        <tr>
											<td style="width:79px;text-align: right;padding-top: 13px;">专业名称:</td>
											<td id="zymc">
											 <select class="selectpicker" name="mtype" id="mtype" data-placeholder="请选择专业名称" style="vertical-align:top;" style="width:98%;" v-model="pid">
								                   <option v-for="a in ma" :value="a.type_id">{{a.type_name}}</option>
							              </select>
							              <input type="hidden" id="major_name" name="major_name" />
							              <input type="hidden" id="type_id" name="type_id" />
											</td>
                                         </tr>
                                         <tr>
											<td style="width:79px;text-align: right;padding-top: 13px;">招生对象:</td>
											<td><input type="text" name="zsdx" id="zsdx"  value=""  maxlength="32" placeholder="这里输入招生对象" title="招生对象" style="width:98%;"/></td>
										</tr>
										<tr>
											<td style="width:79px;text-align: right;padding-top: 13px;">就读年限:</td>
											<td><input type="text" name="year" id="year"  value=""  maxlength="32" placeholder="这里输入年限" title="年限" style="width:98%;"/></td>
										</tr>
										
										<tr>
											<td style="width:79px;text-align: right;padding-top: 13px;">就读费用:</td>
											<td><input type="number" name="money" id="money"  value="" maxlength="32" placeholder="这里输入就读费用" title="就读费用"  style="width:98%;"/></td>
										</tr>
										<tr>
											<td style="width:79px;text-align: right;padding-top: 13px;">备注:</td>
											<td><input type="text" name="remark" id="remark"  value="" maxlength="32" placeholder="这里输入备注" title="备注"  style="width:98%;"/></td>
										</tr>
										<tr>
											<td style="text-align: center;" colspan="10">
												<a class="btn btn-mini btn-primary" onclick="save();">保存</a>
												<a class="btn btn-mini btn-danger" onclick="top.Dialog.close();">取消</a>
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
	<script src="static/vue.js"></script>
	<script src="static/vue-resource.js"></script>
	<!-- inline scripts related to this page -->
	<!-- 下拉框 -->
	<script src="static/ace/js/chosen.jquery.js"></script>
	<!--提示框-->
	<script type="text/javascript" src="static/js/jquery.tips.js"></script>
</body>
<script type="text/javascript">
	$(top.hangge());
	
	var example2 = new Vue({
		  el: '#zhongxin',
		  data:{
			typeId:'',
			typeId2:"",
			pid:'',
			ej:[],
			ma:[],
		  },
		methods : {
			selectSubject:function(){
				var _this = this;
				var stId =  $("#stype").find("option:selected").val();
				$.ajax({
					type:"get",
					url:"<%=basePath%>school/major/getMajorTypeByPid?pid="+stId,
					async:true,
					success:function(ret){
						console.log(ret);
						_this.ej = ret;
						_this.typeId = ret[0].type_id;
						_this.selectTtype(_this.typeId);
					},
					error:function(){
						
					}
				})
			},
			selectTtype:function(typeId){
				var _this=this;
				 var url2="<%=basePath%>school/major/getMajorTypeByPid?pid="+typeId;
					_this.$http.get(url2).then(function(data) {
						_this.ma = data.body;
						_this.pid=_this.ma[0].type_id;
					}, function(response) {
						console.info(response);
					});
			},
		}
				});
	//保存
	function save(){
		var stName = $("#stype").find("option:selected").text();
		var ttName = $("#ttype").find("option:selected").text();
		var majorName = $("#mtype").find("option:selected").text();
		var typeId = $("#mtype").find("option:selected").val();
		
		$("#subject_type").val(stName);
		$("#two_type").val(ttName);
		$("#major_name").val(majorName);
		$("#type_id").val(typeId);
		
		if ($("#subject_type").val() == "") {
			$("#subject_type").tips({
				side : 3,
				msg : '请选择学科分类',
				bg : '#AE81FF',
				time : 2
			});
			$("#subject_type").focus();
			return false;
		}
		if ($("#type_id").val() == "") {
			$("#type_id").tips({
				side : 3,
				msg : '请选择专业',
				bg : '#AE81FF',
				time : 2
			});
			$("#type_id").focus();
			return false;
		}
		
		if ($("#year").val() == "") {
			$("#year").tips({
				side : 3,
				msg : '请输入就读年限',
				bg : '#AE81FF',
				time : 2
			});
			$("#year").focus();
			return false;
		}
		if ($("#money").val() == "") {
			$("#money").tips({
				side : 3,
				msg : '请输入报名费',
				bg : '#AE81FF',
				time : 2
			});
			$("#money").focus();
			return false;
		}
		if ($("#zsdx").val() == "") {
			$("#zsdx").tips({
				side : 3,
				msg : '请输入招生对象',
				bg : '#AE81FF',
				time : 2
			});
			$("#money").focus();
			return false;
		}
		$("#menuForm").submit();
		$("#zhongxin").hide();
		$("#zhongxin2").show();
		
	}

	$(function() {
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
	});
</script>
</html>