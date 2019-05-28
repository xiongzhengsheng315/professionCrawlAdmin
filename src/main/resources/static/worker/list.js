$(function(){
	//初始化
	workObj.init({"pageSize": workObj.pageSize, "pageNo": workObj.pageNo});
	
	workObj.bindEvent();
});

var workObj = {
	"pageSize":10,
	"pageNo":1,
	"init" : function(paramObj){
		$.ajax({
			method : "POST",
			url : "/worker/list",
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
					html.push('	<td>'+obj.jobName+'</td>');
					html.push('	<td>'+obj.relatedMajor+'</td>');
					html.push('	<td>'+obj.academicRequire+'</td>');
					html.push('	<td>'+obj.workPlace+'</td>');
					html.push('	<td>'+obj.cityName+'</td>');
					html.push('	<td>'+obj.regionName+'</td>');
					html.push('	<td>'+obj.salary+'</td>');
					html.push('	<td>'+obj.jobBrightSpot+'</td>');
					html.push('	<td>'+obj.statusMsg+'</td>');
					html.push('	<td>'+obj.updateTime+'</td>');
					html.push('	<td class="f-14 td-manage"><a style="text-decoration:none" href="javascript:;" title="下架"><i class="Hui-iconfont">&#xe6de;</i></a> <a style="text-decoration:none" class="ml-5" href="javascript:;" title="编辑"><i class="Hui-iconfont">&#xe6df;</i></a> <a style="text-decoration:none" class="ml-5" href="javascript:;" title="删除"><i class="Hui-iconfont">&#xe6e2;</i></a></td>');
					html.push('</tr>');
				}
				$("#workListDom").html(html.join(""));
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
		            	workObj.pageNo = page;
		            	var paramObj = {
		            		"pageSize" : workObj.pageSize,
				    		"pageNo": workObj.pageNo
		            	};
		            	workObj.init(paramObj);
		            }
		        });
			}
		});
	},
	"bindEvent" : function(){
		$("#search").click(function(){
			var status = $("#status").val();
			var startDateMin = $("#startDateMin").val();
			var startDateMax = $("#startDateMax").val();
			var jobName = $("#jobName").val();
			var paramObj = {};
			if(status != "") {
				paramObj["status"] = status;
			}
			if(startDateMin) {
				paramObj["startDateMin"] = startDateMin;
			}
			if(startDateMax) {
				paramObj["startDateMax"] = startDateMax;
			}
			if(jobName) {
				paramObj["jobName"] = jobName;
			}
			paramObj["pageSize"] = workObj.pageSize;
			paramObj["pageNo"] = workObj.pageNo
			workObj.init(paramObj);
		});
	}
};