package junit;

import java.io.File;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.video.dao.VideoInfoDAOInter;
import com.video.entity.VideoInfo;
import com.video.entity.VideoType;
import com.video.service.VideoManagerInter;
import com.video.service.impl.DefaultVideoManager;

public class TestVideoManagerService {
	ApplicationContext cxt;
	@Before
	public void saa(){
		cxt = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
	
	@Test
	public void testUpload(){
		DefaultVideoManager vm = new DefaultVideoManager();
		
		VideoInfo videoInfo = new VideoInfo();
		File video = new File("C:\\b\\c\\g","aa.txt");
		//videoInfo.setPath("video/type1/type11/aa.txt");
		videoInfo.setSaveName("中文保存的名字");
		videoInfo.setSize((long) 234234);
		videoInfo.setUploadTime(null);
		videoInfo.setVideoDesc("asdfasdfsadf");
		videoInfo.setVideoName("原来的名字");
		VideoType videoType = new VideoType();
		videoType.setVideoTypeId(1);
		videoInfo.setVideoType(videoType);
		videoInfo.setVideoUplodUser(1);
		videoInfo.setVisitedTimes(0);
		videoInfo.setVisitValue(100);
		VideoInfoDAOInter vd = (VideoInfoDAOInter) cxt.getBean("VideoInfoDAO");
		//vd.save(videoInfo);
		vm.uploadeVideo(videoInfo, video);
		
		
		
	}
	
	
	
	
	@Test
	public void testmakdirs(){
		File file = new File("c:\\qq\\qq","aaa,txt");
		File temp = new File(file.getParent());
		temp.mkdirs();
		
	}
	
	@Test
	public void testGetall(){
		
		VideoManagerInter vm = (VideoManagerInter) cxt.getBean("defaultVideoManager");
		List<VideoInfo> vl = vm.getVideoList(0, 0);
		for(VideoInfo v:vl){
			System.out.println(v.getSavePath());
		}
	}
}
