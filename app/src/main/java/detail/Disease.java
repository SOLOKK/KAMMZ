package detail;

/**
 * Created by Mona on 12/9/2016.
 */

public class Disease extends Detail {
    public Disease(){
        this(0,"","");

    }
    public Disease(int Id,String Name,String Description){
        this.Id=Id;
        this.Name=Name;
        this.Description=Description;
    }
}
