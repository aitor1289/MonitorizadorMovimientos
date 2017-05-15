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

    List<TipoMovimientoBean> find(TipoMovimientoBean tipoMovimientoBean) {
        TipoMovimientoEntity regMovEntity = new TipoMovimientoEntity();
        List<TipoMovimientoBean> regMovBeanList = new ArrayList<>();

        String[] campos = new String[]{"ID_REG_MOV", "X", "Y", "Z", "ID_TIPO_MOV", "USUARIOS_ID_USER"};
        String[] args = new String[]{Integer.toString(regMovBean.getID_REG_MOV()), Integer.toString(regMovBean.getX()), Integer.toString(regMovBean.getY()),
                Integer.toString(regMovBean.getZ()), Integer.toString(regMovBean.getUSUARIOS_ID_USER()), Integer.toString(regMovBean.getID_TIPO_MOV_DETECT())};

        Cursor c = db.query("REGISTRO_MOVIMIENTOS", campos, null, args, null, null, null);

        //Nos aseguramos de que existe al menos un registro
        if (c.moveToFirst()) {
            //Recorremos el cursor hasta que no haya más registros
            do {
                //"ID_REG_MOV", "X", "Y", "Z", "ID_TIPO_MOV", "USUARIOS_ID_USER"
                String ID_REG_MOV = c.getString(0);
                String X = c.getString(1);
                String Y = c.getString(2);
                String Z = c.getString(3);
                String ID_TIPO_MOV = c.getString(4);
                String USUARIOS_ID_USER = c.getString(5);

                regMovEntity.setID_REG_MOV(Integer.parseInt(ID_REG_MOV));
                regMovEntity.setX(Integer.parseInt(X));
                regMovEntity.setY(Integer.parseInt(Y));
                regMovEntity.setZ(Integer.parseInt(Z));
                regMovEntity.setUSUARIOS_ID_USER(Integer.parseInt(USUARIOS_ID_USER));
                regMovEntity.setID_TIPO_MOV_DETECT(Integer.parseInt(ID_TIPO_MOV));

                regMovBeanList.add(regMovTransform.TipoMovimientoEntityToBean(regMovEntity));

            } while (c.moveToNext());
        }

        return regMovBeanList;
    }

    boolean insert(TipoMovimientoBean tipoMovimientoBean) {
        boolean resultado = true;

        TipoMovimientoEntity regMovEntity = new TipoMovimientoEntity();

        //Creamos el registro a insertar como objeto ContentValues
        ContentValues nuevoRegistro = new ContentValues();

        //"ID_REG_MOV", "X", "Y", "Z", "ID_TIPO_MOV", "USUARIOS_ID_USER"
        nuevoRegistro.put("ID_REG_MOV", regMovEntity.getID_REG_MOV());
        nuevoRegistro.put("X", regMovEntity.getX());
        nuevoRegistro.put("Y", regMovEntity.getY());
        nuevoRegistro.put("Z", regMovEntity.getZ());
        nuevoRegistro.put("ID_TIPO_MOV", regMovEntity.getID_TIPO_MOV_DETECT());
        nuevoRegistro.put("USUARIOS_ID_USER", regMovEntity.getUSUARIOS_ID_USER());

        //Insertamos el registro en la base de datos
        long insert = db.insert("REGISTRO_MOVIMIENTOS", null, nuevoRegistro);

        if (insert == -1L) resultado = false;

        return resultado;
    }

    boolean delete(TipoMovimientoBean tipoMovimientoBean) {
        boolean resultado = true;

        TipoMovimientoBean TipoMovimientoBean = find(regMovBean).get(0);

        //Eliminamos el registro
        int delete = db.delete("REGISTRO_MOVIMIENTOS", "ID_REG_MOV=" + TipoMovimientoBean.getID_REG_MOV(), null);

        if (delete == 0) resultado = false;

        return resultado;
    }

    boolean update(TipoMovimientoBean tipoMovimientoBean) {
        boolean resultado = true;

        TipoMovimientoBean TipoMovimientoBean = find(regMovBean).get(0);

        //Establecemos los campos-valores a actualizar
        ContentValues valores = new ContentValues();
        //"ID_REG_MOV", "X", "Y", "Z", "ID_TIPO_MOV", "USUARIOS_ID_USER"
        valores.put("X", TipoMovimientoBean.getX());
        valores.put("Y", TipoMovimientoBean.getY());
        valores.put("Z", TipoMovimientoBean.getZ());
        valores.put("ID_TIPO_MOV", TipoMovimientoBean.getID_TIPO_MOV_DETECT());
        valores.put("USUARIOS_ID_USER", TipoMovimientoBean.getUSUARIOS_ID_USER());

        //Actualizamos el registro en la base de datos
        int update = db.update("REGISTRO_MOVIMIENTOS", valores, "ID_REG_MOV=" + TipoMovimientoBean.getID_REG_MOV(), null);

        if (update != 1) resultado = false;

        return resultado;
    }
}
