package txt;

import java.io.IOException;

public class In
{
  private static String getLine()
	{
		String line = "";
		int ch; 

		try
		{
			ch = System.in.read();
			
			while (ch != '\n')
			{
				if (ch == -1)
					return line;
				
				line += (char)ch;
				ch = System.in.read();
			}
			
			return line;
		} 
		catch (IOException ioe) {}
		
		return "";
	}

	public static String getString()
	{
		return getLine().trim();
	}
}
