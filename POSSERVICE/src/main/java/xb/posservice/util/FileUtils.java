package xb.posservice.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.apache.http.util.TextUtils;


/**
 * 文件处理工具类
 * @author so
 *
 */
public class FileUtils {

	//D:/apache-tomcat-8/logs
	public static void delFile(String url, String fileName){
		if(TextUtils.isEmpty(url) || TextUtils.isEmpty(fileName)) {
			System.out.print("获取文件内容参数错误");
			return ;
		}
		File file = new File(url, fileName);
		if(file.exists())
			file.delete();
	}
	/**
	 * 获取文件内容
	 * @param url 文件路径
	 * @param fileName 文件名
	 * @return
	 */
	@SuppressWarnings("resource")
	public static String getContentFromFile(String url, String fileName,String charType) {
		if(TextUtils.isEmpty(url) || TextUtils.isEmpty(fileName)) {
			System.out.print("获取文件内容参数错误");
			return null;
		}
		File file = new File(url, fileName);
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
				System.out.print("文件没有找到");
				return null;
			}
		}
		FileInputStream fis = null;
		StringBuilder data = new StringBuilder();
		try {
			BufferedReader reader = null;
			FileInputStream inputStream = new FileInputStream(file);//context.openFileInput(file.getName());
			reader = new BufferedReader(new InputStreamReader(inputStream,charType));
			String temp = null;
            while((temp = reader.readLine()) != null){
                data.append(temp+"\n");
            }
//			fis = new FileInputStream(file);
//			buffer = new byte[fis.available()];
//			fis.read(buffer);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		if(data.toString()!=null && !TextUtils.isEmpty(data.toString())){
			return data.toString();
		}
//		if(buffer != null && buffer.length != 0) {
//			try {
//				return new String(buffer, "GBK");
//			} catch (UnsupportedEncodingException e) {
//				e.printStackTrace();
//			}
//		}
		return null;
	}
	
	/**
	 * 保存文件内容
	 * @param url 文件路径
	 * @param fileName 文件名
	 * @param content 内容
	 * @return
	 */
	public static boolean saveContent2File(String url, String fileName, String content) {
		if(TextUtils.isEmpty(url) || TextUtils.isEmpty(fileName) || TextUtils.isEmpty(content)) {
			System.out.print("保存文件参数错误");
			return false;
		}
		File file = new File(url, fileName);
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
				System.out.print("文件创建失败");
				return false;
			}
		}
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(file, true);
			fos.write(content.getBytes());
			fos.flush();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			if(fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return true;
	}
}
