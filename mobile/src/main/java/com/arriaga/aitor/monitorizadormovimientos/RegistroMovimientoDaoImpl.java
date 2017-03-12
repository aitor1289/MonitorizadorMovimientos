package com.arriaga.aitor.monitorizadormovimientos;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by goati on 26/02/2017.
 */

public class RegistroMovimientoDaoImpl implements RegistroMovimientoDao {

    private RegistroMovimientoTransform regMovTransform;
    private SQLiteDatabase db;

    public RegistroMovimientoDaoImpl() {
        regMovTransform = new RegistroMovimientoTransform();
        //Abrimos la base de datos 'DBUsuarios' en modo escritura
        MonitorizadorMovimientosBDSQLiteHelper dbHelper =
                new MonitorizadorMovimientosBDSQLiteHelper(this, "MonitorizadorMovimientosBD", null, 1);

        this.db = dbHelper.getWritableDatabase();
    }

    public RegistroMovimientoBean find(RegistroMovimientoBean regMovBean) {
        RegistroMovimientoEntity regMovEntity = new RegistroMovimientoEntity();

        String[] campos = new String[]{"codigo", "nombre"};
        String[] args = new String[]{"usu1"};

        Cursor c = db.query("Usuarios", campos, "nombre=?", args, null, null, null);

        //Nos aseguramos de que existe al menos un registro
        if (c.moveToFirst()) {
            //Recorremos el cursor hasta que no haya más registros
            do {
                String codigo = c.getString(0);
                String nombre = c.getString(1);
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
