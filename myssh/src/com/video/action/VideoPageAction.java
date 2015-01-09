package com.video.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.video.entity.VideoType;
import com.video.service.impl.DefaultVideoManager;

public class VideoPageAction extends ActionSupport {
	
	private DefaultVideoManager defaultVideoManager;
	
	
	//上传表单，准备实体
	//获得，已定义的影音-类型
	
	public String getSupportType()throws Exception{
		List<VideoType> list = defaultVideoManager.getAllVideoType();
		ActionContext cxt = ActionContext.getContext();
		cxt.put("videoType", list);
		return SUCCESS;
	}

/*************getter-setter************************/
	public DefaultVideoManager getDefaultVideoManager() {
		return defaultVideoManager;
	}


	public void setDefaultVideoManager(DefaultVideoManager defaultVideoManager) {
		this.defaultVideoManager = defaultVideoManager;
	}
	
}
