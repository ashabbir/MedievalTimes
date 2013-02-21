
/**
* <b>Person</b> class to be inherited only. 
* Has name and alive <br/>
* @author AShabbir
*/
public abstract class Person{
	
	
	//Private class fields 
	private String name;
	private Boolean alive;
	
	
	/**
	* constructor, sets name <br/>  
	* default no args constrcutor is not present for this class <br/>
	* this constructor is to be called by child classes to set name and alive
	* @param name string
	*/
	public Person(String name){
		this.name = name;
		alive = true;		
	}
	
	
	/**
	* public accessor for name
	* @return string
	*/
	public String getName(){
		return name;
	}
	
	
	
	/**
	* public accessor for alive
	* @return Boolean
	*/
	public Boolean getAlive(){
		return alive;
	}
	
	
	/**
	*  public mutator for alive 
	* @param alive Boolean 
	*/
	public void setAlive(Boolean alive){
		this.alive = alive;
	}
	
	
}
