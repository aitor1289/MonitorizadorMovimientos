package com.arriaga.aitor.monitorizadormovimientos;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by goati on 26/02/2017.
 */

public class TipoMovimientoDaoImpl implements TipoMovimientoDao {

    private TipoMovimientoTransform regMovTransform;
    private SQLiteDatabase db;

    public TipoMovimientoDaoImpl(Activity activity) {
        regMovTransform = new TipoMovimientoTransform();
        //Abrimos la base de datos 'DBUsuarios' en modo escritura
        MonitorizadorMovimientosBDSQLiteHelper dbHelper =
                new MonitorizadorMovimientosBDSQLiteHelper(activity, "MonitorizadorMovimientosBD", null, 1);

        this.db = dbHelper.getWritableDatabase();
    }

    public List<TipoMovimientoBean> find(TipoMovimientoBean tipoMovimientoBean) {
        TipoMovimientoEntity tipoMovimientoEntity = new TipoMovimientoEntity();
        List<TipoMovimientoBean> tipoMovimientoBeanList = new ArrayList<>();

        //ID_TIPO_MOV", "TYPE", "DESCRIPTION"
        String[] campos = new String[]{"ID_TIPO_MOV", "TYPE", "DESCRIPTION"};
        String[] args = new String[]{Integer.toString(tipoMovimientoBean.getID_TIPO_MOV()), tipoMovimientoBean.getTYPE(), tipoMovimientoBean.getDESCRIPTION()};

        Cursor c = db.query("TIPO_MOVIMIENTOS", campos, null, args, null, null, null);

        //Nos aseguramos de que existe al menos un registro
        if (c.moveToFirst()) {
            //Recorremos el cursor hasta que no haya más registros
            do {
                //ID_TIPO_MOV", "TYPE", "DESCRIPTION"
                String ID_TIPO_MOV = c.getString(0);
                String TYPE = c.getString(1);
                String DESCRIPTION = c.getString(2);

                tipoMovimientoEntity.setID_TIPO_MOV(Integer.parseInt(ID_TIPO_MOV));
                tipoMovimientoEntity.setTYPE(TYPE);
                tipoMovimientoEntity.setDESCRIPTION(DESCRIPTION);

                tipoMovimientoBeanList.add(regMovTransform.TipoMovimientoEntityToBean(tipoMovimientoEntity));

            } while (c.moveToNext());
        }

        return tipoMovimientoBeanList;
    }

    public boolean insert(TipoMovimientoBean tipoMovimientoBean) {
        boolean resultado = true;

        TipoMovimientoEntity regMovEntity = regMovTransform.TipoMovimientoBeanToEntity(tipoMovimientoBean);

        //Creamos el registro a insertar como objeto ContentValues
        ContentValues nuevoRegistro = new ContentValues();

        //ID_TIPO_MOV", "TYPE", "DESCRIPTION"
        nuevoRegistro.put("ID_TIPO_MOV", regMovEntity.getID_TIPO_MOV());
        nuevoRegistro.put("TYPE", regMovEntity.getTYPE());
        nuevoRegistro.put("DESCRIPTION", regMovEntity.getDESCRIPTION());


        //Insertamos el registro en la base de datos
        long insert = db.insert("TIPO_MOVIMIENTOS", null, nuevoRegistro);

        if (insert == -1L) resultado = false;

        return resultado;
    }

    public boolean delete(TipoMovimientoBean tipoMovimientoBean) {
        boolean resultado = true;

        TipoMovimientoBean TipoMovimientoBean = find(tipoMovimientoBean).get(0);

        //Eliminamos el registro
        int delete = db.delete("TIPO_MOVIMIENTOS", "ID_TIPO_MOV=" + TipoMovimientoBean.getID_TIPO_MOV(), null);

        if (delete == 0) resultado = false;

        return resultado;
    }

    public boolean update(TipoMovimientoBean tipoMovimientoBean) {
        boolean resultado = true;

        TipoMovimientoBean TipoMovimientoBean = find(tipoMovimientoBean).get(0);

        //Establecemos los campos-valores a actualizar
        ContentValues valores = new ContentValues();
        //"ID_REG_MOV", "X", "Y", "Z", "ID_TIPO_MOV", "USUARIOS_ID_USER"
        //ID_TIPO_MOV", "TYPE", "DESCRIPTION"
        valores.put("ID_TIPO_MOV", tipoMovimientoBean.getID_TIPO_MOV());
        valores.put("TYPE", tipoMovimientoBean.getTYPE());
        valores.put("DESCRIPTION", tipoMovimientoBean.getDESCRIPTION());

        //Actualizamos el registro en la base de datos
        int update = db.update("TIPO_MOVIMIENTOS", valores, "ID_TIPO_MOV=" + TipoMovimientoBean.getID_TIPO_MOV(), null);

        if (update != 1) resultado = false;

        return resultado;
    }
}
