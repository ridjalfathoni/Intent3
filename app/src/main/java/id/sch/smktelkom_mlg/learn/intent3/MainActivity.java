package id.sch.smktelkom_mlg.learn.intent3;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        findViewById (R.id.imagebr).setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick (View v) {
                openWebPage ("http://www.smktelkom-mlg.sch.id/");
            }
        });

        findViewById (R.id.imagesms).setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick (View v) {
                composeSmsMessage ("Pesan dari SMK Telkom Malang");
            }
        });
    }

    private void openWebPage (String url) {
        Uri webpage = Uri.parse (url);
        Intent intent = new Intent (Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity (getPackageManager ()) != null) startActivity (intent);
    }

    private void composeSmsMessage (String message) {
        Intent intent = new Intent (Intent.ACTION_SEND);
        intent.setType ("text/plain");
        intent.putExtra ("sms_body", message);
        if (intent.resolveActivity (getPackageManager ()) != null) startActivity (intent);
    }
}
