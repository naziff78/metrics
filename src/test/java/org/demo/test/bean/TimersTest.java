/*
 * JUnit test case for bean Timers
 * Created on 29 avr. 2016 ( Date ISO 2016-04-29 - Time 13:45:49 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */

package org.demo.test.bean;


import java.math.BigDecimal;

import org.demo.bean.Timers ;

import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test case for bean Timers
 * 
 * @author Telosys Tools Generator
 *
 */
public class TimersTest 
{
	protected static final byte    byteValue    = 1 ;
	protected static final short   shortValue   = 1 ;
	protected static final int     intValue     = 1 ;
	protected static final int     integerValue = 1 ;
	protected static final long    longValue    = 1 ;
	
	protected static final float   floatValue    = 1.234f ;
	protected static final double  doubleValue   = 1.234 ;
	
	protected static final BigDecimal bigdecimalValue = new BigDecimal("12.3456");
	
	protected static final String  stringValue  = "A" ;
	
	protected static final java.util.Date     dateValue         = new java.util.Date();
	protected static final java.sql.Date      sqldateValue      = new java.sql.Date(dateValue.getTime());
	protected static final java.sql.Time      sqltimeValue      = new java.sql.Time(dateValue.getTime());
	protected static final java.sql.Timestamp sqltimestampValue = new java.sql.Timestamp(dateValue.getTime());

	protected static final byte[]  bytesArray  = "ABCD".getBytes() ;

	@Test
	public void testSettersAndGetters() {
		
		System.out.println("Checking class Timers getters and setters ..." );
		
		Timers timers = new Timers();
		
		//--- Test setter/getter for field "id"  ( type : Integer )
		// System.out.println(" checking field id ..." );
		timers.setId( integerValue ) ;
		Assert.assertTrue( integerValue == timers.getId() ) ;

		//--- Test setter/getter for field "idMetricsRegistry"  ( type : Integer )
		// System.out.println(" checking field idMetricsRegistry ..." );
		timers.setIdMetricsRegistry( integerValue ) ;
		Assert.assertTrue( integerValue == timers.getIdMetricsRegistry() ) ;

		//--- Test setter/getter for field "nom"  ( type : String )
		// System.out.println(" checking field nom ..." );
		timers.setNom( stringValue ) ;
		Assert.assertTrue( stringValue.equals( timers.getNom() ) ) ;

		//--- Test setter/getter for field "count"  ( type : String )
		// System.out.println(" checking field count ..." );
		timers.setCount( stringValue ) ;
		Assert.assertTrue( stringValue.equals( timers.getCount() ) ) ;

		//--- Test setter/getter for field "meanRate"  ( type : Double )
		// System.out.println(" checking field meanRate ..." );
		timers.setMeanRate( doubleValue ) ;
		Assert.assertTrue( doubleValue == timers.getMeanRate() ) ;

		//--- Test setter/getter for field "oneMinuteRate"  ( type : Double )
		// System.out.println(" checking field oneMinuteRate ..." );
		timers.setOneMinuteRate( doubleValue ) ;
		Assert.assertTrue( doubleValue == timers.getOneMinuteRate() ) ;

		//--- Test setter/getter for field "fiveMinuteRate"  ( type : Double )
		// System.out.println(" checking field fiveMinuteRate ..." );
		timers.setFiveMinuteRate( doubleValue ) ;
		Assert.assertTrue( doubleValue == timers.getFiveMinuteRate() ) ;

		//--- Test setter/getter for field "fifteenMinuteRate"  ( type : Double )
		// System.out.println(" checking field fifteenMinuteRate ..." );
		timers.setFifteenMinuteRate( doubleValue ) ;
		Assert.assertTrue( doubleValue == timers.getFifteenMinuteRate() ) ;

		//--- Test setter/getter for field "min"  ( type : String )
		// System.out.println(" checking field min ..." );
		timers.setMin( stringValue ) ;
		Assert.assertTrue( stringValue.equals( timers.getMin() ) ) ;

		//--- Test setter/getter for field "max"  ( type : String )
		// System.out.println(" checking field max ..." );
		timers.setMax( stringValue ) ;
		Assert.assertTrue( stringValue.equals( timers.getMax() ) ) ;

		//--- Test setter/getter for field "mean"  ( type : Double )
		// System.out.println(" checking field mean ..." );
		timers.setMean( doubleValue ) ;
		Assert.assertTrue( doubleValue == timers.getMean() ) ;

		//--- Test setter/getter for field "stddev"  ( type : Integer )
		// System.out.println(" checking field stddev ..." );
		timers.setStddev( integerValue ) ;
		Assert.assertTrue( integerValue == timers.getStddev() ) ;

		//--- Test setter/getter for field "median"  ( type : Double )
		// System.out.println(" checking field median ..." );
		timers.setMedian( doubleValue ) ;
		Assert.assertTrue( doubleValue == timers.getMedian() ) ;

		//--- Test setter/getter for field "seventyFivePercent"  ( type : Double )
		// System.out.println(" checking field seventyFivePercent ..." );
		timers.setSeventyFivePercent( doubleValue ) ;
		Assert.assertTrue( doubleValue == timers.getSeventyFivePercent() ) ;

		//--- Test setter/getter for field "ninetyFivePercent"  ( type : Double )
		// System.out.println(" checking field ninetyFivePercent ..." );
		timers.setNinetyFivePercent( doubleValue ) ;
		Assert.assertTrue( doubleValue == timers.getNinetyFivePercent() ) ;

		//--- Test setter/getter for field "ninetyHeightPercent"  ( type : Double )
		// System.out.println(" checking field ninetyHeightPercent ..." );
		timers.setNinetyHeightPercent( doubleValue ) ;
		Assert.assertTrue( doubleValue == timers.getNinetyHeightPercent() ) ;

		//--- Test setter/getter for field "ninetyNinePercent"  ( type : Double )
		// System.out.println(" checking field ninetyNinePercent ..." );
		timers.setNinetyNinePercent( doubleValue ) ;
		Assert.assertTrue( doubleValue == timers.getNinetyNinePercent() ) ;

		//--- Test setter/getter for field "ninetyNinePercentPointNine"  ( type : Double )
		// System.out.println(" checking field ninetyNinePercentPointNine ..." );
		timers.setNinetyNinePercentPointNine( doubleValue ) ;
		Assert.assertTrue( doubleValue == timers.getNinetyNinePercentPointNine() ) ;

		//--- Test setter/getter for field "dateCreation"  ( type : Date )
		// System.out.println(" checking field dateCreation ..." );
		timers.setDateCreation( dateValue ) ;
		Assert.assertTrue( dateValue.equals( timers.getDateCreation() ) );

		//--- Test setter/getter for field "dateModification"  ( type : Date )
		// System.out.println(" checking field dateModification ..." );
		timers.setDateModification( dateValue ) ;
		Assert.assertTrue( dateValue.equals( timers.getDateModification() ) );

		
	}



}
