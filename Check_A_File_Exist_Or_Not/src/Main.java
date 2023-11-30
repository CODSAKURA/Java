

import java.io.File;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		File tmp = new File("tmp/test","tmp.txt");
		System.out.println(tmp.exists());
		
		File tmp2 = new File("tmp/test/tmp.txt");
		System.out.print(tmp2.exists());				
	}

}
