package co.project.bench;
import java.io.File;
import java.util.Scanner;
import java.util.Random;

public class Benchmark implements IBenchmark {
	private int []a;
	private boolean running;
	 public void initialize(Object... objects)
	 {
		 running=true;

	 }
	 public void run() {
		 
		 int n = a.length;
		 for (int i = 0; i < n - 1 && running; i++)
			 for (int j = 0; j < n - i - 1 && running; j++)
				 if (a[j] > a[j + 1])
				 {
					 int temp = a[j];
					 a[j] = a[j+1];
					 a[j+1] = temp;
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
