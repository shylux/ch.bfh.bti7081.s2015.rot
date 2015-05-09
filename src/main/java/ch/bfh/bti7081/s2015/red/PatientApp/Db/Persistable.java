package ch.bfh.bti7081.s2015.red.PatientApp.Db;

public interface Persistable {
	
	/**
	 * covert the class properties to json
	 * @return
	 */
	public String serialize();
	
	/**
	 * initialize a class with json code
	 * @param json
	 */
	public void deserialize(String json);
	
	/**
	 * a db specific unique hash id
	 * @return
	 */
	public String getId();
}
