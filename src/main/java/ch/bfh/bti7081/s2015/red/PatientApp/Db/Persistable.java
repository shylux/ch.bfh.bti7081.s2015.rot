package ch.bfh.bti7081.s2015.red.PatientApp.Db;


import com.google.gson.Gson;

/**
 * Every Class that could be stored into an document base database
 * must implement this interface
 * @author James Mayr
 *
 */
public interface Persistable {
	
	/**
	 * a db specific unique hash id
	 * @return
	 */
    String getId();
	
	/**
	 * a db specific unique hash id
	 * @return
	 */
    void setId(String id);

	/**
	 * covert the class properties to json
	 * @return
	 */
	default String serialize() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}
}