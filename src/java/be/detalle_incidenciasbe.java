/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be;

/**
 *
 * @author gustavo-pc
 */
public class detalle_incidenciasbe {
    
    
    private String iddet_incidencias;
    private String nom_area;
    private int idincidencia;
    private String areaorigen;
    private String areadestino;
    private String detalle;
    private String fecha;
    private int idfuncionario;

    public detalle_incidenciasbe() {
    }

    public detalle_incidenciasbe(String iddet_incidencias, String nom_area, int idincidencia, String areaorigen, String areadestino, String detalle, String fecha, int idfuncionario) {
        this.iddet_incidencias = iddet_incidencias;
        this.nom_area = nom_area;
        this.idincidencia = idincidencia;
        this.areaorigen = areaorigen;
        this.areadestino = areadestino;
        this.detalle = detalle;
        this.fecha = fecha;
        this.idfuncionario = idfuncionario;
    }

    public String getIddet_incidencias() {
        return iddet_incidencias;
    }

    public void setIddet_incidencias(String iddet_incidencias) {
        this.iddet_incidencias = iddet_incidencias;
    }

    public String getNom_area() {
        return nom_area;
    }

    public void setNom_area(String nom_area) {
        this.nom_area = nom_area;
    }

    public int getIdincidencia() {
        return idincidencia;
    }

    public void setIdincidencia(int idincidencia) {
        this.idincidencia = idincidencia;
    }

    public String getAreaorigen() {
        return areaorigen;
    }

    public void setAreaorigen(String areaorigen) {
        this.areaorigen = areaorigen;
    }

    public String getAreadestino() {
        return areadestino;
    }

    public void setAreadestino(String areadestino) {
        this.areadestino = areadestino;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getIdfuncionario() {
        return idfuncionario;
    }

    public void setIdfuncionario(int idfuncionario) {
        this.idfuncionario = idfuncionario;
    }

    
    
}
