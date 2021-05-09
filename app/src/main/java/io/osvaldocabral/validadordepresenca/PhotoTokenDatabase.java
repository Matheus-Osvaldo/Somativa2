package io.osvaldocabral.validadordepresenca;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;


public class PhotoTokenDatabase extends SQLiteOpenHelper {


    private static final String DB_NAME = "phototoken.sqlite";
    private static final int DB_VERSION = 1;
    private static final String DB_TABLE = "PhotoToken";
    private static final String COL_ID = "id";
    private static final String COL_DATE = "data";
    private static final String COL_DESCRIPTION = "descricao";
    private static final String COL_PHOTO = "photo";
    private Context context;


    public PhotoTokenDatabase(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        this.context = context;
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = String.format("CREATE TABLE IF NOT EXISTS %s(" +
                " %s INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " %s TEXT, " +
                " %s TEXT, " +
                " %s TEXT " +
                ")", DB_TABLE, COL_ID, COL_DATE, COL_DESCRIPTION, COL_PHOTO);
        sqLiteDatabase.execSQL(query);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }


    public long createPhotoTokenInDB(PhotoToken photoToken) {
        SQLiteDatabase database = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_DATE, photoToken.getData());
        values.put(COL_DESCRIPTION, photoToken.getDescricacao());
        values.put(COL_PHOTO, photoToken.getPhoto());

        long id = database.insert(DB_TABLE, null, values);

        database.close();
        return id;
    }


    public ArrayList<PhotoToken> retrieveAllPhotoTokensFromDB() {
        ArrayList<PhotoToken> listPhotoToken = new ArrayList<>();
        SQLiteDatabase database = getReadableDatabase();
        Cursor cursor = database.query(DB_TABLE,
                null,
                null,
                null,
                null,
                null,
                null
        );

        if(cursor.moveToFirst()) {
            do {
                long id = cursor.getLong(cursor.getColumnIndex(COL_ID));
                String date  = cursor.getString(cursor.getColumnIndex(COL_DATE));
                String description  = cursor.getString(cursor.getColumnIndex(COL_DESCRIPTION));
                String photo = cursor.getString(cursor.getColumnIndex(COL_PHOTO));
                PhotoToken photoToken = new PhotoToken(id, date, description, photo);

                listPhotoToken.add(photoToken);
            }
            while(cursor.moveToNext());
        }

        database.close();
        return listPhotoToken;
    }


    public long updatePhotoTokenInDB(PhotoToken photoToken) {
        SQLiteDatabase database = getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COL_DATE, photoToken.getData());
        values.put(COL_DESCRIPTION, photoToken.getDescricacao());
        values.put(COL_PHOTO, photoToken.getPhoto());
        String query = String.format(" %s = %s ", COL_ID, photoToken.getId());
        long id = database.update(DB_TABLE, values, query, null);

        database.close();

        return id;
    }


    public long deletePhotoTokenDB(PhotoToken photoToken) {
        SQLiteDatabase database = getWritableDatabase();
        String query = String.format(" %s = %s ", COL_ID, photoToken.getId());

        long id = database.delete(DB_TABLE, query, null);

        return id;
    }

}
