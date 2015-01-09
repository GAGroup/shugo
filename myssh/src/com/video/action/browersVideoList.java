package com.video.action;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.jsp.JspException;

import org.displaytag.export.BinaryExportView;
import org.displaytag.model.TableModel;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.video.entity.VideoInfo;
import com.video.service.VideoManagerInter;

public class browersVideoList extends ActionSupport implements BinaryExportView{
	
	//同依赖注入得到
	private VideoManagerInter defaultVideoManager;
	
	
	
	public String browersVideoList() throws Exception{
		
		//注意没有实现分页
		List<VideoInfo> videoList =  (List<VideoInfo>)defaultVideoManager.getVideoList(0, 0);
		for(VideoInfo v:videoList){
			String srcpath = v.getVisitPath();
			int index = srcpath.lastIndexOf(".");
			v.setEx(srcpath.substring(0,index)+".jpg");
			
		}
		ActionContext cxt = ActionContext.getContext();
		cxt.put("videoList", videoList);
		return SUCCESS;
	}
	
	
	

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return super.execute();
	}

	public VideoManagerInter getDefaultVideoManager() {
		return defaultVideoManager;
	}

	public void setDefaultVideoManager(VideoManagerInter defaultVideoManager) {
		this.defaultVideoManager = defaultVideoManager;
	}




	@Override
	public String getMimeType() {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public void setParameters(TableModel arg0, boolean arg1, boolean arg2,
			boolean arg3) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void doExport(OutputStream arg0) throws IOException, JspException {
		// TODO Auto-generated method stub
		
	}
	
}
