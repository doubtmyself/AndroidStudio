package kr.hnu.jack.as02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView text1;
    TextView text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text1 = (TextView)findViewById(R.id.id);
        text2 = (TextView)findViewById(R.id.password);


    }

    public void onClickButton(View view) {
        Toast.makeText(getApplicationContext(),"이동중",Toast.LENGTH_LONG).show();

        Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
        intent.putExtra("id",text1.getText().toString());
        intent.putExtra("password",text1.getText().toString());
        startActivity(intent);
    }
}
