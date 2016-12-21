package detail;

/**
 * Created by Mona on 12/9/2016.
 */

public class Detail {
    public int Id;
    public String Name;
    public String Description;

    public Detail(){
        this(0,"","");

    }
    public Detail(int Id,String Name,String Description){
        this.Id=Id;
        this.Name=Name;
        this.Description=Description;
    }
}
