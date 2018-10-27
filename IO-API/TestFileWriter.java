package Demo;
import java.io.*;

public class TestFileWriter {
	
	public static void main(String[] args) {

		FileWriter f = null;
		String dir = new String("E:\\\\JavaWorkspace\\\\JavaCode\\\\TestFileWriter1.bak");
		
		try {
			f = new FileWriter(dir);
		} catch(IOException e) {
			System.out.println("File read or save error!");
			System.exit(-1);
		}
		
		try {
			for(int c=0; c<50000; c++) {
				f.write(c);
			}
			f.close();
		} catch(IOException e1) {
			System.out.println("File read error!");
			System.exit(-1);
		}
		
		System.out.println();
		System.out.println("File read successfully!");
	}

}
