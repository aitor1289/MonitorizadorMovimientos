package com.arriaga.aitor.monitorizadormovimientos;

import java.util.List;

/**
 * Created by goati on 26/02/2017.
 */

public interface RegistroMovimientoDao {

    List<RegistroMovimientoBean> find(RegistroMovimientoBean regMovBean);

    boolean insert(RegistroMovimientoBean regMovBean);

    boolean delete(RegistroMovimientoBean regMovBean);

    boolean update(RegistroMovimientoBean regMovBean);
}
