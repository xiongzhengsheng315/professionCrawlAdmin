/**
 * @Title: SkillMapper.java
 * @Package com.profession.plan.mapper
 * @Description: 工作技能mapper接口
 * @author 袁永国
 * @date 2019年5月30日
 * @version V1.0
 */
package com.profession.plan.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.profession.plan.entity.Skill;
import com.profession.plan.vo.response.skill.ListSkillResponseVo;

import tk.mybatis.mapper.common.Mapper;

/**
 * @ClassName: SkillMapper
 * @Description: 工作技能mapper接口
 * @author 袁永国
 * @date 2019年5月30日
 *
 */
public interface SkillMapper extends Mapper<Skill> {

}
