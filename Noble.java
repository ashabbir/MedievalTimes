import java.util.ArrayList;


/**
* <b>Nobel</b> class inherits <b>Person</b>
* has an army collection,
* can hire warriors and
* can initiate battle 
* @author AShabbir
*/
public class Noble extends Person{
	
	private ArrayList<Warrior> army;
	
	/**
	* constructor for Nobel takes one argument String <br/>
	* default constructor or no args constrcutor is not used <br/>
	* @param name String
	*/
	public Noble(String name){
		super(name);
		army = new ArrayList<Warrior>();
	}
	
	
	/**
	* hire method adds warrior to army only if warrior is alive and is not employed
	* @param warrior Warrior
	*/
	public void hire(Warrior warrior){
		if(getAlive() && warrior.getEmployer() == null){
			warrior.setEmployer(this);
			army.add(warrior);
			
		}
		
	}
	
	/**
	* removes warrior method removes a warrior from nobels army is alive <br/>
	* warrior can only run away if he is alive <br/>
	* this method is called by warrior class when he is running away <br/>
	* warrior class does not have direct access to nobles army list
	* @param exWarrior Warrior
	*/
	public void removeWarrior(Warrior exWarrior){
		if(getAlive()){
			army.remove(exWarrior);
		}
		
	}
	
	
	/**
	* battle method does logic for fighting <br/>
	* calls battleResults for business logic <br/>
	* business battle busines logic is removed from this method and placed in
	* private methods. 
	* @param enemy Noble
	*/
	public void battle(Noble enemy){
		System.out.println(this.getName() + " battles " + enemy.getName());
		
		System.out.println(battleResults(enemy));
		
	}
	
	
	//private method for internal logic removes logic dependency from caller
	//returns battle summary which the calling method can use to print or email
	//sets live or dead status 
	//changes strength
	private String battleResults(Noble enemy){
		String battleSummary;
		
		if(!this.getAlive() && !enemy.getAlive() ){ 
			//if both are dead
			//print msg
			battleSummary ="Oh, NO! They're both dead!  Yuck!"; 
			
		}else if (!this.getAlive() || !enemy.getAlive()){ 
			//if i am dead or he is dead 
			//print he's dead, (Fight initiator - from discussion board comments)
			battleSummary ="He's dead, " + getName() ;		
			
		}else if(this.getArmyStrenght() == enemy.getArmyStrenght()) {
			 //if both are equal
			//we both die
			battleSummary = "Mutual Annihilation: " + getName() + " and " + enemy.getName() + " die at each other's hands";
			enemy.killAll();
			this.killAll();
					
		}else if(this.getArmyStrenght() > enemy.getArmyStrenght()){
			//if i am stronger
			//he dies and my strength goes down
			battleSummary = this.getName() + " defeats " + enemy.getName();
			this.decreaseStrength(enemy);
			enemy.killAll();
			
			
		}else{
			//if he is stronger (the only case left)
			//i die and his strength goes down
			battleSummary = enemy.getName() + " defeats " + this.getName();
			enemy.decreaseStrength(this);
			this.killAll();
			
			
		}
		
		return battleSummary;
	}
	
	
	//private method for internal logic removes logic dependency from caller
	//kills the noble and each warrior in his army
	private void killAll(){
		for(Warrior warrior : army){
			//kill warrior
			warrior.setAlive(false);
		}
		//kill nobel
		setAlive(false);
		
		//set army to null
		army = null;
		
			
	}
	
	//private method for internal logic decrease strength
	//decrease winning nobel strength by ratio 
	private void decreaseStrength(Noble looser){
		//get winner strength and looser strength 
		float winnerStrength = getArmyStrenght();
		float looserStrength = looser.getArmyStrenght();
		
		//calcualte ration
		float ratio = looserStrength / winnerStrength;
		
		
		//decrease winner strength by ratio
		for(Warrior warrior : army){
			float remainingStrength = warrior.getStrength() - (warrior.getStrength() * ratio);
			warrior.setStrength(remainingStrength);
			
		}
			
	}
	
	// private method not to be inlcuded in java Docs as is private
	// calcualtes all warrior strength in army and returns
	private float getArmyStrenght(){
		float strength = 0f;
		for(Warrior warrior : army){
			strength = strength + warrior.getStrength();
			
		}
		return strength;
	}
	
		
	/**
	* builds a string to return noble and his army. <br/>
	* @return String
	*/
	@Override
	public String toString(){
		StringBuilder builder = new StringBuilder();
		if(getAlive()){
			builder = builder.append(getName()).append(" has an army of ").append(army.size());
			for(Warrior warrior : army)
			{
				builder = builder.append("\n    ").append(warrior);
			}
		}
	
		return  builder.toString();
	}
}

