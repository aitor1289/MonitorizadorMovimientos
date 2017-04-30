package com.arriaga.aitor.monitorizadormovimientos;

/**
 * Created by goati on 26/02/2017.
 */

public class RegistroMovimientoEntity {
    private int ID_REG_MOV;
    private int X;
    private int Y;
    private int Z;
    private int USUARIOS_ID_USER;
    private int ID_TIPO_MOV_DETECT;

    public RegistroMovimientoEntity(int ID_REG_MOV, int x, int y, int z, int USUARIOS_ID_USER, int ID_TIPO_MOV_DETECT) {
        this.ID_REG_MOV = ID_REG_MOV;
        X = x;
        Y = y;
        Z = z;
        this.USUARIOS_ID_USER = USUARIOS_ID_USER;
        this.ID_TIPO_MOV_DETECT = ID_TIPO_MOV_DETECT;
    }

    public RegistroMovimientoEntity() {
    }

    @Override
    public String toString() {
        return "RegistroMovimientoEntity{" +
                "ID_REG_MOV=" + ID_REG_MOV +
                ", X=" + X +
                ", Y=" + Y +
                ", Z=" + Z +
                ", USUARIOS_ID_USER=" + USUARIOS_ID_USER +
                ", ID_TIPO_MOV_DETECT=" + ID_TIPO_MOV_DETECT +
                '}';
    }

    public int getID_REG_MOV() {
        return ID_REG_MOV;
    }

    public void setID_REG_MOV(int ID_REG_MOV) {
        this.ID_REG_MOV = ID_REG_MOV;
    }

    public int getX() {
        return X;
    }

    public void setX(int x) {
        X = x;
    }

    public int getY() {
        return Y;
    }

    public void setY(int y) {
        Y = y;
    }

    public int getZ() {
        return Z;
    }

    public void setZ(int z) {
        Z = z;
    }

    public int getUSUARIOS_ID_USER() {
        return USUARIOS_ID_USER;
    }

    public void setUSUARIOS_ID_USER(int USUARIOS_ID_USER) {
        this.USUARIOS_ID_USER = USUARIOS_ID_USER;
    }

    public int getID_TIPO_MOV_DETECT() {
        return ID_TIPO_MOV_DETECT;
    }

    public void setID_TIPO_MOV_DETECT(int ID_TIPO_MOV_DETECT) {
        this.ID_TIPO_MOV_DETECT = ID_TIPO_MOV_DETECT;
    }
}
