/**
 * @Title: WorkServiceImpl.java
 * @Package com.profession.plan.service.impl
 * @Description: TODO
 * @author 熊正胜
 * @date 2019年4月8日
 * @version V1.0
 */
package com.profession.plan.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.profession.plan.constant.WorkStatusConstant;
import com.profession.plan.entity.Area;
import com.profession.plan.entity.Work;
import com.profession.plan.mapper.WorkMapper;
import com.profession.plan.service.AreaService;
import com.profession.plan.service.WorkService;
import com.profession.plan.util.DateUtil;
import com.profession.plan.vo.request.work.QueryListParam;
import com.profession.plan.vo.response.work.ListWorkResponseVo;

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
	
	@Autowired
	private AreaService areaService;
	
	/**
	 * @Title: listWorkers
	 * @Description: 查询职业列表
	 * @param param 查询参数
	 * @param @return 参数
	 * @return PageInfo<ListWorkResponseVo> 返回类型
	 * @throws
	 */
	@Override
	public PageInfo<ListWorkResponseVo> listWorkers(QueryListParam param) {
		Example example = new Example(Work.class);
		Criteria criteria = example.createCriteria();
		if(param.getStatus() != null) {
			criteria.andEqualTo("status", param.getStatus());
		}
		if(StringUtils.isNotBlank(param.getJobName())){
			criteria.andLike("jobName", "%" + param.getJobName() + "%");
		}
		if(param.getStartDateMin() != null){
			criteria.andGreaterThan("createTime", param.getStartDateMin());
		}
		if(param.getStartDateMax() != null){
			criteria.andGreaterThan("createTime", param.getStartDateMax());
		}
		PageHelper.startPage(param.getPageNo(), param.getPageSize());
		List<Work> works = workMapper.selectByExample(example);
		PageInfo<Work> pageInfo = new PageInfo<Work>(works);
		if(pageInfo == null || CollectionUtils.isEmpty(pageInfo.getList())) {
			return null;
		}
		List<ListWorkResponseVo> responseVos = new ArrayList<>();
		ListWorkResponseVo responseVo = null;
		Map<Integer, String> map = WorkStatusConstant.getStatusMsg();
		for (Work work : pageInfo.getList()) {
			responseVo = new ListWorkResponseVo();
			BeanUtils.copyProperties(work, responseVo);
			//
			Area cityArea = areaService.getArea(work.getCityId());
			if(cityArea != null) {
				responseVo.setCityName(cityArea.getName());
			}
			Area regionArea = areaService.getArea(work.getRegionId());
			if(regionArea != null) {
				responseVo.setRegionName(regionArea.getName());
			}
			responseVo.setStatusMsg(map.get(work.getStatus()));
			responseVo.setUpdateTime(DateUtil.convertDateToString(work.getUpdateTime()));
			responseVos.add(responseVo);
		}
		PageInfo<ListWorkResponseVo> resultPageInfo = new PageInfo<ListWorkResponseVo>();
		resultPageInfo.setTotal(pageInfo.getTotal());
		resultPageInfo.setPageNum(pageInfo.getPageNum());
		resultPageInfo.setPages(pageInfo.getPages());
		resultPageInfo.setList(responseVos);
		return resultPageInfo;
	}

}
