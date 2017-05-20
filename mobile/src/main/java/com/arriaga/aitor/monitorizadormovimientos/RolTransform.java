package com.arriaga.aitor.monitorizadormovimientos;

/**
 * Created by goati on 26/02/2017.
 */

public class RolTransform {

    public RolBean RolEntityToBean(RolEntity entity) {
        RolBean rolBean = new RolBean();

        rolBean.setID_ROL(entity.getID_ROL());
        rolBean.setTYPE(entity.getTYPE());
        rolBean.setDESCRIPTION(entity.getDESCRIPTION());

        return rolBean;
    }

    public RolEntity RolBeanToEntity(RolBean bean) {
        RolEntity rolEntity = new RolEntity();

        rolEntity.setID_ROL(bean.getID_ROL());
        rolEntity.setTYPE(bean.getTYPE());
        rolEntity.setDESCRIPTION(bean.getDESCRIPTION());

        return rolEntity;
    }

}
