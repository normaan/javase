package com.hpe.day13_IO_ArrayList;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/*业务层（控制层C）：主要实现电话本的增、删、改、查*/
public class TelMange {
	ArrayList<PeopleInfo> peopleInfos; // 主要用来存放好友信息
	int count = 0; // 主要记录当前电话本中联系人的个数
	// 构造方法

	public TelMange() {
		// 如果tel.tmp文件存在，则加载
		File file = new File("tel.tep");
		if (file.exists()) {
			myLoad();
		} else {
			// 否则，重新创建
			peopleInfos = new ArrayList<PeopleInfo>(); 
		}
	}

	/* function:电话话本的增加
	 	return:0 添加成功
				-1：联系人存在
	*/
	public int myAdd(PeopleInfo pi) {
		// 查询当前电话本中该联系人是否已存在
		if(mySelect(pi.getName())!=null){
			return -1;
		}
		// 如果不存在，则添加
		peopleInfos.add(pi);
		count++;
		return 0;
	}

	// 电话话本的删除
	public boolean myDel(String name) {
		// 首先找到要删除的联系人
		int i;	//保存要删除人的索引
		for(i=0;i<count;i++){
			if(name.equals(peopleInfos.get(i).getName())){
				break;
			}
		}
		// 如果没找到
		if(i>=count){
			System.out.println("您删除的联系人不存在");
			return false;
		}
		// 删除该联系人，并将其后面的所有联系人前提一位
		peopleInfos.remove(i);
		count--;
		
		return true;
	}

	// 电话话本的修改
	public boolean myUpdate(PeopleInfo pi) {
		//根据姓名先找到该联系人
		String name = pi.getName();
		int i;	//保存要删除人的索引
		for(i=0;i<count;i++){
			if(name.equals(peopleInfos.get(i).getName())){
				break;
			}
		}
		// 如果没找到
		if(i>=count){
			System.out.println("您修改的联系人不存在");
			return false;
		}
		//如果找到，则直接赋值
		peopleInfos.set(i, pi);
		
		return true;
	}

	// 电话话本的查询
	public PeopleInfo mySelect(String name) {
		//根据名字查找联系人
		int i;	//保存要删除人的索引
		for(i=0;i<count;i++){
			if(name.equals(peopleInfos.get(i).getName())){
				return peopleInfos.get(i);
			}
		}
		//如果存在则直接返回，否则返回null
		System.out.println("您所查询的联系人不存在！");
		return null;
	}
	
	// 将电话本信息存储到本地：序列化
	public void mySave() {
		try {
			FileOutputStream fos = new FileOutputStream("tel.tmp");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(peopleInfos);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// 从文件中读取联系人信息：反序列化
	public void myLoad() {
		try {
			FileInputStream fis = new FileInputStream("tel.tmp");
			ObjectInputStream ois = new ObjectInputStream(fis);
			peopleInfos = (ArrayList<PeopleInfo>)ois.readObject();
			ois.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}