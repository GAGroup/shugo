package com.utils;

import java.io.File;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.video.entity.VideoInfo;
import com.video.entity.VideoType;

public class MyFileUtils {
	private File file;
	private String savePath;
	private String visitedPath;
	
/*	public MyFileUtils(File file,String savePaht,String){
		
	}
	private VideoInfo Action2VideoInfo(File video,String videoFileName) {
		//path，可以根据每个用户创建一个文件夹，每个文件夹里有根据不同分类（类别文件夹）存放文件
    	//如果有action个读取的话，可以根据上传的文件名做保存的文件名（注意文件命名重复）---人工管理方案
		//userPath可根据用户和和类型***************************
		String userPath = uploadeDocument+"/"+videoType;
		//获得全路径
    	String realpath = ServletActionContext.getServletContext().getRealPath(userPath);
        //D:\apache-tomcat-6.0.18\webapps\myssh\video
    	//扩展名
    	String exName = videoFileName.substring(videoFileName.lastIndexOf(".",videoFileName.length()));//文件扩展名
    	String saveDiskName = UUID.randomUUID().toString();//不读取，不人工管理的保存方案（人工管理，要增加action读取文件，网络不允许中文访问路径）
    	//文件全名
    	String holdVideoName = saveDiskName + exName; 
    	VideoInfo videoInfo = new VideoInfo();
    	videoInfo.setEx(realpath+"\\"+saveDiskName+".jpg");//保存文件类型
    	videoInfo.setSavePath(realpath+"\\"+holdVideoName);//保存的路径 保存扩展名，有。不用再加
        videoInfo.setSaveName(saveDiskName+exName);//保存的名字
        videoInfo.setSize(FileUtils.sizeOf(video));
        	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        videoInfo.setUploadTime(Timestamp.valueOf(format.format(System.currentTimeMillis())));
       // videoInfo.setVideoDesc(videoDesc);
        videoInfo.setVideoName(videoFileName);//文件上传时的名字，如果要支持中文，需要些一个actin发送流，用文件名读取文件，就可以解决乱码
        videoInfo.setVisitValue(0);//等用户模块确定，再写
	        VideoType videoType1 = new VideoType();
	        videoType1.setVideoTypeId(videoType);
        videoInfo.setVideoType(videoType1);
        videoInfo.setVideoType(videoType1);//前台需要做约束，从数据库读取类型，做成下拉框
        videoInfo.setVideoUplodUser(1);//没有用户模块，先不做
        //videoInfo.setVisitPower(visitPower);
        //videoInfo.setVisitValue(visitValue);
       
        	//得到保存的网络路径---上传到服务器
        	String path = userPath;
        	videoInfo.setVisitPath(path+"/"+holdVideoName);
       
        // Map<String, Object> sessions = ActionContext.getContext().getSession();
		return videoInfo;
	}*/
	
}
