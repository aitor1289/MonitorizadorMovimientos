package com.arriaga.aitor.monitorizadormovimientos;

/**
 * Created by goati on 26/02/2017.
 */

public class UsuarioTransform {

    public UsuarioBean UsuarioEntityToBean(UsuarioEntity entity) {
        UsuarioBean UsuarioBean = new UsuarioBean();

        UsuarioBean.setID_USER(entity.getID_USER());
        UsuarioBean.setMAIL(entity.getMAIL());
        UsuarioBean.setNAME(entity.getNAME());
        UsuarioBean.setPASSWORD(entity.getPASSWORD());
        UsuarioBean.setPHONE(entity.getPHONE());
        UsuarioBean.setROLES_ID_ROL(entity.getROLES_ID_ROL());
        UsuarioBean.setSURENAME1(entity.getSURENAME1());
        UsuarioBean.setSURENAME2(entity.getSURENAME2());
        UsuarioBean.setUSERNAME(entity.getUSERNAME());

        return UsuarioBean;
    }

    public UsuarioEntity UsuarioEntityBeanToEntity(UsuarioBean bean) {
        UsuarioEntity UsuarioEntity = new UsuarioEntity();

        UsuarioEntity.setID_USER(bean.getID_USER());
        UsuarioEntity.setMAIL(bean.getMAIL());
        UsuarioEntity.setNAME(bean.getNAME());
        UsuarioEntity.setPASSWORD(bean.getPASSWORD());
        UsuarioEntity.setPHONE(bean.getPHONE());
        UsuarioEntity.setROLES_ID_ROL(bean.getROLES_ID_ROL());
        UsuarioEntity.setSURENAME1(bean.getSURENAME1());
        UsuarioEntity.setSURENAME2(bean.getSURENAME2());
        UsuarioEntity.setUSERNAME(bean.getUSERNAME());

        return UsuarioEntity;
    }
}
