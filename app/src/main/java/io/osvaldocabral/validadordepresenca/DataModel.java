package io.osvaldocabral.validadordepresenca;

import android.content.Context;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;

import io.osvaldocabral.validadordepresenca.dao.PhotoTokenDatabase;
import io.osvaldocabral.validadordepresenca.model.PhotoToken;

public class DataModel {


    private static DataModel instance = new DataModel();
    private ArrayList<PhotoToken> listPhotoTokens;
    private PhotoTokenDatabase database;
    private Context context;

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
            Toast.makeText(context, R.string.msg_error_save_photo, Toast.LENGTH_LONG).show();
        }

        return id;
    }


    public long updatePhotoToken(PhotoToken photoToken) {
        photoToken.setData(new Date().toString());
        return database.updatePhotoTokenInDB(photoToken);
    }


    public void excludePhotoToken(PhotoToken photoToken) {
        database.deletePhotoTokenDB(photoToken);
        listPhotoTokens.remove(photoToken);
        new File(photoToken.getPhoto()).delete();
    }
}
