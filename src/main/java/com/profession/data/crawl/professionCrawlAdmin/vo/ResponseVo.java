/**
 * @Title: Response.java
 * @Package com.profession.data.crawl.professionCrawlAdmin.vo
 * @Description: TODO
 * @author 熊正胜
 * @date 2019年3月24日
 * @version V1.0
 */
package com.profession.data.crawl.professionCrawlAdmin.vo;

import com.profession.data.crawl.professionCrawlAdmin.constant.HttpStatusConstant;

/**
 * @ClassName: Response
 * @Description: TODO
 * @author 熊正胜
 * @date 2019年3月24日
 *
 */
public class ResponseVo<T> {

	/**
	 * 返回状态位
	 */
	private Integer status;
	
	/**
	 * 错误消息
	 */
	private String errMsg;
	
	/**
	 * 返回内容体
	 */
	private T data;
	
	/**
	 * @Title: ofSuccess
	 * @Description: 成功返回
	 * @param data 返回内容
	 * @param @return 参数
	 * @return ResponseVo<T> 返回类型
	 * @throws
	 */
	public static <T> ResponseVo<T> ofSuccess(T data) {
		ResponseVo<T> responseVo = new ResponseVo<>();
		responseVo.setData(data);
		responseVo.setStatus(HttpStatusConstant.success.getStatus());
		return responseVo;
	}
	
	/**
	 * @Title: ofFailure
	 * @Description: 错误返回
	 * @param msg 错误消息
	 * @param @return 参数
	 * @return ResponseVo<T> 返回类型
	 * @throws
	 */
	public static <T> ResponseVo<T> ofFailure(String msg) {
		ResponseVo<T> responseVo = new ResponseVo<>();
		responseVo.setStatus(HttpStatusConstant.fialure.getStatus());
		responseVo.setErrMsg(msg);
		return responseVo;
	}
	
	/**
	 * @Title: ofFailure
	 * @Description: 错误返回
	 * @param status 状态码
	 * @param msg 错误消息
	 * @param @return 参数
	 * @return ResponseVo<T> 返回类型
	 * @throws
	 */
	public static <T> ResponseVo<T> ofFailure(Integer status, String msg) {
		ResponseVo<T> responseVo = new ResponseVo<>();
		responseVo.setStatus(status);
		responseVo.setErrMsg(msg);
		return responseVo;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
