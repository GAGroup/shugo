/*package junit;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

public class TestFile {

	
	@Test
	public void testFile(){
		File file = new File("c:\\aa.txt");
		try {
			FileUtils.write(file, "fgdfsgsdfg");
			File f = new File("c:/a.txt");
			FileUtils.copyFile(f, file);
			
			file.createNewFile();
			String p = file.getParent();
			System.out.println(p);
			file.mkdir();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testFileUtils(){
		File f = new File("c:/a.txt");
		System.out.println(f);
		try {
			String s = FileUtils.readFileToString(f);
			System.out.println(s);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}

//执行上传功能
    private void uploadFile(int i) throws FileNotFoundException, IOException {
        try {
            InputStream in = new FileInputStream(file.get(i));
            String dir = ServletActionContext.getRequest().getRealPath(UPLOADDIR);
            File uploadFile = new File(dir, this.getFileFileName().get(i));
            OutputStream out = new FileOutputStream(uploadFile);
            byte[] buffer = new byte[1024 * 1024];
            int length;
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
 
            in.close();
            out.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    *
    *
    *
    *
    *
    *
    *
    *
    *
    *import org.apache.commons.io.FileUtils; 
import org.apache.commons.io.filefilter.*; 
import org.apache.commons.logging.Log; 
import org.apache.commons.logging.LogFactory;

import java.io.*;

/** 
* 文件工具箱 
* 
* @author leizhimin 2008-12-15 13:59:16 
 
public final class FileToolkit { 
        private static final Log log = LogFactory.getLog(FileToolkit.class);

        *//** 
         * 复制文件或者目录,复制前后文件完全一样。 
         * 
         * @param resFilePath 源文件路径 
         * @param distFolder    目标文件夹 
         * @IOException 当操作发生异常时抛出 
         *//* 
        public static void copyFile(String resFilePath, String distFolder) throws IOException { 
                File resFile = new File(resFilePath); 
                File distFile = new File(distFolder); 
                if (resFile.isDirectory()) { 
                        FileUtils.copyDirectoryToDirectory(resFile, distFile); 
                } else if (resFile.isFile()) { 
                        FileUtils.copyFileToDirectory(resFile, distFile, true); 
                } 
        }

        *//** 
         * 删除一个文件或者目录 
         * 
         * @param targetPath 文件或者目录路径 
         * @IOException 当操作发生异常时抛出 
         *//* 
        public static void deleteFile(String targetPath) throws IOException { 
                File targetFile = new File(targetPath); 
                if (targetFile.isDirectory()) { 
                        FileUtils.deleteDirectory(targetFile); 
                } else if (targetFile.isFile()) { 
                        targetFile.delete(); 
                } 
        }

        *//** 
         * 移动文件或者目录,移动前后文件完全一样,如果目标文件夹不存在则创建。 
         * 
         * @param resFilePath 源文件路径 
         * @param distFolder    目标文件夹 
         * @IOException 当操作发生异常时抛出 
         *//* 
        public static void moveFile(String resFilePath, String distFolder) throws IOException { 
                File resFile = new File(resFilePath); 
                File distFile = new File(distFolder); 
                if (resFile.isDirectory()) { 
                        FileUtils.moveDirectoryToDirectory(resFile, distFile, true); 
                } else if (resFile.isFile()) { 
                        FileUtils.moveFileToDirectory(resFile, distFile, true); 
                } 
        }


        *//** 
         * 重命名文件或文件夹 
         * 
         * @param resFilePath 源文件路径 
         * @param newFileName 重命名 
         * @return 操作成功标识 
         *//* 
        public static boolean renameFile(String resFilePath, String newFileName) { 
                String newFilePath = StringToolkit.formatPath(StringToolkit.getParentPath(resFilePath) + "/" + newFileName); 
                File resFile = new File(resFilePath); 
                File newFile = new File(newFilePath); 
                return resFile.renameTo(newFile); 
        }

        *//** 
         * 读取文件或者目录的大小 
         * 
         * @param distFilePath 目标文件或者文件夹 
         * @return 文件或者目录的大小，如果获取失败，则返回-1 
         *//* 
        public static long genFileSize(String distFilePath) { 
                File distFile = new File(distFilePath); 
                if (distFile.isFile()) { 
                        return distFile.length(); 
                } else if (distFile.isDirectory()) { 
                        return FileUtils.sizeOfDirectory(distFile); 
                } 
                return -1L; 
        }

        *//** 
         * 判断一个文件是否存在 
         * 
         * @param filePath 文件路径 
         * @return 存在返回true，否则返回false 
         *//* 
        public static boolean isExist(String filePath) { 
                return new File(filePath).exists(); 
        }

        *//** 
         * 本地某个目录下的文件列表（不递归） 
         * 
         * @param folder ftp上的某个目录 
         * @param suffix 文件的后缀名（比如.mov.xml) 
         * @return 文件名称列表 
         *//* 
        public static String[] listFilebySuffix(String folder, String suffix) { 
                IOFileFilter fileFilter1 = new SuffixFileFilter(suffix); 
                IOFileFilter fileFilter2 = new NotFileFilter(DirectoryFileFilter.INSTANCE); 
                FilenameFilter filenameFilter = new AndFileFilter(fileFilter1, fileFilter2); 
                return new File(folder).list(filenameFilter); 
        }

        *//** 
         * 将字符串写入指定文件(当指定的父路径中文件夹不存在时，会最大限度去创建，以保证保存成功！) 
         * 
         * @param res            原字符串 
         * @param filePath 文件路径 
         * @return 成功标记 
         *//* 
        public static boolean string2File(String res, String filePath) { 
                boolean flag = true; 
                BufferedReader bufferedReader = null; 
                BufferedWriter bufferedWriter = null; 
                try { 
                        File distFile = new File(filePath); 
                        if (!distFile.getParentFile().exists()) distFile.getParentFile().mkdirs(); 
                        bufferedReader = new BufferedReader(new StringReader(res)); 
                        bufferedWriter = new BufferedWriter(new FileWriter(distFile)); 
                        char buf[] = new char[1024];         //字符缓冲区 
                        int len; 
                        while ((len = bufferedReader.read(buf)) != -1) { 
                                bufferedWriter.write(buf, 0, len); 
                        } 
                        bufferedWriter.flush(); 
                        bufferedReader.close(); 
                        bufferedWriter.close(); 
                } catch (IOException e) { 
                        flag = false; 
                        e.printStackTrace(); 
                } 
                return flag; 
        } 
} 
-------------------------------------------------------------------------------------------------------------
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


*//**
* 字符串工具箱
*
* @author leizhimin 2008-12-15 22:40:12
*//*
public final class StringToolkit {
  *//**
  * 将一个字符串的首字母改为大写或者小写
  *
  * @param srcString 源字符串
  * @param flag     大小写标识，ture小写，false大些
  * @return 改写后的新字符串
  *//*
  public static String toLowerCaseInitial(String srcString, boolean flag) {
    StringBuilder sb = new StringBuilder();
    if (flag) {
        sb.append(Character.toLowerCase(srcString.charAt(0)));
    } else {
        sb.append(Character.toUpperCase(srcString.charAt(0)));
    }
    sb.append(srcString.substring(1));
    return sb.toString();
  }

  *//**
  * 将一个字符串按照句点（.）分隔，返回最后一段
  *
  * @param clazzName 源字符串
  * @return 句点（.）分隔后的最后一段字符串
  *//*
  public static String getLastName(String clazzName) {
    String[] ls = clazzName.split("\\.");
    return ls[ls.length - 1];
  }

  *//**
  * 格式化文件路径，将其中不规范的分隔转换为标准的分隔符,并且去掉末尾的"/"符号。
  *
  * @param path 文件路径
  * @return 格式化后的文件路径
  *//*
  public static String formatPath(String path) {
    String reg0 = "\\\\＋";
    String reg = "\\\\＋|/＋";
    String temp = path.trim().replaceAll(reg0, "/");
    temp = temp.replaceAll(reg, "/");
    if (temp.endsWith("/")) {
        temp = temp.substring(0, temp.length() - 1);
    }
    if (System.getProperty("file.separator").equals("\\")) {
      temp= temp.replace('/','\\');
    }
    return temp;
  }

  *//**
  * 格式化文件路径，将其中不规范的分隔转换为标准的分隔符,并且去掉末尾的"/"符号(适用于FTP远程文件路径或者Web资源的相对路径)。
  *
  * @param path 文件路径
  * @return 格式化后的文件路径
  *//*
  public static String formatPath4Ftp(String path) {
    String reg0 = "\\\\＋";
    String reg = "\\\\＋|/＋";
    String temp = path.trim().replaceAll(reg0, "/");
    temp = temp.replaceAll(reg, "/");
    if (temp.endsWith("/")) {
        temp = temp.substring(0, temp.length() - 1);
    }
    return temp;
  }

  public static void main(String[] args) {
    System.out.println(System.getProperty("file.separator"));
    Properties p = System.getProperties();
    System.out.println(formatPath("C:///\\xxxx\\\\\\\\\\///\\\\R5555555.txt"));

//     List<String> result = series2List("asdf | sdf|siii|sapp|aaat| ", "\\|");
//     System.out.println(result.size());
//     for (String s : result) {
//         System.out.println(s);
//     }
  }

  *//**
  * 获取文件父路径
  *
  * @param path 文件路径
  * @return 文件父路径
  *//*
  public static String getParentPath(String path) {
    return new File(path).getParent();
  }

  *//**
  * 获取相对路径
  *
  * @param fullPath 全路径
  * @param rootPath 根路径
  * @return 相对根路径的相对路径
  *//*
  public static String getRelativeRootPath(String fullPath, String rootPath) {
    String relativeRootPath = null;
    String _fullPath = formatPath(fullPath);
    String _rootPath = formatPath(rootPath);

    if (_fullPath.startsWith(_rootPath)) {
        relativeRootPath = fullPath.substring(_rootPath.length());
    } else {
        throw new RuntimeException("要处理的两个字符串没有包含关系，处理失败！");
    }
    if (relativeRootPath == null) return null;
    else
        return formatPath(relativeRootPath);
  }

  *//**
  * 获取当前系统换行符
  *
  * @return 系统换行符
  *//*
  public static String getSystemLineSeparator() {
    return System.getProperty("line.separator");
  }

  *//**
  * 将用“|”分隔的字符串转换为字符串集合列表，剔除分隔后各个字符串前后的空格
  *
  * @param series 将用“|”分隔的字符串
  * @return 字符串集合列表
  *//*
  public static List<String> series2List(String series) {
    return series2List(series, "\\|");
  }

  *//**
  * 将用正则表达式regex分隔的字符串转换为字符串集合列表，剔除分隔后各个字符串前后的空格
  *
  * @param series 用正则表达式分隔的字符串
  * @param regex 分隔串联串的正则表达式
  * @return 字符串集合列表
  *//*
  private static List<String> series2List(String series, String regex) {
    List<String> result = new ArrayList<String>();
    if (series != null && regex != null) {
        for (String s : series.split(regex)) {
          if (s.trim() != null && !s.trim().equals("")) result.add(s.trim());
        }
    }
    return result;
  }

  *//**
  * @param strList 字符串集合列表
  * @return 通过“|”串联为一个字符串
  *//*
  public static String list2series(List<String> strList) {
    StringBuffer series = new StringBuffer();
    for (String s : strList) {
        series.append(s).append("|");
    }
    return series.toString();
  }

  *//**
  * 将字符串的首字母转为小写
  *
  * @param resStr 源字符串
  * @return 首字母转为小写后的字符串
  *//*
  public static String firstToLowerCase(String resStr) {
    if (resStr == null) {
        return null;
    } else if ("".equals(resStr.trim())) {
        return "";
    } else {
        StringBuffer sb = new StringBuffer();
        Character c = resStr.charAt(0);
        if (Character.isLetter(c)) {
          if (Character.isUpperCase(c))
            c = Character.toLowerCase(c);
          sb.append(resStr);
          sb.setCharAt(0, c);
          return sb.toString();
        }
    }
    return resStr;
  }

  *//**
  * 将字符串的首字母转为大写
  *
  * @param resStr 源字符串
  * @return 首字母转为大写后的字符串
  *//*
  public static String firstToUpperCase(String resStr) {
    if (resStr == null) {
        return null;
    } else if ("".equals(resStr.trim())) {
        return "";
    } else {
        StringBuffer sb = new StringBuffer();
        Character c = resStr.charAt(0);
        if (Character.isLetter(c)) {
          if (Character.isLowerCase(c))
            c = Character.toUpperCase(c);
          sb.append(resStr);
          sb.setCharAt(0, c);
          return sb.toString();
        }
    }
    return resStr;
  }

}

    *
    *
    *
    *
    *
    *
    *
    */