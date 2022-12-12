package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView result;
    final int READ_CONTACT_CODE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = findViewById(R.id.result);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnread:
                tryOutContact();
                break;
            case R.id.btnreset:
                result.setText("주소록");
                break;
        }
    }

    void tryOutContact() {
        if (checkSelfPermission(Manifest.permission.READ_CONTACTS)
                == PackageManager.PERMISSION_GRANTED) {
            outContact();
        } else {
            requestPermissions(new String[]{Manifest.permission.READ_CONTACTS},
                    READ_CONTACT_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case READ_CONTACT_CODE:
                if (grantResults.length > 0 && grantResults[0]
                        == PackageManager.PERMISSION_GRANTED) {
                    outContact();
                }
        }
    }

    void outContact() {
        ContentResolver cr = getContentResolver();
        Cursor c = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                null, null, null, null);
        int i1 = c.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME);
        int i2 = c.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);

        StringBuilder sb = new StringBuilder();
        while(c.moveToNext()) {
            sb.append(c.getString(i1) + " " +  c.getString(i2) + "\n");
        }
        result.setText(sb.toString());
        c.close();
    }
}