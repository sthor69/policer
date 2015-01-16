package com.storassa.javase.policercomparison;

public class IETFPolicer extends Policer {
	private int pir;
        private transient int pPeriod;
	private int pbs;
        private transient int elapsedPTick;
	private transient int pBucket;
        
	public IETFPolicer() {
		super();
		
		pir = 1;
		pbs = 1;
		pBucket = 0;
                elapsedPTick = 0;
	}
        
        @Override
        public void tick() {
            super.tick();
            
            if (elapsedPTick > pPeriod) {
                elapsedPTick = 0;
                incrementPBucket();
            }
        }
        
        private void incrementPBucket() {
            if (pBucket < pbs)
                pBucket++;
        }
        
	public int getPir() {
		return pir;
	}

	public void setPir(int pir) {
            if (pir > 0) {
                pPeriod = TICK_GRANULARITY / pir;
		this.pir = pir;
            } else {
                throw new IllegalArgumentException("PIR cannot be negative or zero");
            }
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
