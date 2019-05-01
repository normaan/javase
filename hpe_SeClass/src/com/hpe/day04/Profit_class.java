package com.hpe.day04;
/*
 *  实验一
	企业发放的奖金根据利润提成。
	利润低于或等于10万元时，奖金可提10%；
	利润高于10万元，低于20万元时，低于10万元的部分按10%提成，高于10万元的部分，可可提成7.5%；
	20万到40万之间时，高于20万元的部分，可提成5%；
	40万到60万之间时高于40万元的部分，可提成3%；
	60万到100万之间时，高于60万元的部分，可提成1.5%，
	高于100万元时，超过100万元的部分按1%提成；
	从键盘输入当月利润，求应发放奖金总数；
	使用if条件语句输出相应的结果
 */
import java.util.Scanner;

public class Profit_class {
	public static void main(String[] args) {
		//键盘输入
		System.out.println("请输入万元");
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		//初始化奖金
		double sum = 0;
		if (i <= 10) {
			//利润低于或等于10万元时，奖金可提10%；
			sum = 10 * 0.1;
		} else if (i <= 20) {
			//利润高于10万元，低于20万元时，低于10万元的部分按10%提成，高于10万元的部分，可可提成7.5%；
			sum = 10 * 0.1 + (i - 10) * 0.075;
		} else if (i <= 40) {
			//20万到40万之间时，高于20万元的部分，可提成5%；
			sum = 10 * 0.1 + (i - 10) * 0.075 + (i - 20) * 0.05;
		} else if (i <= 60) {
			//40万到60万之间时高于40万元的部分，可提成3%；
			sum = 10 * 0.1 + (i - 10) * 0.075 + (i - 20) * 0.05 + (i - 40) * 0.03;
		} else if (i <= 100) {
			//60万到100万之间时，高于60万元的部分，可提成1.5%，
			sum = 10 * 0.1 + (i - 10) * 0.075 + (i - 20) * 0.05 + (i - 40) * 0.03 + (i - 60) *  0.015;
		} else {
			//高于100万元时，超过100万元的部分按1%提成；
			sum = 10 * 0.1 + (i - 10) * 0.075 + (i - 20) * 0.05 + (i - 40) * 0.03 + (i - 60) *  0.015 + (i - 100) * 0.01;
		}
		System.out.println(sum +"万元");
	}
}