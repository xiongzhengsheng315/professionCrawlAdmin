/**
 * @Title: SkillController.java
 * @Package com.profession.plan.controller
 * @Description: 工作能力跳转类
 * @author 袁永国
 * @date 2019年5月30日
 * @version V1.0
 */
package com.profession.plan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName: SkillController
 * @Description: 工作能力列表
 * @author 袁永国
 * @date 2019年5月30日
 *
 */
@Controller
@RequestMapping("/skill")
public class SkillController {

	/**
	 * @Title: list
	 * @Description: 工作能力列表
	 * @param @return 参数
	 * @return String 返回类型
	 * @throws
	 */
	@RequestMapping("/list")
	public String list(){
		return "/skill/list";
	}
	
	/**
	 * @Title: goAdd
	 * @Description: 添加工作能力界面
	 * @param @return 参数
	 * @return String 返回类型
	 * @throws
	 */
	@RequestMapping("/goAdd")
	public String goAdd(){
		return "/skill/addSkill";
	}
	/**
	 * @Title: goEdit
	 * @Description: 编辑工作能力界面
	 * @param @return 参数
	 * @return String 返回类型
	 * @throws
	 */
	@RequestMapping("/goEdit")
	public String goEdit(){
		return "/skill/editSkill";
	}
}
