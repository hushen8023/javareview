package com.hushen.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class CopyFile {
	static public void main(String args[]) throws Exception {
		if (args.length < 2) {
			System.err.println("Usage: java CopyFile infile outfile");
			System.exit(1);
		}

		String infile = args[0];
		String outfile = args[1];
		//输入字节流
		FileInputStream fin = new FileInputStream(infile);
		//输出字节流
		FileOutputStream fout = new FileOutputStream(outfile);
		//获取输入通道
		FileChannel fcin = fin.getChannel();
		//获取输出通道
		FileChannel fcout = fout.getChannel();
		//创建缓冲区
		ByteBuffer buffer = ByteBuffer.allocate(1024);

		while (true) {
			//缓冲区清空
			buffer.clear();
			//把输入字节流读到的数据读到缓冲区中，position开始依次增加
			int r = fcin.read(buffer);
			//r=-1表示缓冲区读完了
			if (r == -1) {
				break;
			}
			//反转buffer，position设置为0，这样就输出流就可以从缓冲区中读到数据了
			buffer.flip();
			//输出流从缓冲区中读取数据并写入outfile文件
			fcout.write(buffer);
		}
	}
}
