import java.util.Date;

public class PoliceDatabase {

    public Vehicle[] vehicles = new Vehicle [0];
    public int numVehicles = 0;
    public Driver[] drivers = new Driver [0];
    public int numDrivers = 0;
    public Infraction[] infractions = new Infraction [0];
    public int numInfractions = 0;

    public static int maxDrivers = 2000;
    public static int maxVehicles = 1000;
    public static int maxInfractions = 800;

    public PoliceDatabase(){
    }

    public void registerDriver(Driver aDriver){
        if (numDrivers < maxDrivers){
            Driver[] driversHolder = new Driver[numDrivers];
            driversHolder = drivers;
            drivers = new Driver[numDrivers + 1];
            drivers[numDrivers] = aDriver;
            for (int p = 0; p < numDrivers; p++){
                drivers[p] = driversHolder[p];
            }
            numDrivers++;
        }
    }

    public void registerVehicle(Vehicle aVehicle, String license){
        if (numVehicles < maxVehicles){
            
            Vehicle[] vehiclesHolder = new Vehicle[numVehicles];
            vehiclesHolder = vehicles;
            vehicles = new Vehicle[numVehicles + 1];
            vehicles[numVehicles] = aVehicle;
            for (int p = 0; p < numVehicles; p++){
                vehicles[p] = vehiclesHolder[p];
            }
            for (int p = 0; p < numDrivers; p++){
                if (drivers[p].license.equals(license)){
                        aVehicle.owner = drivers[p];
                }
            }
            numVehicles++;
        }
    }

    public void unregisterVehicle(String plate){
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < numVehicles; i++){
            if(vehicles[i].plate.equals(plate)){
                count2++;
                i++;
            }
            vehicles[count1] = vehicles[count2];
            count1++;
            count2++;
        }
        numVehicles --;

