/**
 * @Title: WorkResource.java
 * @Package com.profession.plan.resource
 * @Description: 职业接口
 * @author 熊正胜
 * @date 2019年4月7日
 * @version V1.0
 */
package com.profession.plan.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.profession.plan.service.WorkService;
import com.profession.plan.vo.ResponseVo;
import com.profession.plan.vo.request.work.QueryListParam;
import com.profession.plan.vo.response.work.ListWorkResponseVo;

/**
 * @ClassName: WorkResource
 * @Description: 职业接口
 * @author 熊正胜
 * @date 2019年4月7日
 *
 */
@RestController
@RequestMapping("/worker")
public class WorkResource {

	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private WorkService workService;
	
	/**
	 * 
	 * @Title: listWorks
	 * @Description: 查询职业列表
	 * @param param
	 * @param @return 参数
	 * @return ResponseVo<?> 返回类型
	 * @throws
	 */
	@PostMapping("/list")
	public ResponseVo<?> listWorks(@RequestBody QueryListParam param){
		PageInfo<ListWorkResponseVo> pageInfo = null;
		try {
			pageInfo = workService.listWorkers(param);
		} catch (Exception e) {
			logger.error("查询职业列表异常!", e);
			return ResponseVo.ofFailure("查询职业列表异常,请联系管理员!");
		}
		return ResponseVo.ofSuccess(pageInfo);
	}
}
