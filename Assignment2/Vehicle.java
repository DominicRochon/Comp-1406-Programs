public class Vehicle {
    public String make;
    public String model;
    public int year;
    public String color;
    public String plate;
    public Driver owner = new Driver();
    public boolean reportedStolen = false;

    public Vehicle(String make, String model, int year, String color, String plate){
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.plate = plate;
    }

    public Vehicle(){
        this("", "", "", "","");
        
    }

    @Override
    public String toString(){
        return String.format("A %s %d %s %s with plate %s", color, year, make, model, plate);
    }
}
