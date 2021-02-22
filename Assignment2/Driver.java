public class Driver {
    public String license;
    public String name;
    public String street;
    public String city;
    public String province;

    public Driver(String license, String name, String street, String city, String province){
        this.name = name;
        this.license = license;
        this.street = street;
        this.city = city;
        this.province = province;
    }

    public Driver(){
        this("", "", "", "Ottawa","");
    }

    @Override
    public String toString(){
        return String.format("%s %s living at %s, %s %s", license, name, street, city, province);
    }
}