        Vehicle[] vehiclesHolder = new Vehicle[numVehicles];
        vehiclesHolder = vehicles;
        vehicles = new Vehicle[numVehicles];
        vehicles = vehiclesHolder;
    }

    public void reportStolen(String plate){
        for (Vehicle p: vehicles){
            if(p.plate.equals(plate)){
                p.reportedStolen = true;
            }
        }
    }

    public void changeOwner(String plate, String license){
        for (Vehicle p: vehicles){
            if(p.plate.equals(plate)){
                for (Driver k: drivers){
                    if(k.license.equals(license)){
                        p.owner = k;
                    }
                }
            }
        }
    }

    public Infraction issueInfraction(String license, float amount, String description, Date date){
        Infraction infraction = new Infraction(amount, description, date);
        for (Driver k: drivers){
                if(k.license.equals(license)){
                        infraction = new Infraction(amount, description, date);
                        infraction.driver = k;
                        if(numInfractions < maxInfractions){
                                Infraction[] infractionsHolder = new Infraction[numVehicles];
                                infractionsHolder = infractions;
                                infractions = new Infraction[numInfractions + 1];
                                for (int i = 0; i < numInfractions; i++){
                                        infractions[i] = infractionsHolder[i];
                                }
                                infractions[numInfractions] = infraction;
                                numInfractions++;
                        }
                }
        }
        return infraction;
    }

    public boolean hasOutstandingInfractions(Driver d){
        for (Infraction k: infractions){
                if(k.driver.equals(d) && k.outstanding){
                        return true;
                }
        }
        return false;
    }

    public boolean shouldStopVehicle(String plate){
        for (Vehicle k: vehicles){
                if(k.plate.equals(plate)){
                        if(k.reportedStolen || hasOutstandingInfractions(k.owner)){
                                return true;
                        }
                }
        }
        return false;
    }

    public void showInfractionsFor(String license){
        for (Infraction k: infractions){
                if(k.driver.license.equals(license)){
                        System.out.println(k);
                }
        }
    }

    public Driver[] cleanDrivers(){
        boolean dirtyDriver;
        int numClean = 0;
        for (Driver k: drivers){
                dirtyDriver = false;
                for (Infraction i: infractions){
                        if (i.driver.equals(k)){
                                dirtyDriver = true;
                        }
                }
                if(!dirtyDriver){
                        numClean ++;
                }
        }

        Driver[] goodDrivers = new Driver [numClean];
        int[] badDriverLocations = new int [numDrivers - numClean];
        int count = 0;
        for (int k = 0; k < numDrivers; k++){
                dirtyDriver = false;
                for (Infraction i: infractions){
                        if (i.driver.equals(drivers[k])){
                                dirtyDriver = true;    
                        }
                }
                if(dirtyDriver){
                        badDriverLocations[count] = k;
                        count++;
                }
                
        }
        
        boolean skip;
        count = 0;
        for (int k = 0; k < numClean; k++){
                skip = false;
                for (int i: badDriverLocations){
                        if (i == count){
                                k--;
                                skip = true;
                        }
                }
                if(!skip){
                        goodDrivers[k] = drivers[count];
                }
                count++;
        }
        return goodDrivers;
    }

    public void showInfractionReport(){
        int infractionCount;
        float infractionPaidSum;
        for (Driver k: drivers){
                infractionCount = 0;
                infractionPaidSum = 0;
                boolean goodDriver = false;
                for (Driver i: cleanDrivers()){
                    if(k.equals(i)){
                            goodDriver = true;
                        }
                }
            if (!goodDriver){
                for (Infraction p: infractions){
                        if(p.driver.equals(k)){
                                infractionCount++;
                                if (!p.outstanding){
                                        infractionPaidSum += p.amount;
                                }
                        }
                        
                }
                //System.out.println(k.name + ": " + infractionCount + " infractions, total paid = $" + infractionPaidSum);
                System.out.println(String.format("%20s: %d infractions, total paid = $%6.2f", k.name, infractionCount, infractionPaidSum));
           }
        }
    }

    public static  PoliceDatabase example() { // Register all drivers and their vehicles
        PoliceDatabase pdb = new PoliceDatabase();
    
        pdb.registerDriver(new Driver("L1567-34323-84980", "Matt Adore",
                "1323 Kenaston St.", "Gloucester", "ON"));
        pdb.registerDriver(new Driver("L0453-65433-87655", "Bob B. Pins",
                "32 Rideau Rd.", "Greely", "ON"));
        pdb.registerDriver(new Driver("L2333-45645-54354", "Stan Dupp",
                "1355 Louis Lane", "Gloucester", "ON"));
        pdb.registerDriver(new Driver("L1234-35489-99837", "Ben Dover",
                "2348 Walkley Rd.", "Ottawa", "ON"));
        pdb.registerDriver(new Driver("L8192-87498-27387", "Patty O'Lantern",
                "2338 Carling Ave.", "Nepean", "ON"));
        pdb.registerDriver(new Driver("L2325-45789-35647", "Ilene Dover",
                "287 Bank St.", "Ottawa", "ON"));
        pdb.registerDriver(new Driver("L1213-92475-03984", "Patty O'Furniture",
                "200 St. Laurant Blvd.", "Ottawa", "ON"));
        pdb.registerDriver(new Driver("L1948-87265-34782", "Jen Tull",
                "1654 Stonehenge Cres.", "Ottawa", "ON"));
        pdb.registerDriver(new Driver("L0678-67825-83940", "Jim Class",
                "98 Oak Blvd.", "Ottawa", "ON"));
        pdb.registerDriver(new Driver("L0122-43643-73286", "Mark Mywords",
                "3 Third St.", "Ottawa", "ON"));
        pdb.registerDriver(new Driver("L6987-34532-43334", "Bob Upandown",
                "434 Gatineau Way", "Hull", "QC"));
        pdb.registerDriver(new Driver("L3345-32390-23789", "Carrie Meehome",
                "123 Thurston Drive", "Kanata", "ON"));
        pdb.registerDriver(new Driver("L3545-45396-88983", "Sam Pull",
                "22 Colonel By Drive", "Ottawa", "ON"));
        pdb.registerDriver(new Driver("L1144-26783-58390", "Neil Down",
                "17 Murray St.", "Nepean", "ON"));
        pdb.registerDriver(new Driver("L5487-16576-38426", "Pete Reedish",
                "3445 Bronson Ave.", "Ottawa", "ON"));
        pdb.registerVehicle(new Vehicle("Honda", "Civic", 2015, "yellow", "W3EW4T"),
                "L0453-65433-87655");
        pdb.registerVehicle(new Vehicle("Pontiac","Grand Prix",2007,"dark green","GO SENS"),
                "L0453-65433-87655");
        pdb.registerVehicle(new Vehicle("Mazda", "RX-8", 2004, "white", "OH YEAH"),
                "L2333-45645-54354");
        pdb.registerVehicle(new Vehicle("Nissan","Altima",2017,"bergundy", "Y6P9O7"),
                "L1234-35489-99837");
        pdb.registerVehicle(new Vehicle("Saturn", "Vue", 2002, "white", "9R6P2P"),
                "L2325-45789-35647");
        pdb.registerVehicle(new Vehicle("Honda", "Accord", 2018, "gray", "7U3H5E"),
                "L2325-45789-35647");
        pdb.registerVehicle(new Vehicle("Chrysler", "PT-Cruiser", 2006, "gold", "OLDIE"),
                "L2325-45789-35647");
        pdb.registerVehicle(new Vehicle("Nissan", "Cube", 2010, "white", "5Y6K8V"),
                "L1948-87265-34782");
        pdb.registerVehicle(new Vehicle("Porsche", "959", 1989, "silver", "CATCHME"),
                "L0678-67825-83940");
        pdb.registerVehicle(new Vehicle("Kia", "Soul", 2018, "red", "J8JG2Z"),
                "L0122-43643-73286");
        pdb.registerVehicle(new Vehicle("Porsche", "Cayenne", 2014, "black", "EXPNSV"),
                "L6987-34532-43334");
        pdb.registerVehicle(new Vehicle("Nissan", "Murano", 2010, "silver", "Q2WF6H"),
                "L3345-32390-23789");
        pdb.registerVehicle(new Vehicle("Honda", "Element", 2008, "black", "N7MB5C"),
                "L3545-45396-88983");
        pdb.registerVehicle(new Vehicle("Toyota", "RAV-4", 2010, "green", "R3W5Y7"),
                "L3545-45396-88983");
        pdb.registerVehicle(new Vehicle("Toyota", "Celica", 2006, "red", "FUNFUN"),
                "L5487-16576-38426");
    
        return pdb;
    }

}
