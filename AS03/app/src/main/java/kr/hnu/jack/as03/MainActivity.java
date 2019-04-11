package kr.hnu.jack.as03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;
//1) intent는 택배다. intent 정의시 매개변수로 출발지과 도착지을 매개변수로 갖는다.
//2) putExtra(name:"",String)를 이용해 택배에 넣을 내용물의 종류(=해더)와 내용(String)을 집어넣는다.
//3_1) startActivity() 우편기사로써 편지봉투를 들고 intent의 도착지로 출발한다.
//3_2) startActivityForResult(,) 우편기사로써 편지봉투를 받고 출발지 정보(REQCODE_ACTEDIT)를 가져가 회송이 가능하게 한다.
public class MainActivity extends AppCompatActivity {
    final static int REQCODE_ACTEDIT = 1001;
    //REQCODE_ACTEDIT : 뒤로가기나 버튼으로 intent한 자료를 되돌려 받을 경우
    TextView TextID;
    TextView TextPa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextID = (TextView) findViewById(R.id.id);
        TextPa = (TextView) findViewById(R.id.password);

    }

    public void onClicked(View v) {
        switch (v.getId()) {
            case R.id.EditT:
                Intent intent = new Intent(this, SubActivity.class);
                intent.putExtra("textIn", TextID.getText().toString());
                intent.putExtra("textPa", TextPa.getText().toString());
                startActivityForResult(intent, REQCODE_ACTEDIT);
                //엑티비티 시작할때 되돌아올 주소 입력
                break;
        }
    }

    /**
     * onActivityResult=> 행동의 결과 => 택배를 환송받음
     * 처음 출발지 코드, 도착지에서 체크한 코드, 택배 3가지를 매개변수로 삼는다.
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {//출발지 코드로 택배 확인
            case REQCODE_ACTEDIT:
                if (resultCode== RESULT_OK) {//도착지 체크 코드 확인
                    TextID.setText(data.getStringExtra("RId"));
                    TextPa.setText(data.getStringExtra("RPa"));
                    Toast.makeText(getApplicationContext(), "성공적인 입력", Toast.LENGTH_SHORT).show();

                }
                else if (resultCode == RESULT_CANCELED)
                    Toast.makeText(getApplicationContext(), "입력하지 않고 되돌아왔습니다.", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
