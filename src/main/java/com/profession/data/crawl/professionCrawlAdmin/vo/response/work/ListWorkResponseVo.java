/**
 * @Title: ListWorkResponseVo.java
 * @Package com.profession.data.crawl.professionCrawlAdmin.vo.response.work
 * @Description: 职业列表返回
 * @author 熊正胜
 * @date 2019年4月8日
 * @version V1.0
 */
package com.profession.data.crawl.professionCrawlAdmin.vo.response.work;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @ClassName: ListWorkResponseVo
 * @Description: 职业列表返回
 * @author 熊正胜
 * @date 2019年4月8日
 *
 */
public class ListWorkResponseVo implements Serializable {

	/**
	 * @Fields field:field:{todo}
	 */
	private static final long serialVersionUID = 7125233032281357786L;

	/**
	 * 岗位名称
	 */
	private String jobName;
	
	/**
	 * 相关专业
	 */
	private String relatedMajor;
	
	/**
	 * 学历要求
	 */
	private String academicRequire;
	
	/**
	 * 工作地点
	 */
	private String workPlace;
	
	/**
	 * 城市
	 */
	private String cityName;
	
	/**
	 * 区域
	 */
	private String regionName;
	
	/**
	 * 薪资待遇
	 */
	private String salary;
	
	/**
	 * 职位亮点
	 */
	private String jobBrightSpot;
	
	/**
	 * 状态  0:待审核;1:已审核;2:审核失败;
	 */
	private String statusMsg;
	
	/**
	 * 更新时间
	 */
	private String updateTime;

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getRelatedMajor() {
		return relatedMajor;
	}

	public void setRelatedMajor(String relatedMajor) {
		this.relatedMajor = relatedMajor;
	}

	public String getAcademicRequire() {
		return academicRequire;
	}

	public void setAcademicRequire(String academicRequire) {
		this.academicRequire = academicRequire;
	}

	public String getWorkPlace() {
		return workPlace;
	}

	public void setWorkPlace(String workPlace) {
		this.workPlace = workPlace;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getJobBrightSpot() {
		return jobBrightSpot;
	}

	public void setJobBrightSpot(String jobBrightSpot) {
		this.jobBrightSpot = jobBrightSpot;
	}

	public String getStatusMsg() {
		return statusMsg;
	}

	public void setStatusMsg(String statusMsg) {
		this.statusMsg = statusMsg;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
}
