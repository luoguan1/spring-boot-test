package com.example.demo;

import java.io.File;
import java.net.InetAddress;

import org.junit.Test;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.model.CityResponse;
import com.maxmind.geoip2.record.City;
import com.maxmind.geoip2.record.Country;
import com.maxmind.geoip2.record.Location;
import com.maxmind.geoip2.record.Postal;
import com.maxmind.geoip2.record.Subdivision;

public class IpTest {
	
	@Test
	public void test() {
		File database = new File("C:\\Users\\Lenovo\\Desktop\\GeoLite2-City_20180911\\GeoLite2-City_20180911\\GeoLite2-City.mmdb");
		//File database = new File("C:\\Users\\Lenovo\\Desktop\\GeoLite2-City.mmdb\\GeoLite2-City.mmdb");
		try {
			DatabaseReader reader = new DatabaseReader.Builder(database).build();
			InetAddress ipAddress = InetAddress.getByName("125.79.81.91");
			CityResponse response = reader.city(ipAddress);
			Country country = response.getCountry();
			System.out.println(country.getIsoCode());            // 'US'
			System.out.println(country.getName());               // 'United States'
			System.out.println(country.getNames().get("zh-CN")); // '美国'
			
			Subdivision subdivision = response.getMostSpecificSubdivision();
			System.out.println(subdivision.getName());    // 'Minnesota'
			System.out.println(subdivision.getIsoCode()); // 'MN'

			City city = response.getCity();
			System.out.println(city.getName()); // 'Minneapolis'

			Postal postal = response.getPostal();
			System.out.println(postal.getCode()); // '55455'

			Location location = response.getLocation();
			System.out.println(location.getLatitude());  // 44.9733
			System.out.println(location.getLongitude()); // -93.2323
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
