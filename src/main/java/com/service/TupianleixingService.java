package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.TupianleixingEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.TupianleixingVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.TupianleixingView;


/**
 * 图片类型
 *
 * @author 
 * @email 
 * @date 2022-05-05 09:37:48
 */
public interface TupianleixingService extends IService<TupianleixingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<TupianleixingVO> selectListVO(Wrapper<TupianleixingEntity> wrapper);
   	
   	TupianleixingVO selectVO(@Param("ew") Wrapper<TupianleixingEntity> wrapper);
   	
   	List<TupianleixingView> selectListView(Wrapper<TupianleixingEntity> wrapper);
   	
   	TupianleixingView selectView(@Param("ew") Wrapper<TupianleixingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<TupianleixingEntity> wrapper);
   	

}

