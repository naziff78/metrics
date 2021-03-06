/*
 * Created on 29 avr. 2016 ( Time 14:11:56 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.bean;

import java.io.Serializable;

import javax.validation.constraints.*;

import java.util.Date;

public class Timers implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @NotNull
    private Integer id;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @NotNull
    private Integer idMetricsRegistry;

    @Size( max = 255 )
    private String nom;

    @Size( max = 2147483647 )
    private String count;


    private Double meanRate;


    private Double oneMinuteRate;


    private Double fiveMinuteRate;


    private Double fifteenMinuteRate;

    @Size( max = 2147483647 )
    private String min;

    @Size( max = 2147483647 )
    private String max;


    private Double mean;


    private Integer stddev;


    private Double median;


    private Double seventyFivePercent;


    private Double ninetyFivePercent;


    private Double ninetyHeightPercent;


    private Double ninetyNinePercent;


    private Double ninetyNinePercentPointNine;


    private Date dateCreation;


    private Date dateModification;



    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setId( Integer id ) {
        this.id = id ;
    }

    public Integer getId() {
        return this.id;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    public void setIdMetricsRegistry( Integer idMetricsRegistry ) {
        this.idMetricsRegistry = idMetricsRegistry;
    }
    public Integer getIdMetricsRegistry() {
        return this.idMetricsRegistry;
    }

    public void setNom( String nom ) {
        this.nom = nom;
    }
    public String getNom() {
        return this.nom;
    }

    public void setCount( String count ) {
        this.count = count;
    }
    public String getCount() {
        return this.count;
    }

    public void setMeanRate( Double meanRate ) {
        this.meanRate = meanRate;
    }
    public Double getMeanRate() {
        return this.meanRate;
    }

    public void setOneMinuteRate( Double oneMinuteRate ) {
        this.oneMinuteRate = oneMinuteRate;
    }
    public Double getOneMinuteRate() {
        return this.oneMinuteRate;
    }

    public void setFiveMinuteRate( Double fiveMinuteRate ) {
        this.fiveMinuteRate = fiveMinuteRate;
    }
    public Double getFiveMinuteRate() {
        return this.fiveMinuteRate;
    }

    public void setFifteenMinuteRate( Double fifteenMinuteRate ) {
        this.fifteenMinuteRate = fifteenMinuteRate;
    }
    public Double getFifteenMinuteRate() {
        return this.fifteenMinuteRate;
    }

    public void setMin( String min ) {
        this.min = min;
    }
    public String getMin() {
        return this.min;
    }

    public void setMax( String max ) {
        this.max = max;
    }
    public String getMax() {
        return this.max;
    }

    public void setMean( Double mean ) {
        this.mean = mean;
    }
    public Double getMean() {
        return this.mean;
    }

    public void setStddev( Integer stddev ) {
        this.stddev = stddev;
    }
    public Integer getStddev() {
        return this.stddev;
    }

    public void setMedian( Double median ) {
        this.median = median;
    }
    public Double getMedian() {
        return this.median;
    }

    public void setSeventyFivePercent( Double seventyFivePercent ) {
        this.seventyFivePercent = seventyFivePercent;
    }
    public Double getSeventyFivePercent() {
        return this.seventyFivePercent;
    }

    public void setNinetyFivePercent( Double ninetyFivePercent ) {
        this.ninetyFivePercent = ninetyFivePercent;
    }
    public Double getNinetyFivePercent() {
        return this.ninetyFivePercent;
    }

    public void setNinetyHeightPercent( Double ninetyHeightPercent ) {
        this.ninetyHeightPercent = ninetyHeightPercent;
    }
    public Double getNinetyHeightPercent() {
        return this.ninetyHeightPercent;
    }

    public void setNinetyNinePercent( Double ninetyNinePercent ) {
        this.ninetyNinePercent = ninetyNinePercent;
    }
    public Double getNinetyNinePercent() {
        return this.ninetyNinePercent;
    }

    public void setNinetyNinePercentPointNine( Double ninetyNinePercentPointNine ) {
        this.ninetyNinePercentPointNine = ninetyNinePercentPointNine;
    }
    public Double getNinetyNinePercentPointNine() {
        return this.ninetyNinePercentPointNine;
    }

    public void setDateCreation( Date dateCreation ) {
        this.dateCreation = dateCreation;
    }
    public Date getDateCreation() {
        return this.dateCreation;
    }

    public void setDateModification( Date dateModification ) {
        this.dateModification = dateModification;
    }
    public Date getDateModification() {
        return this.dateModification;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
 
        public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append(id);
        sb.append("|");
        sb.append(idMetricsRegistry);
        sb.append("|");
        sb.append(nom);
        // attribute 'count' not usable (type = String Long Text)
        sb.append("|");
        sb.append(meanRate);
        sb.append("|");
        sb.append(oneMinuteRate);
        sb.append("|");
        sb.append(fiveMinuteRate);
        sb.append("|");
        sb.append(fifteenMinuteRate);
        // attribute 'min' not usable (type = String Long Text)
        // attribute 'max' not usable (type = String Long Text)
        sb.append("|");
        sb.append(mean);
        sb.append("|");
        sb.append(stddev);
        sb.append("|");
        sb.append(median);
        sb.append("|");
        sb.append(seventyFivePercent);
        sb.append("|");
        sb.append(ninetyFivePercent);
        sb.append("|");
        sb.append(ninetyHeightPercent);
        sb.append("|");
        sb.append(ninetyNinePercent);
        sb.append("|");
        sb.append(ninetyNinePercentPointNine);
        sb.append("|");
        sb.append(dateCreation);
        sb.append("|");
        sb.append(dateModification);
        return sb.toString(); 
    } 


}
