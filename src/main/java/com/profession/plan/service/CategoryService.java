/**
 * @Title: CategoryService.java
 * @Package com.profession.plan.service
 * @Description: 职业业务接口
 * @author 袁永国
 * @date 2019年5月30日
 * @version V1.0
 */
package com.profession.plan.service;

import java.util.List;

import com.profession.plan.entity.Category;

/**
 * @ClassName: CategoryService
 * @Description: 职业分类接口
 * @author 袁永国
 * @date 2019年5月30日
 *
 */
public interface CategoryService {
	
	/**
	 * @Title: getCategory
	 * @Description: 获取职业分类对象
	 * @param categoryId 职业分类id
	 * @param @return 参数
	 * @return Category 返回类型
	 * @throws
	 */
	public Category getCategory(Long categoryId);
	
	/**
	 * @Title: listCategory
	 * @Description: 获取职业分类列表
	 * @param 
	 * @param @return 参数
	 * @return List<Category> 返回类型
	 * @throws
	 */
	public List<Category> listCategory();
}
