package Demo;
import java.io.*;

public class TestFileInputStream {
	
	public static void main(String[] args) {
		int b = 0;
		FileInputStream in = null;
		FileOutputStream out = null;
		String dir = new String("E:\\JavaWorkspace\\JavaCode\\TestArgsWords.java");
		String dir_out = new String("E:\\\\JavaWorkspace\\\\JavaCode\\\\TestOutputStream.java");
		
		try {
			in = new FileInputStream(dir);
			out = new FileOutputStream(dir_out);
		} catch (FileNotFoundException e) {
			System.out.println("Can not find file");
			System.exit(-1);
		}
		
		try {
			long num = 0;
			while((b = in.read()) != -1) {
				System.out.print((char)b);
				num++;
				out.write(b);
			}
			
			in.close();
			out.close();
			System.out.println();
			System.out.println("共读取" + num + "个文件");
		} catch (IOException e1) {
			System.out.println("File read or copy error!");
			System.exit(-1);
		}
		
		System.out.println("File copy successfully!");
	}

}
