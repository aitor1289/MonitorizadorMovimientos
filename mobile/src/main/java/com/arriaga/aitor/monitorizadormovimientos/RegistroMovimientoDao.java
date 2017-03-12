package com.arriaga.aitor.monitorizadormovimientos;

/**
 * Created by goati on 26/02/2017.
 */

public interface RegistroMovimientoDao {

    RegistroMovimientoBean find(RegistroMovimientoBean regMovBean);

    boolean insert(RegistroMovimientoBean regMovBean);

    boolean delete(RegistroMovimientoBean regMovBean);

    boolean update(RegistroMovimientoBean regMovBean);
}
