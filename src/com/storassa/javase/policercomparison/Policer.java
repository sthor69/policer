package com.storassa.javase.policercomparison;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public abstract class Policer implements Serializable {
	protected int cir;
	protected int cbs;
	protected transient int cBucket;
	protected transient Thread cThread;
	protected transient boolean stopCThread;
        @Id
        protected String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

	public Policer() {
		cBucket = 0;
		cir = 1;
		cbs = 1;
		stopCThread = false;
		
		cThread = new Thread(new Runnable() {

			@Override
			public void run() {
				while (!stopCThread) {
					if (cBucket < cbs)
						cBucket++;
					try {
						Thread.sleep(1000 / cir);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		});
	}

	public void start() {

		stopCThread = false;
		cThread.start();
	}

	public void stop() {
		stopCThread = true;
	}

	abstract PacketColor check(int size);

	public int getCir() {
		return cir;
	}

	public void setCir(int cir) {
		if (cir > 0)
			this.cir = cir;
	}

	public int getCbs() {
		return cbs;
	}

	public void setCbs(int cbs) {
		if (cbs > 0)
			this.cbs = cbs;
	}
	
	public int getCBucket() {
		return cBucket;
	}

}
