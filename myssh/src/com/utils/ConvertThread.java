package com.utils;


import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.List;

import com.user.entity.User;
import com.video.entity.VideoInfo;

public class ConvertThread implements Runnable {

	private String PATH;
	private String videoName;
	private String videoTitle;
	private String videoDesc;
	private User user;

	private String picPath;

	private VideoInfo video = new VideoInfo();
	//private VideoService videoService = new VideoServiceImpl();
	private Process process;

	public ConvertThread(String pATH, String videoName, String videoTitle, String videoDesc, User user, String picPath) {
		super();
		PATH = pATH;
		this.videoName = videoName;
		this.videoTitle = videoTitle;
		this.videoDesc = videoDesc;
		this.user = user;
		this.picPath = picPath;
	}

	/**
	 * 运行线程
	 */
	public void run() {
		// TODO Auto-generated method stub
		if (!checkfile(PATH)) {
			System.out.println(PATH + " is not file");
			return;
		}
		if (process()) {
			System.out.println("ok");
		}
	}

	/**
	 * 处理视频
	 * @return
	 */
	private boolean process() {
		int type = checkContentType();
		boolean status = false;
		if (type == 0) {
			status = processFLV(PATH);// 直接将文件转为flv文件
		} else if (type == 1) {
			String avifilepath = processAVI(type);
			if (avifilepath == null)
				return false;// avi文件没有得到
			status = processFLV(avifilepath);// 将avi转为flv
		}
		return status;
	}

	/**
	 * 检查视频格式
	 * @return
	 */
	private int checkContentType() {
		String type = PATH.substring(PATH.lastIndexOf(".") + 1, PATH.length()).toLowerCase();
		// ffmpeg能解析的格式：（asx，asf，mpg，wmv，3gp，mp4，mov，avi，flv等）
		if (type.equals("avi")) {
			return 0;
		} else if (type.equals("mpg")) {
			return 0;
		} else if (type.equals("wmv")) {
			return 0;
		} else if (type.equals("3gp")) {
			return 0;
		} else if (type.equals("mov")) {
			return 0;
		} else if (type.equals("mp4")) {
			return 0;
		} else if (type.equals("asf")) {
			return 0;
		} else if (type.equals("asx")) {
			return 0;
		} else if (type.equals("flv")) {
			return 0;
		}
		// 对ffmpeg无法解析的文件格式(wmv9，rm，rmvb等),
		// 可以先用别的工具（mencoder）转换为avi(ffmpeg能解析的)格式.
		else if (type.equals("wmv9")) {
			return 1;
		} else if (type.equals("rm")) {
			return 1;
		} else if (type.equals("rmvb")) {
			return 1;
		}
		return 9;
	}

	private boolean checkfile(String path) {
		File file = new File(path);
		if (!file.isFile()) {
			return false;
		}
		return true;
	}

	// 对ffmpeg无法解析的文件格式(wmv9，rm，rmvb等), 可以先用别的工具（mencoder）转换为avi(ffmpeg能解析的)格式.
	private String processAVI(int type) {
		List<String> commend = new java.util.ArrayList<String>();
		commend.add("g:\\input\\mencoder");
		commend.add(PATH);
		commend.add("-oac");
		commend.add("lavc");
		commend.add("-lavcopts");
		commend.add("acodec=mp3:abitrate=64");
		commend.add("-ovc");
		commend.add("xvid");
		commend.add("-xvidencopts");
		commend.add("bitrate=600");
		commend.add("-of");
		commend.add("avi");
		commend.add("-o");
		commend.add("g:\\input\\a.avi");

		try {
			ProcessBuilder builder = new ProcessBuilder();
			builder.command(commend);
			builder.start();
			return "g:\\input\\a.avi";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 处理ffmpeg能解析的视频格式：（asx，asf，mpg，wmv，3gp，mp4，mov，avi，flv等）.
	 * return result 是否成功
	 */
	private boolean processFLV(String oldfilepath) {
		if (!checkfile(PATH)) {
			System.out.println(oldfilepath + " is not file");
			return false;
		}
		int pos = PATH.lastIndexOf(".");
		// 输出flv的路径
		String flvPath = PATH.substring(0, pos) + ".flv";
		List<String> commend = new java.util.ArrayList<String>();
		commend.add("E:\\Test\\ffmpeg\\ffmpeg.exe");
		commend.add("-i");
		commend.add(oldfilepath);
		commend.add("-ab");
		commend.add("64");
		commend.add("-acodec");
		commend.add("mp3");
		commend.add("-ac");
		commend.add("2");
		commend.add("-ar");
		commend.add("22050");
		commend.add("-b");
		commend.add("230");
		commend.add("-r");
		commend.add("24");
		commend.add("-y");
		commend.add(flvPath);
		try {
			ProcessBuilder builder = new ProcessBuilder();
			builder.command(commend);
			process = builder.start();
			// 开始格式转换
			new Thread(new Runnable() {
				public void run() {
					BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
					try {
						while (br.readLine() != null)
							;
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}).start(); // 启动单独的线程来清空process.getInputStream()的缓冲区
			InputStream is2 = process.getErrorStream();
			BufferedReader br2 = new BufferedReader(new InputStreamReader(is2));
			String line = null;
			while ((line = br2.readLine()) != null) {
				continue;
			}
			int ret = process.waitFor();
			System.out.println(ret);
			System.out.println("转换成功");

			// 抓取视频第一张图片
			pos = videoName.lastIndexOf(".");
			String picName = videoName.substring(0, pos);
			File picFile = new File(picPath);
			//new GetFlvPic().getFlv(flvPath, picName, picFile);

			// 删除转换前视频文件
			File oldFile = new File(PATH);
			pos = PATH.lastIndexOf(".");
			if (!".flv".equals(PATH.substring(pos))) {
				if (oldFile.exists()) {
					oldFile.delete();
				}
			}

			// 保存视频实体信息
			/*video.setVideoName(picName + ".flv");
			video.setVideoTitle(videoTitle);
			video.setVideoDesc(videoDesc);
			video.setPath(flvPath);
			video.setUploadTime(new Date());
			video.setCount(0);
			video.setUser(user);
			video.setPicPath("uploadPic/" + picName + ".jpg");
			video.setStatus("0");
			videoService.save(video);*/
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
