/**
 * @Title: AreaService.java
 * @Package com.profession.plan.service
 * @Description: 区域业务接口
 * @author 熊正胜
 * @date 2019年4月5日
 * @version V1.0
 */
package com.profession.plan.service;

import com.profession.plan.entity.Area;

/**
 * @ClassName: AreaService
 * @Description: 区域业务接口
 * @author 熊正胜
 * @date 2019年4月5日
 *
 */
public interface AreaService {
	
	/**
	 * @Title: getArea
	 * @Description: 获取区域对象
	 * @param areaId 区域id
	 * @param @return 参数
	 * @return Area 返回类型
	 * @throws
	 */
	public Area getArea(Long areaId);
}
