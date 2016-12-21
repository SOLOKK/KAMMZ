package com.example.me.KAMMZ;

import detail.*;
import other.*;
import user.*;

/**
 * Created by Mona on 12/9/2016.
 */

public abstract class ClinicFactory {
    abstract User getUser(String u);
    abstract Detail getDetail(String d);
    abstract Other getOther(String o);
}
