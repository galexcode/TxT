package txt;

import static txt.Global.EOF;

public class Formatter
{  
	private Storage raw;
	private Storage parsed;
	private int lineWidth = 20;
	
	public Formatter(Storage rawText, Storage parsedText)
	{
		raw = rawText;
		parsed = parsedText;
	}
	
	private boolean isCmd(String word)
	{
		return word.startsWith(".");
	}
	
	private String addSpaces(int number)
    {
        String spaces = "";

        for (int i = 0; i < number; i++)
            spaces += " ";

        return spaces;
    }

    private String justify(String[] words, int allSpaces)
    {
        int realSpaces = words.length - 1;   

        int evenSpaces = allSpaces / realSpaces;
        int pool = allSpaces % realSpaces;
        
        String line = "";
        
        for (String word : words)
        	line += word + " " + addSpaces(evenSpaces) + (pool-- > 0 ? " " : "");
        
        return line.trim();
    }
    
    private String justify(String line)
    {
        while (line.length() < lineWidth)
            line += " ";
        
        return line;
    }

    public void process()
    {
    	boolean stop = false;
    	
    	while (!stop)
		  {
	    	String line = raw.next();
	    	String word = "";
	    	
	    	while (!stop && line.length() + 1 + raw.nextLength() <= lineWidth)
	    	{
	    		//word = raw.next();
	    		
	    		if ((word = raw.next()).equals(EOF))
	    			stop = true;
	    		else
	    			line += " " + word;
	    	}
	    	
	        String[] words = line.split(" ");
	        
	        if (words.length == 1)
	            line = justify(words[0]);
	        else
	        {
	            int spaces = lineWidth - line.length();
	            line = justify(words, spaces);
	        }
	
	        parsed.store(line.replace(" ", "."));
		  }
    }
}
