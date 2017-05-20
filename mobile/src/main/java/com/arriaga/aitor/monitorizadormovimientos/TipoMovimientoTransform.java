package com.arriaga.aitor.monitorizadormovimientos;

/**
 * Created by goati on 26/02/2017.
 */

public class TipoMovimientoTransform {

    public TipoMovimientoBean TipoMovimientoEntityToBean(TipoMovimientoEntity entity) {
        TipoMovimientoBean TipoMovimientoBean = new TipoMovimientoBean();

        TipoMovimientoBean.setID_TIPO_MOV(entity.getID_TIPO_MOV());
        TipoMovimientoBean.setDESCRIPTION(entity.getDESCRIPTION());
        TipoMovimientoBean.setTYPE(entity.getTYPE());

        return TipoMovimientoBean;
    }

    public TipoMovimientoEntity TipoMovimientoBeanToEntity(TipoMovimientoBean bean) {
        TipoMovimientoEntity TipoMovimientoEntity = new TipoMovimientoEntity();

        TipoMovimientoEntity.setID_TIPO_MOV(bean.getID_TIPO_MOV());
        TipoMovimientoEntity.setTYPE(bean.getTYPE());
        TipoMovimientoEntity.setDESCRIPTION(bean.getDESCRIPTION());

        return TipoMovimientoEntity;
    }
}
