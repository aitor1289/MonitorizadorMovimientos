package com.arriaga.aitor.monitorizadormovimientos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by aarriaga on 08/02/2017.
 */

public class MonitorizadorMovimientosBDSQLiteHelper extends SQLiteOpenHelper {

    Context ctx;

    public MonitorizadorMovimientosBDSQLiteHelper(Context contexto, String nombre,
                                CursorFactory factory, int version) {
        super(contexto, nombre, factory, version);
        this.ctx = contexto;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            int insertCount = insertFromFile(ctx, R.raw.bbddsqlite, db);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAnterior, int versionNueva) {
    }

    public int insertFromFile(Context context, int resourceId, SQLiteDatabase db) throws IOException {
        // Reseting Counter
        int result = 0;

        // Open the resource
        InputStream insertsStream = context.getResources().openRawResource(resourceId);
        BufferedReader insertReader = new BufferedReader(new InputStreamReader(insertsStream));

        // Iterate through lines (assuming each insert has its own line and theres no other stuff)
        while (insertReader.ready()) {
            String insertStmt = insertReader.readLine();
            db.execSQL(insertStmt);
            result++;
        }
        insertReader.close();

        // returning number of inserted rows
        return result;
    }

}
