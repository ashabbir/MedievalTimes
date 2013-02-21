


/**
* <b>Warrior</b> class inherits <b>Person</b> class. 
* a warrior has a name, strength and employer<br/>
* can only have one employee and quit<br/>
* can only be constructed by name and strength<br/>
* @author AShabbir
*/
public class Warrior extends Person{	
	
	//fields for employer and strength
	private Noble employer;
	private float strength;
	
	
	/**
	* no args constructors not present for class 
	* constructor takes 2 args name and strength
	* uses parent constructor as well
	* @param name string
	* @param strength float 
	*/
	public Warrior(String name , float strength){
		super(name);
		this.strength = strength;
		
	}
	
	
	/**
	* public method runaway sets employer to null and prints to console
	* if warrior is employed and alive. 
	*/
	public void runaway(){
		//if warrior is employed and alive call nobel removeWarrior which removes warrior for army arraylist
		//then set employer to null
		if(employer != null && getAlive()){
			System.out.printf("So long %s. I'm out'a here! -- %s \n" , employer.getName() , getName());
			employer.removeWarrior(this);
			employer = null;
		}
		
	}
	
	/**
	* public accessor method for employer if warrior is alive.
	* @return noble
	*/
	public Noble getEmployer(){
		//if warrior is alive set employer
		return getAlive() ? employer : null;	
	}
	
	
	/**
	* public mutator method for strength.
	* @param employer Noble
	*/
	public void setEmployer(Noble employer){
		//if warrior is alive set employer
		if(getAlive()){
			this.employer = employer;
		}	
	}
	
	
	/**
	* public accessor method for strength.
	* @return float
	*/
	public float getStrength(){
		//if warrior is alive return strength else return 0f
		return getAlive() ? strength : 0f;	
	}
	
	
	/**
	* public mutator for strength
	* @param  strength float
	*/
	public void setStrength(float strength){
		//if warrior is alive set strength
		if(getAlive()){
			this.strength = strength;
		}	
	}
	
	
	
	
	/**
	* builds a string to return warrior and his strength <br/>
	* (Overrides toString() for object class). 
	* @return string
	*/
	@Override
	public String toString(){
		StringBuilder builder = new StringBuilder();
		//if warrior is alive build string
		if(getAlive()){
			builder = builder.append(getName()).append(": ").append(this.strength);
		}
		return  builder.toString();
	}
}
