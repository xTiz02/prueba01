package org.prd.demo2.persistencia;

import org.prd.demo2.servicio.Acceso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class DaoImp implements Dao {
    LocalDate fechaActual = LocalDate.now();
    DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    String fechaFormateada = fechaActual.format(formato);

    public String guardarMatricula(String numeroMat,String nombre, int totalCreditos) {
        String msg = "DETALLE GRABADO CORRECTAMENTE";
        String sql = "INSERT INTO matricula (numero_matricula, fecha, nombre_alumno,total_creditos) VALUES ('"
                + numeroMat + "', '" + fechaFormateada + "', " + nombre + ", " + totalCreditos + ")";
        Acceso.ejecutar(sql);
        
        return msg;  
    }

    @Override
    public String guardarDetalleMatricula(List<Object[]> detalles, String numero_matricula) {
        String msg = null;

        for (Object[] fila : detalles) {
            String sql = "INSERT INTO detalle_matricula (numero_matricula, codigo_curso) VALUES ('"
                    + numero_matricula + "', '" + fila[1] + "')";

            msg = Acceso.ejecutar(sql);
            if (msg != null) {
                return "Error al guardar el detalle del comprobante: " + msg;
            }
        }
        return "Todos los registros se han guardado correctamente.";
    }

}