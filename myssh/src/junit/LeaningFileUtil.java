package junit;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

public class LeaningFileUtil {

	
	@Test
	public void testFile(){
		
		try {
			
			File file = new File("c:\\b","aa.txt");
			file.createNewFile();
			String path = file.getAbsolutePath();
			
			System.out.println(path);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//FileUtils.copyFileToDirectory(srcFile, destDir, preserveFileDate);
	}
	
	
	
	@Test 
	public void testDir(){
		File file = new File("c:\\b\\c\\g");
		file.mkdirs();
	}
	@Test
	public void testFileUtils(){
		File file = new File("c:\\b","aa.txt");
		File dir = new File("c:\\b\\z\\g");
		try {
			FileUtils.moveFileToDirectory(file, dir, false);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testRead(){
		File file = new File("C:\\developer_tool\\Apache Software Foundation\\Tomcat 7.0\\webapps\\myssh\\inages\\uploadList","Android基础.doc");
		try {
			String s = FileUtils.readFileToString(file,"gbk");
			FileUtils.readFileToByteArray(file);
			System.out.println(s);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
