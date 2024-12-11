
package org.prd.demo2.vista;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Presentador {
    private List lis=new ArrayList();
    private Object[]fil={"","","","",""};
    private Object[]comp={"",""};
    private String msg="";

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    public Presentador() {
        lis.add(fil);
    }

    public List getLis() {
        return lis;
    }

    public void setLis(List lis) {
        this.lis = lis;
    }

    public Object[] getFil() {
        return fil;
    }

    public void setFil(Object[] fil) {
        this.fil = fil;
    }

    public Object[] getComp() {
        return comp;
    }

    public void setComp(Object[] comp) {
        this.comp = comp;
    }

    @Override
    public String toString() {
        return "Presentador{" +
                "comp=" + Arrays.toString(comp) +
                ", lis=" + lis +
                ", fil=" + Arrays.toString(fil) +
                ", msg='" + msg + '\'' +
                '}';
    }
}