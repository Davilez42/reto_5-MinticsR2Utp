package com.reto_5.utp.mintics.davidsuarez.model.vo;

public class LiderVo {
    private Integer id;
    private String nombre;
    private String primer_Apellido;
    private String Ciudad_Residencia;

    
    public LiderVo(Integer id) {
        this.id = id;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getPrimer_Apellido() {
        return primer_Apellido;
    }
    public void setPrimer_Apellido(String primer_Apellido) {
        this.primer_Apellido = primer_Apellido;
    }
    public String getCiudad_Residencia() {
        return Ciudad_Residencia;
    }
    public void setCiudad_Residencia(String ciudad_Residencia) {
        Ciudad_Residencia = ciudad_Residencia;
    }

    
}
