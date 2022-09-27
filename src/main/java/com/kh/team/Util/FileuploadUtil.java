package com.kh.team.Util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Calendar;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;
import org.springframework.util.FileCopyUtils;

public class FileuploadUtil {
	
	public static String uploadFile(String uploadPath,String originalName,byte[] fileData) throws Exception{
		UUID uuid = UUID.randomUUID();
		System.out.println("uuid:"+uuid);
		String dataPath = calcPath(uploadPath);
		String dateFilepath = dataPath + File.separator + uuid+"_"+originalName;
		String filePath = uploadPath + File.separator + dateFilepath;
		File target = new File(filePath);
		FileCopyUtils.copy(fileData, target);
		//이미지 파일인지 확인하고 이미지면 생성 아니면 생성 안함
		boolean result = isImage(originalName);
		System.out.println("result: "+result);
		if (result == true) {
			makeThumbnail(filePath);
		}
		
		return dateFilepath;
	}
	//확장자 얻기
	private static String getFormatName(String fileName) {
		int dotIndex = fileName.lastIndexOf(".");
		String extName = fileName.substring(dotIndex+1);
		return extName.toUpperCase();
	}
	//d메인 이미지 생성
	private static void makeThumbnail(String filePath) throws Exception{
		int lastSlashIndex = filePath.lastIndexOf("\\");
		String front = filePath.substring(0,lastSlashIndex +1);
		String rear = filePath.substring(lastSlashIndex +1);
		String thumbnailName = front +"sm_"+rear;
		System.out.println("thumbnailName:" +thumbnailName);
		BufferedImage srcImage = ImageIO.read(new File(filePath));
		//원본이미지를 메로리에 로드
		BufferedImage destImage = Scalr.resize(srcImage,
												Scalr.Method.AUTOMATIC, 
												Scalr.Mode.FIT_TO_HEIGHT, 150);
		File thumbFile = new File(thumbnailName);
		ImageIO.write(destImage, getFormatName(thumbnailName), thumbFile);
	}
	//이미지 확인 public
	public static boolean isImage(String filename) throws Exception{
		String extName = filename.substring(filename.lastIndexOf(".")+1).toUpperCase();
		if (extName.equals("JPG") || extName.equals("GIF") || extName.equals("PNG")) {
			return true;
		}
		return false;
	}
	
	//날자
	public static String calcPath(String uploadPath) {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)+1;
		int date = cal.get(Calendar.DATE);
		String dateString = year + File.separator
				+month +File.separator
				+date; //날자 설정
		String datePath = uploadPath + File.separator + dateString;
		System.out.println("datePath:" + datePath);
		File f = new File(datePath); //해당 경로의 파일 "객채"생성
		if(!f.exists()) { //폴더 경로가 존재하지 않는다면
			f.mkdirs(); //하위 경로 포함해서 생성
		}
		return dateString;
	}
}
