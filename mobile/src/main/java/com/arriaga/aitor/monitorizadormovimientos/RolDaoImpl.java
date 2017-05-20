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

public class RolDaoImpl implements RolDao {

    private RolTransform rolTransform;
    private SQLiteDatabase db;

    public RolDaoImpl(Activity activity) {
        rolTransform = new RolTransform();
        //Abrimos la base de datos 'DBUsuarios' en modo escritura
        MonitorizadorMovimientosBDSQLiteHelper dbHelper =
                new MonitorizadorMovimientosBDSQLiteHelper(activity, "MonitorizadorMovimientosBD", null, 1);

        this.db = dbHelper.getWritableDatabase();
    }

    public List<RolBean> find(RolBean rolBean) {
        RolEntity rolEntity = new RolEntity();
        List<RolBean> rolBeanList = new ArrayList<>();

        String[] campos = new String[]{"ID_ROL", "TYPE", "DESCRIPTION"};
        String[] args = new String[]{Integer.toString(rolBean.getID_ROL()), rolBean.getTYPE(), rolBean.getDESCRIPTION()};

        Cursor c = db.query("ROLES", campos, null, args, null, null, null);

        //Nos aseguramos de que existe al menos un registro
        if (c.moveToFirst()) {
            //Recorremos el cursor hasta que no haya más registros
            do {
                //"ID_ROL", "DESCRIPTION", "TYPE"
                String ID_ROL = c.getString(0);
                String TYPE = c.getString(1);
                String DESCRIPTION = c.getString(2);

                rolEntity.setID_ROL(Integer.parseInt(ID_ROL));
                rolEntity.setTYPE(TYPE);
                rolEntity.setDESCRIPTION(DESCRIPTION);

                rolBeanList.add(rolTransform.RolEntityToBean(rolEntity));

            } while (c.moveToNext());
        }

        return rolBeanList;
    }

    public boolean insert(RolBean rolBean) {
        boolean resultado = true;

        RolEntity rolEntity = rolTransform.RolBeanToEntity(rolBean);

        //Creamos el registro a insertar como objeto ContentValues
        ContentValues nuevoRegistro = new ContentValues();

        //"ID_ROL", "DESCRIPTION", "TYPE"
        nuevoRegistro.put("ID_ROL", rolEntity.getID_ROL());
        nuevoRegistro.put("TYPE", rolEntity.getTYPE());
        nuevoRegistro.put("DESCRIPTION", rolEntity.getDESCRIPTION());

        //Insertamos el registro en la base de datos
        long insert = db.insert("ROLES", null, nuevoRegistro);

        if (insert == -1L) resultado = false;

        return resultado;
    }

    public boolean delete(RolBean rolBean) {
        boolean resultado = true;

        RolBean RolBean = find(rolBean).get(0);

        //Eliminamos el registro
        int delete = db.delete("ROLES", "ID_ROL=" + RolBean.getID_ROL(), null);

        if (delete == 0) resultado = false;

        return resultado;
    }

    public boolean update(RolBean rolBean) {
        boolean resultado = true;

        RolBean RolBean = find(rolBean).get(0);

        //Establecemos los campos-valores a actualizar
        ContentValues valores = new ContentValues();
        //"ID_ROL", "DESCRIPTION", "TYPE"
        valores.put("ID_ROL", RolBean.getID_ROL());
        valores.put("TYPE", RolBean.getTYPE());
        valores.put("DESCRIPTION", RolBean.getDESCRIPTION());

        //Actualizamos el registro en la base de datos
        int update = db.update("ROLES", valores, "ID_ROL=" + RolBean.getID_ROL(), null);

        if (update != 1) resultado = false;

        return resultado;
    }
}
