package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.DiscusstupianxinxiDao;
import com.entity.DiscusstupianxinxiEntity;
import com.service.DiscusstupianxinxiService;
import com.entity.vo.DiscusstupianxinxiVO;
import com.entity.view.DiscusstupianxinxiView;

@Service("discusstupianxinxiService")
public class DiscusstupianxinxiServiceImpl extends ServiceImpl<DiscusstupianxinxiDao, DiscusstupianxinxiEntity> implements DiscusstupianxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscusstupianxinxiEntity> page = this.selectPage(
                new Query<DiscusstupianxinxiEntity>(params).getPage(),
                new EntityWrapper<DiscusstupianxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscusstupianxinxiEntity> wrapper) {
		  Page<DiscusstupianxinxiView> page =new Query<DiscusstupianxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscusstupianxinxiVO> selectListVO(Wrapper<DiscusstupianxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscusstupianxinxiVO selectVO(Wrapper<DiscusstupianxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscusstupianxinxiView> selectListView(Wrapper<DiscusstupianxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscusstupianxinxiView selectView(Wrapper<DiscusstupianxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
