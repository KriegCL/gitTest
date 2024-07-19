
package com.mycompany.peluqueriacanina.persistencia;

import com.mycompany.peluqueriacanina.logica.Dueno;
import com.mycompany.peluqueriacanina.logica.Mascota;
import com.mycompany.peluqueriacanina.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ControladoraPersistencia {
    DuenoJpaController duenoJpa = new DuenoJpaController();
    MascotaJpaController mascoJpa = new MascotaJpaController();
    
    

    public void guardar(Dueno dueno, Mascota masc) {
        
        duenoJpa.create(dueno);
        
        mascoJpa.create(masc);
    }

    public List<Mascota> traerMascotas() {
        return mascoJpa.findMascotaEntities();
    }

    public void borrarMascota(int numCliente) {
        try {
            mascoJpa.destroy(numCliente);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Mascota traerMascota(int numCliente) {
        return mascoJpa.findMascota(numCliente);
    }

    public void modificarMascota(Mascota masco) {
        try {
            mascoJpa.edit(masco);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Dueno buscarDueno(int idDueno) {
        return duenoJpa.findDueno(idDueno);
    }

    public void modificarDueno(Dueno dueno) {
        try {
            duenoJpa.edit(dueno);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
