
package com.mycompany.peluqueriacanina.logica;

import com.mycompany.peluqueriacanina.persistencia.ControladoraPersistencia;
import java.util.List;


public class Controladora {
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    public void guardar(String nomMasc, String raza, String color, String alergia, String atEsp, String obs, String nomDueno, String direccion, String cel) {
        Dueno dueno = new Dueno();
        
        dueno.setNombreDueno(nomDueno);
        dueno.setDireccion(direccion);
        dueno.setCelDueno(cel);
        
        Mascota masc = new Mascota();
        masc.setNombre(nomMasc);
        masc.setRaza(raza);
        masc.setColor(color);
        masc.setAlergias(alergia);
        masc.setAtEsp(atEsp);
        masc.setObservaciones(obs);
        masc.setDueno(dueno);
        
        controlPersis.guardar(dueno, masc);
    }

    public List<Mascota> traerMascotas() {
        return controlPersis.traerMascotas();
        
    }

    public void borraMascota(int numCliente) {
        controlPersis.borrarMascota(numCliente);
    }

    //public Mascota traerMascota(int numCliente) {
        
    //}

    public Mascota traerMascota(int numCliente) {
        return controlPersis.traerMascota(numCliente);
        
    }

    public void modificarMascota(Mascota masco, String nomMasc, String raza, String color, String alergia, String atEsp, String obs, String nomDueno, String direccion, String cel) {
        masco.setNombre(nomMasc);
        masco.setRaza(raza);
        masco.setColor(color);
        masco.setAlergias(alergia);
        masco.setAtEsp(atEsp);
        masco.setObservaciones(obs);
        
        //modificar mascota
        
        controlPersis.modificarMascota(masco);
        
        Dueno dueno = this.buscarDueno(masco.getDueno().getIdDueno());
        dueno.setCelDueno(cel);
        dueno.setDireccion(direccion);
        dueno.setNombreDueno(nomDueno);
        
        //modificar dueño
        this.modificarDueno(dueno);
    }

    private Dueno buscarDueno(int idDueno) {
        return controlPersis.buscarDueno(idDueno);
    }

    private void modificarDueno(Dueno dueno) {
        controlPersis.modificarDueno(dueno);
    }
}
