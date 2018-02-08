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

public class ActivityKuliner extends AppCompatActivity {

    RecyclerView view;
    CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuliner);
        view = findViewById(R.id.listView);
        view.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CustomAdapter();
        view.setAdapter(adapter);

    }
    String [] namaWisata = {"Bingka Bakar", "Luti Gendang", "Sop Ikan", "Mie Tarempa", "Kerapu Steam"};
    int [] gambarWisata = {R.drawable.bingka, R.drawable.luti, R.drawable.sopikan, R.drawable.tarempa, R.drawable.kerapu};
    String [] detail = {"Bingka bakar adalah makanan yang berjenis kue-kue an yang sudah sangat populer di Batam, kepopuleran makanan ini bisa dilihat dengan banyaknya toko yang menjual makanan khas Batam ini. Aslinya sih bingka batam adalah kue yang berasal dari kerajaan melayu. Hanya saja sudah ada sejak lama dan terkenal di Batam alhasil kue bingka bakar dijadikan kue khas Batam. Kue ini biasa di beli oleh orang yang merantau atau berkunjung ke Batam untuk dijadikan buah tangan dari Batam.",
    "Luti gendang salah satu makanan khas Batam yang termasuk kedalam makanan ringan, makanan ini biasa dijadikan cemilan atau perbekalan ketika bepergian. Makanan ringan ini juga bisa dijadikan oleh-oleh khas Batam juga. Menikmati jajanan khas Batam ini enaknya saat santai yang jual pun banyak pedagang kaki lima, jadi kamu bisa menikmati waktu santai kamu sambil ditemani luti gendang, bukan hanya itu saja harganya yang murah dan rasanya yang muantap menjadikan luti gendang disukai banyak orang.",
    "Sop adalah makanan khas Indonesia yang sudah popular dan sangat terkenal, di batam sendiri ada sop yang berbahan utama ikan, jadi namanya sop ikan. Ikan yang digunakan dalam pembuatan sop ikan adalah jenis ikan tenggiri. Sop ikan ini bisa menjadi lauk tambahan ketika kamu makan dengan laukan yang kering, sop ikan ini adalah sop dengan beragam gizi. Bahan utamnya saja sudah ikan, dan seperti yang kamu dan saya ketahui dalam ikan terdapat protein dan gizi lainnya.",
    "Tidak kalah populer dan menarik seperti mie sagu maupun mie lendir mie tarempa juga memiliki rasa yang wow. Mie tarempa adalah mie gepeng yang dimasak menggunakan bumbu mie seperti pada umumnya. Namun yang membedakan adalah pada penyajiannya, dimana pada penyajiannya terdapat topping yang isinya adalah potongan ikan tongkol dan seafood yang sudah di suwir-suwir. Jadi buat kamu para pecinta mie jangan lupa ya untuk ke Batam karena di sini ada empat jenis mie yang unik.",
    "Dari namanya saja kerapu sudah pasti makanan ini berbahan utama ikan kerapu, terus nama steam? Asal nama steam diambil dari cara pembuatannya atau cara mengolahnya yaitu dengan cara distream. Di stream itu gimana sih? Kamu dapat menemukan jawabanya di google (hehehe). Ikan stream yang masih segar diolah dan dicampur menggunakan bumbu rempah-rempah, antara lain adalah, bawang putih, jahe, dan saus sebagai penambah rasa. Selain itu ada bumbu rahasia yang menjadikan kerapu steam lebih wuenak dan lezat."};
    private class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_adapter_gambar, null);
            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, final int position) {

            holder.img.setImageResource(gambarWisata[position]);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent hgfds = new Intent(ActivityKuliner.this, ActivityDetailKuliner.class);
                    hgfds.putExtra("imga", gambarWisata[position]);
                    hgfds.putExtra("namaa", namaWisata[position]);
                    hgfds.putExtra("detaila", detail[position]);
                    startActivity(hgfds);
                }
            });

        }

        @Override
        public int getItemCount() {
            return namaWisata.length;
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {

            ImageView img;

            public MyViewHolder(View itemView) {
                super(itemView);

                img = itemView.findViewById(R.id.img);
            }
        }
    }
}
