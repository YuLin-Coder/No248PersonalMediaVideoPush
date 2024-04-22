package com.entity.view;

import com.entity.DiscusswenzhangxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 文章信息评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-05-05 09:37:48
 */
@TableName("discusswenzhangxinxi")
public class DiscusswenzhangxinxiView  extends DiscusswenzhangxinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscusswenzhangxinxiView(){
	}
 
 	public DiscusswenzhangxinxiView(DiscusswenzhangxinxiEntity discusswenzhangxinxiEntity){
 	try {
			BeanUtils.copyProperties(this, discusswenzhangxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
