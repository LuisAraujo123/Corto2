/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.modelo;

/**
 *
 * @author bernardo
 */
public class SeresVivos {
    private int codi_sere;
    private String nomb_sere;
    private String desc_sere;
    private int codi_refe_sere;
    private String padre_sere;

    public SeresVivos() {
    }
    
    public SeresVivos(int codi_sere, String nomb_sere, String desc_sere, int codi_refe_sere, String padre_sere) {
        this.codi_sere = codi_sere;
        this.nomb_sere = nomb_sere;
        this.desc_sere = desc_sere;
        this.codi_refe_sere = codi_refe_sere;
        this.padre_sere = padre_sere;
    }

    public int getCodi_sere() {
        return codi_sere;
    }

    public void setCodi_sere(int codi_sere) {
        this.codi_sere = codi_sere;
    }

    public String getNomb_sere() {
        return nomb_sere;
    }

    public void setNomb_sere(String nomb_sere) {
        this.nomb_sere = nomb_sere;
    }

    public String getDesc_sere() {
        return desc_sere;
    }

    public void setDesc_sere(String desc_sere) {
        this.desc_sere = desc_sere;
    }

    public int getCodi_refe_sere() {
        return codi_refe_sere;
    }

    public void setCodi_refe_sere(int codi_refe_sere) {
        this.codi_refe_sere = codi_refe_sere;
    }

    public String getPadre_sere() {
        return padre_sere;
    }

    public void setPadre_sere(String padre_sere) {
        this.padre_sere = padre_sere;
    }

    @Override
    public String toString() {
        return this.nomb_sere;
    }
    
    
}
