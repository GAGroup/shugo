package com.video.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;

import com.utils.GetFlvPic;
import com.video.dao.VideoInfoDAOInter;
import com.video.dao.VideoTypeDAOInter;
import com.video.entity.VideoExProperty;
import com.video.entity.VideoInfo;
import com.video.service.VideoManagerInter;

public class  DefaultVideoManager  implements VideoManagerInter {

	//通过依赖注入
	private VideoInfoDAOInter videoInfoDAO;
	private VideoTypeDAOInter videoTypeDAO;
	
	
	//  未解决断点续传
	@Override
	public boolean uploadeVideo(VideoInfo videoInfo, File video){
		/*校验videoInfo*/
		
		//要做路径转换
		String filepath = videoInfo.getSavePath().replace("\\", "\\\\");
		filepath = formatePathLast(filepath);
		File savefile = new File(filepath,videoInfo.getSaveName());
		File parentFile = new File(savefile.getParent());//创建到文件级别
        if (!parentFile.getParentFile().exists()){
        	parentFile.getParentFile().mkdirs();//可能需要创建多级目录
        }
        try {
			FileUtils.copyFile(video, parentFile);
			GetFlvPic pictool = new GetFlvPic();
			pictool.getFlv(videoInfo.getSavePath(), new File(videoInfo.getEx()));
			//videoInfo.setEx(videoInfo.getEx().substring("myssh\\"));
			videoInfoDAO.save(videoInfo);
		} catch (IOException e) {
			throw new RuntimeException("保存文件出错",e);
		}
		return false;
	}
	//递归去除路径末尾的\
	private String formatePathLast(String filepath) {
		filepath = filepath.trim();
		if(filepath.endsWith("\\")){
			filepath = filepath.substring(0,filepath.length()-1);
			formatePathLast(filepath);
		}
		return filepath;
	}

	@Override
	public VideoInfo browerVideo(Integer videoID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getVideoList(Integer state, Integer pageSize) {
		//注意没有分页**************************************
		return videoInfoDAO.findAll();
		
	}

	@Override
	public List getVideoList(Map wheremap) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VideoInfo downloadVidwo(Integer videoID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VideoInfo updateVideo(VideoInfo newViddeoInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VideoInfo moveVideo(VideoInfo newVideoInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VideoInfo deleteVideo(VideoInfo videoInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addExProperty(VideoExProperty videoExProperty) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List getAllExProperty() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean uploadeVideoList(List<VideoInfo> videoInfoList,
			List<File> videoFileList) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public VideoInfo deleteVideoList(List<VideoInfo> videoInfoList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getAllVideoType() {
		return videoTypeDAO.findAll();
	}
	
	
	/*%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%getter-setter%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%*/
	

	public VideoInfoDAOInter getVideoInfoDAO() {
		return videoInfoDAO;
	}

	public void setVideoInfoDAO(VideoInfoDAOInter videoInfoDAO) {
		this.videoInfoDAO = videoInfoDAO;
	}
	public VideoTypeDAOInter getVideoTypeDAO() {
		return videoTypeDAO;
	}
	public void setVideoTypeDAO(VideoTypeDAOInter videoTypeDAO) {
		this.videoTypeDAO = videoTypeDAO;
	}
	
	
	
	
	
	
	

}
