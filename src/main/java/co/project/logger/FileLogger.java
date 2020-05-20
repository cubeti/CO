package co.project.logger;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileLogger implements ILogger {
    BufferedWriter writer = null;

    public FileLogger(String s) {
        try {
            File output = new File(s);
            if (output.createNewFile()) {
                System.out.println("File created: " + output.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        try {
            writer = new BufferedWriter(new FileWriter(s));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void write(long n) {
        try {
            writer.write(Long.toString(n));
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public void write(String s) {
        try {
            writer.write(s);
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void write(Object... values) {
        try {
            for (Object value : values) writer.write(value+ " ");
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public void WriteTime(String s,long n,TimeUnit u)
	{
		double x;
		if(u==TimeUnit.micro)
		{
			x=n/1000.0;
			try{writer.write(s+" "+x+" micro");}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else if(u==TimeUnit.milli)
		{
			x=n/1000000.0;
			try{writer.write(s+" "+x+" milli");}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else 
			{
				x=n/1000000000.0;
				try{writer.write(s+" "+x+" sec");}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		
	}
    public void close()
    {
    	try{writer.close();}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
}

