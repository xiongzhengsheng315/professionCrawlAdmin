/**
 * @Title: WorkStatusConstant.java
 * @Package com.profession.plan.constant
 * @Description: 职业审核状态枚举
 * @author 熊正胜
 * @date 2019年4月15日
 * @version V1.0
 */
package com.profession.plan.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: WorkStatusConstant
 * @Description: 职业审核状态枚举
 * @author 熊正胜
 * @date 2019年4月15日
 *
 */
public enum WorkStatusConstant {
	AUDIT(0, "待审核"),
	AUDIT_SUCCESS(1, "已审核"),
	AUDIT_FAILURE(2, "审核失败");
	
	private WorkStatusConstant(Integer status, String msg) {
		this.status = status;
		this.msg = msg;
	}

	private Integer status;
	
	private String msg;

	public Integer getStatus() {
		return status;
	}

	public String getMsg() {
		return msg;
	}
	
	/**
	 * 
	 * @Title: getStatusMsg
	 * @Description: 获取审核状态
	 * @param @return 参数
	 * @return Map<Integer,String> 返回类型
	 * @throws
	 */
	public static Map<Integer, String> getStatusMsg() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		for (WorkStatusConstant status : WorkStatusConstant.values()) {
			map.put(status.getStatus(), status.getMsg());
		}
		return map;
	}
}
