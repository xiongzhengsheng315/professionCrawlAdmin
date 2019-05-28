package com.profession.plan.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.profession.plan.entity.CrawlProfessionConfig;
import com.profession.plan.service.CrawlProfessionConfigService;
import com.profession.plan.vo.ResponseVo;
import com.profession.plan.vo.request.crawlConfig.ListRequestParamVo;

@RestController
@RequestMapping("/crawlConfig")
public class CrawlProfessionConfigResource {

	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private CrawlProfessionConfigService crawlProfessionConfigService;
	
	/**
	 * 
	 * @Title: listWorks
	 * @Description: 查询爬虫配置列表
	 * @param param
	 * @param @return 参数
	 * @return ResponseVo<?> 返回类型
	 * @throws
	 */
	@PostMapping("/list")
	@ResponseBody
	public ResponseVo<?> listCrawlProfessionConfigs(@RequestBody ListRequestParamVo param){
		PageInfo<CrawlProfessionConfig> pageInfo = null;
		try {
			pageInfo = crawlProfessionConfigService.listCrawlProfessionConfigs(param);
		} catch (Exception e) {
			logger.error("查询爬虫配置列表异常!", e);
			return ResponseVo.ofFailure("查询爬虫配置列表异常,请联系管理员!");
		}
		return ResponseVo.ofSuccess(pageInfo);
	} 
}
