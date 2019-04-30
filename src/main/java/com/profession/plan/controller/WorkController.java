/**
 * @Title: WorkController.java
 * @Package com.profession.plan.controller
 * @Description: 职位列表
 * @author 熊正胜
 * @date 2019年4月7日
 * @version V1.0
 */
package com.profession.plan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName: WorkController
 * @Description: 职位列表
 * @author 熊正胜
 * @date 2019年4月7日
 *
 */
@Controller
@RequestMapping("/work")
public class WorkController {

	/**
	 * @Title: list
	 * @Description: 页面跳转url
	 * @return String 返回类型
	 * @throws
	 */
	@RequestMapping("/list")
	public String list(){
		return "/work/list";
	}
}
