/**
 * @Title: RequestParamVo.java
 * @Package com.profession.plan.vo
 * @Description: 请求参数
 * @author 熊正胜
 * @date 2019年3月24日
 * @version V1.0
 */
package com.profession.plan.vo;

import java.io.Serializable;

/**
 * @ClassName: RequestParamVo
 * @Description: 请求参数
 * @author 熊正胜
 * @date 2019年3月24日
 *
 */
public class RequestParamVo implements Serializable {

	/**
	 * @Fields field:field:{todo}
	 */
	private static final long serialVersionUID = 6266552953674669050L;

	/**
	 * 每页显示条数
	 */
	private Integer pageSize;
	
	/**
	 * 页码
	 */
	private Integer pageNo;

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
}
