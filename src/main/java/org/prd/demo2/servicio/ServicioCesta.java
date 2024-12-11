
package org.prd.demo2.servicio;

import java.util.List;


public class ServicioCesta {
    private Cesta ces;
    public void nuevaCesta(){
        ces=new Cesta();
    }
    public void agregarCurso(String cod,String nom,String cre){
        ces.agregar(cod, nom, cre);
    }
    public void quitarCurso(String cod){
        ces.quitar(cod);
    }
    public List getCesta(){
        return ces.getCesta();
    }
}