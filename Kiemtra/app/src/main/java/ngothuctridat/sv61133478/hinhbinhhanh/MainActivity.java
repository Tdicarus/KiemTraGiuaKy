package ngothuctridat.sv61133478.hinhbinhhanh;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button chuvi;
    private Button dientich;
    private TextView tvKq;
    private EditText canhben;
    private EditText canhday;
    private EditText chieucao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TimWidget();
    }


        public void TimWidget()
        {
            chuvi = (Button) findViewById(R.id.chuvi);
            dientich = (Button) findViewById(R.id.dientich);
        }

        //Hàm xử lý chu vi
        public void Xuly_Chuvi (View view)
        {
             canhben = (EditText) findViewById(R.id.canhben);
            int soA = Integer.parseInt ( canhben.getText().toString() );
             canhday = (EditText) findViewById(R.id.canhday);
            int soB = Integer.parseInt ( canhday.getText().toString() );
            int Kq = (soA + soB)*2;
             tvKq = (TextView) findViewById(R.id.ketqua);
            tvKq.setText ( "Chu vi là: " + Kq );
        }

        //Hàm xử lý diện tích
        public void Xuly_Dientich (View view)
        {
            canhday = (EditText) findViewById(R.id.canhday);
            int soB = Integer.parseInt ( canhday.getText().toString() );
            chieucao = (EditText) findViewById(R.id.chieucao);
            int soC = Integer.parseInt ( chieucao.getText().toString() );
            int Kq = soB*soC ;
            tvKq = (TextView) findViewById(R.id.ketqua);
            tvKq.setText ( "Diện tích là: " + Kq );
        }






}