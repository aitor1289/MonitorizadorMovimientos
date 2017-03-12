package com.arriaga.aitor.monitorizadormovimientos;

/**
 * Created by goati on 26/02/2017.
 */

public class UsuarioDaoImpl {
    private int ID_USER;
    private String USERNAME;
    private String PASSWORD;
    private String NAME;
    private String SURENAME1;
    private String SURENAME2;
    private String PHONE;
    private String MAIL;
    private int ROLES_ID_ROL;

    public UsuarioDaoImpl(int ID_USER, String USERNAME, String PASSWORD, String NAME, String SURENAME1, String SURENAME2, String PHONE, String MAIL, int ROLES_ID_ROL) {
        this.ID_USER = ID_USER;
        this.USERNAME = USERNAME;
        this.PASSWORD = PASSWORD;
        this.NAME = NAME;
        this.SURENAME1 = SURENAME1;
        this.SURENAME2 = SURENAME2;
        this.PHONE = PHONE;
        this.MAIL = MAIL;
        this.ROLES_ID_ROL = ROLES_ID_ROL;
    }

    @Override
    public String toString() {
        return "UsuarioEntity{" +
                "ID_USER=" + ID_USER +
                ", USERNAME='" + USERNAME + '\'' +
                ", PASSWORD='" + PASSWORD + '\'' +
                ", NAME='" + NAME + '\'' +
                ", SURENAME1='" + SURENAME1 + '\'' +
                ", SURENAME2='" + SURENAME2 + '\'' +
                ", PHONE='" + PHONE + '\'' +
                ", MAIL='" + MAIL + '\'' +
                ", ROLES_ID_ROL=" + ROLES_ID_ROL +
                '}';
    }

    public int getID_USER() {
        return ID_USER;
    }

    public void setID_USER(int ID_USER) {
        this.ID_USER = ID_USER;
    }

    public String getUSERNAME() {
        return USERNAME;
    }

    public void setUSERNAME(String USERNAME) {
        this.USERNAME = USERNAME;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getSURENAME1() {
        return SURENAME1;
    }

    public void setSURENAME1(String SURENAME1) {
        this.SURENAME1 = SURENAME1;
    }

    public String getSURENAME2() {
        return SURENAME2;
    }

    public void setSURENAME2(String SURENAME2) {
        this.SURENAME2 = SURENAME2;
    }

    public String getPHONE() {
        return PHONE;
    }

    public void setPHONE(String PHONE) {
        this.PHONE = PHONE;
    }

    public String getMAIL() {
        return MAIL;
    }

    public void setMAIL(String MAIL) {
        this.MAIL = MAIL;
    }

    public int getROLES_ID_ROL() {
        return ROLES_ID_ROL;
    }

    public void setROLES_ID_ROL(int ROLES_ID_ROL) {
        this.ROLES_ID_ROL = ROLES_ID_ROL;
    }
}
