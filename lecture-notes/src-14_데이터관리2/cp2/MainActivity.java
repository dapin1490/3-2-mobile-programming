package com.example.cp2demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.CallLog;
import android.widget.TextView;

import static android.Manifest.permission.READ_CALL_LOG;
import static android.Manifest.permission.WRITE_CALL_LOG;

public class MainActivity extends AppCompatActivity {
    TextView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view = findViewById(R.id.tv);
        if (checkSelfPermission(READ_CALL_LOG) == PackageManager.PERMISSION_DENIED ||
                checkSelfPermission(WRITE_CALL_LOG) == PackageManager.PERMISSION_DENIED) {
            requestPermissions(new String[]{READ_CALL_LOG, WRITE_CALL_LOG}, 1);
            return;
        } else
            makeDisplay();
    }

    void makeDisplay() {
        Cursor c = getContentResolver().query(CallLog.Calls.CONTENT_URI, null, null, null, null);

        int i1 = c.getColumnIndex(CallLog.Calls.DATE);
        int i2 = c.getColumnIndex(CallLog.Calls.NUMBER);
        int i3 = c.getColumnIndex(CallLog.Calls.DURATION);
        while (c.moveToNext()) {
            view.append(c.getString(i1) + "\n");
            view.append(c.getString(i2) + "\n");
            view.append(c.getString(i3) + "\n");
        }
        c.close();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED
                        && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                    makeDisplay();
                }
        }
    }
}