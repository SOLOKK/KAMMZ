package other;

/**
 * Created by Mona on 12/9/2016.
 */

public class Med_For_Pat extends Other {
    public int ID_Pa;
    public int ID_Me;
    public Med_For_Pat(){
        this(0,0);
    }
    public Med_For_Pat(int p,int m){
        ID_Pa=p;
        ID_Me=m;
    }
}
