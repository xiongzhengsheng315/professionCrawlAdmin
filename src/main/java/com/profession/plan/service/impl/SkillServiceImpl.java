/**
 * @Title: SkillServiceImpl.java
 * @Package com.profession.plan.service.impl
 * @Description: TODO
 * @author 袁永国
 * @date 2019年5月30日
 * @version V1.0
 */
package com.profession.plan.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.profession.plan.entity.Category;
import com.profession.plan.entity.Skill;
import com.profession.plan.mapper.SkillMapper;
import com.profession.plan.service.CategoryService;
import com.profession.plan.service.SkillService;
import com.profession.plan.util.DateUtil;
import com.profession.plan.vo.request.work.QueryListParam;
import com.profession.plan.vo.response.skill.ListSkillResponseVo;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

/**
 * @ClassName: SkillServiceImpl
 * @Description: 工作技能业务接口实现类
 * @author 袁永国
 * @date 2019年5月30日
 *
 */
@Service
public class SkillServiceImpl implements SkillService {

	@Autowired
	private SkillMapper skillMapper;
	@Autowired
	private CategoryService categoryService;
	
	/**
	 * @Title: listSkills
	 * @Description: 查询工作技能列表
	 * @param param 查询参数
	 * @param @return 参数
	 * @return PageInfo<ListSkillResponseVo> 返回类型
	 * @throws
	 */
	@Override
	public PageInfo<ListSkillResponseVo> listSkills(QueryListParam param) {
		Example example = new Example(Skill.class);
		Criteria criteria = example.createCriteria();
		if(StringUtils.isNotBlank(param.getSkillName())){
			criteria.andLike("name", "%" + param.getSkillName() + "%");
		}
		if(param.getStartDateMin() != null){
			criteria.andGreaterThanOrEqualTo("createTime", param.getStartDateMin());
		}
		if(param.getStartDateMax() != null){
			criteria.andLessThanOrEqualTo("createTime", param.getStartDateMax());
		}
		PageHelper.startPage(param.getPageNo(), param.getPageSize());
		List<Skill> skills = skillMapper.selectByExample(example);
		PageInfo<Skill> pageInfo = new PageInfo<Skill>(skills);
		if(pageInfo == null || CollectionUtils.isEmpty(pageInfo.getList())) {
			return null;
		}
		List<ListSkillResponseVo> responseVos = new ArrayList<>();
		ListSkillResponseVo responseVo = null;
		for (Skill skill : pageInfo.getList()) {
			responseVo = new ListSkillResponseVo();
			BeanUtils.copyProperties(skill, responseVo);
			//
			Category category = categoryService.getCategory(skill.getCategoryId());
			if(category != null) {
				responseVo.setCategoryName(category.getName());
			}
			responseVo.setUpdateTime(DateUtil.convertDateToString(skill.getUpdateTime()));
			responseVos.add(responseVo);
		}
		PageInfo<ListSkillResponseVo> resultPageInfo = new PageInfo<ListSkillResponseVo>();
		resultPageInfo.setTotal(pageInfo.getTotal());
		resultPageInfo.setPageNum(pageInfo.getPageNum());
		resultPageInfo.setPageSize(pageInfo.getPages());
		resultPageInfo.setList(responseVos);
		return resultPageInfo;
	}

	/**
	 * @Title: delSkill
	 * @Description: 根据id删除工作技能
	 * @param param 查询参数
	 * @param @return 参数
	 * @throws
	 */
	@Override
	public void delSkill(QueryListParam param) {
		// TODO Auto-generated method stub
		skillMapper.deleteByPrimaryKey(param.getId());
	}

	/**
	 * @Title: addSkill
	 * @Description: 添加工作技能
	 * @param skill 工作技能实体
	 * @param @return 参数
	 * @return 
	 * @throws
	 */
	@Override
	public void addSkill(QueryListParam param) {
		// TODO Auto-generated method stub
		Skill skill=new Skill();
		skill.setCategoryId(param.getCategoryId());
		skill.setName(param.getSkillName());
		skill.setVersion(param.getVersion());
		skill.setCreateTime(new Date());
		skill.setUpdateTime(new Date());
		skill.setDel(0);
		skillMapper.insert(skill);
	}

}
