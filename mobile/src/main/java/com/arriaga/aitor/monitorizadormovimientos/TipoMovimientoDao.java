package com.arriaga.aitor.monitorizadormovimientos;

import java.util.List;

/**
 * Created by goati on 26/02/2017.
 */

public interface TipoMovimientoDao {
    List<TipoMovimientoBean> find(TipoMovimientoBean tipoMovimientoBean);

    boolean insert(TipoMovimientoBean tipoMovimientoBean);

    boolean delete(TipoMovimientoBean tipoMovimientoBean);

    boolean update(TipoMovimientoBean tipoMovimientoBean);
}
