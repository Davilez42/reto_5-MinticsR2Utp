package com.reto_5.utp.mintics.davidsuarez.model.vo;

public class ComprasVo {
    private Integer id;
    private String constructora;
    private String bancoVinculado;

    
    public ComprasVo(Integer id) {
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
    public String getBancoVinculado() {
        return bancoVinculado;
    }
    public void setBancoVinculado(String bancoVinculado) {
        this.bancoVinculado = bancoVinculado;
    }
    

}
