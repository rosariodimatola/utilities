package utilities.sql;

import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class SqlDate {
	
	
	private SqlDate() {
	}
	
	//Il costruttore chiamato con una stringa restituisce in output un oggetto Date in millisecondi
	public static java.sql.Date getSqlDate (String data) {
		String dataDaConvertire = data + " 00:00:00";
		LocalDateTime localDateTime = LocalDateTime.parse(dataDaConvertire,DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss") );
		long millis = localDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
		return new java.sql.Date(millis);
	}
	
	public static java.sql.Date getSqlDateFromWeb (String data) {
		String dataDaConvertire = data + " 00:00:00";
		LocalDateTime localDateTime = LocalDateTime.parse(dataDaConvertire,DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss") );
		long millis = localDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
		return new java.sql.Date(millis);
	}
	
	public static java.sql.Date getSqlDateFromSpecificBeforeNow(int numberOfDay) {
		ZonedDateTime zonedDateTime = LocalDateTime.now().atZone(ZoneId.systemDefault()).minus(Period.ofDays(numberOfDay));
		long millis = zonedDateTime.toInstant().toEpochMilli();
		return new java.sql.Date(millis);
	}
	
	//Metodo che converte una sql.date in una java.util.date
	public static java.util.Date toJavaUtilDate(java.sql.Date dataDaConvertire) {
		return new java.util.Date(dataDaConvertire.getTime());
	}
	
	//Metodo che converte una java.util.date in una sql.date 
	public static java.sql.Date toJavaSqlDate(java.util.Date dataDaConvertire) {
		return new java.sql.Date(dataDaConvertire.getTime());
	}

}
