/**
 * @Title: QueryListParam.java
 * @Package com.profession.plan.vo.request.work
 * @Description: TODO
 * @author 熊正胜
 * @date 2019年4月8日
 * @version V1.0
 */
package com.profession.plan.vo.request.work;

import java.util.Date;

import com.profession.plan.vo.RequestParamVo;

/**
 * @ClassName: QueryListParam
 * @Description: TODO
 * @author 熊正胜
 * @date 2019年4月8日
 *
 */
public class QueryListParam extends RequestParamVo {

	/**
	 * @Fields field:field:{todo}
	 */
	private static final long serialVersionUID = 5637045704837269194L;

	/**
	 * 审核状态
	 */
	private Integer status;
	
	/**
	 * 开始时间
	 */
	private Date startDateMin;
	
	/**
	 * 结束时间
	 */
	private Date startDateMax;
	
	/**
	 * 职业名称
	 */
	private String jobName;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getStartDateMin() {
		return startDateMin;
	}

	public void setStartDateMin(Date startDateMin) {
		this.startDateMin = startDateMin;
	}

	public Date getStartDateMax() {
		return startDateMax;
	}

	public void setStartDateMax(Date startDateMax) {
		this.startDateMax = startDateMax;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
}
