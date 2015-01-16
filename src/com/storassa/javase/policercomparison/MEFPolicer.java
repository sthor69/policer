package com.storassa.javase.policercomparison;

public class MEFPolicer extends Policer {

    private int eir;
    private transient int ePeriod;
    private int ebs;
    private transient int elapsedETick;
    private transient int eBucket;

    public MEFPolicer() {
        super();

        eir = 1;
        ebs = 1;
        eBucket = 0;
        elapsedETick = 0;
    }
    
    @Override
    public void tick() {
        super.tick();
        
        elapsedETick++;
        if (elapsedETick > ePeriod) {
            elapsedETick = 0;
            incrementEBucket();
        }
    }
    
    private void incrementEBucket() {
        if (eBucket < ebs)
            eBucket++;
    }

    public int getEir() {
        return eir;
    }

    public void setEir(int eir) {
        if (eir > 0) {
            ePeriod = TICK_GRANULARITY / eir;
            this.eir = eir;
        } else {
            throw new IllegalArgumentException("EIR cannot be negative or zero");
        }
    }

    public int getEbs() {
        return ebs;
    }

    public void setEbs(int ebs) {
        this.ebs = ebs;
    }

    @Override
    PacketColor check(int size) {
        
        if (size > cBucket) {
            if (size > eBucket) {
                return PacketColor.RED;
            } else {
                eBucket -= size;
                return PacketColor.YELLOW;
            }
        } else {
            cBucket -= size;
            return PacketColor.GREEN;
        }
    }

    public int getEBucket() {
        return eBucket;
    }

}
