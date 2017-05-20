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

public class UsuarioDaoImpl implements UsuarioDao {

    private UsuarioTransform regMovTransform;
    private SQLiteDatabase db;

    public UsuarioDaoImpl(Activity activity) {
        regMovTransform = new UsuarioTransform();
        //Abrimos la base de datos 'DBUsuarios' en modo escritura
        MonitorizadorMovimientosBDSQLiteHelper dbHelper =
                new MonitorizadorMovimientosBDSQLiteHelper(activity, "MonitorizadorMovimientosBD", null, 1);

        this.db = dbHelper.getWritableDatabase();
    }

    public List<UsuarioBean> find(UsuarioBean usuarioBean) {
        UsuarioEntity usuarioEntity = new UsuarioEntity();
        List<UsuarioBean> usuarioBeanList = new ArrayList<>();

        //ID_USER, USERNAME, PASSWORD, NAME, SURENAME1, SURENAME2, PONE, MAIL, ROLES_ID_ROL
        String[] campos = new String[]{"ID_USER", "USERNAME", "PASSWORD", "NAME", "SURENAME1", "SURENAME2", "PONE", "MAIL", "ROLES_ID_ROL"};
        String[] args = new String[]{Integer.toString(usuarioBean.getID_USER()), usuarioBean.getUSERNAME(), usuarioBean.getPASSWORD(),
                usuarioBean.getNAME(), usuarioBean.getSURENAME1(), usuarioBean.getSURENAME2(), usuarioBean.getPHONE(),
                usuarioBean.getMAIL(), Integer.toString(usuarioBean.getROLES_ID_ROL())};

        Cursor c = db.query("USUARIOS", campos, null, args, null, null, null);

        //Nos aseguramos de que existe al menos un registro
        if (c.moveToFirst()) {
            //Recorremos el cursor hasta que no haya más registros
            do {
                //ID_USER, USERNAME, PASSWORD, NAME, SURENAME1, SURENAME2, PONE, MAIL, ROLES_ID_ROL
                String ID_USER = c.getString(0);
                String USERNAME = c.getString(1);
                String PASSWORD = c.getString(2);
                String NAME = c.getString(3);
                String SURENAME1 = c.getString(4);
                String SURENAME2 = c.getString(5);
                String PONE = c.getString(6);
                String MAIL = c.getString(7);
                String ROLES_ID_ROL = c.getString(8);

                usuarioEntity.setID_USER(Integer.parseInt(ID_USER));
                usuarioEntity.setUSERNAME(USERNAME);
                usuarioEntity.setPASSWORD(PASSWORD);
                usuarioEntity.setNAME(NAME);
                usuarioEntity.setSURENAME1(SURENAME1);
                usuarioEntity.setSURENAME2(SURENAME2);
                usuarioEntity.setPHONE(PONE);
                usuarioEntity.setMAIL(MAIL);
                usuarioEntity.setROLES_ID_ROL(Integer.parseInt(ROLES_ID_ROL));

                usuarioBeanList.add(regMovTransform.UsuarioEntityToBean(usuarioEntity));

            } while (c.moveToNext());
        }

        return usuarioBeanList;
    }

    public boolean insert(UsuarioBean usuarioBean) {
        boolean resultado = true;

        UsuarioEntity regMovEntity = regMovTransform.UsuarioEntityBeanToEntity(usuarioBean);

        //Creamos el registro a insertar como objeto ContentValues
        ContentValues nuevoRegistro = new ContentValues();

        //ID_USER, USERNAME, PASSWORD, NAME, SURENAME1, SURENAME2, PONE, MAIL, ROLES_ID_ROL
        nuevoRegistro.put("ID_USER", regMovEntity.getID_USER());
        nuevoRegistro.put("USERNAME", regMovEntity.getUSERNAME());
        nuevoRegistro.put("PASSWORD", regMovEntity.getPASSWORD());
        nuevoRegistro.put("NAME", regMovEntity.getNAME());
        nuevoRegistro.put("SURENAME1", regMovEntity.getSURENAME1());
        nuevoRegistro.put("SURENAME2", regMovEntity.getSURENAME2());
        nuevoRegistro.put("PONE", regMovEntity.getPHONE());
        nuevoRegistro.put("MAIL", regMovEntity.getMAIL());
        nuevoRegistro.put("ROLES_ID_ROL", regMovEntity.getROLES_ID_ROL());

        //Insertamos el registro en la base de datos
        long insert = db.insert("USUARIOS", null, nuevoRegistro);

        if (insert == -1L) resultado = false;

        return resultado;
    }

    public boolean delete(UsuarioBean usuarioBean) {
        boolean resultado = true;

        UsuarioBean UsuarioBean = find(usuarioBean).get(0);

        //Eliminamos el registro
        int delete = db.delete("USUARIOS", "ID_USER=" + UsuarioBean.getID_USER(), null);

        if (delete == 0) resultado = false;

        return resultado;
    }

    public boolean update(UsuarioBean usuarioBean) {
        boolean resultado = true;

        UsuarioBean UsuarioBean = find(usuarioBean).get(0);

        //Establecemos los campos-valores a actualizar
        ContentValues valores = new ContentValues();
        //ID_USER, USERNAME, PASSWORD, NAME, SURENAME1, SURENAME2, PONE, MAIL, ROLES_ID_ROL
        valores.put("ID_USER", usuarioBean.getID_USER());
        valores.put("USERNAME", usuarioBean.getUSERNAME());
        valores.put("PASSWORD", usuarioBean.getPASSWORD());
        valores.put("NAME", usuarioBean.getNAME());
        valores.put("SURENAME1", usuarioBean.getSURENAME1());
        valores.put("SURENAME2", usuarioBean.getSURENAME2());
        valores.put("PONE", usuarioBean.getPHONE());
        valores.put("MAIL", usuarioBean.getMAIL());
        valores.put("ROLES_ID_ROL", usuarioBean.getROLES_ID_ROL());

        //Actualizamos el registro en la base de datos
        int update = db.update("USUARIOS", valores, "ID_USER=" + UsuarioBean.getID_USER(), null);

        if (update != 1) resultado = false;

        return resultado;
    }
}
