/**
 * @Title: ListSkillResponseVo.java
 * @Package com.profession.plan.vo.response.work
 * @Description: 工作技能列表返回
 * @author 袁永国
 * @date 2019年5月30日
 * @version V1.0
 */
package com.profession.plan.vo.response.skill;

import java.io.Serializable;

/**
 * @ClassName: ListSkillResponseVo
 * @Description: 工作技能列表返回
 * @author 袁永国
 * @date 2019年5月30日
 *
 */
public class ListSkillResponseVo implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -5905172847698142669L;

	/**
	 * id
	 */
	private Long id;
	
	/**
	 * 技能名称
	 */
	private String name;
	
	/**
	 * 技能介绍
	 */
	private String description ;
	
	/**
	 * 职业分类
	 */
	private String categoryName;
	
	/**
	 * 更新时间
	 */
	private String updateTime;

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	
	
}
