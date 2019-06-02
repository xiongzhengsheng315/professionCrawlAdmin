/**
 * @Title: Skill.java
 * @Package com.profession.plan.entity
 * @Description: 工作技能实体
 * @author 袁永国
 * @date 2019年5月30日
 * @version V1.0
 */
package com.profession.plan.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @ClassName: Skill
 * @Description: 工作技能实体
 * @author 袁永国
 * @date 2019年5月30日
 *
 */
@Table(name = "skill")
public class Skill implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -5256376018561955852L;

	/**
	 * 技能id
	 */
	@Id
	@Column(name = "id")
	private Long id;
	
	/**
	 * 职业分类id
	 */
	@Column(name = "category_id")
	private Long categoryId;
	
	/**
	 * 技能名称
	 */
	@Column(name = "name")
	private String name;
	
	/**
	 * 删除标记
	 */
	@Column(name = "del")
	private Integer del;
	
	
	/**
	 * 创建时间
	 */
	@Column(name = "create_time")
	private Date createTime;
	
	/**
	 * 更新时间
	 */
	@Column(name = "update_time")
	private Date updateTime;
	
	/**
	 * 版本号
	 */
	@Column(name = "version")
	private String version;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getDel() {
		return del;
	}

	public void setDel(Integer del) {
		this.del = del;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	
	
	
}