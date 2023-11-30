package read;

public class The{
	public static void main(String[] args) {
		// Create an object to hold the lines
		PGPText text = new PGPText();
		// Create an object to deal with the files
		PGPFile file = new PGPFile();
		file.openReadFile("MyTestFileIn.txt");
		String strLine;
		while ( (strLine = file.readNextLine()) != null )
		{
		text.addLine(strLine);
		}
		file.closeReadFile();
		
		int i = 0;
		for ( i = 0 ; i < text.getLineCount(); i++ )
		{
		String str = text.getLine(i);
		str = str.replace('a', 'b');
		text.setLine(i, str);
		}
		file.openWriteFile("MyTestFileOut.txt");
		for ( i = 0 ; i < text.getLineCount(); i++ )
		{
		file.writeLine
		(text.getLine(i));
		}
		file.closeWriteFile();
	}

}
