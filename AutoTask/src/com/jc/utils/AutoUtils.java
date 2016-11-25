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
	 * @return    ��ȡ�Զ�������
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
	 * @param x  �������x��
	 * @param y  �������y��
	 * @param dely  ���ʱ��
	 * @return ������
	 */
	public void clickLeftMousePoint(int x,int y,int dely){
		robot.mouseMove(x, y);
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.delay(100);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
		robot.delay(dely);
	}
	
	/**
	 * @param x   �������x��
	 * @param y   �������y��
	 * @param dely  ���ʱ��
	 * @return ����Ҽ�
	 */
	public void clickRightMousePoint(int x,int y,int dely){
		robot.mouseMove(x, y);
		robot.mousePress(InputEvent.BUTTON3_MASK);
		robot.delay(100);
		robot.mouseRelease(InputEvent.BUTTON3_MASK);
		robot.delay(dely);
	}
	
	/**
	 * @param x    ִ�������x��
	 * @param y    ִ�������y��
	 * @param dely  ���ʱ��
	 * @param keys   ����ļ�����
	 * @return ִ�м��������¼�
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
	 * @param distance  �����ľ���
	 * @param dery     ���ʱ��
	 * @return ִ�й��ֹ����¼�
	 */
	public void scrollTo(int distance,int dery){
		if(distance<=0){
			return ;
		}
		robot.mouseWheel(distance);
		robot.delay(dery);
	}
	
	/**
	 * @param x    ��ȡ��x��
	 * @param y    ��ȡ��y��
	 * @param width   ��ȡ�Ŀ��
	 * @param height  ��ȡ�ĸ߶�
	 * @param format   ͼƬ��ʽ    example:png/jpg
	 * @param savePath �����·��  example:  d:/mycapture/
	 * @param dery  ���ʱ��
	 * @return  ��ȡ��Ļ�̶���С
	 * @throws IOException
	 */
	public void capturePoint(int x,int y,int width,int height,String format,String savePath,int dery) throws IOException{
		BufferedImage image=robot.createScreenCapture(new Rectangle(x, y, width, height));
		File file=new File(savePath+UUID.randomUUID().toString()+"."+format);
		ImageIO.write(image, format, file);
		robot.delay(dery);
	}
	
	/**
	 * @param format   ͼƬ��ʽ  JPG��png
	 * @param savePath  ͼƬ����·��   d:/full/
	 * @param dery   ���ʱ��
	 * @return  ��ȡ������Ļ
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
	 * @return ִ���ƶ�����¼�
	 */
	public void moveCurser(int x,int y,int dery){
		if(dery==0){
			robot.setAutoDelay(100);
		}
		robot.mouseMove(x, y);
		robot.delay(dery);
	}
	
	
	
	

}
