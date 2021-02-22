import java.util.Date;

public class Infraction {
    public float amount;
    public String description;
    public java.util.Date dateIssued;
    public Boolean outstanding = true;
    public Driver driver;

    public Infraction(float amount, String description, Date dateIssued){
        this.amount = amount;
        this.description = description;
        this.dateIssued = dateIssued;
    }

    public Infraction(){
        this(0.00, "", Date(0));
    }

    public void pay(){
        outstanding = false;
    }

    @Override
    public String toString(){
        if (outstanding){
            return String.format("$%.2f Infraction on %tc [OUTSTANDING]", amount, dateIssued);
        }else{
            return String.format("$%.2f Infraction on %tc [PAID IN FULL]", amount, dateIssued);
        }
    }
}
