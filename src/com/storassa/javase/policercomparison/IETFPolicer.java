package com.storassa.javase.policercomparison;

public class IETFPolicer extends Policer {
	private int pir;
	private int pbs;
	private transient int pBucket;
	private transient Thread pThread;
	private transient boolean stopPThread;
        
	public IETFPolicer() {
		super();
		
		pir = 1;
		pbs = 1;
		pBucket = 0;
		stopPThread = false;

		pThread = new Thread(new Runnable() {

			@Override
			public void run() {
				while (!stopPThread) {
					if (pBucket < pbs)
						pBucket++;
					try {
						Thread.sleep(1000 / pir);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		});

	}

	@Override
	public void start() {
		super.start();
		stopPThread = false;
		pThread.start();
	}
	
	@Override
	public void stop() {
		super.stop();
		stopPThread = true;
	}

	public int getPir() {
		return pir;
	}

	public void setPir(int pir) {
		this.pir = pir;
	}

	public int getPbs() {
		return pbs;
	}

	public void setPbs(int pbs) {
		this.pbs = pbs;
	}
	
	public int getPBucket() {
		return pBucket;
	}

	@Override
	public PacketColor check(int size) {
		
		if (size > pBucket) {
			return PacketColor.RED;
		}
		else if (size > cBucket) {
			pBucket -= size;
			return PacketColor.YELLOW;
		}
		else {
			pBucket -= size;
			cBucket -= size;
			return PacketColor.GREEN;
		}
	}

}
