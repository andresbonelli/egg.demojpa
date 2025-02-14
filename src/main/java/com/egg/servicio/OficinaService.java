package com.egg.servicio;

import com.egg.entidades.Oficina;
import com.egg.persistencia.OficinaDAO;

public class OficinaService {

        private final OficinaDAO daoOficina;// Instancio a la unidad d persistencia para acceder a los metodos del EM

        public OficinaService() {
            this.daoOficina = new OficinaDAO();
        }

        public void crearOficina(String codigodOficina, String ciudad, String pais,
                                String region, String telefono, String codigoPostal) {
            try {
            // Crear una nueva instancia de Oficina
                Oficina oficinaNueva = new Oficina();


                oficinaNueva.setCodigodOficina(codigodOficina);
                oficinaNueva.setCiudad(ciudad);
                oficinaNueva.setPais(pais);
                oficinaNueva.setRegion(region);
                oficinaNueva.setTelefono(telefono);
                oficinaNueva.setCodigoPostal(codigoPostal);


            // Llamar al metodo de OficinaDAO para guardar la nueva oficina
                daoOficina.guardar(oficinaNueva);

            } catch (Exception e) {
                System.out.println(e.toString() + "No se guardo la nueva oficina de manera correcta");
            }
        }
}
