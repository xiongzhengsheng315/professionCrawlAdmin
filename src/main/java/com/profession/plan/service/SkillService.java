/**
 * @Title: SkillService.java
 * @Package com.profession.plan.service
 * @Description: 工作技能业务接口
 * @author 袁永国
 * @date 2019年5月30日
 * @version V1.0
 */
package com.profession.plan.service;

import com.github.pagehelper.PageInfo;
import com.profession.plan.entity.Skill;
import com.profession.plan.vo.request.work.QueryListParam;
import com.profession.plan.vo.response.skill.ListSkillResponseVo;

/**
 * @ClassName: SkillService
 * @Description: 工作技能业务接口
 * @author 袁永国
 * @date 2019年5月30日
 *
 */
public interface SkillService {

	/**
	 * @Title: listSkills
	 * @Description: 查询工作技能列表
	 * @param param 查询参数
	 * @param @return 参数
	 * @return PageInfo<ListSkillResponseVo> 返回类型
	 * @throws
	 */
	public PageInfo<ListSkillResponseVo> listSkills(QueryListParam param);
	
	/**
	 * @Title: delSkill
	 * @Description: 根据id删除工作技能
	 * @param param 查询参数
	 * @param @return 参数
	 * @return 
	 * @throws
	 */
	public void delSkill(QueryListParam param);
	
	/**
	 * @Title: addSkill
	 * @Description: 添加工作技能
	 * @param param 工作技能实体
	 * @param @return 参数
	 * @return 
	 * @throws
	 */
	public void addSkill(QueryListParam param);
}
