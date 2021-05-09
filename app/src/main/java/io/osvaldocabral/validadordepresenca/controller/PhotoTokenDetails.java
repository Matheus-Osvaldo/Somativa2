package io.osvaldocabral.validadordepresenca.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

import io.osvaldocabral.validadordepresenca.DataModel;
import io.osvaldocabral.validadordepresenca.R;
import io.osvaldocabral.validadordepresenca.model.PhotoToken;

public class PhotoTokenDetails extends AppCompatActivity {

    TextView textViewDate;
    EditText editTextTextDescription;
    ImageView imageViewDetail;
    int indexDetail;
    PhotoToken photoToken;
    SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_token_details);
        setTitle(getString(R.string.title_details));

        indexDetail = DataModel.getInstance().indexToDetails;
        photoToken = DataModel.getInstance().getListPhotoTokens().get(indexDetail);

        textViewDate = findViewById(R.id.textViewDate);
        editTextTextDescription = findViewById(R.id.editTextTextDescription);
        imageViewDetail = findViewById(R.id.imageViewDetail);
        seekBar = findViewById(R.id.seekBar);

        textViewDate.setText(photoToken.getData());
        editTextTextDescription.setText(photoToken.getDescricacao());
        File file = new File(photoToken.getPhoto());
        imageViewDetail.setImageURI(Uri.fromFile(file));

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                float scale = ((progress / 100.0f) + 1);
                imageViewDetail.setScaleX(scale);
                imageViewDetail.setScaleY(scale);
            }


            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}


            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

    }


    public void updateDetailsClicked(View view) {
        String description = editTextTextDescription.getText().toString();
        photoToken.setDescricacao(description);
        DataModel.getInstance().updatePhotoToken(photoToken);
        Toast.makeText(this, R.string.msg_alert_updated_successfully, Toast.LENGTH_LONG).show();
        super.onBackPressed();
    }


    public void excludePhotoTokenClicked(View view) {
        DataModel.getInstance().excludePhotoToken(photoToken);
        Toast.makeText(this, R.string.msg_alert_successfully_deleted, Toast.LENGTH_LONG).show();
        super.onBackPressed();
    }

}