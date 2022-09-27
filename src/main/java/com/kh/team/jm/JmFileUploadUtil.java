package com.kh.team.jm;


import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Calendar;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;
import org.springframework.util.FileCopyUtils;



public class JmFileUploadUtil {

	
	public static String uploadFile(String uploadPath ,String originalName, byte[] fileData )throws Exception{
		
		UUID uuid = UUID.randomUUID();
		
		String datePath = calcPath(uploadPath);
		String dirPath = datePath+File.separator+uuid+"-"+originalName;
		String filePath= uploadPath+File.separator+dirPath;
		File target =  new File(filePath);
		FileCopyUtils.copy(fileData, target);
		boolean result = isImage(originalName);
		
		if(result == true) {
			makeThumbNail(filePath);
		}
		
		return dirPath;
	}
	
	
	public static boolean isImage(String filename)throws Exception {
		
		String extName = filename.substring(filename.lastIndexOf(".")+1).toUpperCase();
		if(extName.equals("JPG")||extName.equals("GIF")||extName.equals("PNG")) {
			return true;
		}
		return false;
	}
	
	
	public static String makeThumbNail(String filePath)throws Exception{
		
		int lastSlashIndex = filePath.lastIndexOf("\\");
		String front =filePath.substring(0,lastSlashIndex+1);
		String rear = filePath.substring(lastSlashIndex+1);
		String thumbNail = front+"jm_"+rear;
		
		BufferedImage srcImage = ImageIO.read(new File(filePath));
		
		BufferedImage destImage = Scalr.resize(srcImage, Scalr.Method.AUTOMATIC, Scalr.Mode.FIT_TO_HEIGHT,100);
		
		File thumFile = new File(thumbNail);
		ImageIO.write(destImage, getFormatName(thumbNail),thumFile);
		
		return thumbNail;
		
	}
	
	public static String getFormatName(String filename) {
		
		int dotindex = filename.lastIndexOf(".");
		String extName = filename.substring(dotindex+1);
		
		
		return extName.toUpperCase();
		
	}
	
	
	
	
	
	
	private static String calcPath(String uploadPath){
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)+1;
		int date = cal.get(Calendar.DATE);
		
		String dateString = year+File.separator+month+File.separator+date;
		String datePath = uploadPath +File.separator+dateString;
		
		File f = new File(datePath);
		if(!f.exists()) {
			f.mkdir();
		}

		return dateString;
	}
	
	
	
	
	
	
	
}

