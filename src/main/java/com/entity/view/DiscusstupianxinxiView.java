package com.entity.view;

import com.entity.DiscusstupianxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 图片信息评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-05-05 09:37:48
 */
@TableName("discusstupianxinxi")
public class DiscusstupianxinxiView  extends DiscusstupianxinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscusstupianxinxiView(){
	}
 
 	public DiscusstupianxinxiView(DiscusstupianxinxiEntity discusstupianxinxiEntity){
 	try {
			BeanUtils.copyProperties(this, discusstupianxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
