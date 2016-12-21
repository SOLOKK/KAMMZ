package other;

/**
 * Created by Mona on 12/9/2016.
 */

public class Confirm extends Other {
    public int ID_DOc;
    public int ID_PAt;

    public Confirm(){
        this(0,0);
    }
    public Confirm(int d,int p){
        ID_DOc=d;
        ID_PAt=p;
    }
}
