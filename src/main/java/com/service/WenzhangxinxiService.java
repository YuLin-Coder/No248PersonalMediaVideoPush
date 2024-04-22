package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.WenzhangxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.WenzhangxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.WenzhangxinxiView;


/**
 * 文章信息
 *
 * @author 
 * @email 
 * @date 2022-05-05 09:37:48
 */
public interface WenzhangxinxiService extends IService<WenzhangxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<WenzhangxinxiVO> selectListVO(Wrapper<WenzhangxinxiEntity> wrapper);
   	
   	WenzhangxinxiVO selectVO(@Param("ew") Wrapper<WenzhangxinxiEntity> wrapper);
   	
   	List<WenzhangxinxiView> selectListView(Wrapper<WenzhangxinxiEntity> wrapper);
   	
   	WenzhangxinxiView selectView(@Param("ew") Wrapper<WenzhangxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<WenzhangxinxiEntity> wrapper);
   	

}

