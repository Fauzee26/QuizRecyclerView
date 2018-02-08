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

public class ActivityWisata extends AppCompatActivity {

    RecyclerView view;
    CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wisata);

        view = findViewById(R.id.listView);
        view.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CustomAdapter();
        view.setAdapter(adapter);

    }
    String [] namaWisata = {"Wisata Pantai Marina", "Jembatan Barelang", "Wisata Ocarina Park", "Wisata Kampung Vietnam", "Bukit Senyum"};
    int [] gambarWisata = {R.drawable.marina, R.drawable.barelang, R.drawable.ocarina, R.drawable.vietnam, R.drawable.senyum};
    String [] detail = {"Tempat wisata Pantai Marina merupakan sebuah pantai yang sangat terkenal dan popular di Batam. Pantai Marina terletak di sebelah barat dari kepulauan Batam, selain terdapat banyak kawasan wisata, di pulau ini juga dijadikan sebagai pelabuhan kapal-kapal Ferry. Di lokasi pantai tidak hanya menawarkan keindahan alam tetapi juga terdapat sebuah taman yang hijau untuk dijadikan sebagai taman bermain bagi anak-anak. Untuk masuk ke lokasi wisata ini, para pengunjung hanya akan dikenakan tarif tiket masuk sekitar 3.000 rupiah untuk anak-anak dan 6.000 rupiah untuk Dewasa. Bagi anda yang ingin menginap dan mencari makan, dikawasan sekitar pantai juga terdapat banyak hotel dan restoran.",
    "Jembatan Barelang yang terdapat di kepulauan batam ini merupakan sebuah bangunan yang sekaligus menjadi ikon nya kota Batam. Selain itu, jemabatan ini dapat menghubungkan antar pulau yang tujuannya untuk meningkatkan kemajuan perekonomian dan juga perindustrian. Jembatan ini di bangun sekitar pada tahun 1992, pembangunannya pun direncanakan oleh mantan Presiden kita Bapak Habibie.",
    "Ocarina Park merupakan sebuah tempat wisata yang sama halnya dengan Ancol yang ada di Ibu Kota Jakarta. Lokasi wisata ini mulai dibuka sejak tahun 2008, walaupun masih sangat baru, namun lokasi wisata ini sangat ramai dan menjadi kebanggaan kota Batam. Wisata Ocarina Park ini di bangun diatas lahan seluas 40 hektar, di lokasi wisata permainan ini terdapat banyak sekali wahana bermain yang sangat menarik. Wahana yang tersedia pun tidak hanya diperuntukan bagi anak-anak, tetapi juga untuk orang dewasa. Selain itu, di lokasi wisata ini juga suka diadakan acara konser music yang dapat menghibur para wisatawan yang berkunjung ke Ocarina Park. Sedangkan harga tiket masuknya sekitar 5.000 rupiah dan itu belum termasuk tiket untuk menikmati aneka wahana permainan.",
    "Kampung Vietnam merupakan sebuah perkampungan yang tidak berpenghuni, lokasinya terletak di pulau Galang. Kampung ini dahulunya pernah dijadikan sebagai tempat pengungsian bagi para warga Negara Vietnam, para pengungsi ini dikenal dengan sebutan manusia perahu. Pada saat itu, para warga ini terpaksa mengungsi ke pulau galang dikarenakan sedang terjadi konflik internal di negaranya, sehingga pemerintah Indonesia mengijinkan mereka untuk mengungsi sementara di pulau ini. Setelah konflik mereda, mereka di pulangkan kembali ke kampung halamnya masing-masing dan kemudian kampung ini dibiarkan kosong hingga sekarang. Walaupun tidak berpenghuni, lokasi ini sangat menarik untuk dikunjungi, karena kondisi perkampungan ini masih sama seperti dulu.",
    "Bukit Senyum merupakan sebuah wisata perbukitan yang ada di Batam, tempat dimana untuk melihat keindahan cahaya lampu kota batam dimalam hari. Memang tidak ada yang special dari bukit ini, tetapi diatas bukit anda dapat menikmati keindahan kota Singapura terutama di malam hari. Selain itu, anda dapat melihat pesawat yang pulang dan pergi ke bandara Changi. Untuk menikmati keindahan di atas bukit, anda dapat menemukan tempat nongkrong yang sangat nyaman. Lokasi ini menjadi lokasi favorit bagi warga batam untuk menikmati keindahan malam tahun baru, sehingga akan sangat jelas gemerlapnya kembang api di Singapura."};
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
                    Intent a1 = new Intent(ActivityWisata.this, ActivityDetailWisata.class);
                    a1.putExtra("img", gambarWisata[position]);
                    a1.putExtra("nama", namaWisata[position]);
                    a1.putExtra("detail", detail[position]);
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
