
package org.prd.demo2.servicio;

import java.util.List;


public class ServicioCursos {
    public static List listar(){
        String sql="SELECT * FROM curso";
        return Acceso.listar(sql);
    }
}