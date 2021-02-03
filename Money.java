
/*
 * A class to model currency (money) as dollars and cents
 */

 /** Does this work?
  * 
  * @author Dominic Rochon
	* @version 1.1
  */
 
public class Money{
  
  /* attributes */ 
  private int dollars = -1;
  private int cents = -1;

  
  public Money(){
    // create an object with zero dollars and cents.
    dollars = 0;
    cents = 0;
  }
  
  public Money(int c){
    this();
		// create an object with c cents
    // (adjusting dollars and cents so that 0<=cents<=99)
    while (c > 99){
      dollars++;
      c -= 100;
    }
    cents += c;
  }
  
  public Money(int d, int c){
    this();
		// create an object with d dollars and c cents
    // (adjusting dollars and cents so that 0<=cents<=99)
    while (c > 99){
      dollars++;
      c -= 100;
    }
    cents += c;
    dollars += d;
  }
  
  public Money(int[] coins){
    this();
	  // input array have 6 elements and corresponds to 
		// {#toonies, #loonies, #quarters, #dimes, #nickels, #pennies}
    // {$2, $1, $0.25, $0.10, $0.05, $0.01}		
		// create an object with total money passed in array 
    // (adjusting internal dollars and cents so that 0<=cents<=99)
    dollars += (coins[0]*2);
    dollars += (coins[1]);
    cents += (coins[2]*25);
    cents += (coins[3]*10);
    cents += (coins[4]*5);
    cents += (coins[5]);
    while (cents > 99){
      dollars++;
      cents -= 100;
    }
  }
  
  public void add(int c){
    // adds c cents to the current value
    // Again, be sure the internal states does not have cents greater than 99
    cents += c;
    while (cents > 99){
      dollars++;
      cents -= 100;
    }
  }

  public void add(int d, int c){
    // adds d dollars and c cents to the current value
    // Again, be sure the internal states does not have cents greater than 99
    dollars += d;
    cents += c;
    while (cents > 99){
      dollars++;
      cents -= 100;
    }
  }
  public int remove(int c){
    // removes c >= 0 cents from current value if current
    // value is large enough. Otherwise, removes as much as it can.
    // Returns the actual amount of cents removed (may be > 100),
    // and adjusts the internal state.
    while (cents < c){
      dollars--;
      cents += 100;
    }
    cents -= c;
    return c;
  }
  
  /** 
   * Returns a String representation of the value of the current object. 
   * 
   * @return The value of the current object is returned as the <code>String</code>"$D.cc"
   * where D is the number of dollars and cc is the cents of the value.  Uses the <code>format()</code>
   * method from the <code>String</code> class to ensure that the cents are displayed properly (2 spaces
   * with leading zeros if needed).
   **/
  public String toString(){
    return "$" + String.format("%01d", dollars) + "." + String.format("%02d", cents);
  }
  
}