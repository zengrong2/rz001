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
						<div class="content pb0">
	<!-- Info boxes -->
	<div class="row">
		<div class="col-md-3 col-sm-6 col-xs-12">
			<div class="info-box">
				<span class="info-box-icon bg-aqua"><i class="fa fa-cog"></i></span>
				<div class="info-box-content">
					 <span class="info-box-text">当日新增钻石客户经理</span>
					<span class="info-box-number"><span style="color:red;">${alldiamondCustomerCountByDay }</span><small></small></span> 
				</div>
			</div>
		</div>
		<div class="col-md-3 col-sm-6 col-xs-12">
			<div class="info-box">
				<span class="info-box-icon bg-red"><i class="fa fa-google-plus"></i></span>
				<div class="info-box-content">
					<span class="info-box-text">当日新增VIP客户经理</span>
					<span class="info-box-number"><span style="color:red;">${allVipCustomerCountByDay }</span> </span>
				</div>
			</div>
		</div>

		<!-- fix for small devices only -->
		<div class="clearfix visible-sm-block"></div>

		<div class="col-md-3 col-sm-6 col-xs-12">
			<div class="info-box">
				<span class="info-box-icon bg-green"><i class="fa fa-internet-explorer"></i></span>
				<div class="info-box-content">
					<span class="info-box-text">当日新增VIP体验客户经理</span>
					<span class="info-box-number"><span style="color:red;">${allVipExperienceCustomerCountByDay }</span></span>
				</div>
			</div>
		</div>
		<div class="col-md-3 col-sm-6 col-xs-12">
			<div class="info-box">
				<span class="info-box-icon bg-green"><i class="fa fa-internet-explorer"></i></span>
				<div class="info-box-content">
					<span class="info-box-text">当日新增VIP试用客户经理</span>
					<span class="info-box-number"><span style="color:red;">${allVipTryCustomerCountByDay }</span></span>
				</div>
			</div>
		</div>
		<div class="col-md-3 col-sm-6 col-xs-12">
			<div class="info-box">
				<span class="info-box-icon bg-green"><i class="fa fa-internet-explorer"></i></span>
				<div class="info-box-content">
					<span class="info-box-text">当日新增普通客户经理</span>
					<span class="info-box-number"><span style="color:red;">${allCustomerManagerCountByDay }</span></span>
				</div>
			</div>
		</div>
		<div class="col-md-3 col-sm-6 col-xs-12">
			<div class="info-box">
				<span class="info-box-icon bg-green"><i class="fa fa-internet-explorer"></i></span>
				<div class="info-box-content">
					<span class="info-box-text">当日新增普通用户</span>
					<span class="info-box-number"><span style="color:red;">${allOrdinaryUserCountByDay }</span></span>
				</div>
			</div>
		</div>
		<div class="col-md-3 col-sm-6 col-xs-12">
			<div class="info-box">
				<span class="info-box-icon bg-green"><i class="fa fa-internet-explorer"></i></span>
				<div class="info-box-content">
					<span class="info-box-text">当日新增未激活用户</span>
					<span class="info-box-number"><span style="color:red;">${allNotActivityUserCountByDay }</span></span>
				</div>
			</div>
		</div>
		<div class="col-md-3 col-sm-6 col-xs-12">
			<div class="info-box">
				<span class="info-box-icon bg-yellow"><i class="fa fa-internet-explorer"></i></span>

				<div class="info-box-content">
					<span class="info-box-text">当日新增总用户</span>
					<span class="info-box-number"><span style="color:red;">${allCustomerCountByDay }</span></span>
				</div>
			</div>
		</div>
	</div>
	<!-- Chart boxes -->
	<div class="row">
		<div class="col-md-12">
			<div class="box box-widget">
				<div class="box-header with-border">
					<h3 class="box-title"><form action="membershipStatements/goListmembershipStatements.do" name="form1" id="form1"  method="post">
					<input type="number" value="${pd.yearNumber }" id="yearNumber" name="yearNumber" style="border:none;width:100px;height:60px;font-size: 25px;font-weight: bold;">
					<button class="btn btn-mini">查询</button>
					用户报表					 
					</form>
					<!-- <div class="box-tools pull-right">
						<button type="button" class="btn btn-box-tool" data-widget="collapse">
							<i class="fa fa-minus"></i>
						</button>
						 <div class="btn-group">
							<button type="button" class="btn btn-box-tool dropdown-toggle" data-toggle="dropdown">
								<i class="fa fa-wrench"></i></button>
							 <ul class="dropdown-menu" role="menu">
								<li><a href="#">导出Excel</a></li>
								<li><a href="#">导出Word</a></li>
								<li class="divider"></li>
								<li><a href="#">基本设置</a></li>
							</ul> 
						</div> 
						<button type="button" class="btn btn-box-tool" data-widget="remove">
							<i class="fa fa-times"></i>
						</button>
					</div> -->
				</div>
				<div class="box-body">
					<div class="row">
						<div class="col-md-8">
							<div class="chart">
								<div id="myChart" style="height:300px;width:150%"></div>
								<script src="http://echarts.baidu.com/dist/echarts.common.min.js"></script>
								<script>
									var option = {
									    title : {
									        text: ''
									    },
									    tooltip : {
									        trigger: 'axis'
									    },
									    legend: {
									        data:['钻石客户经理','VIP客户经理','VIP试用客户经理','VIP体验客户经理','普通客户经理','普通用户']
									    },
									    toolbox: {
									        show : true,
									        feature : {
									            mark : {show: true},
									            dataView : {show: true, readOnly: false},
									            magicType : {show: true, type: ['line', 'bar', 'stack', 'tiled']},
									            restore : {show: true},
									            saveAsImage : {show: true}
									        }
									    },
									    calculable : true,
									    grid : {
									    	top: '49',
									    	right: '20',
									    	bottom: '30'
									    },
									    xAxis : [
									        {
									            type : 'category',
									            boundaryGap : false,
									            data : ['一月','二月','三月','四月','五月','六月','七月','八月','九月','十月','十一月','十二月']
									        }
									    ],
									    yAxis : [
									        {
									            type : 'value'
									        }
									    ],
									    series : [
									        {
									            name:'VIP试用客户经理',
									            type:'line',
									            smooth:true,
									            itemStyle: {normal: {areaStyle: {type: 'default'}}},
									            data:[
									            <c:forEach items="${vipTryCustomerManagers}" var="ts">
									            ${ts},
									            </c:forEach>
									            ]
									            
									        },
									        {
									            name:'VIP客户经理',
									            type:'line',
									            smooth:true,
									            itemStyle: {normal: {areaStyle: {type: 'default'}}},
									            data:[
									            	 <c:forEach items="${vipCustomerManagers}" var="ts">
											            ${ts},
											            </c:forEach>
									            ]
									        },
									        {
									            name:'钻石客户经理',
									            type:'line',
									            smooth:true,
									            itemStyle: {normal: {areaStyle: {type: 'default'}}},
									            data:[
									            	 <c:forEach items="${diamondCustomerManagers}" var="ts">
											            ${ts},
											            </c:forEach>
									            ]
									        },
									        {
									            name:'VIP体验客户经理',
									            type:'line',
									            smooth:true,
									            itemStyle: {normal: {areaStyle: {type: 'default'}}},
									            data:[
									            	
									            	 <c:forEach items="${vipExperienceCustomerManagers}" var="ts">
										            ${ts},
										            </c:forEach>
									            ]
									        }
									        ,
									        {
									            name:'普通客户经理',
									            type:'line',
									            smooth:true,
									            itemStyle: {normal: {areaStyle: {type: 'default'}}},
									            data:[
									            	
									            	 <c:forEach items="${CustomerManagers}" var="ts">
										            ${ts},
										            </c:forEach>
									            ]
									        },
									        {
									            name:'普通用户',
									            type:'line',
									            smooth:true,
									            itemStyle: {normal: {areaStyle: {type: 'default'}}},
									            data:[
									            	 <c:forEach items="${customers}" var="ts">
											            ${ts},
											            </c:forEach>
									            ]
									        }
									     ]
									};
									// 基于准备好的dom，初始化echarts实例
							        var myChart = echarts.init(document.getElementById('myChart'));
							        myChart.setOption(option);
								</script>
							</div>
						</div>
						<!-- <div class="col-md-4">
							<p class="text-center">
								<strong>完成目标</strong>
							</p>
							<div class="progress-group">
								<span class="progress-text">钻石客户经理</span>
								<span class="progress-number"><b>160</b>/200</span>
								<div class="progress sm">
									<div class="progress-bar progress-bar-aqua" style="width: 80%"></div>
								</div>
							</div>
							<div class="progress-group">
								<span class="progress-text">VIP客户经理</span>
								<span class="progress-number"><b>310</b>/400</span>
								<div class="progress sm">
									<div class="progress-bar progress-bar-red" style="width: 80%"></div>
								</div>
							</div>
							<div class="progress-group">
								<span class="progress-text">普通客户经理</span>
								<span class="progress-number"><b>480</b>/800</span>
								<div class="progress sm">
									<div class="progress-bar progress-bar-green" style="width: 80%"></div>
								</div>
							</div>
							<div class="progress-group">
								<span class="progress-text">用户量</span>
								<span class="progress-number"><b>800</b>/1000</span>
								<div class="progress sm">
									<div class="progress-bar progress-bar-yellow" style="width: 80%"></div>
								</div>
							</div>
						</div> -->
					</div>
				</div>
				<div class="box-footer" style="margin-left:120px;margin-top:50px;">
					<div class="row">
						<div class="col-sm-3 col-xs-6">
							<div class="description-block border-right">
								<span class="description-percentage text-green"><span class="glyphicon glyphicon-bullhorn" style="font-size: 20px;color: green;"></span></span>
								<h5 class="description-header"><span style="color:red;">${ allCustomerCountByYear}</span></h5>
								<span class="description-text">年总用户</span>
							</div>
						</div>
						<div class="col-sm-3 col-xs-6">
							<div class="description-block border-right">
								<span class="description-percentage text-yellow"><span class="glyphicon glyphicon-send" style="font-size: 20px;color: green;"></span></span>
								<h5 class="description-header"><span style="color:red;">${diamondCustomerManagerCountByYear }</span></h5>
								<span class="description-text">年总钻石客户经理</span>
							</div>
						</div>
						<div class="col-sm-3 col-xs-6">
							<div class="description-block border-right">
								<span class="description-percentage text-green"><span class="glyphicon glyphicon-thumbs-up" style="font-size: 20px;color: green;"></span></span>
								<h5 class="description-header"><span style="color:red;">${vipCustomerManagerCountByYear }</span></h5>
								<span class="description-text">年总VIP客户经理</span>
							</div>
						</div>
						<div class="col-sm-3 col-xs-6">
							<div class="description-block" >
								<span class="description-percentage text-red"><span class="glyphicon glyphicon-magnet" style="font-size: 20px;color: green;"></span> </span>
								<h5 class="description-header"><span style="color:red;">${allNotActiveCustomerCountByYear }</span></h5>
								<span class="description-text">年总未激活用户</span>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
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
	<script src="static/ace/js/date-time/bootstrap-datepicker.js"></script>
	<script src="static/ace/js/chosen.jquery.js"></script>
	<!--提示框-->
	<script type="text/javascript" src="static/js/jquery.tips.js"></script>
		<script src="static/ace/js/bootbox.js"></script>
	<!-- ace scripts -->
	<script src="static/ace/js/ace/ace.js"></script>
	<script type="text/javascript">
	top.hangge();
	//保存
	function save(){
		/* if ($("#name").val() == "") {
			$("#name").tips({
				side : 3,
				msg : '请输入职位名称',
				bg : '#AE81FF',
				time : 2
			});
			$("#name").focus();
			return false;
		}
		var myreg=/^[0-9]+([.]{1}[0-9]+){0,1}$/;
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
		
		if ($("#p_requirement").val() == "") {
			$("#p_requirement").tips({
				side : 3,
				msg : '请输入职位需求',
				bg : '#AE81FF',
				time : 2
			});
			$("#p_requirement").focus();
			return false;
		}
		if ($("#work").val() == "") {
			$("#work").tips({
				side : 3,
				msg : '请输入工作职位',
				bg : '#AE81FF',
				time : 2
			});
			$("#work").focus();
			return false;
		}
		
		 */
		
			$("#form1").submit();
			$("#zhongxin").hide();
			$("#zhongxin2").show();
	}
	
	
	</script>
</body>
</html>

