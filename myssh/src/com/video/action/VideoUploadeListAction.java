package com.video.action;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.video.entity.VideoInfo;
import com.video.entity.VideoType;
import com.video.service.VideoManagerInter;

public class VideoUploadeListAction extends ActionSupport{
	private static final long serialVersionUID = 1L;  
	
	//依赖注入得到
	private VideoManagerInter defaultVideoManager;
	private String uploadeDocument = "uploadVideo";//注入失败了？？？？？？？？？？？
	
    // 上传多个文件的集合文本  
    private List<File> videos;  
    // /多个上传文件的类型集合  
    private List<String> videosContentType;  
   // 多个上传文件的文件名集合  
    private List<String> videosFileName;  
  
    //类型
    private Integer videoType;
    
    public String execute() {  
    	if (videos != null) {
    		String path = uploadeDocument + "/"+videoType;
    		path = ServletActionContext.getServletContext().getRealPath(  
        			path);  // 写到指定的路径中  "/inages/uploadList"
        	// 把上传的文件放到指定的路径下  
        	File file = new File(path);  
        	// 如果指定的路径没有就创建  
        	if (!file.exists()) {  
        		file.mkdirs();  
        	}  
        	// 把得到的文件的集合通过循环的方式读取并放在指定的路径下  
        	int i = 0;
        	for (File video:videos) {  
        		try {  
        			//list集合通过get(i)的方式来获取索引  
        			//FileUtils.copyFile(videos.get(i), new File(file, uploadFileName.get(i)));
        			VideoInfo videoInfo = Action2VideoInfo(video,videosFileName.get(i++));
        			defaultVideoManager.uploadeVideo(videoInfo, video);
        		} catch (Exception e) {  
        			throw new RuntimeException("上传出错了", e);
        		}  
        	}  
            ActionContext.getContext().put("message", "文件上传成功");
        }else{
        	ActionContext.getContext().put("message", "请选择文件或输入影音的路径");
        	return INPUT;
        }
    	return SUCCESS;  
    }  
   
    /**
     * 由action生成VideoInfo规则
     * uuid保存文件videoName和ex（封面图片路径），保存路径和访问路径，创建日期
     * @return
     */
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
	}
   
  
    public List<File> getVideos() {
		return videos;
	}
	public void setVideos(List<File> videos) {
		this.videos = videos;
	}
	public List<String> getUploadContentType() {  
       return videosContentType;  
    }  
    public void setUploadContentType(List<String> uploadContentType) {  
       this.videosContentType = uploadContentType;  
    }  
	public List<String> getVideosContentType() {
		return videosContentType;
	}
	public void setVideosContentType(List<String> videosContentType) {
		this.videosContentType = videosContentType;
	}
	public List<String> getVideosFileName() {
		return videosFileName;
	}
	public void setVideosFileName(List<String> videosFileName) {
		this.videosFileName = videosFileName;
	}
	public Integer getVideoType() {
		return videoType;
	}
	public void setVideoType(Integer videoType) {
		this.videoType = videoType;
	}
	public VideoManagerInter getDefaultVideoManager() {
		return defaultVideoManager;
	}
	public void setDefaultVideoManager(VideoManagerInter defaultVideoManager) {
		this.defaultVideoManager = defaultVideoManager;
	}
	public String getUploadeDocument() {
		return uploadeDocument;
	}
	public void setUploadeDocument(String uploadeDocument) {
		this.uploadeDocument = uploadeDocument;
	} 
}
