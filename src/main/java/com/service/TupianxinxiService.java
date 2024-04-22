package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.TupianxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.TupianxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.TupianxinxiView;


/**
 * 图片信息
 *
 * @author 
 * @email 
 * @date 2022-05-05 09:37:48
 */
public interface TupianxinxiService extends IService<TupianxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<TupianxinxiVO> selectListVO(Wrapper<TupianxinxiEntity> wrapper);
   	
   	TupianxinxiVO selectVO(@Param("ew") Wrapper<TupianxinxiEntity> wrapper);
   	
   	List<TupianxinxiView> selectListView(Wrapper<TupianxinxiEntity> wrapper);
   	
   	TupianxinxiView selectView(@Param("ew") Wrapper<TupianxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<TupianxinxiEntity> wrapper);
   	

}

