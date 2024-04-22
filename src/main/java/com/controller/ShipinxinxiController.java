package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.ShipinxinxiEntity;
import com.entity.view.ShipinxinxiView;

import com.service.ShipinxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 视频信息
 * 后端接口
 * @author 
 * @email 
 * @date 2022-05-05 09:37:48
 */
@RestController
@RequestMapping("/shipinxinxi")
public class ShipinxinxiController {
    @Autowired
    private ShipinxinxiService shipinxinxiService;

    @Autowired
    private StoreupService storeupService;

    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShipinxinxiEntity shipinxinxi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			shipinxinxi.setYonghuming((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ShipinxinxiEntity> ew = new EntityWrapper<ShipinxinxiEntity>();
		PageUtils page = shipinxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shipinxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ShipinxinxiEntity shipinxinxi, 
		HttpServletRequest request){
        EntityWrapper<ShipinxinxiEntity> ew = new EntityWrapper<ShipinxinxiEntity>();
		PageUtils page = shipinxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shipinxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShipinxinxiEntity shipinxinxi){
       	EntityWrapper<ShipinxinxiEntity> ew = new EntityWrapper<ShipinxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shipinxinxi, "shipinxinxi")); 
        return R.ok().put("data", shipinxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShipinxinxiEntity shipinxinxi){
        EntityWrapper< ShipinxinxiEntity> ew = new EntityWrapper< ShipinxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shipinxinxi, "shipinxinxi")); 
		ShipinxinxiView shipinxinxiView =  shipinxinxiService.selectView(ew);
		return R.ok("查询视频信息成功").put("data", shipinxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShipinxinxiEntity shipinxinxi = shipinxinxiService.selectById(id);
		shipinxinxi.setClicknum(shipinxinxi.getClicknum()+1);
		shipinxinxi.setClicktime(new Date());
		shipinxinxiService.updateById(shipinxinxi);
        return R.ok().put("data", shipinxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShipinxinxiEntity shipinxinxi = shipinxinxiService.selectById(id);
		shipinxinxi.setClicknum(shipinxinxi.getClicknum()+1);
		shipinxinxi.setClicktime(new Date());
		shipinxinxiService.updateById(shipinxinxi);
        return R.ok().put("data", shipinxinxi);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R vote(@PathVariable("id") String id,String type){
        ShipinxinxiEntity shipinxinxi = shipinxinxiService.selectById(id);
        if(type.equals("1")) {
        	shipinxinxi.setThumbsupnum(shipinxinxi.getThumbsupnum()+1);
        } else {
        	shipinxinxi.setCrazilynum(shipinxinxi.getCrazilynum()+1);
        }
        shipinxinxiService.updateById(shipinxinxi);
        return R.ok("投票成功");
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ShipinxinxiEntity shipinxinxi, HttpServletRequest request){
    	shipinxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shipinxinxi);
        shipinxinxiService.insert(shipinxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ShipinxinxiEntity shipinxinxi, HttpServletRequest request){
    	shipinxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shipinxinxi);
        shipinxinxiService.insert(shipinxinxi);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ShipinxinxiEntity shipinxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shipinxinxi);
        shipinxinxiService.updateById(shipinxinxi);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        shipinxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<ShipinxinxiEntity> wrapper = new EntityWrapper<ShipinxinxiEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			wrapper.eq("yonghuming", (String)request.getSession().getAttribute("username"));
		}

		int count = shipinxinxiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,ShipinxinxiEntity shipinxinxi, HttpServletRequest request,String pre){
        EntityWrapper<ShipinxinxiEntity> ew = new EntityWrapper<ShipinxinxiEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicknum");
        params.put("order", "desc");
		PageUtils page = shipinxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shipinxinxi), params), params));
        return R.ok().put("data", page);
    }







}
