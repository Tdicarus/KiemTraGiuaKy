package ngothuctridat.sv61133478.baitho;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private AdapterView adapterView;
    private ArrayAdapter arrayAdapter;
    private ListView listView;
    private Button them;
    private Button xoa;
    private EditText nhapten;
    private ArrayList<String> ListBT;
    int vt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nhapten = (EditText) findViewById(R.id.nhapten);
        them = (Button) findViewById(R.id.them);
        xoa = (Button) findViewById(R.id.xoa);
        listView = (ListView) findViewById(R.id.listView);


        ListBT = new ArrayList<String>();
        ListBT.add("Quê Hương - Đỗ Trung Quân");
        ListBT.add("Quê Hương - Nguyễn Đình Huân");
        ListBT.add("Về Làng - Nguyễn Duy");

        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ListBT);
        listView.setAdapter(arrayAdapter);


        them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String item = nhapten.getText().toString().trim();
                if(TextUtils.isEmpty(item))
                {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập dữ liệu", Toast.LENGTH_LONG).show();
                    return;
                }
                ListBT.add(item);

                arrayAdapter.notifyDataSetChanged();
            }
        });


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                nhapten.setText(ListBT.get((int)i));
                vt = i;
            }
        });

        xoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tenbt = nhapten.getText().toString();
                ListBT.set(vt,tenbt);
                arrayAdapter.notifyDataSetChanged();
            }
        });


        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int vt, long l) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("Xác nhận");
                dialog.setMessage("Chắc chắn muốn xóa?");
                dialog.setPositiveButton("Co", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ListBT.remove(vt);
                        arrayAdapter.notifyDataSetChanged();

                    }
                });

                dialog.setNegativeButton("Khong", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                AlertDialog alertDialog = dialog.create();
                alertDialog.show();
                return  false;
            }


        });

    }



}