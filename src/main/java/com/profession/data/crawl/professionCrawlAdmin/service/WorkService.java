/**
 * @Title: WorkService.java
 * @Package com.profession.data.crawl.professionCrawlAdmin.service
 * @Description: 职业业务接口
 * @author 熊正胜
 * @date 2019年4月8日
 * @version V1.0
 */
package com.profession.data.crawl.professionCrawlAdmin.service;

import java.util.List;

import com.profession.data.crawl.professionCrawlAdmin.vo.request.work.QueryListParam;
import com.profession.data.crawl.professionCrawlAdmin.vo.response.work.ListWorkResponseVo;

/**
 * @ClassName: WorkService
 * @Description: 职业业务接口
 * @author 熊正胜
 * @date 2019年4月8日
 *
 */
public interface WorkService {

	/**
	 * @Title: listWorkers
	 * @Description: 查询职业列表
	 * @param param 查询参数
	 * @param @return 参数
	 * @return List<ListWorkResponseVo> 返回类型
	 * @throws
	 */
	public List<ListWorkResponseVo> listWorkers(QueryListParam param);
}
