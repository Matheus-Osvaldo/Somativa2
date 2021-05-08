package io.osvaldocabral.validadordepresenca;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import androidx.core.content.FileProvider;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;

public class DataModel {


    private static DataModel instance = new DataModel();
    private PhotoTokenDatabase database;
    private Context context;

    private ArrayList<PhotoToken> listPhotoTokens;

    public int indexToDetails;


    public void setContext(Context context) {
        this.context = context;
        database = new PhotoTokenDatabase(context);
        listPhotoTokens = database.retrieveAllPhotoTokensFromDB();
    }


    private DataModel() {
    }


    public static DataModel getInstance() {
        return instance;
    }


    public ArrayList<PhotoToken> getListPhotoTokens() {
        return listPhotoTokens;
    }


    public long addPhotoToken(PhotoToken photoToken) {
        long id = database.createPhotoTokenInDB(photoToken);
        if(id > 0) {
            photoToken.setId(id);
            listPhotoTokens.add(photoToken);
        }
        else {
            Toast.makeText(context, "Erro ao salvar foto!", Toast.LENGTH_LONG).show();
        }

        return id;
    }


    public long updatePhotoToken(int indexPhotoToken, PhotoToken photoToken) {
        photoToken.setData(new Date().toString());
        return database.updatePhotoTokenInDB(indexPhotoToken, photoToken);
    }


    public long excludePhotoToken(int indexPhotoToken) {
        return database.deletePhotoTokenDB(indexPhotoToken);
    }
}
