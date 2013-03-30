package txt;

import static txt.Global.*;

public class Logic
{
  public void start()
	{
		Storage raw = new Storage();
		Storage parsed = new Storage();
		Formatter fmt = new Formatter(raw, parsed);
		
		Out.msg("#Enter text");
		String line = In.getString();
		
		while (!line.equals(".END"))
		{
			raw.store(line);
			line = In.getString();
		}
		
		fmt.process();
		
		while (!(line = parsed.next()).equals(EOF))
		{
			Out.msg(line);
		}
	}
}
