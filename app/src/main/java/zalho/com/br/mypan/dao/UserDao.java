package zalho.com.br.mypan.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by andrepereira on 11/07/17.
 */

public class UserDao extends SQLiteOpenHelper {

	public UserDao(Context context) {
		super(context, "usuario", null, 1);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

	}
}
