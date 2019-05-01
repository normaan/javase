package com.tz.LSM_iteration;
/*
 *  Map集合的嵌套，Map中存储的还是Map集合,要求:
 *	潭州教育 
 * 		java中级班
 *  		001 舍得
 *  		002 李四
 *  	java 高级班
 *  		001 梁辰
 *  		002 辰梁
 *  
 *	对以上数据进行对象的存储
 *  001 舍得     键值对
 *  java中级班：存储学号和姓名键值对
 *  
 *  java高级班:
 *  	潭州教育:存储的是班级
 *  	中级班Map集合<学号，姓名>
 *  	潭州教育mpa集合 <班级名字，中级班Map>
 */
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapNest {
	public static void main(String[] args) {
		//定义中级班集合
		HashMap<String,String> javaSE = new HashMap<String,String>();
		//定义高级版集合
		HashMap<String,String> javaEE = new HashMap<String,String>();
		//向班级集合中存储学生信息
		javaSE.put("01", "张三");
		javaSE.put("02", "李四");
		
		javaEE.put("01", "王五");
		javaEE.put("02", "刘六");
		//定义潭州教育集合容器，键是班级名字，值是两个班级容器
		HashMap<String,HashMap<String,String>> tze = new HashMap<String,HashMap<String,String>>();
		tze.put("中级班", javaSE);
		tze.put("高级班", javaEE);
		
		keySet(tze);
		entrySet(tze);
	}
	//Map集合keySet()遍历
	public static void keySet(HashMap<String,HashMap<String,String>> tze) {
		//调用tze集合方法keySet()将键存储到Set集合中
		Set<String> classNameSet = tze.keySet();
		//迭代Set集合
		Iterator<String> classNameIt = classNameSet.iterator();
		while (classNameIt.hasNext()) {
			//classNameIt.next()获取出来的是Set集合元素：tze集合的键
			String classNameKey = classNameIt.next();
			
			//核心：tze集合的get()方法获取值，值是一个HashMap集合
			HashMap<String,String> classMap = tze.get(classNameKey);
			//调用classMap集合方法keySet()，存储到Set集合
			Set<String> studentNum = classMap.keySet();
			//迭代Set集合
			Iterator<String> studentIt = studentNum.iterator();
			while (studentIt.hasNext()) {
				//studentIt.next()获取的是classMap的键:学号
				String numKey = studentIt.next();
				//调用classMap集合中的get()方法获取值
				String nameValue = classMap.get(numKey);
				System.out.println(classNameKey +"..."+ numKey +"..."+ nameValue);
			}
		}
	}
	//Map集合entrySet()遍历
	public static void entrySet(HashMap<String,HashMap<String,String>> tze) {
		System.out.println();
		//调用tze集合方法entrySet()将映射关系对象存储到Set集合中
		Set<Map.Entry<String, HashMap<String, String>>> classNameSet = tze.entrySet();
		//迭代Set对象
		Iterator<Map.Entry<String, HashMap<String, String>>> classNameIt = classNameSet.iterator();
		while (classNameIt.hasNext()) {
			//classNameIt.next()获取出来的是Set集合元素：tze集合的映射关系的对象
			Map.Entry<String, HashMap<String, String>> classNameEntry = classNameIt.next();
			
			//核心：tze集合的get()方法获取值，值是一个HashMap集合
			HashMap<String,String> classMap = classNameEntry.getValue();
			//调用classMap的entrySet()方法，将映射关系对象存储到Set集合
			Set<Map.Entry<String, String>> studentNum = classMap.entrySet();
			//迭代Set集合
			Iterator<Map.Entry<String, String>> studentIt = studentNum.iterator();
			while (studentIt.hasNext()) {
				//studentIt.next()获取的是classMap的映射关系对象
				Map.Entry<String, String> numEntry = studentIt.next();
				//调用numEntry集合中的getKey()和getValue()方法
				String numkey = numEntry.getKey();
				String nameValue = numEntry.getValue();
				System.out.println(classNameEntry.getKey()+"..."+ numkey +"..."+ nameValue);
			}
		}
	}
}
























