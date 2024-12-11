package org.prd.demo2.persistencia;

import java.util.List;

public interface Dao {
    public String guardarDetalleMatricula(List<Object[]> detalles, String idComprobante);
    public String guardarMatricula(String numeroMat,String nombre, int totalCreditos);
}