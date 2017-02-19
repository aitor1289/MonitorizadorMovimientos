package com.arriaga.aitor.monitorizadormovimientos;

import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by aarriaga on 08/02/2017.
 */

public class AndroidBaseDatos extends Activity {

    private SQLiteDatabase db;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        //Abrimos la base de datos 'DBUsuarios' en modo escritura
        MonitorizadorMovimientosBDSQLiteHelper dbHelper =
                new MonitorizadorMovimientosBDSQLiteHelper(this, "MonitorizadorMovimientosBD", null, 1);

        this.db = dbHelper.getWritableDatabase();

        //Si hemos abierto correctamente la base de datos
        if (db != null) {
            try {
                int insertCount = insertFromFile(this, R.raw.bbddsqlite);
                Toast.makeText(this, "Rows loaded from file= " + insertCount, Toast.LENGTH_SHORT).show();
            } catch (IOException e) {
                Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }
        }
    }

    public int insertFromFile(Context context, int resourceId) throws IOException {
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
