/**
 * 
 */
package com.life.service;

import java.util.List;

import com.life.po.Memo;

/** 
 * 	类描述：备忘录服务层接口
 * 	作者： LiuJinrong 
 * 	创建日期：2018年11月11日
 * 	修改人：
 * 	修改日期：
 * 	修改内容：
 * 	版本号： 1.0.0   
 */
public interface IMemoService {
	
	/**
	 * 
	 * 	方法描述：根据用户id查看备忘录
	 * 	@param users 备忘录实体类
	 * 	@return 根据用户id查看备忘录
	 */
	public List<Memo> selectMemo(Memo memo);
	
	/**
	 * 
	 * 	方法描述：添加备忘录
	 * 	@param memo 备忘录实体类
	 * 	@return 影响行数
	 */
	public int insertMemo(Memo memo);
	
	/**
	 * 
	 * 	方法描述：修改备忘录
	 * 	@param memo 备忘录实体类
	 * 	@param mid 备忘录id
	 * 	@return 影响行数
	 */
	public int updateMemo(Memo memo, int mid);
	
	/**
	 * 
	 * 	方法描述：删除备忘录
	 * 	@param mid 备忘录id
	 * 	@return 影响行数
	 */
	public int delete(int mid);

}
