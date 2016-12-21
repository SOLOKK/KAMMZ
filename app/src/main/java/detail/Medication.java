package detail;

/**
 * Created by Mona on 12/9/2016.
 */

public class Medication extends Detail {
    public Medication(){
        this(0,"","");

    }
    public Medication(int Id,String Name,String Description){
        this.Id=Id;
        this.Name=Name;
        this.Description=Description;
    }
}
