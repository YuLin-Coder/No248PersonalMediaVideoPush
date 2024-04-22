package com.dao;

import com.entity.TupianxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.TupianxinxiVO;
import com.entity.view.TupianxinxiView;


/**
 * 图片信息
 * 
 * @author 
 * @email 
 * @date 2022-05-05 09:37:48
 */
public interface TupianxinxiDao extends BaseMapper<TupianxinxiEntity> {
	
	List<TupianxinxiVO> selectListVO(@Param("ew") Wrapper<TupianxinxiEntity> wrapper);
	
	TupianxinxiVO selectVO(@Param("ew") Wrapper<TupianxinxiEntity> wrapper);
	
	List<TupianxinxiView> selectListView(@Param("ew") Wrapper<TupianxinxiEntity> wrapper);

	List<TupianxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<TupianxinxiEntity> wrapper);
	
	TupianxinxiView selectView(@Param("ew") Wrapper<TupianxinxiEntity> wrapper);
	

}
