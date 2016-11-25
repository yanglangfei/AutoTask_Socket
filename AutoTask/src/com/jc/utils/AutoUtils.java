package com.jc.utils;
import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.UUID;
import javax.imageio.ImageIO;
public class AutoUtils {
	private static AutoUtils auto;
	private static Robot robot;
	private AutoUtils(){
		
	}
	
	/**
	 * @return    获取自动化对象
	 * @throws AWTException
	 */
	public  static AutoUtils getInstance() throws AWTException{
		if(auto==null){
			auto=new AutoUtils();
			robot=new Robot();
		}
		return auto;
	}
	
	/**
	 * @param x  点击区域x点
	 * @param y  点击区域y点
	 * @param dely  间隔时间
	 * @return 点击左键
	 */
	public void clickLeftMousePoint(int x,int y,int dely){
		robot.mouseMove(x, y);
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.delay(100);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
		robot.delay(dely);
	}
	
	/**
	 * @param x   点击区域x点
	 * @param y   点击区域y点
	 * @param dely  间隔时间
	 * @return 点击右键
	 */
	public void clickRightMousePoint(int x,int y,int dely){
		robot.mouseMove(x, y);
		robot.mousePress(InputEvent.BUTTON3_MASK);
		robot.delay(100);
		robot.mouseRelease(InputEvent.BUTTON3_MASK);
		robot.delay(dely);
	}
	
	/**
	 * @param x    执行区域的x点
	 * @param y    执行区域的y点
	 * @param dely  间隔时间
	 * @param keys   点击的键数组
	 * @return 执行键盘输入事件
	 */
	public void clickKeyPoint(int x,int y,int dely,int keys[]){
		robot.mouseMove(x, y);
		for(int i=0;i<keys.length;i++){
			robot.keyPress(keys[i]);
			robot.delay(100);
			robot.keyRelease(keys[i]);
		}
		robot.delay(dely);
	}
	
	/**
	 * @param distance  滚动的距离
	 * @param dery     间隔时间
	 * @return 执行滚轮滚动事件
	 */
	public void scrollTo(int distance,int dery){
		if(distance<=0){
			return ;
		}
		robot.mouseWheel(distance);
		robot.delay(dery);
	}
	
	/**
	 * @param x    截取的x点
	 * @param y    截取的y点
	 * @param width   截取的宽度
	 * @param height  截取的高度
	 * @param format   图片格式    example:png/jpg
	 * @param savePath 保存的路径  example:  d:/mycapture/
	 * @param dery  间隔时间
	 * @return  截取屏幕固定大小
	 * @throws IOException
	 */
	public void capturePoint(int x,int y,int width,int height,String format,String savePath,int dery) throws IOException{
		BufferedImage image=robot.createScreenCapture(new Rectangle(x, y, width, height));
		File file=new File(savePath+UUID.randomUUID().toString()+"."+format);
		ImageIO.write(image, format, file);
		robot.delay(dery);
	}
	
	/**
	 * @param format   图片格式  JPG、png
	 * @param savePath  图片保存路径   d:/full/
	 * @param dery   间隔时间
	 * @return  截取整个屏幕
	 * @throws IOException
	 */
	public void captureFullScreen(String format,String savePath,int dery) throws IOException{
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		BufferedImage image=robot.createScreenCapture(new Rectangle(size));
		File file=new File(savePath+UUID.randomUUID().toString()+"."+format);
		ImageIO.write(image, format, file);
		robot.delay(dery);
	}
	
	/**
	 * @param x
	 * @param y
	 * @param dery
	 * @return 执行移动光标事件
	 */
	public void moveCurser(int x,int y,int dery){
		if(dery==0){
			robot.setAutoDelay(100);
		}
		robot.mouseMove(x, y);
		robot.delay(dery);
	}
	
	
	
	

}
