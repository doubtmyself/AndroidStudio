package kr.hnu.jack.as03;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class SubActivity extends AppCompatActivity {
    EditText editId;
    EditText editPa;
    Intent getI;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        editId = findViewById(R.id.EditId);
        editPa = findViewById(R.id.EditPa);

        getI = getIntent();
        //getIntent() intent 정의시 출발점과 도착점을 씀 -> subActivity에서 받을수 있다.
        //getI에 택배를 둠
        String text = getI.getStringExtra("textIn");
        //헤더를 보며 택배를 깐다.
        //id, 비밀번호 하나라도 없으면 검색이 불가능하므로 id만 조회하여 hint 입력
        editId.setText(text);
        //MainActivity에서 textin를 받아서 editText에 넣어야 초기값 판별 가능
        if (text.equals("초기값")) {
            editId.setHint("초기값입니다.");
            editPa.setHint("초기값입니다.");
        } else {
            editId.setHint("다시입력하시겠습니까");
            editPa.setHint("다시입력하시겠습니까");
        }
        editId.setText("");
        editPa.setText("");
        //hint가 출력되게 null 값으로 변경

    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public void onClicked(View v) {
        //java와 xml는 따로다 null로 초기화해줬으므로
        // -> 입력하고 클릭하는 시점에서 한번더 불러와줘야 한다!!!
        editId = findViewById(R.id.EditId);
        editPa = findViewById(R.id.EditPa);


        switch (v.getId()) {
            case R.id.btn1:
                if (editId.getText().toString().equals("") || editPa.getText().toString().equals("")) {
                    LinearLayout linearLayoutR = findViewById(R.id.container);
                    Toast toast = Toast.makeText(getApplicationContext(), "ID 또는 패스워드 입력", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER,0,300);
                    toast.show();

                    return;
                }
                getI.putExtra("RId", editId.getText().toString());
                getI.putExtra("RPa", editPa.getText().toString());
                //startActivityForResult를 이용해 택배를 회송할것이기 때문에 받았던 택배상자에 더 집어넣는다.
                setResult(RESULT_OK, getI);
                //RUSLT_OK라는 체크 코드와 함께 택배 회송
                finish();
                break;
            case R.id.btn2:
                setResult(RESULT_CANCELED);
                //RUSLT_OK라는 잘못 받았다 체크와 함께 택배 회송
                finish();
                break;
        }
    }
}


