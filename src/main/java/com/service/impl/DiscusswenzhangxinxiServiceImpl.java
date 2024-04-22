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


import com.dao.DiscusswenzhangxinxiDao;
import com.entity.DiscusswenzhangxinxiEntity;
import com.service.DiscusswenzhangxinxiService;
import com.entity.vo.DiscusswenzhangxinxiVO;
import com.entity.view.DiscusswenzhangxinxiView;

@Service("discusswenzhangxinxiService")
public class DiscusswenzhangxinxiServiceImpl extends ServiceImpl<DiscusswenzhangxinxiDao, DiscusswenzhangxinxiEntity> implements DiscusswenzhangxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscusswenzhangxinxiEntity> page = this.selectPage(
                new Query<DiscusswenzhangxinxiEntity>(params).getPage(),
                new EntityWrapper<DiscusswenzhangxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscusswenzhangxinxiEntity> wrapper) {
		  Page<DiscusswenzhangxinxiView> page =new Query<DiscusswenzhangxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscusswenzhangxinxiVO> selectListVO(Wrapper<DiscusswenzhangxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscusswenzhangxinxiVO selectVO(Wrapper<DiscusswenzhangxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscusswenzhangxinxiView> selectListView(Wrapper<DiscusswenzhangxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscusswenzhangxinxiView selectView(Wrapper<DiscusswenzhangxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
