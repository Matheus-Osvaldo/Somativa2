package io.osvaldocabral.validadordepresenca;

import android.net.Uri;
import android.os.Environment;
import android.util.Log;

import androidx.core.content.FileProvider;

import java.io.File;
import java.util.ArrayList;

public class DataModel {

    private static DataModel instance = new DataModel();

    private DataModel() {
        // Pegar fotos da storage
//        listTokens.add(new PhotoToken("02/05/2021", "Aula de RecyclerView", R.drawable.qr_code1));
//        listTokens.add(new PhotoToken("03/05/2021", "Aula de RecyclerView", R.drawable.qr_code2));
//        listTokens.add(new PhotoToken("04/05/2021", "Aula de RecyclerView", R.drawable.qr_code3));
//        listTokens.add(new PhotoToken("05/05/2021", "Aula de RecyclerView", R.drawable.qr_code4));
//        listTokens.add(new PhotoToken("", "", Uri.fromFile(new File(""))));

        // TODO Melhorar essa rota path
//        File file = new File(Environment.getStorageDirectory().toString()+"/self/primary/Android/data/io.osvaldocabral.validadordepresenca/files/Pictures");
//        File[] pictures = file.listFiles();
//
//        for (File f : pictures) {
//            listTokens.add(new PhotoToken("", "", Uri.fromFile(f).toString()));
//        }
    }

    public static DataModel getInstance() {
        return instance;
    }

    ArrayList<PhotoToken> listTokens = new ArrayList<>();

}
