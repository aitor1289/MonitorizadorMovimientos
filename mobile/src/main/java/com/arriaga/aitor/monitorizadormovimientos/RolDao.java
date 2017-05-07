package com.arriaga.aitor.monitorizadormovimientos;

import java.util.List;

/**
 * Created by goati on 26/02/2017.
 */

public interface RolDao {

    List<RolBean> find(RolBean rolBean);

    boolean insert(RolBean rolBean);

    boolean delete(RolBean rolBean);

    boolean update(RolBean rolBean);
}
