var locat = (window.location+'').split('/'); 
$(function(){if('tool'== locat[3]){locat =  locat[0]+'//'+locat[2];}else{locat =  locat[0]+'//'+locat[2]+'/'+locat[3];};});

$(top.hangge());

//发送
function sendEm(){
	
	if($("#TYPE").val()=="1"){
		$("#CONTENT").val(getContentTxt());
	}else{
		$("#CONTENT").val(getContent());
	}
/*	if($("#EMAIL").val()==""){
		$("#EMAIL").tips({
			side:3,
            msg:'请输入邮箱',
            bg:'#AE81FF',
            time:2
        });
		$("#EMAIL").focus();
		return false;
	}*/
	if($("#img_name").val()==""){
		$("#img_name").tips({
			side:3,
            msg:'请输入广告名称',
            bg:'#AE81FF',
            time:2
        });
		$("#img_name").focus();
		return false;
	}
	
	if($("#imgurl").val()==""){
		$("#imgurl").tips({
			side:3,
            msg:'请上传广告图片',
            bg:'#AE81FF',
            time:2
        });
		$("#imgurl").focus();
		return false;
	}
	
	
	if($("#CONTENT").val()==""){
		
		$("#nr").tips({
			side:3,
            msg:'请输入内容',
            bg:'#AE81FF',
            time:3
        });
		return false;
	}
	
	$("#zhongxin").hide();
	$("#zhongxin2").show();
	

	var img_name = $("#img_name").val();
	var TYPE  = $("#TYPE").val();
	/*var TITLE = $("#TITLE").val();*/
	var CONTENT = $("#CONTENT").val();
	/*var isAll = $("#isAll").val();*/
	var id = $("#id").val();
	var imgurl = $("#imgurl").val();
	
	
	var fmsg = "${pd.msg}";
	
	$.ajax({
		type: "POST",
		url: locat+'/advertisement/sendadvertisementEdit.do?tm='+new Date().getTime(),
    	data: {TYPE:TYPE,CONTENT:CONTENT,fmsg:fmsg,img_name:img_name,imgurl:imgurl,id:id},
		dataType:'json',
		//beforeSend: validateData,
		cache: false,
		success: function(data){
			 $.each(data.list, function(i, list){
				 if(list.msg == 'ok'){
					 alert("发布成功");
				/*	 var count = list.count;
					 var ecount = list.ecount;
					 $("#msg").tips({
						side:3,
			            msg:'成功发出'+count+'条,失败'+ecount+'条,检查邮箱格式',
			            bg:'#68B500',
			            time:5
				      });*/
					 
				 }else{
					 alert("发布失败");
					/* $("#msg").tips({
							side:3,
				            msg:'邮件发送失败,请联系管理员检查邮件服务器配置是否正确!',
				            bg:'#FF0000',
				            time:5
					 });
					 */
				 }
				 setTimeout("showdiv()",4000);
				 timer(3);
			 });
		}
	});
	
}

//倒计时
function timer(intDiff){
	window.setInterval(function(){
	$('#second_shows').html('<s></s>'+intDiff+'秒');
	intDiff--;
	}, 1000);
}

function showdiv(){
	$("#zhongxin2").hide();
	$("#zhongxin").show();
}

function setType(value){
	$("#TYPE").val(value);
}

/*function isAll(){
	if(document.getElementsByName('form-field-checkbox')[0].checked){
		$("#isAll").val('yes');
		$("#EMAIL").attr("disabled",true);
	}else{
		$("#isAll").val('no');
		$("#EMAIL").attr("disabled",false);
	}
}*/

//编辑邮箱(此方式弃用)
function editEmail(){
   var EMAIL = $("#EMAIL").val();
   var result = showModalDialog(locat+"/head/editEmail.do?EMAIL="+EMAIL,"","dialogWidth=600px;dialogHeight=380px;");
   if(result==null || ""==result){
	    $("#EMAIL").val("");
   }else{
		$("#EMAIL").val(result);
   }
}

//打开编辑邮箱
function dialog_open(){
	/*$("#EMAILs").val($("#EMAIL").val());*/
	$("#dialog-add").css("display","block");
}
//关闭编辑邮箱
function cancel_pl(){
	$("#dialog-add").css("display","none");
}
//保存编辑邮箱
function saveEmail(){
/*	$("#EMAIL").val($("#EMAILs").val());*/
	$("#dialog-add").css("display","none");
}

//ueditor纯文本
function getContentTxt() {
    var arr = [];
    arr.push(UE.getEditor('editor').getContentTxt());
    return arr.join("");
}
//ueditor有标签文本
function getContent() {
    var arr = [];
    arr.push(UE.getEditor('editor').getContent());
    return arr.join("");
}

setTimeout("ueditor()",500);
function ueditor(){
	var ue = UE.getEditor('editor');
}
