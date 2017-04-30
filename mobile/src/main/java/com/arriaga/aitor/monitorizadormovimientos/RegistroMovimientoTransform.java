package com.arriaga.aitor.monitorizadormovimientos;

/**
 * Created by goati on 26/02/2017.
 */

public class RegistroMovimientoTransform {

    public RegistroMovimientoBean RegistroMovimientoEntityToBean(RegistroMovimientoEntity entity) {
        RegistroMovimientoBean regMovBean = new RegistroMovimientoBean();

        regMovBean.setID_REG_MOV(entity.getID_REG_MOV());
        regMovBean.setID_TIPO_MOV_DETECT(entity.getID_TIPO_MOV_DETECT());
        regMovBean.setUSUARIOS_ID_USER(entity.getUSUARIOS_ID_USER());
        regMovBean.setX(entity.getX());
        regMovBean.setY(entity.getY());
        regMovBean.setZ(entity.getZ());

        return regMovBean;
    }

    public RegistroMovimientoEntity RegistroMovimientoEntityToBean(RegistroMovimientoBean bean) {
        RegistroMovimientoEntity regMovEntity = new RegistroMovimientoEntity();

        regMovEntity.setID_REG_MOV(bean.getID_REG_MOV());
        regMovEntity.setID_TIPO_MOV_DETECT(bean.getID_TIPO_MOV_DETECT());
        regMovEntity.setUSUARIOS_ID_USER(bean.getUSUARIOS_ID_USER());
        regMovEntity.setX(bean.getX());
        regMovEntity.setY(bean.getY());
        regMovEntity.setZ(bean.getZ());

        return regMovEntity;
    }

}
