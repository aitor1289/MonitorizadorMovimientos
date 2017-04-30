package com.arriaga.aitor.monitorizadormovimientos;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by goati on 26/02/2017.
 */

public class RegistroMovimientoDaoImpl implements RegistroMovimientoDao {

    private RegistroMovimientoTransform regMovTransform;
    private SQLiteDatabase db;

    public RegistroMovimientoDaoImpl(Activity activity) {
        regMovTransform = new RegistroMovimientoTransform();
        //Abrimos la base de datos 'DBUsuarios' en modo escritura
        MonitorizadorMovimientosBDSQLiteHelper dbHelper =
                new MonitorizadorMovimientosBDSQLiteHelper(activity, "MonitorizadorMovimientosBD", null, 1);

        this.db = dbHelper.getWritableDatabase();
    }

    public RegistroMovimientoBean find(RegistroMovimientoBean regMovBean) {
        RegistroMovimientoEntity regMovEntity = new RegistroMovimientoEntity();

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

            } while (c.moveToNext());
        }

        RegistroMovimientoBean regMovBeanNew = regMovTransform.RegistroMovimientoEntityToBean(regMovEntity);

        return regMovBeanNew;
    }

    public boolean insert(RegistroMovimientoBean regMovBean) {
        boolean resultado = false;

        RegistroMovimientoEntity regMovEntity = new RegistroMovimientoEntity();

        //Creamos el registro a insertar como objeto ContentValues
        ContentValues nuevoRegistro = new ContentValues();
        nuevoRegistro.put("codigo", "6");
        nuevoRegistro.put("nombre", "usuariopru");

        //Insertamos el registro en la base de datos
        db.insert("Usuarios", null, nuevoRegistro);

        RegistroMovimientoBean regMovBeanNew = regMovTransform.RegistroMovimientoEntityToBean(regMovEntity);

        return resultado;
    }

    public boolean update(RegistroMovimientoBean regMovBean) {
        boolean resultado = false;

        RegistroMovimientoEntity regMovEntity = new RegistroMovimientoEntity();

        //Establecemos los campos-valores a actualizar
        ContentValues valores = new ContentValues();
        valores.put("nombre", "usunuevo");

        //Actualizamos el registro en la base de datos
        db.update("Usuarios", valores, "codigo=6", null);

        RegistroMovimientoBean regMovBeanNew = regMovTransform.RegistroMovimientoEntityToBean(regMovEntity);

        return resultado;
    }

    public boolean delete(RegistroMovimientoBean regMovBean) {
        boolean resultado = false;

        RegistroMovimientoEntity regMovEntity = new RegistroMovimientoEntity();

        //Eliminamos el registro del usuario '6'
        db.delete("Usuarios", "codigo=6", null);

        RegistroMovimientoBean regMovBeanNew = regMovTransform.RegistroMovimientoEntityToBean(regMovEntity);

        return resultado;
    }

}
