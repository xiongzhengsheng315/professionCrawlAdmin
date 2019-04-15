/**
 * @Title: WorkResource.java
 * @Package com.profession.data.crawl.professionCrawlAdmin.resource
 * @Description: 职业接口
 * @author 熊正胜
 * @date 2019年4月7日
 * @version V1.0
 */
package com.profession.data.crawl.professionCrawlAdmin.resource;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.profession.data.crawl.professionCrawlAdmin.service.WorkService;
import com.profession.data.crawl.professionCrawlAdmin.vo.ResponseVo;
import com.profession.data.crawl.professionCrawlAdmin.vo.request.work.QueryListParam;
import com.profession.data.crawl.professionCrawlAdmin.vo.response.work.ListWorkResponseVo;

/**
 * @ClassName: WorkResource
 * @Description: 职业接口
 * @author 熊正胜
 * @date 2019年4月7日
 *
 */
@RestController
public class WorkResource {

	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private WorkService workService;
	
	/**
	 * 
	 * @Title: listWorks
	 * @Description: 查询职业列表
	 * @param param
	 * @param @return 参数
	 * @return ResponseVo<?> 返回类型
	 * @throws
	 */
	public ResponseVo<?> listWorks(QueryListParam param){
		List<ListWorkResponseVo> listWorkResponseVos = null;
		try {
			listWorkResponseVos = workService.listWorkers(param);
		} catch (Exception e) {
			logger.error("查询职业列表异常!", e);
			return ResponseVo.ofFailure("查询职业列表异常,请联系管理员!");
		}
		return ResponseVo.ofSuccess(listWorkResponseVos);
	}
}
