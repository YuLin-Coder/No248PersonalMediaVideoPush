package com.dao;

import com.entity.WenzhangxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.WenzhangxinxiVO;
import com.entity.view.WenzhangxinxiView;


/**
 * 文章信息
 * 
 * @author 
 * @email 
 * @date 2022-05-05 09:37:48
 */
public interface WenzhangxinxiDao extends BaseMapper<WenzhangxinxiEntity> {
	
	List<WenzhangxinxiVO> selectListVO(@Param("ew") Wrapper<WenzhangxinxiEntity> wrapper);
	
	WenzhangxinxiVO selectVO(@Param("ew") Wrapper<WenzhangxinxiEntity> wrapper);
	
	List<WenzhangxinxiView> selectListView(@Param("ew") Wrapper<WenzhangxinxiEntity> wrapper);

	List<WenzhangxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<WenzhangxinxiEntity> wrapper);
	
	WenzhangxinxiView selectView(@Param("ew") Wrapper<WenzhangxinxiEntity> wrapper);
	

}
