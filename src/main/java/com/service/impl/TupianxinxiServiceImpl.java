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


import com.dao.TupianxinxiDao;
import com.entity.TupianxinxiEntity;
import com.service.TupianxinxiService;
import com.entity.vo.TupianxinxiVO;
import com.entity.view.TupianxinxiView;

@Service("tupianxinxiService")
public class TupianxinxiServiceImpl extends ServiceImpl<TupianxinxiDao, TupianxinxiEntity> implements TupianxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<TupianxinxiEntity> page = this.selectPage(
                new Query<TupianxinxiEntity>(params).getPage(),
                new EntityWrapper<TupianxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<TupianxinxiEntity> wrapper) {
		  Page<TupianxinxiView> page =new Query<TupianxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<TupianxinxiVO> selectListVO(Wrapper<TupianxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public TupianxinxiVO selectVO(Wrapper<TupianxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<TupianxinxiView> selectListView(Wrapper<TupianxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public TupianxinxiView selectView(Wrapper<TupianxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
