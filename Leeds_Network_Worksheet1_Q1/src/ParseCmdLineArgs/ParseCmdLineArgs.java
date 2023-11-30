package ParseCmdLineArgs;

public class ParseCmdLineArgs {

	private String[] cmdLineArgs;

	public ParseCmdLineArgs( String[] args )
	{
		if( args.length==0 )
		{
			System.out.println( "No command line arguments; quitting." );
			return;
		}
		
		//assign argument into cmdLineArgs
		cmdLineArgs = args;

		for( int i=0; i<cmdLineArgs.length; i++ )
		{
			System.out.print( "Argument " + i + " : " + cmdLineArgs[i] );		// (iii)

			//contains any dots
			if( cmdLineArgs[i].contains(".") )
			{
				System.out.print( " (may be a hostname)" );
			}
			
			//contains exactly 3 dots
			if( cmdLineArgs[i].split("[.]").length == 4 ) 
			{
				System.out.print( " (may be an IPv4 address)" );
			}

			System.out.println();
		}

	}

 public static void main( String[] args )
	{
		@SuppressWarnings("unused")
		ParseCmdLineArgs parser = new ParseCmdLineArgs(args);
	}
}
