/**
 * @Title: WorkServiceImpl.java
 * @Package com.profession.data.crawl.professionCrawlAdmin.service.impl
 * @Description: TODO
 * @author 熊正胜
 * @date 2019年4月8日
 * @version V1.0
 */
package com.profession.data.crawl.professionCrawlAdmin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.profession.data.crawl.professionCrawlAdmin.entity.Work;
import com.profession.data.crawl.professionCrawlAdmin.mapper.WorkMapper;
import com.profession.data.crawl.professionCrawlAdmin.service.WorkService;
import com.profession.data.crawl.professionCrawlAdmin.vo.request.work.QueryListParam;
import com.profession.data.crawl.professionCrawlAdmin.vo.response.work.ListWorkResponseVo;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

/**
 * @ClassName: WorkServiceImpl
 * @Description: 职业业务接口实现类
 * @author 熊正胜
 * @date 2019年4月8日
 *
 */
@Service
public class WorkServiceImpl implements WorkService {

	@Autowired
	private WorkMapper workMapper;
	
	/**
	 * @Title: listWorkers
	 * @Description: 查询职业列表
	 * @param param 查询参数
	 * @param @return 参数
	 * @return List<ListWorkResponseVo> 返回类型
	 * @throws
	 */
	@Override
	public List<ListWorkResponseVo> listWorkers(QueryListParam param) {
		Example example = new Example(Work.class);
		Criteria criteria = example.createCriteria();
		List<Work> works = workMapper.selectByExample(example);
		
		return null;
	}

}
