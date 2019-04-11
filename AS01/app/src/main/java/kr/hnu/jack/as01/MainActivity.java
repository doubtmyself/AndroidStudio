package kr.hnu.jack.as01;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButton(View v) {
        switch (v.getId()) {
            case R.id.button:
                Toast.makeText(getApplicationContext(), "시작 버튼이 눌렸어요", Toast.LENGTH_LONG).show();
                break;
            case R.id.button1:
                Intent intent = new Intent(Intent.ACTION_VIEW , Uri.parse("https://www.naver.com/"));
                startActivity(intent);
                break;
            case R.id.button2:
                Intent intent2 = new Intent(Intent.ACTION_VIEW , Uri.parse("tel:010-1234-1234"));
                startActivity(intent2);
                break;


        }

    }
}
