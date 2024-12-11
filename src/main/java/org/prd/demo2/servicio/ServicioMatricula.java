
package org.prd.demo2.servicio;

import org.prd.demo2.persistencia.Dao;
import org.prd.demo2.persistencia.DaoImp;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;



public class ServicioMatricula {
    private static int contador = 1; // Contador para generar números secuenciales

    public static Object[] nuevaMatricula() {
        Object[] com = new Object[2];

        // Generar el número de comprobante
        String num= String.format("R%05d", contador);
        contador++; // Incrementar el contador para el siguiente comprobante

        // Obtener la fecha actual
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String fec = sdf.format(new Date());

        // Asignar valores al comprobante
        com[0] = num;
        com[1] = fec;

        return com;
    }
     public static String grabarMatricula(String numeroMatricula,String nombre, int totalCreditos) {
        Dao dao = new DaoImp();
        return dao.guardarMatricula(numeroMatricula, nombre, totalCreditos);
    }

    public static String grabarDetalleMatricula(List<Object[]> detalles, String numeroRecibo) {
        Dao dao = new DaoImp();
        return dao.guardarDetalleMatricula(detalles, numeroRecibo);
    }
}