package fauzi.hilmy.quizgojek;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class ActivityDetailHotel extends AppCompatActivity {

    TextView lblNama, lblHarga;
    ImageView img;
    String nama, harga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_hotel);

        Intent uytr = getIntent();
        nama = uytr.getStringExtra("namaq");
        harga = uytr.getStringExtra("hargaq");

        lblNama = (TextView)findViewById(R.id.lblNama);
        lblHarga = (TextView)findViewById(R.id.lblHarga);
        img = (ImageView)findViewById(R.id.img);

        lblNama.setText(nama);
        lblHarga.setText("Harga /Malam : " + harga);
        Bundle mBundle = getIntent().getExtras();

        if (mBundle != null){

            img.setImageResource(mBundle.getInt("imgq"));
        }
    }
}
