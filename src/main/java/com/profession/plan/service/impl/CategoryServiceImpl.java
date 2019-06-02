/**
 * @Title: CategoryServiceImpl.java
 * @Package com.profession.plan.service.impl
 * @Description: 职业分类接口实现
 * @author 袁永国
 * @date 2019年5月30日
 * @version V1.0
 */
package com.profession.plan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.profession.plan.entity.Category;
import com.profession.plan.mapper.CategoryMapper;
import com.profession.plan.service.CategoryService;

/**
 * @ClassName: CategoryServiceImpl
 * @Description: 区域业务接口实现
 * @author 袁永国
 * @date 2019年5月30日
 *
 */
@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryMapper categoryMapper;
	
	/**
	 * @Title: getCategory
	 * @Description: 职业分类对象
	 * @param categoryId 职业分类id
	 * @param @return 参数
	 * @return Category 返回类型
	 * @throws
	 */
	@Override
	public Category getCategory(Long categoryId) {
		Category category = categoryMapper.selectByPrimaryKey(categoryId);
		return category;
	}

	/**
	 * @Title: listCategory
	 * @Description: 获取职业分类列表
	 * @param 
	 * @param @return 参数
	 * @return List<Category> 返回类型
	 * @throws
	 */
	@Override
	public List<Category> listCategory() {
		// TODO Auto-generated method stub
		return categoryMapper.selectAll();
	}

}
