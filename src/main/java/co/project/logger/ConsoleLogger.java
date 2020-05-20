package co.project.logger;
public class ConsoleLogger implements ILogger {


	public void write(long n)
	{
		System.out.println(n);
	}
	public void write(String s) {System.out.println(s);}

	@Override
	public void write(Object... values) {
			for(Object value : values) System.out.print(value.toString());
			System.out.println();
		}
	}

