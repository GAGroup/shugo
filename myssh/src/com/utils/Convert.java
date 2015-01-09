package com.utils;



import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class Convert {

	private final static String PATH = "E:\\学习视频\\1.avi";

	/**
	 * 测试.
	 * @param args
	 */
	public static void main(String[] args) {
		if (!checkfile(PATH)) {
			System.out.println(PATH + " is not file");
			return;
		}
		if (process()) {
			System.out.println("ok");
		}
	}

	/**
	 * 处理视频转换.
	 * @return
	 */
	private static boolean process() {
		int type = checkContentType();
		boolean status = false;
		if (type == 0) {
			// 直接将文件转为flv文件
			status = processFLV(PATH);
		} else if (type == 1) {
			String avifilepath = processAVI(type);
			if (avifilepath == null)
				// avi文件没有得到
				return false;
			// 将avi转为flv
			status = processFLV(avifilepath);
		}
		return status;
	}

	/**
	 * 检查视频格式
	 * @return
	 */
	private static int checkContentType() {
		String type = PATH.substring(PATH.lastIndexOf(".") + 1, PATH.length())
				.toLowerCase();
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

	/**
	 * 检查是否为文件.
	 * @param path
	 * @return
	 */
	private static boolean checkfile(String path) {
		File file = new File(path);
		if (!file.isFile()) {
			return false;
		}
		return true;
	}

	// 对ffmpeg无法解析的文件格式(wmv9，rm，rmvb等), 可以先用别的工具（mencoder）转换为avi(ffmpeg能解析的)格式.
	private static String processAVI(int type) {
		List<String> commend = new java.util.ArrayList<String>();
		commend.add("E:\\Test\\mencoder");
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
		commend.add("E:\\Test\\a.avi");

		try {
			ProcessBuilder builder = new ProcessBuilder();
			builder.command(commend);
			builder.start();
			return "E:\\Test\\a.avi";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// ffmpeg能解析的格式：（asx，asf，mpg，wmv，3gp，mp4，mov，avi，flv等）
	private static boolean processFLV(String oldfilepath) {

		if (!checkfile(PATH)) {
			System.out.println(oldfilepath + " is not file");
			return false;
		}

		List<String> commend = new java.util.ArrayList<String>();
		commend.add("E:\\Test\\ffmpeg");
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
		commend.add("E:\\学习视频\\16.flv");
		try {
			ProcessBuilder builder = new ProcessBuilder();
			builder.command(commend);
			final Process process = builder.start();
			
			new Thread(new Runnable() {
			    public void run() {
			        BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream())); 
			        try {
						while(br.readLine() != null) ;
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			    }
			}).start(); // 启动单独的线程来清空process.getInputStream()的缓冲区
			InputStream is2 = process.getErrorStream();
			BufferedReader br2 = new BufferedReader(new InputStreamReader(is2)); 
			String line = null;
			while((line = br2.readLine()) != null) {
				continue;
			}
			
			System.out.println(process.waitFor());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
