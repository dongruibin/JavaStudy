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
	//���ļ���Ҫ�����Ƕ�дtxt�ļ�
		//1�����Ȼ��һ���ļ������File file = new File(); file��Ϊ�ļ������
		//  ����֮����ͨ�绰�����ˡ����������Կ�ʼ��绰�ˡ�
		//2��ͨ��������·��ȡ�׷�����Ϣ��new FileInputStream(file) 
		//  Ŀǰ�����Ϣ�Ѿ��������ڴ浱���ˡ���������Ҫ������ҷ��������Ķ���
		//3����Ȼ��ʹ����FileInputStream()����ô��Ӧ����Ҫʹ��InputStreamReader()
		//   ����������н���ղ�װ�����ڴ浱�е�����
		//4�������ɺ�Ҫ���ѽ���ǵ�ȻҪת����IO����ʶ�������ѽ��
		//   �Ǿ���Ҫ�����ֽ����ȡ�ķ���BufferedReader()��ͬʱʹ��bufferedReader()
		//   ��readline(��������ȡtxt�ļ��е�ÿһ�����ݹ���
		
	    //* ���ܣ�Java��ȡtxt�ļ�������
	    //* ���裺1���Ȼ���ļ����
	    //* 2������ļ��������������һ���ֽ���������Ҫ��������������ж�ȡ
	    //* 3����ȡ������������Ҫ��ȡ�����ֽ���
	    //* 4��һ��һ�е������readline()��
	    //* ��ע����Ҫ���ǵ����쳣���
		public static void readTextFile(String path){
			try{
			String encoding="GBK";
			File file=new File(path);
			if(file.isFile() && file.exists()){ //�ж��ļ��Ƿ����
	            InputStreamReader read = new InputStreamReader(
	            new FileInputStream(file),encoding);//���ǵ������ʽ
	            BufferedReader bufferedReader = new BufferedReader(read);
	            String lineTxt = null;
	            while((lineTxt = bufferedReader.readLine()) != null){
	                System.out.println(lineTxt);
	            }
	            read.close();
				}else{
					System.out.println("�Ҳ���ָ�����ļ�");
				}
			} catch (Exception e) {
				System.out.println("��ȡ�ļ����ݳ���");
				e.printStackTrace();
			}

		}
		
	//�ļ���д��	  
	public static void writeTxtFile(String content,String path)throws Exception{
		RandomAccessFile mm=null;  
		  //FileOutputStream o=null; 
		 // String encoding="GBK";
		  try {  
//		   o = new FileOutputStream(fileName);  
//		      o.write(content.getBytes("GBK"));  
//		      o.close();  
			  File file=new File(path);
				if(file.isFile() && file.exists()){ //�ж��ļ��Ƿ����
		            //�ļ�����׼������д�����
		            FileOutputStream writer=new FileOutputStream(file);
		            writer.write(content.getBytes("GBK"));
					}else{
						System.out.println("�Ҳ���ָ�����ļ�");
					} 
		  } catch (Exception e) {  
		   e.printStackTrace();  
		  }finally{  
		   if(mm!=null){  
		    mm.close();  
		   }  
		  }  
		 }  
	//�ļ���д��	
	//ʹ��+��\n�����л��в���
	public static void writeTxtFileNo(String content,String path){

		 FileOutputStream writer = null;
			  File file=new File(path);
			  //System.out.print("����writeTxtFileNo���Ե�");
				if(file.isFile() && file.exists()){ //�ж��ļ��Ƿ����
		            //�ļ�����׼������д�����
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
						System.out.println("�Ҳ���ָ�����ļ�");
					} 
				try {
					writer.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		  }  
}
