/**
 * @Title: CrawlProfessionConfigService.java
 * @Package com.profession.plan.service
 * @Description: 爬虫配置业务接口
 * @author 熊正胜
 * @date 2019年3月24日
 * @version V1.0
 */
package com.profession.plan.service;

import java.util.List;

import com.profession.plan.entity.CrawlProfessionConfig;
import com.profession.plan.vo.request.crawlConfig.ListRequestParamVo;

/**
 * @ClassName: CrawlProfessionConfigService
 * @Description: 爬虫配置业务接口
 * @author 熊正胜
 * @date 2019年3月24日
 *
 */
public interface CrawlProfessionConfigService {

	/**
	 * @Title: listCrawlProfessionConfigs
	 * @Description: 查询爬取职业列表
	 * @param requestParamVo 爬虫状态
	 * @return List<CrawlProfessionConfig> 返回类型
	 * @throws
	 */
	public List<CrawlProfessionConfig> listCrawlProfessionConfigs(ListRequestParamVo requestParamVo);
}
