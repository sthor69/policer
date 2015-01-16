/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.storassa.javase.policercomparison;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author storassa
 */

@Entity
public class Source implements Serializable {
    
    private SourceType sourceType;
    private int low, high;
    private double slope, period;
    @Id
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SourceType getSourceType() {
        return sourceType;
    }

    public void setSourceType(SourceType sourceType) {
        this.sourceType = sourceType;
    }

    public int getLow() {
        return low;
    }

    public void setLow(int low) {
        if (low <= high)
            this.low = low;
    }

    public int getHigh() {
        return high;
    }

    public void setHigh(int high) {
        if (high >= low)
            this.high = high;
    }

    public double getSlope() {
        return slope;
    }

    public void setSlope(double slope) {
        this.slope = slope;
    }

    public double getPeriod() {
        return period;
    }

    public void setPeriod(double period) {
        this.period = period;
    }
    
    
    
}
