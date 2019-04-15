/**
 * @Title: HttpStatusConstant.java
 * @Package com.profession.data.crawl.professionCrawlAdmin.constant
 * @Description: TODO
 * @author 熊正胜
 * @date 2019年4月8日
 * @version V1.0
 */
package com.profession.data.crawl.professionCrawlAdmin.constant;

/**
 * @ClassName: HttpStatusConstant
 * @Description: TODO
 * @author 熊正胜
 * @date 2019年4月8日
 *
 */
public enum HttpStatusConstant {
	success(200, "成功"),
	fialure(500, "失败");
	
	private String msg;
	
	private Integer status;
	
	private HttpStatusConstant(Integer status, String msg) {
		this.msg = msg;
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}
