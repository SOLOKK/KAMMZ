package other;

/**
 * Created by Mona on 12/9/2016.
 */

public class Profile extends Other {
    public int ID_DOC ;
    public int ID_SPE ;
    public int YOG ;
    public String Title;
    public String Uni ;
    public int NOP ;

    public Profile(){
        this(0,0,0,null,null,0);

    }

    public Profile(int d,int s,int y,String t,String u,int n ){
        ID_DOC=d;
        ID_SPE=s;
        YOG=y;
        Title=t;
        Uni=u;
        NOP=n;
    }
}
