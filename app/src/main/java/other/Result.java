package other;

/**
 * Created by Mona on 12/9/2016.
 */

public class Result extends Other {
    public int Id;
    public int ID_pat;
    public double WBC;
    public double RBC;
    public double Hemoglobin;
    public double Hematocrit;
    public double MCV ;
    public double MCH;
    public double MCHV;
    public double RDW ;


    public Result (){
        this(0,0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0);
    }

    public Result (int i,int p,double w,double r,double h,double he,double m,double mh,double mv,double rd){
        Id=i;
        ID_pat=p;
        WBC=w;
        RBC=r;
        Hemoglobin=h;
        Hematocrit=he;
        MCV=m;
        MCH=mh;
        MCHV=mv;
        RDW=rd;

    }
}
