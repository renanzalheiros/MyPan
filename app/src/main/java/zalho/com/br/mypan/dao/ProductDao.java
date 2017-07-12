package zalho.com.br.mypan.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by andrepereira on 26/06/17.
 */

public class ProductDao extends SQLiteOpenHelper {

    public ProductDao(Context context) {
        super(context, "dbname", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
