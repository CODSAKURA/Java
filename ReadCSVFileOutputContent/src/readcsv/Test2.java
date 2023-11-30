package readcsv;

import java.io.*;

public class Test2 {
    public static void main(String[] args) {
        File inFile = new File("C:\\Users\\CODSAKULA\\eclipse-workspace\\ReadCSVFileOutputContent\\leeds.csv");
        String inString = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(inFile));
            while ((inString = reader.readLine()) != null) {
                String[] str = inString.split(",");
                String[] newStr = new String[8];
                if (str.length < 8) {
                    for (int i = 0; i < 8; i++) {
                        if (i < str.length) {
                            newStr[i] = str[i];
                        } else {
                            newStr[i] = "";
                        }
                    }
                } else {
                    newStr = str;
                }
                System.err.println(newStr[0] + "\t" + newStr[1] + "\t" + newStr[2] + "\t" + newStr[3] + "\t" + newStr[4] + "\t" + newStr[5] + "\t" + newStr[6] + "\t" + newStr[7]);
            }
            reader.close();
        } catch (FileNotFoundException note) {
            System.err.println("No File Existed");
        } catch (IOException ioe){
            ioe.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}