package fauzi.hilmy.quizgojek;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class ActivityDetailKuliner extends AppCompatActivity {
    TextView lblNama, lblDetail;
    ImageView img;
    String nama, detail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_kuliner);

        Intent gfdsa = getIntent();
        nama = gfdsa.getStringExtra("namaa");
        detail = gfdsa.getStringExtra("detaila");

        lblNama = (TextView)findViewById(R.id.lblNama);
        lblDetail = (TextView)findViewById(R.id.lblDetail);
        img = (ImageView)findViewById(R.id.img);

        lblNama.setText(nama);
        lblDetail.setText(detail);
        Bundle mBundle = getIntent().getExtras();

        if (mBundle != null){

            img.setImageResource(mBundle.getInt("imga"));
        }
    }
}
