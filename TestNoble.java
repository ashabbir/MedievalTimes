


/**
* Test Noble functionality 
* @author AShabbir
*/
public class TestNoble {

	/**
	* main method to be executed
	* @param  args String[] 
	*/
   	public static void main(String[] args){

	        
			Noble noble1 = new Noble("test noble 1");
			
			
			Noble noble2 = new Noble("test noble 2");
			
			
			Warrior warrior1 = new Warrior("warrior1" , 12);
			noble1.hire(warrior1);
			
			
			Warrior warrior2 = new Warrior("warrior2" , 1);
			noble2.hire(warrior2);
			
			
			System.out.println(noble1);
			System.out.println(noble2);
			
			noble1.battle(noble2);
			
			System.out.println(noble1);
			System.out.println(noble2);
			
			System.out.println(warrior1);
			System.out.println(warrior2);
			
			noble1.battle(noble2);
			

	}
}









