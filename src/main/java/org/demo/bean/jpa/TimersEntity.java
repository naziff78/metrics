/*
 * Created on 29 avr. 2016 ( Time 13:45:10 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 

package org.demo.bean.jpa;

import java.io.Serializable;

//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;

import java.util.Date;

import javax.persistence.*;

/**
 * Persistent class for entity stored in table "timers"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="timers", catalog="metrics" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="TimersEntity.countAll", query="SELECT COUNT(x) FROM TimersEntity x" )
} )
public class TimersEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id", nullable=false)
    private Integer    id           ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="nom", length=255)
    private String     nom          ;

    @Column(name="count")
    private String     count        ;

    @Column(name="mean_rate")
    private Double     meanRate     ;

    @Column(name="one_minute_rate")
    private Double     oneMinuteRate ;

    @Column(name="five_minute_rate")
    private Double     fiveMinuteRate ;

    @Column(name="fifteen_minute_rate")
    private Double     fifteenMinuteRate ;

    @Column(name="min")
    private String     min          ;

    @Column(name="max")
    private String     max          ;

    @Column(name="mean")
    private Double     mean         ;

    @Column(name="stddev")
    private Integer    stddev       ;

    @Column(name="median")
    private Double     median       ;

    @Column(name="seventy_five_percent")
    private Double     seventyFivePercent ;

    @Column(name="ninety_five_percent")
    private Double     ninetyFivePercent ;

    @Column(name="ninety_height_percent")
    private Double     ninetyHeightPercent ;

    @Column(name="ninety_nine_percent")
    private Double     ninetyNinePercent ;

    @Column(name="ninety_nine_percent_point_nine")
    private Double     ninetyNinePercentPointNine ;

    @Temporal(TemporalType.DATE)
    @Column(name="date_creation")
    private Date       dateCreation ;

    @Temporal(TemporalType.DATE)
    @Column(name="date_modification")
    private Date       dateModification ;

	// "idMetricsRegistry" (column "id_metrics_registry") is not defined by itself because used as FK in a link 


    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    @ManyToOne
    @JoinColumn(name="id_metrics_registry", referencedColumnName="id")
    private MetricsRegistryEntity metricsRegistry;


    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public TimersEntity() {
		super();
    }
    
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
    //--- DATABASE MAPPING : nom ( VARCHAR ) 
    public void setNom( String nom ) {
        this.nom = nom;
    }
    public String getNom() {
        return this.nom;
    }

    //--- DATABASE MAPPING : count ( LONGTEXT ) 
    public void setCount( String count ) {
        this.count = count;
    }
    public String getCount() {
        return this.count;
    }

    //--- DATABASE MAPPING : mean_rate ( DOUBLE ) 
    public void setMeanRate( Double meanRate ) {
        this.meanRate = meanRate;
    }
    public Double getMeanRate() {
        return this.meanRate;
    }

    //--- DATABASE MAPPING : one_minute_rate ( DOUBLE ) 
    public void setOneMinuteRate( Double oneMinuteRate ) {
        this.oneMinuteRate = oneMinuteRate;
    }
    public Double getOneMinuteRate() {
        return this.oneMinuteRate;
    }

    //--- DATABASE MAPPING : five_minute_rate ( DOUBLE ) 
    public void setFiveMinuteRate( Double fiveMinuteRate ) {
        this.fiveMinuteRate = fiveMinuteRate;
    }
    public Double getFiveMinuteRate() {
        return this.fiveMinuteRate;
    }

    //--- DATABASE MAPPING : fifteen_minute_rate ( DOUBLE ) 
    public void setFifteenMinuteRate( Double fifteenMinuteRate ) {
        this.fifteenMinuteRate = fifteenMinuteRate;
    }
    public Double getFifteenMinuteRate() {
        return this.fifteenMinuteRate;
    }

    //--- DATABASE MAPPING : min ( LONGTEXT ) 
    public void setMin( String min ) {
        this.min = min;
    }
    public String getMin() {
        return this.min;
    }

    //--- DATABASE MAPPING : max ( LONGTEXT ) 
    public void setMax( String max ) {
        this.max = max;
    }
    public String getMax() {
        return this.max;
    }

    //--- DATABASE MAPPING : mean ( DOUBLE ) 
    public void setMean( Double mean ) {
        this.mean = mean;
    }
    public Double getMean() {
        return this.mean;
    }

    //--- DATABASE MAPPING : stddev ( INT ) 
    public void setStddev( Integer stddev ) {
        this.stddev = stddev;
    }
    public Integer getStddev() {
        return this.stddev;
    }

    //--- DATABASE MAPPING : median ( DOUBLE ) 
    public void setMedian( Double median ) {
        this.median = median;
    }
    public Double getMedian() {
        return this.median;
    }

    //--- DATABASE MAPPING : seventy_five_percent ( DOUBLE ) 
    public void setSeventyFivePercent( Double seventyFivePercent ) {
        this.seventyFivePercent = seventyFivePercent;
    }
    public Double getSeventyFivePercent() {
        return this.seventyFivePercent;
    }

    //--- DATABASE MAPPING : ninety_five_percent ( DOUBLE ) 
    public void setNinetyFivePercent( Double ninetyFivePercent ) {
        this.ninetyFivePercent = ninetyFivePercent;
    }
    public Double getNinetyFivePercent() {
        return this.ninetyFivePercent;
    }

    //--- DATABASE MAPPING : ninety_height_percent ( DOUBLE ) 
    public void setNinetyHeightPercent( Double ninetyHeightPercent ) {
        this.ninetyHeightPercent = ninetyHeightPercent;
    }
    public Double getNinetyHeightPercent() {
        return this.ninetyHeightPercent;
    }

    //--- DATABASE MAPPING : ninety_nine_percent ( DOUBLE ) 
    public void setNinetyNinePercent( Double ninetyNinePercent ) {
        this.ninetyNinePercent = ninetyNinePercent;
    }
    public Double getNinetyNinePercent() {
        return this.ninetyNinePercent;
    }

    //--- DATABASE MAPPING : ninety_nine_percent_point_nine ( DOUBLE ) 
    public void setNinetyNinePercentPointNine( Double ninetyNinePercentPointNine ) {
        this.ninetyNinePercentPointNine = ninetyNinePercentPointNine;
    }
    public Double getNinetyNinePercentPointNine() {
        return this.ninetyNinePercentPointNine;
    }

    //--- DATABASE MAPPING : date_creation ( DATE ) 
    public void setDateCreation( Date dateCreation ) {
        this.dateCreation = dateCreation;
    }
    public Date getDateCreation() {
        return this.dateCreation;
    }

    //--- DATABASE MAPPING : date_modification ( DATE ) 
    public void setDateModification( Date dateModification ) {
        this.dateModification = dateModification;
    }
    public Date getDateModification() {
        return this.dateModification;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------
    public void setMetricsRegistry( MetricsRegistryEntity metricsRegistry ) {
        this.metricsRegistry = metricsRegistry;
    }
    public MetricsRegistryEntity getMetricsRegistry() {
        return this.metricsRegistry;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(id);
        sb.append("]:"); 
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
