package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscusstupianxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscusstupianxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscusstupianxinxiView;


/**
 * 图片信息评论表
 *
 * @author 
 * @email 
 * @date 2022-05-05 09:37:48
 */
public interface DiscusstupianxinxiService extends IService<DiscusstupianxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscusstupianxinxiVO> selectListVO(Wrapper<DiscusstupianxinxiEntity> wrapper);
   	
   	DiscusstupianxinxiVO selectVO(@Param("ew") Wrapper<DiscusstupianxinxiEntity> wrapper);
   	
   	List<DiscusstupianxinxiView> selectListView(Wrapper<DiscusstupianxinxiEntity> wrapper);
   	
   	DiscusstupianxinxiView selectView(@Param("ew") Wrapper<DiscusstupianxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscusstupianxinxiEntity> wrapper);
   	

}

