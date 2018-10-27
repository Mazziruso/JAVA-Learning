package Demo;
import java.io.*;

public class TestBufferIO {
	
	public static void main(String[] args) {
		String dir = new String("E:\\JavaWorkspace\\JavaCode\\data.txt");
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(dir));
			BufferedReader br = new BufferedReader(new FileReader(dir));
			String s = null;
			for(int i=0; i<100; i++) {
				s = String.valueOf(Math.random());
				bw.write(s);
				bw.newLine();
			}
			bw.flush();
			while((s = br.readLine()) != null) {
				System.out.println(s);
			}
			bw.close();
			br.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

}
