package com.egg.servicio;

import com.egg.entidades.GamaProducto;
import com.egg.entidades.Producto;
import com.egg.persistencia.ProductoDAO;

import javax.inject.Singleton;
import java.util.List;

@Singleton
public class ProductoService {

    private final ProductoDAO productoDAO;

    public ProductoService() {
        this.productoDAO = new ProductoDAO();
    }

    public List<Producto> listarProductos() {
        return productoDAO.listar();
    }

    public Producto buscarProductoPorId(int id) {
        return productoDAO.buscarPorId(id);
    }

    public void eliminarProducto(int id) {
        Producto producto = productoDAO.buscarPorId(id);
        productoDAO.eliminar(producto);
    }

    public void actualizarProducto(int id,
                                  String codigoProducto,
                                  String nombreProducto,
                                  String descripcion,
                                  String dimensiones,
                                  GamaProducto gama,
                                  int cantidadEnStock,
                                  String proveedor,
                                  double precioVenta,
                                  double precioProveedor) {
        Producto producto = productoDAO.buscarPorId(id);
        producto.setCodigoProducto(codigoProducto);
        producto.setNombre(nombreProducto);
        producto.setDescripcion(descripcion);
        producto.setDimensiones(dimensiones);
        producto.setGamaProducto(gama);
        producto.setCantidadEnStock(cantidadEnStock);
        producto.setProveedor(proveedor);
        producto.setPrecioVenta(precioVenta);
        producto.setPrecioProveedor(precioProveedor);
        productoDAO.actualizar(producto);
    }

    public void crearProducto(String codigoProducto,
                              String nombreProducto,
                              String descripcion,
                              String dimensiones,
                              GamaProducto gama,
                              int cantidadEnStock,
                              String proveedor,
                              double precioVenta,
                              double precioProveedor) {
        try {
            Producto nuevoProducto = new Producto();
            nuevoProducto.setCodigoProducto(codigoProducto);
            nuevoProducto.setNombre(nombreProducto);
            nuevoProducto.setDescripcion(descripcion);
            nuevoProducto.setDimensiones(dimensiones);
            nuevoProducto.setGamaProducto(gama);
            nuevoProducto.setCantidadEnStock(cantidadEnStock);
            nuevoProducto.setProveedor(proveedor);
            nuevoProducto.setPrecioVenta(precioVenta);
            nuevoProducto.setPrecioProveedor(precioProveedor);
            productoDAO.guardar(nuevoProducto);
        } catch (Exception e) {
            System.out.println(e.toString() + "Error al guardar producto");
        }
    }
}
