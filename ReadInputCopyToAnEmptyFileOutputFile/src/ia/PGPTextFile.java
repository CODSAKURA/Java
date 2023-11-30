package ia;

public class PGPTextFile extends PGPText 
{
	public static void main( String[] args )
	{
		PGPTextFile textfile = new PGPTextFile();
		textfile.load( "input.txt" );
		textfile.save( "output.txt");
	}
	
	public PGPTextFile()
	{
		file = new PGPFile();
		addLine("Hello,My name is Zhoudi");
	}
	
	PGPFile file;
	
	void load( String filename )
	{
		if(file.openReadFile(filename))
		{
			
		}
		else
			System.out.println("Error opening file");
	}
	
	void save( String filename )
	{
		if(file.openWriteFile(filename)) {
			for ( int i = 0 ; i < this.getLineCount() ; i++ )
				file.writeLine( this.getLine(i) );
			file.closeWriteFile();
		}
		else
			System.out.println("Error saving file");
	}
}
