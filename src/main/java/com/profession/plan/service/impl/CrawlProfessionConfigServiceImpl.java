/**
 * @Title: CrawlProfessionConfigServiceImpl.java
 * @Package com.profession.plan.service.impl
 * @Description: TODO
 * @author 熊正胜
 * @date 2019年3月24日
 * @version V1.0
 */
package com.profession.plan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.profession.plan.entity.CrawlProfessionConfig;
import com.profession.plan.mapper.CrawlProfessionConfigMapper;
import com.profession.plan.service.CrawlProfessionConfigService;
import com.profession.plan.vo.request.crawlConfig.ListRequestParamVo;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

/**
 * @ClassName: CrawlProfessionConfigServiceImpl
 * @Description: TODO
 * @author 熊正胜
 * @date 2019年3月24日
 *
 */
@Service
public class CrawlProfessionConfigServiceImpl implements CrawlProfessionConfigService {

	@Autowired
	private CrawlProfessionConfigMapper crawlProfessionConfigMapper;
	
	/**
	 * @Title: listCrawlProfessionConfigs
	 * @Description: 查询爬取职业列表
	 * @param requestParamVo 爬虫状态
	 * @return PageInfo<CrawlProfessionConfig> 返回类型
	 * @throws
	 */
	@Override
	public PageInfo<CrawlProfessionConfig> listCrawlProfessionConfigs(ListRequestParamVo requestParamVo) {
		Example example = new Example(CrawlProfessionConfig.class);
		Criteria criteria = example.createCriteria();
		
		PageHelper.startPage(requestParamVo.getPageNo(), requestParamVo.getPageSize());
		List<CrawlProfessionConfig> crawlProfessionConfigs = crawlProfessionConfigMapper.selectByExample(example);
		PageInfo<CrawlProfessionConfig> pageInfo = new PageInfo<CrawlProfessionConfig>(crawlProfessionConfigs);
		return pageInfo;
	}

}
