package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.WenzhangleixingEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.WenzhangleixingVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.WenzhangleixingView;


/**
 * 文章类型
 *
 * @author 
 * @email 
 * @date 2022-05-05 09:37:47
 */
public interface WenzhangleixingService extends IService<WenzhangleixingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<WenzhangleixingVO> selectListVO(Wrapper<WenzhangleixingEntity> wrapper);
   	
   	WenzhangleixingVO selectVO(@Param("ew") Wrapper<WenzhangleixingEntity> wrapper);
   	
   	List<WenzhangleixingView> selectListView(Wrapper<WenzhangleixingEntity> wrapper);
   	
   	WenzhangleixingView selectView(@Param("ew") Wrapper<WenzhangleixingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<WenzhangleixingEntity> wrapper);
   	

}

