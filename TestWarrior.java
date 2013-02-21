

/**
* Test warrior functionality 
* @author AShabbir
*/
public class TestWarrior {

	/**
	* main method to be executed
	* @param  args String[]
	*/
    public static void main(String[] args){

	        Warrior warrior = new Warrior("test warrior", 10);
			System.out.println(warrior);
			warrior.runaway();
			
			
			Noble noble = new Noble("test noble");
			noble.hire(warrior);
			warrior.runaway();
			
				      

	}
}









