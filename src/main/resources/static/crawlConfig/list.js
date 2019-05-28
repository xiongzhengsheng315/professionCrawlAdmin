$(function(){
	//初始化
	crawlConfigObj.init(crawlConfigObj.condition);
	
	crawlConfigObj.bindEvent();
});

var crawlConfigObj = {
	"condition" : {
		"pageSize":10,
		"pageNo":1
	},
	"init" : function(paramObj){
		$.ajax({
			method : "POST",
			url : "/crawlConfig/list",
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
					html.push('	<td>'+obj.tradeName+'</td>');
					html.push('	<td>'+crawlConfigObj.getDeleteLabel(obj.delete)+'</td>');
					html.push('	<td>'+crawlConfigObj.getStatusLabel(obj.status)+'</td>');
					html.push('	<td>'+(new Date(obj.createTime)).Format("yyyy-MM-dd hh:mm:ss")+'</td>');
					html.push('	<td class="f-14 td-manage"><a style="text-decoration:none" class="ml-5" href="javascript:;" title="编辑"><i class="Hui-iconfont">&#xe6df;</i></a> <a style="text-decoration:none" class="ml-5" href="javascript:;" title="删除"><i class="Hui-iconfont">&#xe6e2;</i></a></td>');
					html.push('</tr>');
				}
				$("#workListDom").html(html.join(""));
				$("#pagination").remove();
				$("#pagerDom").append('<ul id="pagination" class="pagination"></ul>');
				$("#totalRecord").html(dataObj.data.total);
				$("#pager").pager({
                    pagenumber: dataObj.data.pageNum, 
                    pagecount: dataObj.data.pages,
                    totalcount: dataObj.data.total,
                    buttonClickCallback: function(pageclickednumber){
                    	crawlConfigObj.condition.pageNo = pageclickednumber;
                    	crawlConfigObj.init(crawlConfigObj.condition);
                    }
                });
			}
		});
	},
	"getDeleteLabel" : function(key){
		var deleteObj = {"true" : "已删除" , "false": "未删除"};
		return deleteObj[key];
	},
	"getStatusLabel" : function(key){
		var statusObj = {"0":"未爬取","1":"爬取中","2":"爬取完成"};
		return statusObj[key];
	},
	"bindEvent" : function(){
		$("#search").click(function(){
			var status = $("#status").val();
			var startDateMin = $("#startDateMin").val();
			var startDateMax = $("#startDateMax").val();
			var jobName = $("#jobName").val();
			if(status != "") {
				workObj.condition["status"] = status;
			}
			if(startDateMin) {
				workObj.condition["startDateMin"] = startDateMin;
			}
			if(startDateMax) {
				workObj.condition["startDateMax"] = startDateMax;
			}
			if(jobName) {
				workObj.condition["jobName"] = jobName;
			}
			workObj.init(workObj.condition);
		});
	}
};