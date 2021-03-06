package org.isep.pandas.udf;

import static org.junit.Assert.*;

import org.apache.hadoop.io.Text;
import org.joda.time.DateTime;
import org.junit.Test;

public class SeasonTest {
	
	private Season s = new Season();
	
	private Text[] makeDates(String[] dtts){
		Text[] times = new Text[dtts.length];
		for(int t = 0; t < dtts.length; t++ ){ times[t] = new Text(dtts[t]);}
		return times;
	}
	
	@Test
	public void test() {
		//fail("Not yet implemented");
		String[] exemples = {"2012-01-01 01:50:00", "2012-01-01 01:50:00", "2012-01-01 01:50:00"};
		this.makeDates(exemples);
	}
	
	@Test
	public void testWinter(){
		String[] dates = {"2012-01-01 00:00:01", "PANDA SEASON", "2012-02-27 01:50:00"};
		Text[] datetimes = this.makeDates(dates);
		assertEquals("WINTER", s.evaluate(datetimes[0]).toString());
		assertEquals("NOT_FOUND", s.evaluate(datetimes[1]).toString());
		assertEquals("WINTER", s.evaluate(datetimes[2]).toString());
	}
	
	@Test
	public void testSpring(){
		String[] dates = {"2012-04-01 23:59:59", "2012-05-20 14:35:00", "2012-03-17 05:50:30"};
		Text[] datetimes = this.makeDates(dates);
		assertEquals("SPRING", s.evaluate(datetimes[0]).toString());
		assertEquals("SPRING", s.evaluate(datetimes[1]).toString());
		assertEquals("SPRING", s.evaluate(datetimes[2]).toString());
	}
	
	@Test
	public void testSummer(){
		String[] dates = {"2012-06-01 23:59:59", "2012-07-20 14:35:00", "2012-08-17 05:50:30"};
		Text[] datetimes = this.makeDates(dates);
		assertEquals("SUMMER", s.evaluate(datetimes[0]).toString());
		assertEquals("SUMMER", s.evaluate(datetimes[1]).toString());
		assertEquals("SUMMER", s.evaluate(datetimes[2]).toString());
	}
	
	@Test
	public void testAutum(){
		String[] dates = {"2012-09-01 23:59:59", "2012-10-20 14:35:00", "2012-12-01 12:00:21"};
		Text[] datetimes = this.makeDates(dates);
		assertEquals("AUTUMN", s.evaluate(datetimes[0]).toString());
		assertEquals("AUTUMN", s.evaluate(datetimes[1]).toString());
		assertEquals("WINTER", s.evaluate(datetimes[2]).toString());
	}
}
