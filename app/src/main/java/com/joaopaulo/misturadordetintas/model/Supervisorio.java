package com.joaopaulo.misturadordetintas.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties("id")
public class Supervisorio {


    private int btstart;
    private int btemergencia;
    private int bomba01;
    private int valvula01;
    private int valvula02;
    private int misturador;
    private int descarte;
    private int mcompletas;
    private int mincompletas;
    private int resetcontadores;

    public int getBtstart() {
        return btstart;
    }

    public void setBtstart(int btstart) {
        this.btstart = btstart;
    }

    public int getBtemergencia() {
        return btemergencia;
    }

    public void setBtemergencia(int btemergencia) {
        this.btemergencia = btemergencia;
    }

    public int getBomba01() {
        return bomba01;
    }

    public void setBomba01(int bomba01) {
        this.bomba01 = bomba01;
    }

    public int getValvula01() {
        return valvula01;
    }

    public void setValvula01(int valvula01) {
        this.valvula01 = valvula01;
    }

    public int getValvula02() {
        return valvula02;
    }

    public void setValvula02(int valvula02) {
        this.valvula02 = valvula02;
    }

    public int getMisturador() {
        return misturador;
    }

    public void setMisturador(int misturador) {
        this.misturador = misturador;
    }

    public int getDescarte() {
        return descarte;
    }

    public void setDescarte(int descarte) {
        this.descarte = descarte;
    }

    public int getMcompletas() {
        return mcompletas;
    }

    public void setMcompletas(int mcompletas) {
        this.mcompletas = mcompletas;
    }

    public int getMincompletas() {
        return mincompletas;
    }

    public void setMincompletas(int mincompletas) {
        this.mincompletas = mincompletas;
    }

    public int getResetcontadores() {
        return resetcontadores;
    }

    public void setResetcontadores(int resetcontadores) {
        this.resetcontadores = resetcontadores;
    }


    @Override
    public String toString() {
        return "" + btstart +
                ", " + btemergencia +
                ", " + bomba01 +
                ", " + valvula01 +
                ", " + valvula02 +
                ", " + misturador +
                ", " + descarte +
                ", " + mcompletas +
                ", " + mincompletas +
                ", " + resetcontadores;
    }
}
