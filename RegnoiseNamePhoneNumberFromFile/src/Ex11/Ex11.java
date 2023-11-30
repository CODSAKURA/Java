package Ex11;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ex11 {

	public static void main(String[] args) {
		File file = new File("Name.txt");
		String inString = "";
		Map<String,Long> map = new HashMap<>();
		try {
		    BufferedReader reader = new BufferedReader(new FileReader(file));
		    while ((inString = reader.readLine()) != null) {
		        String[] str = inString.split(":");
		        map.put(str[0],Long.parseLong(str[1]));
		    }
		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();
		}

		Scanner input = new Scanner(System.in);
		String a = "";
		while (true){
		    System.out.print("Enter a name:");
		    a = input.next();
		    if (!a.equals("quit")){
		        if (map.containsKey(a)){
		            System.out.println("The phone number for " + a + " is:" + map.get(a));
		        } else {
		            System.out.println("The name can ont be regonised");
		        }
		        System.out.println();
		    } else {
		        return;
		    }
		}
	}
}

