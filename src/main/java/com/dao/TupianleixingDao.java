package com.dao;

import com.entity.TupianleixingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.TupianleixingVO;
import com.entity.view.TupianleixingView;


/**
 * 图片类型
 * 
 * @author 
 * @email 
 * @date 2022-05-05 09:37:48
 */
public interface TupianleixingDao extends BaseMapper<TupianleixingEntity> {
	
	List<TupianleixingVO> selectListVO(@Param("ew") Wrapper<TupianleixingEntity> wrapper);
	
	TupianleixingVO selectVO(@Param("ew") Wrapper<TupianleixingEntity> wrapper);
	
	List<TupianleixingView> selectListView(@Param("ew") Wrapper<TupianleixingEntity> wrapper);

	List<TupianleixingView> selectListView(Pagination page,@Param("ew") Wrapper<TupianleixingEntity> wrapper);
	
	TupianleixingView selectView(@Param("ew") Wrapper<TupianleixingEntity> wrapper);
	

}
