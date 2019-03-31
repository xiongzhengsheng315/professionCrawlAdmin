/**
 * @Title: CrawlProfessionConfigController.java
 * @Package com.profession.data.crawl.professionCrawlAdmin.controller
 * @Description: 抓取职业配置跳转控制类
 * @author 熊正胜
 * @date 2019年3月24日
 * @version V1.0
 */
package com.profession.data.crawl.professionCrawlAdmin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName: CrawlProfessionConfigController
 * @Description: 抓取职业配置跳转控制类
 * @author 熊正胜
 * @date 2019年3月24日
 *
 */
@Controller
@RequestMapping("/crawlConfig")
public class CrawlProfessionConfigController {

	/**
	 * @Title: list
	 * @Description: 职业配置列表
	 * @param @return 参数
	 * @return String 返回类型
	 * @throws
	 */
	@RequestMapping("/list")
	public String list(){
		return "/crawl_config/list";
	}
}
