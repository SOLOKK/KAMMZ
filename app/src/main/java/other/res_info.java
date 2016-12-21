package other;

/**
 * Created by Mona on 12/10/2016.
 */

public class res_info extends Other {
    public int Id ;
    public String Name;
    public int Min;
    public int Max;
    public String Unit;

    public res_info(){
        this(0,null,0,0,null);
    }

    public res_info(int i, String n, int mn, int mx ,String u ){
        Id=i;
        Name=n;
        Min=mn;
        Max=mx;
        Unit=u;

    }



}
