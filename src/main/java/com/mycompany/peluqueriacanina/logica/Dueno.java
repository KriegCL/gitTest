package com.mycompany.peluqueriacanina.logica;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Dueno implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idDueno;
    
    private String nombreDueno;
    private String direccion;
    private String celDueno;
    

    public Dueno() {
    }

    public Dueno(int idDueno, String nombreDueno, String direccion, String celDueno) {
        this.idDueno = idDueno;
        this.nombreDueno = nombreDueno;
        this.direccion = direccion;
        this.celDueno = celDueno;
        
    }

    public int getIdDueno() {
        return idDueno;
    }

    public void setIdDueno(int idDueno) {
        this.idDueno = idDueno;
    }

    public String getNombreDueno() {
        return nombreDueno;
    }

    public void setNombreDueno(String nombreDueno) {
        this.nombreDueno = nombreDueno;
    }

    public String getCelDueno() {
        return celDueno;
    }

    public void setCelDueno(String celDueno) {
        this.celDueno = celDueno;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    

}
