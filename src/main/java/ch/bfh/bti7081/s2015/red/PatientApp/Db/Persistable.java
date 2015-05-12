package ch.bfh.bti7081.s2015.red.PatientApp.Db;

public interface Persistable {
	
	/**
	 * covert the class properties to json
	 * @return
	 */
	public String serialize();
	
	/**
	 * a db specific unique hash id
	 * @return
	 */
	public String getId();
	
	/**
	 * a db specific unique hash id
	 * @return
	 */
	public void setId(String id);
}