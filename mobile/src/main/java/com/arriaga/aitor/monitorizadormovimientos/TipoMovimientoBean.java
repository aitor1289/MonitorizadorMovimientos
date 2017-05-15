package com.arriaga.aitor.monitorizadormovimientos;

/**
 * Created by goati on 26/02/2017.
 */

public class TipoMovimientoBean {
    private int ID_TIPO_MOV;
    private String TYPE;
    private String DESCRIPTION;

    public TipoMovimientoBean(int ID_TIPO_MOV, String TYPE, String DESCRIPTION) {
        this.ID_TIPO_MOV = ID_TIPO_MOV;
        this.TYPE = TYPE;
        this.DESCRIPTION = DESCRIPTION;
    }

    public TipoMovimientoBean() {
    }

    @Override
    public String toString() {
        return "TipoMovimientoEntity{" +
                "ID_TIPO_MOV=" + ID_TIPO_MOV +
                ", TYPE='" + TYPE + '\'' +
                ", DESCRIPTION='" + DESCRIPTION + '\'' +
                '}';
    }

    public int getID_TIPO_MOV() {
        return ID_TIPO_MOV;
    }

    public void setID_TIPO_MOV(int ID_TIPO_MOV) {
        this.ID_TIPO_MOV = ID_TIPO_MOV;
    }

    public String getTYPE() {
        return TYPE;
    }

    public void setTYPE(String TYPE) {
        this.TYPE = TYPE;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }
}
