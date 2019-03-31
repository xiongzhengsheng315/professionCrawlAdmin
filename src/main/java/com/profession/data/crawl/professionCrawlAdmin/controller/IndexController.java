/**
 * @Title: IndexController.java
 * @Package com.profession.data.crawl.professionCrawlAdmin.controller
 * @Description: 首页跳转控制类
 * @author 熊正胜
 * @date 2019年3月24日
 * @version V1.0
 */
package com.profession.data.crawl.professionCrawlAdmin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName: IndexController
 * @Description: 首页跳转控制类
 * @author 熊正胜
 * @date 2019年3月24日
 *
 */
@Controller
public class IndexController {

	/***
	 * @Title: getIndexPath
	 * @Description: 跳转到后台管理首页
	 * @return String 返回类型
	 * @throws
	 */
	@RequestMapping("/index")
	public String getIndexPath(){
		return "index";
	}
}
