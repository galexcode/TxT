package txt;

import java.util.LinkedList;
import java.util.List;

import static txt.Global.*;

public class Storage
{
  private List<String> lines = new LinkedList<String>();
	private int index = 0;
	
	public void store(String text)
	{
		String[] temp = text.split(" +");
		
		for (String word : temp)
			lines.add(word);
	}
	
	public void showAll()
	{
		for (String line : lines)
			System.out.println(line);
	}
	
	public boolean EOF()
	{
		return index >= lines.size();
	}
	
	public String next()
	{
		return !EOF() ? lines.get(index++) : EOF;
	}
	
	public int nextLength()
	{
		return !EOF() ? lines.get(index).length() : -1;
	}
}
