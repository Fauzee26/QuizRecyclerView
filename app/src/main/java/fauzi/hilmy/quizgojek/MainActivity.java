package fauzi.hilmy.quizgojek;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {

    GridView grid;
    String[] kategori = {
            "Tempat Wisata", "Restoran", "Hotel", "Exit"
    };
    int[] imageId = {
            R.drawable.travel, R.drawable.restoran, R.drawable.hotel, R.drawable.exit
    };
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridSingle adapter = new GridSingle(MainActivity.this, kategori, imageId);
        grid = (GridView) findViewById(R.id.grid);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                if (position == 0) {
                    Intent n2 = new Intent(getApplicationContext(), ActivityWisata.class);
                    startActivity(n2);
                } else if (position == 1) {
                    Intent n32 = new Intent(getApplicationContext(), ActivityKuliner.class);
                    startActivity(n32);
                } else if (position == 2) {
                    Intent tt = new Intent(getApplicationContext(), ActivityHotel.class);
                    startActivity(tt);
                } else if (position == 3) {
                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
                    alertDialog.setTitle("Caution!!");
                    alertDialog.setMessage("Apakah anda yakin akan keluar dari aplikasi ini?")
                            .setCancelable(false)
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(
                                        DialogInterface dialog, int which) {
                                    //kondisi ketika kita pencet yes
                                    MainActivity.this.finish();
                                }
                            })
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                }
                            });

                    AlertDialog alert = alertDialog.create();
                    alert.show();
                }
            }
        });
    }
}
