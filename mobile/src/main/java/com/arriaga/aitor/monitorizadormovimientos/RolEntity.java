package com.arriaga.aitor.monitorizadormovimientos;

/**
 * Created by goati on 26/02/2017.
 */

public class RolEntity {
    private int ID_ROL;
    private String TYPE;
    private String DESCRIPTION;

    public RolEntity(int ID_ROL, String TYPE, String DESCRIPTION) {
        this.ID_ROL = ID_ROL;
        this.TYPE = TYPE;
        this.DESCRIPTION = DESCRIPTION;
    }

    public RolEntity() {
    }

    @Override
    public String toString() {
        return "RolEntity{" +
                "ID_ROL=" + ID_ROL +
                ", TYPE='" + TYPE + '\'' +
                ", DESCRIPTION='" + DESCRIPTION + '\'' +
                '}';
    }

    public int getID_ROL() {
        return ID_ROL;
    }

    public void setID_ROL(int ID_ROL) {
        this.ID_ROL = ID_ROL;
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
