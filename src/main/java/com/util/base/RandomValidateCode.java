/**
 * Project Name:bms
 * File Name:RandomValidateCode.java
 * Package Name:sy.util.base
 * Date:2014-4-1下午1:45:46
 * Copyright (c) 2014, Shenzhen Inovance technology Co., Ltd  All Rights Reserved.
 *
 */

package com.util.base;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * ClassName:RandomValidateCode. <br/>
 * Function: TODO 生产验证码 <br/>
 * Reason: TODO 登录验证安全<br/>
 * Date: 2014-4-1 下午1:45:46 <br/>
 * 
 * @author w1898
 * @version
 * @since JDK 1.7
 * @see
 */
public class RandomValidateCode {

	private int width;
	private int height;
	private int length;
	private String code;
    private final String showStr="abcdefgjhghmnpqrstuvwxyz23456789ABCDEFGHJKMNPQRSTUVWXYZ"; 
	public RandomValidateCode() {
		this(90, 40, 4);
	}

	/**
	 * 
	 * 
	 * Creates a new instance of RandomValidateCode.
	 * 
	 * @param width
	 *            ：picture width
	 * @param height
	 *            ：picture heigth
	 * @param length
	 *            ： string length
	 */
	public RandomValidateCode(int width, int height, int length) {
		this.width = width;
		this.height = height;
		this.length = length;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public String getCode() {
		return code;
	}

	public void setHeight(String code) {
		this.code = code;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public BufferedImage CreateValidateCodeImg() {
		code = RandomStringUtils.random(length,showStr);
		BufferedImage image = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();
		// 设定背景色
		g.setColor(getRandColor(200, 250));
		g.fillRect(0, 0, width, height);

		// 设定字体
		Font mFont = new Font("Courier New", Font.ITALIC, 24);// 设置字体
		g.setFont(mFont);
		// 画边框
		// g.setColor(Color.BLACK);
		// g.drawRect(0, 0, width - 1, height - 1);

		// 随机产生干扰线，使图象中的认证码不易被其它程序探测到
		g.setColor(getRandColor(160, 200));
		// 生成随机类
		Random random = new Random();
		for (int i = 0; i < 155; i++) {
			int x2 = random.nextInt(width);
			int y2 = random.nextInt(height);
			int x3 = random.nextInt(12);
			int y3 = random.nextInt(12);
			g.drawLine(x2, y2, x2 + x3, y2 + y3);
		}
		// 将认证码显示到图象中
		g.setColor(new Color(20 + random.nextInt(110),
				20 + random.nextInt(110), 20 + random.nextInt(110)));
		g.drawString(code, 15, 28);
		// 图象生效
		g.dispose();
		return image;
	}

	// 给定范围获得随机颜色
	private Color getRandColor(int fc, int bc) {
		Random random = new Random();
		if (fc > 255) {
			fc = 255;
		}
		if (bc > 255) {
			bc = 255;
		}
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		return new Color(r, g, b);
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

}
