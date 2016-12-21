package detail;

/**
 * Created by Mona on 12/9/2016.
 */

public class Allergy extends Detail {

    public Allergy(){
        this(0,"","");
    }

    public Allergy(int Id,String Name,String Description){
        this.Id=Id;
        this.Name=Name;
        this.Description=Description;
    }
}
