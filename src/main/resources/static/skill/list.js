var pageSize=10;
var pageNo=1;
$(function(){
	//初始化
	init({"pageSize": pageSize, "pageNo": pageNo});
	
	bindEvent();

});
	function init(paramObj){
		$.ajax({
			method : "POST",
			url : "/skillResource/list",
			async : true,
			dataType : "json",
			contentType: "application/json;charset-UTF-8",
			data : JSON.stringify(paramObj),
			success : function(dataObj){
				if(!dataObj || dataObj.status != 200) {
					alert(dataObj.errMsg);
					return false;
				}
				var arr = dataObj.data.list;
				var html = [];
				if(arr==null||arr.length==0){
					html.push('<tr><td colspan="6">数据为空</td></tr>');
					$("#skillListDom").html(html.join(""));
					$("#totalRecord").html(0);
					$("#pagination").remove();
				}else{
					for(var i = 0, len = arr.length; i < len; i++) {
						var obj = arr[i];
						html.push('<tr class="text-c">');
						html.push('	<td><input type="checkbox" value="" name=""></td>');
						html.push('	<td>'+obj.name+'</td>');
						html.push('	<td>'+obj.categoryName+'</td>');
						html.push('	<td>'+'介绍'+'</td>');
						html.push('	<td>'+obj.updateTime+'</td>');
						html.push('	<td class="f-14 td-manage"> <a style="text-decoration:none" class="ml-5" href="javascript:;" onclick="editSkill('+obj.id+')" title="编辑"><i class="Hui-iconfont">&#xe6df;</i></a> <a style="text-decoration:none" class="ml-5" href="javascript:;" onclick="delSkill('+obj.id+')" title="删除"><i class="Hui-iconfont">&#xe6e2;</i></a></td>');
						html.push('</tr>');
					}
					$("#skillListDom").html(html.join(""));
					$("#pagination").remove();
					$("#pagerDom").append('<ul id="pagination" class="pagination"></ul>');
					$("#totalRecord").html(dataObj.data.total);
					$("#pagination").twbsPagination({
			            totalPages:dataObj.data.pageSize,  //总页数
			            hideOnlyOnePage: true,  //当总数为一页时，不显示分页
			            visiblePages:7,  //设置最多显示的页码数
			            currentPage:dataObj.data.pageNum,  //设置当前的页码
			            first:'首页',
			            last:'末页',
			            prev:'上一页',
			            next:'下一页',
			            onPageClick:function(event, page){
			            	pageNo = page;
			            	var paramObj1 = {
			            		"pageSize" : pageSize,
					    		"pageNo": pageNo
			            	};
			            	getListInfo(paramObj1);
			            }
			        });
				}
			}
		});
	}
	function getListInfo(paramObj){
		$.ajax({
			method : "POST",
			url : "/skillResource/list",
			async : true,
			dataType : "json",
			contentType: "application/json;charset-UTF-8",
			data : JSON.stringify(paramObj),
			success : function(dataObj){
				if(!dataObj || dataObj.status != 200) {
					alert(dataObj.errMsg);
					return false;
				}
				var arr = dataObj.data.list;
				var html = [];
				for(var i = 0, len = arr.length; i < len; i++) {
					var obj = arr[i];
					html.push('<tr class="text-c">');
					html.push('	<td><input type="checkbox" value="" name=""></td>');
					html.push('	<td>'+obj.name+'</td>');
					html.push('	<td>'+obj.categoryName+'</td>');
					html.push('	<td>'+'介绍'+'</td>');
					html.push('	<td>'+obj.updateTime+'</td>');
					html.push('	<td class="f-14 td-manage"> <a style="text-decoration:none" class="ml-5" href="javascript:;" onclick="editSkill('+obj.id+')" title="编辑"><i class="Hui-iconfont">&#xe6df;</i></a> <a style="text-decoration:none" class="ml-5" href="javascript:;" onclick="delSkill('+obj.id+')" title="删除"><i class="Hui-iconfont">&#xe6e2;</i></a></td>');
					html.push('</tr>');
				}
				$("#skillListDom").html(html.join(""));
			}
		});
	}
	function bindEvent(){
		$("#search").click(function(){
			var startDateMin = $("#startDateMin").val();
			var startDateMax = $("#startDateMax").val();
			var skillName = $("#skillName").val();
			var paramObj = {};
			paramObj["startDateMin"] = startDateMin;
			paramObj["startDateMax"] = startDateMax;
			paramObj["skillName"] = skillName;
			paramObj["pageSize"] = pageSize;
			paramObj["pageNo"] = pageNo
			search(paramObj);
		});
	}
	
	function search(paramObj){
		$.ajax({
			method : "POST",
			url : "/skillResource/list",
			async : true,
			dataType : "json",
			contentType: "application/json;charset-UTF-8",
			data : JSON.stringify(paramObj),
			success : function(dataObj){
				if(!dataObj || dataObj.status != 200) {
					alert(dataObj.errMsg);
					return false;
				}
				var html = [];
				var arr = dataObj.data.list;
				var len;
				if(arr==null||arr.length==0){
					html.push('<tr><td colspan="6">数据为空</td></tr>');
					$("#skillListDom").html(html.join(""));
					$("#totalRecord").html(0);
					$("#pagination").remove();
				}else{
					len = arr.length;
					for(var i = 0; i < len; i++) {
						var obj = arr[i];
						html.push('<tr class="text-c">');
						html.push('	<td><input type="checkbox" value="" name=""></td>');
						html.push('	<td>'+obj.name+'</td>');
						html.push('	<td>'+obj.categoryName+'</td>');
						html.push('	<td>'+'介绍'+'</td>');
						html.push('	<td>'+obj.updateTime+'</td>');
						html.push('	<td class="f-14 td-manage"> <a style="text-decoration:none" class="ml-5" href="javascript:;" onclick="editSkill('+obj.id+')" title="编辑"><i class="Hui-iconfont">&#xe6df;</i></a> <a style="text-decoration:none" class="ml-5" href="javascript:;" onclick="delSkill('+obj.id+')" title="删除"><i class="Hui-iconfont">&#xe6e2;</i></a></td>');
						html.push('</tr>');
					}
					$("#skillListDom").html(html.join(""));
					$("#pagination").remove();
					$("#pagerDom").append('<ul id="pagination" class="pagination"></ul>');
					$("#totalRecord").html(dataObj.data.total);
					$("#pagination").twbsPagination({
			            totalPages:dataObj.data.pageSize,  //总页数
			            hideOnlyOnePage: true,  //当总数为一页时，不显示分页
			            visiblePages:7,  //设置最多显示的页码数
			            currentPage:dataObj.data.pageNum,  //设置当前的页码
			            first:'首页',
			            last:'末页',
			            prev:'上一页',
			            next:'下一页',
			            onPageClick:function(event, page){
			            	paramObj.pageNo=page;
			            	getListInfo(paramObj);
			            }
			        });
				}
			}
		});
	}
	function addSkill(){
		layer.open({
			type: 2,
			area: ['500px', '300px'], 
			title: "添加工作技能",
			content: "/skill/goAdd"
		});
	}
	
	function delSkill(id){
		var mymessage=confirm("您确定要删除吗?");
		if(mymessage==true){
			var paramObj = {};
			paramObj["id"] = id;
			$.ajax({
				method : "POST",
				url : "/skillResource/delSkill",
				async : true,
				dataType : "json",
				contentType: "application/json;charset-UTF-8",
				data : JSON.stringify(paramObj),
				success : function(dataObj){
					if(!dataObj || dataObj.status != 200) {
						alert(dataObj.errMsg);
					}
					var startDateMin = $("#startDateMin").val();
					var startDateMax = $("#startDateMax").val();
					var skillName = $("#skillName").val();
					var paramObj = {};
					paramObj["startDateMin"] = startDateMin;
					paramObj["startDateMax"] = startDateMax;
					paramObj["skillName"] = skillName;
					paramObj["pageSize"] = pageSize;
					paramObj["pageNo"] = pageNo
					search(paramObj);
				}
			});
		} else{  
			return false;   
		}
	}
	function editSkill(sid){
		layer.open({
			type: 2,
			area: ['500px', '300px'], 
			title: "修改工作技能",
			content: "/skill/goEdit?skillId="+sid
		});
	}