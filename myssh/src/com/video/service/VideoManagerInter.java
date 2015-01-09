package com.video.service;

import java.io.File;
import java.util.List;
import java.util.Map;

import com.video.entity.VideoExProperty;
import com.video.entity.VideoInfo;

public interface VideoManagerInter {

	//管理员的影音管理业务
	/**
	 * 单文件上传影音
	 * @return
	 */
	public abstract boolean uploadeVideo(VideoInfo videoInfo,File videoFile);
	/**
	 * 批量上传影音
	 * @return
	 */
	public abstract boolean uploadeVideoList(List<VideoInfo> videoInfoList,List<File> videoFileList);

	/**
	 * 浏览影音
	 * @return
	 */
	public abstract VideoInfo browerVideo(Integer videoID);
	/**
	 * 获得影音列表
	 * @return
	 */
	public abstract List getVideoList(Integer state,Integer pageSize);
	/**
	 * 按条件查找
	 * @return
	 */
	public abstract List getVideoList(Map wheremap);

	/**
	 * 下载影音
	 * @param videoID
	 * @return
	 */
	public abstract VideoInfo downloadVidwo(Integer videoID);

	/**
	 * 更新影音信息
	 * @param newViddeoInfo
	 * @return
	 */
	public abstract VideoInfo updateVideo(VideoInfo newViddeoInfo);

	/**
	 * 移动影音
	 * @param newVideoInfo
	 * @return
	 */
	public abstract VideoInfo moveVideo(VideoInfo newVideoInfo);

	/**
	 * 删除影音
	 * @param videoInfo
	 * @return
	 */
	public abstract VideoInfo deleteVideo(VideoInfo videoInfo);
	/**
	 * 批量删除影音
	 * @param videoInfo
	 * @return
	 */
	public abstract VideoInfo deleteVideoList(List<VideoInfo> videoInfoList);
	/**
	 * 添加额外属性
	 * @param videoExProperty
	 * @return
	 */
	public abstract boolean addExProperty(VideoExProperty videoExProperty);
	/**
	 * 获取额外属性列表
	 * @param 
	 * @return
	 */
	public abstract List getAllExProperty();
	/**
	 * 获取类别列表
	 * @param 
	 * @return
	 */
	public abstract List getAllVideoType();
	
	
	

}