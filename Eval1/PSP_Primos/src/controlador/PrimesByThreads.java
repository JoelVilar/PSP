package controlador;

import java.util.ArrayList;

import modelo.PrimeNumberThread;

public class PrimesByThreads {
	private float executionTime;
	
	public PrimesByThreads() {
		this.executionTime=0;
	}
	
	public void run(int desiredNumOfThreads) throws InterruptedException{
		ArrayList<PrimeNumberThread> threadArray = new ArrayList<>();
		ArrayList<int[]> HeadNEnd= getLimits(desiredNumOfThreads);
		Long time=null;
		
		for(int x = 0; x < desiredNumOfThreads;x++) {
			threadArray.add(new PrimeNumberThread(
					HeadNEnd.get(x)[0],
					HeadNEnd.get(x)[1])
					);
			if(x==0) time = System.nanoTime();
			threadArray.get(x).start();
			System.out.println("Hilo " + (x+1) +  " en marcha.");
		}
		
		threadArray.get(desiredNumOfThreads - 1).join();
		executionTime = (float)(System.nanoTime()-time);
		
		int totalPrimes=0;
		for(int x=0; x<threadArray.size();x++) {
			totalPrimes+=threadArray.get(x).getCont();
			executionTime+=threadArray.get(x).getExecutionTime();
		}
		System.out.println("Se han econtrado un total de " + totalPrimes + " números primos"
				+ " en " + executionTime/1000000000 + " segundos,"
				+ " con " + desiredNumOfThreads + " hilos.");
	}
	
	public ArrayList<int[]> getLimits(int desiredNumOfThreads){
		ArrayList<int[]> limits = new ArrayList<>();
		int groupOfPrimes = 100000/desiredNumOfThreads;
		int lastLimit=groupOfPrimes;
		
		int[] firstHeadNEndNums= {2,lastLimit};
		limits.add(firstHeadNEndNums);
		
		for(int x = 2; x <= desiredNumOfThreads;x++) {
			int headNEnd[]= {lastLimit+1,lastLimit = groupOfPrimes*x};
			limits.add(headNEnd);
		}
		return limits;
	}
}
