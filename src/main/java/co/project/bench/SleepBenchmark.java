package co.project.bench;
public class SleepBenchmark implements IBenchmark {
	private long n;
	 public void initialize(Object... objects)
	 {
	 		n=(long)objects[0];
	 }
	 public void run() {
		 try{Thread.sleep(n);}
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
	 }
	 public void clean()
	 {
		 System.out.println("Cleaning"); 
	 }
	 public void cancel()
	 {
		 System.out.println("Canceling"); 
	 }
}

