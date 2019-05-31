/**
 * @Title: CategoryResource.java
 * @Package com.profession.plan.resource
 * @Description: 职业分类接口
 * @author 袁永国
 * @date 2019年5月31日
 * @version V1.0
 */
package com.profession.plan.resource;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.profession.plan.entity.Category;
import com.profession.plan.service.CategoryService;
import com.profession.plan.vo.ResponseVo;

/**
 * @ClassName: CategoryResource
 * @Description: 职业分类接口
 * @author 袁永国
 * @date 2019年5月31日
 *
 */
@RestController
@RequestMapping("/categoryResource")
public class CategoryResource {

	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private CategoryService categoryService;
	
	/**
	 * 
	 * @Title: listCategory
	 * @Description: 查询职业分类列表
	 * @param param
	 * @param @return 参数
	 * @return ResponseVo<?> 返回类型
	 * @throws
	 */
	@PostMapping("/list")
	@ResponseBody
	public ResponseVo<?> listCategory(){
		List<Category> categoryList = null;
		try {
			categoryList = categoryService.listCategory();
		} catch (Exception e) {
			logger.error("查询职业分类列表异常!", e);
			return ResponseVo.ofFailure("查询职业分类列表异常,请联系管理员!");
		}
		return ResponseVo.ofSuccess(categoryList);
	}
}
