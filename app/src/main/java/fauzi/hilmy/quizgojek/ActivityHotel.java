package fauzi.hilmy.quizgojek;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class ActivityHotel extends AppCompatActivity {

    RecyclerView view;
    CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel);
        view = findViewById(R.id.listView);
        view.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CustomAdapter();
        view.setAdapter(adapter);

    }
    String [] namaWisata = {"Harbourbay Amir Hotel", "GGi Hotel", "Zest Hotel Harbour Bay Batam", "Horison Ultima King's Nagoya Batam", "Sahid Batam Center Hotel & Convention"};
    int [] gambarWisata = {R.drawable.harbour, R.drawable.ggi, R.drawable.zest, R.drawable.horison, R.drawable.sahid};
    String [] harga = {"Starting from Rp 250.000", "Starting from Rp 385.000", "Starting from Rp 363.999", "Starting from Rp 480.000", "Starting from Rp 3.450.000"};
    private class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_adapter, null);
            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, final int position) {

            holder.judul.setText(namaWisata[position]);
            holder.img.setImageResource(gambarWisata[position]);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent a1 = new Intent(ActivityHotel.this, ActivityDetailHotel.class);
                    a1.putExtra("imgq", gambarWisata[position]);
                    a1.putExtra("namaq", namaWisata[position]);
                    a1.putExtra("hargaq", harga[position]);
                    startActivity(a1);
                }
            });

        }

        @Override
        public int getItemCount() {
            return namaWisata.length;
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {

            TextView judul;
            ImageView img;

            public MyViewHolder(View itemView) {
                super(itemView);

                judul = itemView.findViewById(R.id.judul);
                img = itemView.findViewById(R.id.img);
            }
        }
    }
}
