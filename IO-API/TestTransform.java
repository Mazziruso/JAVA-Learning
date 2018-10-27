package Demo;
import java.io.*;

public class TestTransform {
	
	public static void main(String[] args) {
		String dir = new String("E:\\\\JavaWorkspace\\\\JavaCode\\\\char.txt");
		try {
			OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(dir));
			osw.write("Microsoftibmsunjavaeclipse");
			System.out.println(osw.getEncoding());
			osw.close();
			osw = new OutputStreamWriter(new FileOutputStream(dir, true), "ISO8859_1");
			osw.write("Microsoftibmsunjavaeclipse");
			System.out.println(osw.getEncoding());
			osw.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

}
