package co.project.bench;
import java.io.File;
import java.util.Scanner;
import java.util.Random;

import static java.util.stream.IntStream.rangeClosed;

public class Benchmark implements IBenchmark {
	private int nrthreads;
	private int iterations;
	private boolean running;
	 public void initialize(Object... objects)
	 {
		 running=true;
		 nrthreads=(int)objects[0];
		 iterations=(int)objects[1];

	 }
	 public void run() {
		 final int MILLION = 1_000_000;
		 for (int threads = 1; threads < nrthreads; threads++) {
			 long start = System.currentTimeMillis();
			 int count = iterations * MILLION / threads;
			 rangeClosed(1, threads).parallel()
					 .forEach(i -> rangeClosed(1, count).mapToDouble(Math::sqrt).sum());

			 System.out.println(String.format("Benchmark of %d M iterations on %d thread(s): %d ms", iterations, threads, System.currentTimeMillis() - start));
		 }
	 }
	 public void clean()
	 {
		 System.out.println("Cleaning"); 
	 }
	 public void cancel()
	 {
		running=false; 
	 }
}
