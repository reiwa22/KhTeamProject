package com.kh.team.jm;

import java.io.File;
import java.io.FileInputStream;

import javax.annotation.Resource;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kh.team.Util.FileuploadUtil;

@RestController
@RequestMapping("/jm")
public class Jm_UploadController {

	
	@Resource
	private String uploadPath;
	
	@RequestMapping(value="/jmUploadAjex" ,method=RequestMethod.POST)
	public String jmUpLoadAjex(MultipartFile file)throws Exception{
		String originalName = file.getOriginalFilename();
		System.out.println("file:"+file);
		long size = file.getSize();
		System.out.println("uploadPath:"+uploadPath);
		System.out.println("size:"+size);
		
		String dirPath = JmFileUploadUtil.uploadFile(uploadPath, originalName, file.getBytes());
		System.out.println("dirPath:"+dirPath);
		return dirPath.replace("\\", "/");
	}
	
	
	
	@RequestMapping(value="/jmDisplayFile",method=RequestMethod.GET)
	public byte[] jmdisplayFile(@RequestParam("fileName")String fileName)throws Exception{
		
		String filePath = uploadPath+File.separator+fileName;
		String rFilePath = filePath.replace("\\", "/");
		FileInputStream fis = new FileInputStream(rFilePath);
		byte[] bytes = IOUtils.toByteArray(fis);
		fis.close();
	
		return bytes;
	}
	@RequestMapping(value="/jmDeleteFile",method=RequestMethod.GET)
	public String deleteFile(String filename)throws Exception{
		String front = filename.substring(0,filename.lastIndexOf("/"));
		System.out.println("front:::"+front);
		String rear = filename.substring(filename.lastIndexOf("/")+1);
		System.out.println("rear:::"+rear);
		String jmServerPath = uploadPath+File.separator+front+"jm_"+rear;
		System.out.println("jmServerPath:"+jmServerPath);
		String serverPath = uploadPath+File.separator+filename;
		
		File f = new File(serverPath);
		
		f.delete();
		
		boolean result = JmFileUploadUtil.isImage(filename);
		
		if(result ==true) {
			File f2 = new File(jmServerPath);
			f2.delete();
		}
		return "success";
		
	
	}
	
	
	
	
	
}
