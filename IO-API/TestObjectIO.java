package Demo;
import java.io.*;

public class TestObjectIO {
	
	public static void main(String[] args) throws IOException{
		String dir = new String("E:\\\\JavaWorkspace\\\\JavaCode\\\\TestObjectIO.txt");
		T t = new T();
		t.k = 1.765;
		try {
			FileOutputStream fos = new FileOutputStream(dir);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(t);
			oos.flush();
			oos.close();
			
			FileInputStream fis = new FileInputStream(dir);
			ObjectInputStream ois = new ObjectInputStream(fis);
			T tReaded = (T)ois.readObject();
			System.out.println(tReaded.i + " " + tReaded.j + " " + tReaded.k + " " + tReaded.s);
		} catch(ClassNotFoundException e1) {
			e1.printStackTrace();
		}
			
		
		
	}

}

class T implements Serializable 
{
	int i = 10;
	int j = 4;
	double k = 1.25;
	String s = new String("Hello World");
}
