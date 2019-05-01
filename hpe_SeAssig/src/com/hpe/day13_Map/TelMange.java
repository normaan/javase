package com.hpe.day13_Map;

import java.util.HashMap;
import java.util.Map;

/*业务层（控制层C）：主要实现电话本的增、删、改、查*/
public class TelMange {
	Map<String,PeopleInfo> peopleInfos; // 主要用来存放好友信息
	int count = 0; // 主要记录当前电话本中联系人的个数
	
	// 构造方法
	public TelMange() {
		peopleInfos = new HashMap<String,PeopleInfo>(); // 默认只能存储50个联系人
	}
	
	/* function:电话话本的增加
	 	return:0 添加成功
				-1：联系人存在
	*/
	public int myAdd(PeopleInfo pi) {
		// 查询当前电话本中该联系人是否已存在
		PeopleInfo p = mySelect(pi.getName());
		// 如果不存在，则添加
		if (p == null) {
			peopleInfos.put(pi.getName(), pi);
			count++;
			return 0;
		}
		return -1;
	}

	// 电话话本的删除
	public boolean myDel(String name) {
		// 首先找到要删除的联系人
		PeopleInfo p = mySelect(name);
		if (p == null) {
			return false;
		}
		// 删除该联系人，并将其后面的所有联系人前提一位
		peopleInfos.remove(name);
		return true;
	}

	// 电话话本的修改
	public boolean myUpdate(PeopleInfo pi) {
		//根据姓名先找到该联系人
		PeopleInfo p = mySelect(pi.getName());
		if (p == null) {
			return false;
		}
		//如果找到，则直接赋值
		//Map指向引用变量指向新的变量
		p = pi;
		return true;
	}

	// 电话话本的查询
	public PeopleInfo mySelect(String name) {
		//根据名字查找联系人
		PeopleInfo pi = peopleInfos.get(name);
		//如果存在则直接返回，否则返回null
		return pi;
	}
}
