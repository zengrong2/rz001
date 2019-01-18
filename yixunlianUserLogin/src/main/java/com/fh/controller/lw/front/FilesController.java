package com.fh.controller.lw.front;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveInputStream;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;


@Controller  
@RequestMapping("file")  
public class FilesController {
	
	
	/**
	 * 图片上传
	 * @param file
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	 @RequestMapping("/onefile")  
	    public ResponseEntity<String> oneFileUpload( @RequestParam("file") CommonsMultipartFile file) throws IllegalStateException, IOException {  
			String fileName = file.getOriginalFilename();  
			
	    	fileName=FileNameUtil.rename(fileName);//文件重命名 
	        String path = "C:\\uploadFiles\\yxjy\\"+fileName+".jpg";
	        File f = new File(path);  
	        file.transferTo(f);
	        path=path.replaceAll("C:\\\\","/");
	        path=path.replaceAll("\\\\", "/");
	        return ResponseEntity.ok(path);
	    }  
	 /**
	  * 文件
	  * 
	  * @param file
	  * @return
	  * @throws IllegalStateException
	  * @throws IOException
	  */
	 @RequestMapping("/xxFileUpload")  
	    public ResponseEntity<String> xxFileUpload( @RequestParam("file") CommonsMultipartFile file) throws IllegalStateException, IOException {  
			String fileName = file.getOriginalFilename();  
	    	fileName=FileNameUtil.rename(fileName);//文件重命名 
	        String path = "C:\\uploadFiles\\yxjy\\xuexiao\\"+fileName;
	        String path1= path.replaceAll(".zip","");
	        File f = new File(path);  
	        file.transferTo(f);
	        decompressZip(path, path1);
	        path1=path1.replaceAll("C:\\\\","/");
	        path1=path1.replaceAll("\\\\", "/");
	        return ResponseEntity.ok(path1+"/h5/index.html");
	    }  
	 
	 /**
	  * 解压
	  * @param zipFilePath
	  * @param saveFileDir
	  */
	 public static void decompressZip(String zipFilePath,String saveFileDir) {
		    if(!saveFileDir.endsWith("\\") && !saveFileDir.endsWith("/") ){  
		             saveFileDir += File.separator;  
		         }  
		         File dir = new File(saveFileDir);  
		         //判断是否存在该目录
		         if(!dir.exists()){  
		             dir.mkdirs();  
		         }  
		         File file = new File(zipFilePath);  
		         //判断是否存在该文件
		         if (file.exists()) {  
		             InputStream is = null;   
		             ZipArchiveInputStream zas = null;  
		             try {  
		                 is = new FileInputStream(file);  
		                 zas = new ZipArchiveInputStream(is,"GBK");  
		                 ArchiveEntry archiveEntry = null;
		                 //遍历获取文件名称
		                 while ((archiveEntry = zas.getNextEntry()) != null) {   
		                     // 获取压缩文件中的名称
		                     String entryFileName = archiveEntry.getName();  
		                     //解压后的文件存放路径
		                     String entryFilePath = saveFileDir + entryFileName;  
		                     OutputStream os = null;  
		                     try {  
		                         // 将解压出的文件写到指定路径  
		                         File entryFile = new File(entryFilePath);  
		                         if(entryFileName.endsWith("/")){  
		                             entryFile.mkdirs();  
		                         }else{  
		                             os = new BufferedOutputStream(new FileOutputStream(entryFile));                              
		                             byte[] buffer = new byte[1024 ];   
		                             int len = -1;   
		                             while((len = zas.read(buffer)) != -1) {  
		                                 os.write(buffer, 0, len);   
		                             }  
		                         }  
		                     } catch (IOException e) {  
		                         throw new IOException(e);  
		                     } finally {  
		                         if (os != null) {  
		                             os.flush();  
		                             os.close();  
		                         }  
		                     }  
		                 }   
		             } catch (Exception e) {  
		                 throw new RuntimeException(e);  
		             } finally {  
		                 try {  
		                     if (zas != null) {  
		                         zas.close();  
		                     }  
		                     if (is != null) {  
		                    is.close();  
		                     }  
		                 } catch (Exception e) {  
		                     throw new RuntimeException(e);  
		                 }  
		             }  
		         }  
		    }
	
}
