
public class UseMonthEnumType{

	public static int days(Month month){
		int num;
		switch (month){
			case JANUARY:
			case MARCH:
			case MAY:
			case JULY:
			case AUGUST:
			case OCTOBER:
			case DECEMBER:
				num = 31;
				break;
			case FEBRUARY:
				num = 28;
				break;
			default:
				num = 30;
		}
		return num;
	}

	public static void main(String[] args){
		// a Month object

		System.out.println(days(current));
		
		// all enum objects have a pre-defined toString() method
		System.out.println("the current month is " + current.toString());
		
		// the values() method returns an array of all constants (objects)
		// in the order that they appear in the enum declaration/definition
		for(Month m : Month.values()){
			System.out.println(m.toString());
		}
	
		// the valueOf(String) method returns the enum object corresponding to the 
		// input string (if it exitst)
		current = Month.valueOf("OCTOBER");
		System.out.println("the new current month is " + current.toString());
		
		
		// try uncommenting this code to see what happens
		//current = Month.valueOf("September");
		//System.out.println("the new current month is " + current.toString());
	
	}
}