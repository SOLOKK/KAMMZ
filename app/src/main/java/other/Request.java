package other;

/**
 * Created by Mona on 12/9/2016.
 */

public class Request extends Other {
    public int ID_DR;
    public int ID_PA;
    public String Message;

    public Request (){
        this(0,0,null);
    }
    public Request(int d, int p,String m){
        ID_DR=d;
        ID_PA=p;
        Message=m;
    }
}
