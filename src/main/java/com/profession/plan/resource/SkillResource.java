/**
 * @Title: SkillResource.java
 * @Package com.profession.plan.resource
 * @Description: 工作技能接口
 * @author 袁永国
 * @date 2019年5月30日
 * @version V1.0
 */
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
import com.profession.plan.entity.Skill;
import com.profession.plan.service.SkillService;
import com.profession.plan.vo.ResponseVo;
import com.profession.plan.vo.request.work.QueryListParam;
import com.profession.plan.vo.response.skill.ListSkillResponseVo;

/**
 * @ClassName: SkillResource
 * @Description: 工作技能接口
 * @author 袁永国
 * @date 2019年5月30日
 *
 */
@RestController
@RequestMapping("/skillResource")
public class SkillResource {

	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private SkillService skillService;
	
	/**
	 * 
	 * @Title: listSkills
	 * @Description: 查询工作技能列表
	 * @param param
	 * @param @return 参数
	 * @return ResponseVo<?> 返回类型
	 * @throws
	 */
	@PostMapping("/list")
	@ResponseBody
	public ResponseVo<?> listSkills(@RequestBody QueryListParam param){
		PageInfo<ListSkillResponseVo> pageInfo = null;
		try {
			pageInfo = skillService.listSkills(param);
		} catch (Exception e) {
			logger.error("查询工作技能列表异常!", e);
			return ResponseVo.ofFailure("查询工作技能列表异常,请联系管理员!");
		}
		return ResponseVo.ofSuccess(pageInfo);
	}
	/**
	 * 
	 * @Title: findSkillById
	 * @Description: 根据id查询工作技能
	 * @param param
	 * @param @return 参数
	 * @return ResponseVo<?> 返回类型
	 * @throws
	 */
	@PostMapping("/findSkillById")
	@ResponseBody
	public ResponseVo<?> findSkillById(@RequestBody QueryListParam param){
		Skill skill = null;
		try {
			skill = skillService.findSkillById(param);
		} catch (Exception e) {
			logger.error("查询工作技能异常!", e);
			return ResponseVo.ofFailure("查询工作技能异常,请联系管理员!");
		}
		return ResponseVo.ofSuccess(skill);
	}
	
	/**
	 * 
	 * @Title: delSkill
	 * @Description: 根据id删除工作技能
	 * @param param
	 * @param @return 参数
	 * @return ResponseVo<?> 返回类型
	 * @throws
	 */
	@PostMapping("/delSkill")
	@ResponseBody
	public ResponseVo<?> delSkill(@RequestBody QueryListParam param){
		try {
			skillService.delSkill(param);
		} catch (Exception e) {
			logger.error("删除工作技能异常!", e);
			return ResponseVo.ofFailure("删除工作技能异常!");
		}
		return ResponseVo.ofSuccess("删除工作技能成功!");
	}
	
	/**
	 * 
	 * @Title: addSkill
	 * @Description: 新增工作技能
	 * @param param
	 * @param @return 参数
	 * @return ResponseVo<?> 返回类型
	 * @throws
	 */
	@PostMapping("/addSkill")
	@ResponseBody
	public ResponseVo<?> addSkill(@RequestBody QueryListParam param){
		try {
			skillService.addSkill(param);
		} catch (Exception e) {
			logger.error("添加工作技能异常!", e);
			return ResponseVo.ofFailure("添加工作技能异常!");
		}
		return ResponseVo.ofSuccess("添加工作技能成功!");
	}
	
	/**
	 * 
	 * @Title: editSkill
	 * @Description: 修改工作技能
	 * @param param
	 * @param @return 参数
	 * @return ResponseVo<?> 返回类型
	 * @throws
	 */
	@PostMapping("/editSkill")
	@ResponseBody
	public ResponseVo<?> editSkill(@RequestBody QueryListParam param){
		try {
			skillService.editSkill(param);
		} catch (Exception e) {
			logger.error("修改工作技能异常!", e);
			return ResponseVo.ofFailure("修改工作技能异常!");
		}
		return ResponseVo.ofSuccess("修改工作技能成功!");
	}
}
