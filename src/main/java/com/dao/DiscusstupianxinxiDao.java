package com.dao;

import com.entity.DiscusstupianxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscusstupianxinxiVO;
import com.entity.view.DiscusstupianxinxiView;


/**
 * 图片信息评论表
 * 
 * @author 
 * @email 
 * @date 2022-05-05 09:37:48
 */
public interface DiscusstupianxinxiDao extends BaseMapper<DiscusstupianxinxiEntity> {
	
	List<DiscusstupianxinxiVO> selectListVO(@Param("ew") Wrapper<DiscusstupianxinxiEntity> wrapper);
	
	DiscusstupianxinxiVO selectVO(@Param("ew") Wrapper<DiscusstupianxinxiEntity> wrapper);
	
	List<DiscusstupianxinxiView> selectListView(@Param("ew") Wrapper<DiscusstupianxinxiEntity> wrapper);

	List<DiscusstupianxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscusstupianxinxiEntity> wrapper);
	
	DiscusstupianxinxiView selectView(@Param("ew") Wrapper<DiscusstupianxinxiEntity> wrapper);
	

}
