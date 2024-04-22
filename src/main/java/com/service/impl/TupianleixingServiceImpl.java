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


import com.dao.TupianleixingDao;
import com.entity.TupianleixingEntity;
import com.service.TupianleixingService;
import com.entity.vo.TupianleixingVO;
import com.entity.view.TupianleixingView;

@Service("tupianleixingService")
public class TupianleixingServiceImpl extends ServiceImpl<TupianleixingDao, TupianleixingEntity> implements TupianleixingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<TupianleixingEntity> page = this.selectPage(
                new Query<TupianleixingEntity>(params).getPage(),
                new EntityWrapper<TupianleixingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<TupianleixingEntity> wrapper) {
		  Page<TupianleixingView> page =new Query<TupianleixingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<TupianleixingVO> selectListVO(Wrapper<TupianleixingEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public TupianleixingVO selectVO(Wrapper<TupianleixingEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<TupianleixingView> selectListView(Wrapper<TupianleixingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public TupianleixingView selectView(Wrapper<TupianleixingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
