package other;

/**
 * Created by Mona on 12/9/2016.
 */

public class Speciality extends Other {
    private int Id;
    private String Name;
    private String Description;

    public Speciality (){
        this(0,null,null);
    }

    public Speciality (int i,String n,String d){
        Id=i;
        Name=n;
        Description=d;
    }

    public void setId(int id){
        this.Id=Id;
    }
    public int getId(){
        return Id;
    }
    public void setName(String Name){
        this.Name=Name;
    }
    public String getName(){
        return Name;
    }
    public void setDescription(String Description){
        this.Description=Description;

    }
    public String getDescription(){
        return Description;
    }
}
