package com.youxia.util;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.imageio.ImageIO;
import org.springframework.stereotype.Component;
import com.sun.image.codec.jpeg.ImageFormatException;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

@Component("ImageCut")
public class ImageCut {
	private int width = 130;		//默认输出图片宽
	private int height = 130;		//默认输出图片高
	
	private int rate = 0;
	private boolean proportion = true; //是否等比缩放标记(默认为等比缩放)
	
	public ImageCut(){
		width = 130;
		height = 130;
		rate = 0;
	}
	
	public boolean sPic(File file, File cutFile){
		FileOutputStream tempOut = null;
		try {
			tempOut = new FileOutputStream(cutFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Image img = null;
		try {
			InputStream in = new FileInputStream(file);
			BufferedImage bi = ImageIO.read(in);
			img = (Image)bi;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(img.getWidth(null) == -1){
			return false;
		}
		else{
			int new_w, new_h;
			if(this.proportion == true){	//判断是否是等比缩放
				double rate1 = ((double)img.getWidth(null))/(double)width + 0.1;
				double rate2 = ((double)img.getHeight(null))/(double)height+ 0.1;
				new_w = (int) (((double)img.getWidth(null))/rate);
				new_h = (int) (((double)img.getHeight(null))/rate);
			}
			else{
				new_w = width; new_h = height;
			}
			BufferedImage buffImg = new BufferedImage(new_w, new_h, BufferedImage.TYPE_INT_RGB);
			Graphics g = buffImg.createGraphics();
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, new_w, new_h);
			
			g.drawImage(img, 0, 0, new_w, new_h, null);
			g.dispose();
			
			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(tempOut);
			
			try {
				encoder.encode(buffImg);
				tempOut.close();
			} catch (ImageFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return true;
	}
	
	public boolean sPic(String fileUrl, String cutFileUrl){
		return this.sPic(new File(fileUrl), new File(cutFileUrl));
	}
	
	public boolean sPic(String fileUrl, String cutFileUrl, int width, int height, boolean proportion){
		this.width = width;
		this.height = height;
		this.proportion = proportion;
		return this.sPic(fileUrl, cutFileUrl);
	}
	
	public void copy(File orgFile, File aimFile){
		InputStream in = null;
		OutputStream out = null;
		BufferedInputStream reader = null;
		BufferedOutputStream outer = null;
		
		try {
			in = new FileInputStream(orgFile);
			out = new FileOutputStream(aimFile);
			
			reader = new BufferedInputStream(in);
			outer = new BufferedOutputStream(out);
			byte[] charts = new byte[512];
			int index = 0;
			while((index = reader.read(charts)) != -1){
				outer.write(charts, 0, index);
				outer.flush();
			}	
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				reader.close();
				outer.close();
				in.close();
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public boolean isProportion() {
		return proportion;
	}

	public void setProportion(boolean proportion) {
		this.proportion = proportion;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
