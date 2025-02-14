package com.egg.servicio;

import com.egg.entidades.GamaProducto;
import com.egg.persistencia.GamaProductoDAO;

public class GamaProductoService {

    private final GamaProductoDAO gamaProductoDAO;
    public GamaProductoService() {
        gamaProductoDAO = new GamaProductoDAO();
    }

    public void crearGamaProducto(String descripcionTexto, String descripcionHtml, String gama, String imagen) {
        try {
            // Crear una nueva instancia de GamaProducto
            GamaProducto gamaProducto = new GamaProducto();
            gamaProducto.setDescripcionTexto(descripcionTexto);
            gamaProducto.setDescripcionHtml(descripcionHtml);
            gamaProducto.setGama(gama);
            gamaProducto.setImagen(imagen);

            gamaProductoDAO.guardar(gamaProducto);

            System.out.println("Gama de producto creada exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al crear la gama de producto: " + e.getMessage());
        }
    }
}
