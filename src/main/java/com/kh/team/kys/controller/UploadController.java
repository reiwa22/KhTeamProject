package com.kh.team.kys.controller;

import java.io.File;
import java.io.FileInputStream;
import java.time.Month;
import java.time.MonthDay;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kh.team.Util.FileuploadUtil;
import com.kh.team.domain.CjhCartVo;
import com.kh.team.domain.Kys_salesVo;
import com.kh.team.kys.dao.KysBoardDao;
import com.kh.team.kys.service.KysBoardService;

@RestController
@RequestMapping("/upload")
public class UploadController {
	
	@Resource
	private String uploadPath;
	
	@Inject
	private KysBoardService boardService;

	
	@RequestMapping(value = "/imgFile", method = RequestMethod.POST)
	public String imgFile(MultipartFile file) throws Exception{
		System.out.println("file:"+file);
		String oFileName = file.getOriginalFilename();
		long size  = file.getSize();
		System.out.println("oFileName: "+oFileName);
		System.out.println("size : " +size);
		System.out.println("uploadpath : " + uploadPath );
		String dirPath = FileuploadUtil.uploadFile(uploadPath, oFileName, file.getBytes());
		System.out.println("dirPath:" + dirPath);
		return dirPath.replace("\\", "/");
	}
	//업로드한 파일을 다시 가져와서 보여줌
	@RequestMapping(value = "/displayFile",method = RequestMethod.GET)
	public byte[] displayFile(String fileName) throws Exception{
		
		String filePath = uploadPath + File.separator+fileName;
		String rFilePath = filePath.replace("/", "\\");
		FileInputStream fis = new FileInputStream(rFilePath);
		byte[] bytes = IOUtils.toByteArray(fis);
		fis.close();
		return bytes;
	}
	@RequestMapping(value = "/deleteFile", method =RequestMethod.GET)
	public String deleteFile(String filename) throws Exception{
		boardService.fileImgDelete(filename);
		String front = filename.substring(0,filename.indexOf("/")+1);
		String rear = filename.substring(filename.lastIndexOf("/")+1);
		String smServerPath = uploadPath + File.separator +front +"sm_"+ rear;
		
		String serverPath = uploadPath + File.separator + filename;
		File f1 = new File(serverPath);
		File f2 = new File(smServerPath);
		f1.delete();
		f2.delete();
		return "success";
	}
	@RequestMapping(value="/updateDelete",method = RequestMethod.GET)
	public String updateDelete(String filename) throws Exception{
		boardService.fileImgDelete(filename);
		String front = filename.substring(0,filename.indexOf("/")+1);
		String rear = filename.substring(filename.lastIndexOf("/")+1);
		String smServerPath = uploadPath + File.separator +front +"sm_"+ rear;
		
		String serverPath = uploadPath + File.separator + filename;
		File f1 = new File(serverPath);
		File f2 = new File(smServerPath);
		f1.delete();
		f2.delete();
		return "success";
	}
	@RequestMapping(value="/toExcel", method = RequestMethod.GET)
	public ModelAndView toExcel(HttpServletRequest req,HttpSession session) throws Exception {
		ModelAndView result = new ModelAndView();
		Map<String,Object> param = new HashMap<>();
		List<Kys_salesVo> list = boardService.exportToExcel();
		result.addObject("list",list);
//		System.out.println("엑셀:"+list);
		Calendar now = new GregorianCalendar();
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH)+1;
		int day = now.get(Calendar.DAY_OF_MONTH);
		int hour = now.get(Calendar.HOUR_OF_DAY);
		int minute = now.get(Calendar.MINUTE);
		int second = now.get(Calendar.SECOND);
		int millisecond = now.get(Calendar.MILLISECOND);
		StringBuffer str = new StringBuffer();
		str.append(year).append(month).append(day).append(hour).append(minute).append(second).append(millisecond);
		req.setAttribute("filename",str);
		result.setViewName("manager/expostToExcel");
		return result;
	}
}
