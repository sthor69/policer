package com.storassa.javase.policercomparison;

public class MEFPolicer extends Policer {
	private int eir;
	private int ebs;
	private transient int eBucket;
	private transient boolean stopEThread;
	private transient Thread eThread;
	
	public MEFPolicer() {
		super();
		
		eir = 1;
		ebs = 1;
		eBucket = 0;
		stopEThread = false;
		
		eThread = new Thread(new Runnable() {

			@Override
			public void run() {
				while (!stopEThread) {
					if (eBucket < ebs)
						eBucket++;
					try {
						Thread.sleep(1000/eir);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}});
		
	}
	
	public int getEir() {
		return eir;
	}
	public void setEir(int eir) {
		this.eir = eir;
	}
	public int getEbs() {
		return ebs;
	}
	public void setEbs(int ebs) {
		this.ebs = ebs;
	}
	@Override
	PacketColor check(int size) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public int getEBucket() {
		return eBucket;
	}

}
