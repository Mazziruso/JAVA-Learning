package Demo;
import java.io.*;
import java.util.*;

public class TestPrintStream2 {
	
	public static void main(String[] args) {
		String dir = new String("E:\\\\JavaWorkspace\\\\JavaCode\\\\logfile.log");
		String s = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			FileWriter fw = new FileWriter(dir, true);
			PrintWriter log = new PrintWriter(fw);
			while((s=br.readLine()) != null) {
				if(s.equalsIgnoreCase("exit")) {
					break;
				}
				System.out.println(s.toUpperCase());
				log.println("-----");
				log.println(s.toUpperCase());
			}
			log.println("===" + new Date() + "===");
			log.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

}
