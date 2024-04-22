package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 图片信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2022-05-05 09:37:48
 */
@TableName("tupianxinxi")
public class TupianxinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public TupianxinxiEntity() {
		
	}
	
	public TupianxinxiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 图片名称
	 */
					
	private String tupianmingcheng;
	
	/**
	 * 图片类型
	 */
					
	private String tupianleixing;
	
	/**
	 * 图片封面
	 */
					
	private String tupianfengmian;
	
	/**
	 * 图片简介
	 */
					
	private String tupianjianjie;
	
	/**
	 * 图片详情
	 */
					
	private String tupianxiangqing;
	
	/**
	 * 用户名
	 */
					
	private String yonghuming;
	
	/**
	 * 发布时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date fabushijian;
	
	/**
	 * 是否审核
	 */
					
	private String sfsh;
	
	/**
	 * 审核回复
	 */
					
	private String shhf;
	
	/**
	 * 最近点击时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date clicktime;
	
	/**
	 * 点击次数
	 */
					
	private Integer clicknum;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：图片名称
	 */
	public void setTupianmingcheng(String tupianmingcheng) {
		this.tupianmingcheng = tupianmingcheng;
	}
	/**
	 * 获取：图片名称
	 */
	public String getTupianmingcheng() {
		return tupianmingcheng;
	}
	/**
	 * 设置：图片类型
	 */
	public void setTupianleixing(String tupianleixing) {
		this.tupianleixing = tupianleixing;
	}
	/**
	 * 获取：图片类型
	 */
	public String getTupianleixing() {
		return tupianleixing;
	}
	/**
	 * 设置：图片封面
	 */
	public void setTupianfengmian(String tupianfengmian) {
		this.tupianfengmian = tupianfengmian;
	}
	/**
	 * 获取：图片封面
	 */
	public String getTupianfengmian() {
		return tupianfengmian;
	}
	/**
	 * 设置：图片简介
	 */
	public void setTupianjianjie(String tupianjianjie) {
		this.tupianjianjie = tupianjianjie;
	}
	/**
	 * 获取：图片简介
	 */
	public String getTupianjianjie() {
		return tupianjianjie;
	}
	/**
	 * 设置：图片详情
	 */
	public void setTupianxiangqing(String tupianxiangqing) {
		this.tupianxiangqing = tupianxiangqing;
	}
	/**
	 * 获取：图片详情
	 */
	public String getTupianxiangqing() {
		return tupianxiangqing;
	}
	/**
	 * 设置：用户名
	 */
	public void setYonghuming(String yonghuming) {
		this.yonghuming = yonghuming;
	}
	/**
	 * 获取：用户名
	 */
	public String getYonghuming() {
		return yonghuming;
	}
	/**
	 * 设置：发布时间
	 */
	public void setFabushijian(Date fabushijian) {
		this.fabushijian = fabushijian;
	}
	/**
	 * 获取：发布时间
	 */
	public Date getFabushijian() {
		return fabushijian;
	}
	/**
	 * 设置：是否审核
	 */
	public void setSfsh(String sfsh) {
		this.sfsh = sfsh;
	}
	/**
	 * 获取：是否审核
	 */
	public String getSfsh() {
		return sfsh;
	}
	/**
	 * 设置：审核回复
	 */
	public void setShhf(String shhf) {
		this.shhf = shhf;
	}
	/**
	 * 获取：审核回复
	 */
	public String getShhf() {
		return shhf;
	}
	/**
	 * 设置：最近点击时间
	 */
	public void setClicktime(Date clicktime) {
		this.clicktime = clicktime;
	}
	/**
	 * 获取：最近点击时间
	 */
	public Date getClicktime() {
		return clicktime;
	}
	/**
	 * 设置：点击次数
	 */
	public void setClicknum(Integer clicknum) {
		this.clicknum = clicknum;
	}
	/**
	 * 获取：点击次数
	 */
	public Integer getClicknum() {
		return clicknum;
	}

}
