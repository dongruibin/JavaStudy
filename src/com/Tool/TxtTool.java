package com.Tool;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;

public class TxtTool {
	//本文件主要作用是读写txt文件
		//1、首先获得一个文件句柄。File file = new File(); file即为文件句柄。
		//  两人之间连通电话网络了。接下来可以开始打电话了。
		//2、通过这条线路读取甲方的信息：new FileInputStream(file) 
		//  目前这个信息已经读进来内存当中了。接下来需要解读成乙方可以理解的东西
		//3、既然你使用了FileInputStream()。那么对应的需要使用InputStreamReader()
		//   这个方法进行解读刚才装进来内存当中的数据
		//4、解读完成后要输出呀。那当然要转换成IO可以识别的数据呀。
		//   那就需要调用字节码读取的方法BufferedReader()。同时使用bufferedReader()
		//   的readline(）方法读取txt文件中的每一行数据哈。
		
	    //* 功能：Java读取txt文件的内容
	    //* 步骤：1：先获得文件句柄
	    //* 2：获得文件句柄当做是输入一个字节码流，需要对这个输入流进行读取
	    //* 3：读取到输入流后，需要读取生成字节流
	    //* 4：一行一行的输出。readline()。
	    //* 备注：需要考虑的是异常情况
		public static void readTextFile(String path){
			try{
			String encoding="GBK";
			File file=new File(path);
			if(file.isFile() && file.exists()){ //判断文件是否存在
	            InputStreamReader read = new InputStreamReader(
	            new FileInputStream(file),encoding);//考虑到编码格式
	            BufferedReader bufferedReader = new BufferedReader(read);
	            String lineTxt = null;
	            while((lineTxt = bufferedReader.readLine()) != null){
	                System.out.println(lineTxt);
	            }
	            read.close();
				}else{
					System.out.println("找不到指定的文件");
				}
			} catch (Exception e) {
				System.out.println("读取文件内容出错");
				e.printStackTrace();
			}

		}
		
	//文件的写入	  
	public static void writeTxtFile(String content,String path)throws Exception{
		RandomAccessFile mm=null;  
		  //FileOutputStream o=null; 
		 // String encoding="GBK";
		  try {  
//		   o = new FileOutputStream(fileName);  
//		      o.write(content.getBytes("GBK"));  
//		      o.close();  
			  File file=new File(path);
				if(file.isFile() && file.exists()){ //判断文件是否存在
		            //文件存在准备进行写入操作
		            FileOutputStream writer=new FileOutputStream(file);
		            writer.write(content.getBytes("GBK"));
					}else{
						System.out.println("找不到指定的文件");
					} 
		  } catch (Exception e) {  
		   e.printStackTrace();  
		  }finally{  
		   if(mm!=null){  
		    mm.close();  
		   }  
		  }  
		 }  
	//文件的写入	
	//使用+“\n”进行换行操作
	public static void writeTxtFileNo(String content,String path){

		 FileOutputStream writer = null;
			  File file=new File(path);
			  //System.out.print("我是writeTxtFileNo测试的");
				if(file.isFile() && file.exists()){ //判断文件是否存在
		            //文件存在准备进行写入操作
		            //FileOutputStream writer;
					try {
						writer = new FileOutputStream(file);
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		            try {
						writer.write(content.getBytes("GBK"));
					} catch (UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					}else{
						System.out.println("找不到指定的文件");
					} 
				try {
					writer.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		  }  
}
