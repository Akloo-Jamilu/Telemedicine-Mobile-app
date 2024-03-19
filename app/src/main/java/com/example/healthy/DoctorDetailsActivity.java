package com.example.healthy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {
    private String [][] doctorDetails =
            {
                    {"Doctor Name : Ajit Saate", "Hospital Address : Pimpri", "Exp : 5yrs", "Mobile No: 9898989898", "600"},
                    {"Doctor Name : Hassan Lega", "Hospital Address : Bombai", "Exp : 15yrs", "Mobile No: 7878787878", "900"},
                    {"Doctor Name : Habeeb ha", "Hospital Address : Kado", "Exp : 8yrs", "Mobile No: 9594392993", "300"},
                    {"Doctor Name : Emma emmy", "Hospital Address : Abuja", "Exp : 6yrs", "Mobile No: 4352426242662", "500"},
                    {"Doctor Name : Ebube ebu", "Hospital Address : Niger", "Exp : 7yrs", "Mobile No: 64292984682472", "500"},
                    {"Doctor Name : Harrison Har", "Hospital Address : Lagos", "Exp : 5yrs", "Mobile No: 9898989898", "600"},
            };

    private String [][] doctorDetails2 =
            {
                    {"Doctor Name : sam son", "Hospital Address : Pimpri", "Exp : 10yrs", "Mobile No: 9898989898", "600"},
                    {"Doctor Name : aklo Lega", "Hospital Address : Bombai", "Exp : 11yrs", "Mobile No: 7878787878", "900"},
                    {"Doctor Name : joe ha", "Hospital Address : Kado", "Exp : 7yrs", "Mobile No: 9594392993", "300"},
                    {"Doctor Name : ella emmy", "Hospital Address : Abuja", "Exp : 9yrs", "Mobile No: 4352426242662", "500"},
                    {"Doctor Name : farida ebu", "Hospital Address : Niger", "Exp : 3yrs", "Mobile No: 64292984682472", "500"},
                    {"Doctor Name : prais Har", "Hospital Address : Lagos", "Exp : 2yrs", "Mobile No: 9898989898", "600"},
            };

    private String [][] doctorDetails3 =
            {
                    {"Doctor Name : tim Saate", "Hospital Address : Pimpri", "Exp : 15yrs", "Mobile No: 9898989898", "600"},
                    {"Doctor Name : jay Lega", "Hospital Address : Bombai", "Exp : 10yrs", "Mobile No: 7878787878", "900"},
                    {"Doctor Name : john ha", "Hospital Address : Kado", "Exp : 9yrs", "Mobile No: 9594392993", "300"},
                    {"Doctor Name : woe emmy", "Hospital Address : Abuja", "Exp : 9yrs", "Mobile No: 4352426242662", "500"},
                    {"Doctor Name : kou ebu", "Hospital Address : Niger", "Exp : 12yrs", "Mobile No: 64292984682472", "500"},
                    {"Doctor Name : wee Har", "Hospital Address : Lagos", "Exp : 18yrs", "Mobile No: 9898989898", "600"},
            };

    private String [][] doctorDetails4 =
            {
                    {"Doctor Name : lam Saate", "Hospital Address : Pimpri", "Exp : 5yrs", "Mobile No: 9898989898", "600"},
                    {"Doctor Name : sam Lega", "Hospital Address : Bombai", "Exp : 12yrs", "Mobile No: 7878787878", "900"},
                    {"Doctor Name : hanna ha", "Hospital Address : Kado", "Exp : 21yrs", "Mobile No: 9594392993", "300"},
                    {"Doctor Name : Emma jay", "Hospital Address : Abuja", "Exp : 4yrs", "Mobile No: 4352426242662", "500"},
                    {"Doctor Name : akpos ebu", "Hospital Address : Niger", "Exp : 19yrs", "Mobile No: 64292984682472", "500"},
                    {"Doctor Name : sayi Har", "Hospital Address : Lagos", "Exp : 4yrs", "Mobile No: 9898989898", "600"},
            };

    private String [][] doctorDetails5 =
            {
                    {"Doctor Name : march Saate", "Hospital Address : Pimpri", "Exp : 25yrs", "Mobile No: 9898989898", "600"},
                    {"Doctor Name : isaac Lega", "Hospital Address : Bombai", "Exp : 5yrs", "Mobile No: 7878787878", "900"},
                    {"Doctor Name : low ha", "Hospital Address : Kado", "Exp : 18yrs", "Mobile No: 9594392993", "300"},
                    {"Doctor Name : rain emmy", "Hospital Address : Abuja", "Exp : 16yrs", "Mobile No: 4352426242662", "500"},
                    {"Doctor Name : gillet ebu", "Hospital Address : Niger", "Exp : 9yrs", "Mobile No: 64292984682472", "500"},
                    {"Doctor Name : remi Har", "Hospital Address : Lagos", "Exp : 10yrs", "Mobile No: 9898989898", "600"},
            };
    TextView tv;
    Button btn;
    String [][] doctorDetail = {};
    ArrayList list;
    HashMap<String, String> item;
    SimpleAdapter sa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv = findViewById(R.id.textViewDDTitle);
        btn = findViewById(R.id.buttonDDBack);
        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("family physicians")==0)
            doctorDetail = doctorDetails;
        else
        if(title.compareTo("Dietitian")==0)
            doctorDetail = doctorDetails2;
        else
        if(title.compareTo("Dentist")==0)
            doctorDetail = doctorDetails3;
        else
        if(title.compareTo("Surgeon")==0)
            doctorDetail = doctorDetails4;
        else
//        if(title.compareTo("Cardiologist")==0)
            doctorDetail = doctorDetails5;

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailsActivity.this, FindDoctorActivity.class));
            }
        });

        list = new ArrayList();
        for (int i =0; i<doctorDetail.length; i++){
            item = new HashMap<String, String>();
            item.put("line1", doctorDetail[i][0]);
            item.put("line2", doctorDetail[i][2]);
            item.put("line3", doctorDetail[i][3]);
            item.put("line4", doctorDetail[i][4]);
            item.put("line5", "cons fees:"+doctorDetail [i][4]+"/-");
            list.add(item);
        }

    }
}