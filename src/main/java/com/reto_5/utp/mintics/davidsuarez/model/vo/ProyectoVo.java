package com.reto_5.utp.mintics.davidsuarez.model.vo;

public class ProyectoVo {
    private Integer id;
    private String constructora;
    private Integer numero_habitaciones;
    private String Ciudad;

    
    public ProyectoVo(Integer id) {
        this.id = id;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getConstructora() {
        return constructora;
    }
    public void setConstructora(String constructora) {
        this.constructora = constructora;
    }
    public Integer getNumero_habitaciones() {
        return numero_habitaciones;
    }
    public void setNumero_habitaciones(Integer numero_habitaciones) {
        this.numero_habitaciones = numero_habitaciones;
    }
    public String getCiudad() {
        return Ciudad;
    }
    public void setCiudad(String ciudad) {
        Ciudad = ciudad;
    }
    
}
