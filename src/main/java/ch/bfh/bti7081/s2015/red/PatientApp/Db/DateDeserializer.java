package ch.bfh.bti7081.s2015.red.PatientApp.Db;


import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;

/**
 * somties gson have trouble to deserialize dates
 * so we do it with a custom deserializer
 * @author James Mayr
 *
 */
public class DateDeserializer implements JsonDeserializer<Date> {
	  public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) {
		    SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy h:mm:ss a");
		    Date date = null;
		    try {
		    	
			  date = sdf.parse(json.getAsJsonPrimitive().getAsString());
			  return date;
		    } catch (ParseException e) {
				e.printStackTrace();
		    }
		    return date;
         }
}