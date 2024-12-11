
package org.prd.demo2.servicio;

import java.util.ArrayList;
import java.util.List;


public class Cesta {
    private List cesta=new ArrayList();
    public void agregar(String cod,String nom, String cre){
        Object[]lin=new Object[4];
        lin[0]=cod;
        lin[1]=nom;
        lin[2]=cre;
        cesta.add(lin);
    }

    public List getCesta() {
        return cesta;
    }
    public void quitar(String cod){
        for(int i=0;i<cesta.size();i++){
            Object[]fil=(Object[])cesta.get(i);
            if(fil[0].equals(cod)){
                cesta.remove(i);
            }
        }
    }
}