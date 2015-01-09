package com.utils;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GetFlvPic {

	/** 
	 * 截取flv文件的第一帧图片 
	 */
	public void getFlv(String file, File flvPath) {
		if(!flvPath.getParentFile().exists()){
			flvPath.getParentFile().mkdirs();
		}
		// 调用ffmpeg.exe 
		String ffmpegPath = "E:/ffmpeg.exe";
		//保存路径 
		String path = flvPath +"";
		System.out.println(path);
		//截取flv文件的中的一帧图片 
		List<String> commend = new ArrayList<String>();
		commend.add(ffmpegPath);
		commend.add("-i");
		commend.add(file);
		commend.add("-y");
		commend.add("-f");
		commend.add("image2");
		commend.add("-ss");
		//截取开始时间：1.001秒
		commend.add("1.001");
		commend.add("-t");
		//截取结束时间：1.003秒
		commend.add("1.003");
		commend.add("-s");
		//截取图片大小
		commend.add("1600x900");
		commend.add(path);
		try {
			//用一条指令构造一个进程生成器 
			ProcessBuilder builder = new ProcessBuilder();
			builder.command(commend);
			Process process = builder.start();
		} catch (Exception e) {
			System.out.println("失败");
			e.printStackTrace();
		}
		System.out.println("截取成功");
	}
}
