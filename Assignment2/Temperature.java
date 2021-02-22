/**
 * A Temperature object represents temperature (with a value and scale)
 * Assignment 2
 */

public class Temperature{

private Scale currentScale = Scale.CELSIUS;
private double theTemp;

/** Initializes a temperature object with given value in Celcius
 *
 *  If the initial temperature is less than -273.15C then the temperature
 *  object will be initialized with -273.15C.
 *
 * @param temp is the initial temperature in Celsius.
 */
  public Temperature(double temp){
      currentScale = Scale.CELSIUS;
      if (temp > -273.15){
        theTemp = temp;
      }else{
        theTemp = -273.15;
      }
  }


/** Initializes a temperature object with given value using the specified scale
 * <par>
 * If the temperature is lower than absolute zero, in the given scale,
 * then set the temperature to absolute zero (in that scale).
 * <par>
 * Example: new Temperature(12.3, Scale.KELVIN)
 *
 * @param temp is the initial temperature
 * @param scale is the scale of initial temperature and must a constant
 *        defined in the Scale enum type.
 */
  public Temperature(double temp, Scale scale){
    this.setTemp(temp,scale);
  }


/** Initializes a temperature object with given value using the specified scale
 * <par>
 * If the temperature is lower than absolute zero, in the given scale,
 * then set the temperature to absolute zero (in that scale).
 * <par>
 * Example: each of the following will create the same temerature 12.3K
 *          new Temperature(12.3, "Kelvin")
 *          new Temperature(12.3, "k")
 *          new Temperature(12.3, "kel"
 *
 * @param temp is the initial temperature
 * @param scale is a the scale of initial temperature. As long as the input string
 *        can uniquely identify one of the three scales it is acceptable.
 *        Case is not important. Abbreviations are allowed.
 */
  public Temperature(double temp, String scale){
    scale = scale.toLowerCase();
    int len = scale.length();
    if (scale.equals("kelvin".substring(0,len))){
      currentScale = Scale.KELVIN;
      if (temp > 0){
        theTemp = temp;
      }else{
        theTemp = 0;
      }
    }else if(scale.equals("fahrenheit".substring(0,len))){
      currentScale = Scale.FAHRENHEIT;
      if (temp > -459.69){
        theTemp = temp;
      }else{
        theTemp = -459.69;
      }
    }else{
      currentScale = Scale.CELSIUS;
      if (temp > -273.15){
        theTemp = temp;
      }else{
        theTemp = -273.15;
      }
    }

  }




/** getter for the scale. The output will always be one of the enum objects from Scale.
 *
 * @return the current scale of this object. 
 */
  public Scale getScale(){
    return currentScale;
  }

 /** getter for the temperature
  *
  * @return the temperature of the object using the current scale
  */
  public double getTemp(){
    return theTemp;
  }


  /** setter for scale
  *
  * @param scale is the new scale of the temperature and must be
  *        a constant from the Scale enum type.
  */
  public void setScale(Scale scale){
    if (currentScale == Scale.CELSIUS && scale == Scale.FAHRENHEIT){
      theTemp = (theTemp * 1.8) + 32;
    }else if (currentScale == Scale.CELSIUS && scale == Scale.KELVIN){
      theTemp += 273.15;
    }else if (currentScale == Scale.FAHRENHEIT && scale == Scale.CELSIUS){
      theTemp = (theTemp - 32) * (5/9);
    }else if (currentScale == Scale.FAHRENHEIT && scale == Scale.KELVIN){
      theTemp = ((theTemp - 32) * (5/9)) + 273.15;
    }else if (currentScale == Scale.KELVIN && scale == Scale.CELSIUS){
      theTemp -= 273.15;
    }else if (currentScale == Scale.KELVIN && scale == Scale.FAHRENHEIT){
      theTemp = ((theTemp - 273.15) * 1.8) + 32;
    }
    currentScale = scale;
  }



  /** setter for temperature
  *  <par>
  * If the temperature is lower than absolute zero, in the given scale,
  * then sets the temperature to absolute zero (in that scale).
  *
  * @param temp is the new temperature
  * @param scale is the scale of the new temperature. It must be
  *        a constant from the Scale enum type.
  */
  public void setTemp(double temp, Scale scale){
    currentScale = scale;
    if (scale == Scale.CELSIUS){
      if (temp > -273.15){
        theTemp = temp;
      }else{
        theTemp = -273.15;
      }
    }else if(scale == Scale.KELVIN){
      if (temp > 0){
        theTemp = temp;
      }else{
        theTemp = 0;
      }
    }else{
      if (temp > -459.69){
        theTemp = temp;
      }else{
        theTemp = -459.69;
      }
    }
  }










/* ------------------------------------------------- */
/* ------------------------------------------------- */
/* do not change anything below this                 */
/* ------------------------------------------------- */
/* ------------------------------------------------- */



  /** String representation of a temperature object    */
  @Override
  public String toString(){
    return "" + this.getTemp() + this.getScale().name().charAt(0);
  }

}