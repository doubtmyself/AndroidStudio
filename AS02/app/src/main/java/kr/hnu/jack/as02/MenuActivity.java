package kr.hnu.jack.as02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {
    String id;
    String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Intent intent = getIntent();
         id = intent.getStringExtra("id");
         password = intent.getStringExtra("password");

    }


    public void onClickButton(View view) {
        switch(view.getId()){
            case R.id.button:
                finish();
                break;
            case R.id.button1:
                Toast.makeText(getApplicationContext(),"아이디:"+id+"\n비밀번호:"+password,Toast.LENGTH_SHORT).show();
                break;

        }

    }
}
