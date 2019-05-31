/**
 * @Title: Category.java
 * @Package com.profession.plan.entity
 * @Description: 职业类型
 * @author 袁永国
 * @date 2019年5月30日
 * @version V1.0
 */
package com.profession.plan.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * @ClassName: Category
 * @Description: 职业类型
 * @author 袁永国
 * @date 2019年5月30日
 *
 */
public class Category implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 2530348369500646327L;

	/**
	 * 区域id
	 */
	@Id
	@Column(name = "id")
	private Long id;
	
	/**
	 * 名称
	 */
	@Column(name = "name")
	private String name;
	
	/**
	 * 分级层数
	 */
	@Column(name = "level")
	private Integer level;
	
	/**
	 * 父类目id
	 */
	@Column(name = "fid")
	private Long fid;
	
	/**
	 * 是否启用
	 */
	@Column(name = "enable")
	private Integer enable;
	
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
	private Integer version;

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

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Long getFid() {
		return fid;
	}

	public void setFid(Long fid) {
		this.fid = fid;
	}

	public Integer getEnable() {
		return enable;
	}

	public void setEnable(Integer enable) {
		this.enable = enable;
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

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	
}
