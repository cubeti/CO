package co.project.bench;
import co.project.controllers.BenchController;
import co.project.logger.Loggs;
import co.project.timer.Timer;
public class Benchmark{
	private int iterations;
	private static int nrthreads;
	private static int size;
	private boolean running;
	final int MILLION = 1_000_000;
	 public void initialize(Object... objects)
	 {
		 nrthreads=(int)objects[0];
		 iterations=(int)objects[1];
		 size=(int)objects[2];
	 }
	 public void run() {
		 Timer t=new Timer();
		 int j,i;
		 int count = size * MILLION / nrthreads;
		 Thread[] threads;
		 running = true;
		 for(i=0;i<iterations&&running;i++) {
			 	threads = new Thread[nrthreads];
		 		t.Start();
			 for (j = 0; j < nrthreads; ++j) {
				 threads[j] = new Thread(new SquareRoot((count * j)+1, count * (j + 1)));
			 }
			 for (j = 0; j < nrthreads; ++j) {
				 threads[j].start();
			 }
			 for (j = 0; j < nrthreads; ++j) {
				 try {
					 threads[j].join();
				 } catch (InterruptedException e) {
					 e.printStackTrace();
				 }
			 }
			 Loggs.addLog(BenchController.getId(),nrthreads,t.Stop()/1000000,"run "+i);
		 }
	 }
	 public void cancel()
	 {
		running=false; 
	 }
	class SquareRoot implements Runnable {
		long time;
		private int from, to;
		private final double precision = 1e-5;
		private double result = 0.0;

		public SquareRoot(int from, int to) {
			this.from=from;
			this.to=to;
		}

		public void run() {
			for(int i=from;i<to && running;i++)
			{
				getNewtonian(i);
			}

		}

		private double getNewtonian(double x) {
			double guess=x;
			double diff=9999999.0;
			while(diff>precision)
			{
				result=guess-((guess*guess - x)/(2*guess));
				diff=Math.abs(result-guess);
				guess=result;
			}
			return result;
		}
	}
}
