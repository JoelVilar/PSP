package modelo;

public class PrimeNumberThread extends Thread{
	private int headNum;
	private int endNum;
	private int cont;
	private int executionTime;
	
	public PrimeNumberThread(int head,int end) {
		this.headNum=head;
		this.endNum=end;
		this.cont=0;
		this.executionTime=0;
	}
	
	@Override
	public void run() {
		Long time = System.nanoTime();
		for(int x = headNum; x < endNum; x++) {
			boolean prime=true;
			if((x%2==0 || x%3==0 || x%5==0 || x%7==0) && x>7) prime=false;
			else {
				int y = x < 7 ? 1 : 8;
				while(prime && y<x) {
					if(y!=1 && y!=x)prime = x%y==0 ? false : true;
					y++;
				}
			}
			if(prime) {
				cont++;
			}
		}
	}

	public int getHeadNum() {
		return headNum;
	}

	public void setHeadNum(int headNum) {
		this.headNum = headNum;
	}

	public int getEndNum() {
		return endNum;
	}

	public void setEndNum(int endNum) {
		this.endNum = endNum;
	}

	public int getCont() {
		return cont;
	}

	public void setCont(int cont) {
		this.cont = cont;
	}

	public int getExecutionTime() {
		return executionTime;
	}

	public void setExecutionTime(int executionTime) {
		this.executionTime = executionTime;
	}
}
