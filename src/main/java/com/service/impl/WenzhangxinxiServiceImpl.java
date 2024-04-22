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


import com.dao.WenzhangxinxiDao;
import com.entity.WenzhangxinxiEntity;
import com.service.WenzhangxinxiService;
import com.entity.vo.WenzhangxinxiVO;
import com.entity.view.WenzhangxinxiView;

@Service("wenzhangxinxiService")
public class WenzhangxinxiServiceImpl extends ServiceImpl<WenzhangxinxiDao, WenzhangxinxiEntity> implements WenzhangxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<WenzhangxinxiEntity> page = this.selectPage(
                new Query<WenzhangxinxiEntity>(params).getPage(),
                new EntityWrapper<WenzhangxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<WenzhangxinxiEntity> wrapper) {
		  Page<WenzhangxinxiView> page =new Query<WenzhangxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<WenzhangxinxiVO> selectListVO(Wrapper<WenzhangxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public WenzhangxinxiVO selectVO(Wrapper<WenzhangxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<WenzhangxinxiView> selectListView(Wrapper<WenzhangxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public WenzhangxinxiView selectView(Wrapper<WenzhangxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
