package junit;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.video.dao.impl.VideoDirectorDAO;
import com.video.dao.impl.VideoInfoDAO;
import com.video.dao.VideoInfoDAOInter;
import com.video.entity.VideoInfo;

public class TestVideoSSh {

	ApplicationContext cxt;
	
	@Before
	public void saa(){
		cxt = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
	
	@Test
	public void testSSH(){
		
		VideoInfoDAOInter vd = (VideoInfoDAOInter) cxt.getBean("VideoInfoDAO");
		VideoInfo videoInfo = new VideoInfo();
		videoInfo.setVideoName("dfasdf");
		videoInfo.setSaveName("sdfsadfsad");
		//vd.save(videoInfo);
		videoInfo.setVideoId(1);
		//删除必须根据id
		vd.delete(videoInfo);
	}
	

}
