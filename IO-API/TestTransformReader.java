package Demo;
import java.io.*;

public class TestTransformReader {
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = null;
		try {
			while((s=br.readLine()) != null) {
				if(s.equalsIgnoreCase("exit")) {
					break;
				}
				
				System.out.println(s.toUpperCase());
			}
			br.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

}
