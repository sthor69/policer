package com.storassa.javase.policercomparison;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.omg.DynamicAny.DynAnyPackage.InvalidValue;

@Entity
public abstract class Policer implements Serializable {
	protected int cir;
        protected int cPeriod;
	protected int cbs;
	protected transient int cBucket;
        protected transient int elapsedCTicks;
        @Id
        protected String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

	public Policer() {
		cBucket = cbs;
		cir = 1;
		cbs = 1;
                elapsedCTicks = 0;
	}
        
        public void tick() {
            elapsedCTicks++;
            if (elapsedCTicks > cPeriod) {
                elapsedCTicks = 0;
                incrementCBucket();
            }
        }
        
        private void incrementCBucket() {
            if (cBucket < cbs)
                cBucket++;
        }

	abstract PacketColor check(int size);

	public int getCir() {
		return cir;
	}

	public void setCir (int cir) {
		if (cir > 0) {
			this.cir = cir;
                        cPeriod = TICK_GRANULARITY / cir;
                }
                else
                    throw new IllegalArgumentException("CIR cannot be negative or zero");
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
        
        protected static final int TICK_GRANULARITY = 1000000;

}
