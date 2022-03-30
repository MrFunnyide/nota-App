package com.example.kuis_ajibayupermadi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class notaTransaksi extends AppCompatActivity {

    //deklarasi
    TextView tvMember, isinamaPelanggan, selectGender, isi_alamat, isi_barang, isijumlah_barang, isi_hargaB,
            isiTotalH, isi_DiscHarga, isiDiscMember, Totaljmlh;
    Button btnPrint;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_nota_transaksi);

        tvMember = findViewById(R.id.tv_tpMember);
        isinamaPelanggan = findViewById(R.id.isiNamaP);
        selectGender = findViewById(R.id.isiGender);
        isi_alamat = findViewById(R.id.isiAlamat);
        isi_barang = findViewById(R.id.isibarang);
        isijumlah_barang = findViewById(R.id.jumlahBar);
        isi_hargaB = findViewById(R.id.isiHargabar);
        isiTotalH = findViewById(R.id.isiTotalHarga);
        isi_DiscHarga = findViewById(R.id.isDiskonHarga);
        isiDiscMember = findViewById(R.id.isiDiscMember);
        Totaljmlh = findViewById(R.id.isiTotal);
        btnPrint = findViewById(R.id.print_note);

        String memberPelanggan = getIntent().getStringExtra("TIPE");
        tvMember.setText(memberPelanggan);

        isinamaPelanggan.setText(getIntent().getStringExtra("Pelanggan"));
        isi_alamat.setText(getIntent().getStringExtra("alamat"));
        selectGender.setText(getIntent().getStringExtra("GENDER"));
        isi_barang.setText(getIntent().getStringExtra("nama barang"));
        isijumlah_barang.setText(getIntent().getStringExtra("jumlah_barang"));

        String HB = getIntent().getStringExtra("harPhone");
        isi_hargaB.setText("Rp. " + HB);

        String JB = getIntent().getStringExtra("Total");
        isiTotalH.setText("Rp. " + JB);

        String Dc = getIntent().getStringExtra("Lagi_Discount");
        isi_DiscHarga.setText("Rp. " + Dc);

        String DcMember = getIntent().getStringExtra("Discount_Member");
        isiDiscMember.setText("Rp. " + DcMember);

        String AllTotaly = getIntent().getStringExtra("AllTotal");
        Totaljmlh.setText("Rp. " + AllTotaly);
    }
}