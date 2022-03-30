package com.example.kuis_ajibayupermadi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //declare variabel
    EditText namaP,alamatP, jmlhBrg;
    RadioButton pria, perempuan, gold, silver, biasa, android, iphone, winPhone;
    Button proces, cancle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_transaksi_satu);

        // edit text
        namaP = findViewById(R.id.etNamaP);
        alamatP = findViewById(R.id.etAlamatP);
        jmlhBrg = findViewById(R.id.jmlhBarang);

        pria = findViewById(R.id.pria);
        perempuan = findViewById(R.id.perempuan);
        gold = findViewById(R.id.rb_gold);
        silver = findViewById(R.id.rb_silver);
        biasa = findViewById(R.id.rb_biasa);
        android = findViewById(R.id.rb_android);
        iphone = findViewById(R.id.rb_iphone);
        winPhone = findViewById(R.id.rb_winPhon);
        cancle = findViewById(R.id.btn_cancel);
    }

    public void tombolProcces(View view) {

        int hargaHP = 0;
        int DiscountMember = 0;
        int LgiDiscount = 10;
        String namaHP = null;
        String discTipe = null;
        String pilihGender = null;

        // jenis kelamin
        if (pria.isChecked()) {
            pilihGender = "Pria";
        }
        if (perempuan.isChecked()) {
            pilihGender = "Perempuan";
        }

        // Tipe pelanggan
        if(gold.isChecked()) {
            discTipe = "Gold";
            DiscountMember = 50;
        }
        if(silver.isChecked()) {
            discTipe = "Silver";
            DiscountMember = 30;
        }
        if(biasa.isChecked()) {
            discTipe = "Biasa";
            DiscountMember = 10;
        }

        //Nama Barang
        if (android.isChecked()) {
            namaHP = "Android";
            hargaHP = 1000000;
        }
        if (iphone.isChecked()) {
            namaHP = "Iphone";
            hargaHP = 2000000;
        }
        if (winPhone.isChecked()) {
            namaHP = "Windows Phone";
            hargaHP = 3000000;
        }

        //ambil inputan
        String namaPelanggan = namaP.getText().toString();
        String alamatPelanggan = alamatP.getText().toString();
        String jumlahBarang = jmlhBrg.getText().toString();

        // ambil nilai dari if diatas
        String pilih_Gender = pilihGender;
        String diskonTipe = discTipe;
        String namaHandPhone = namaHP;

        // harga hp versi string
        String hargaHandPhone = String.valueOf(hargaHP);

        // cari total
        // ambil int dari total dulu
        int JmlhBrang = Integer.valueOf(jumlahBarang);
        int AllTotal = JmlhBrang * hargaHP;
        //rubah lagi ke String
        String AllTotal2 = String.valueOf(AllTotal);

        //cari diskon
        int Discount2 = (hargaHP * LgiDiscount) / 100;
        // rubah menjadi string untuk di tampilkan
        String Discount3 = String.valueOf(Discount2);

        //  cari diskon di tiap member
        int Discount4 = (hargaHP * DiscountMember) / 100;
        // rubah menjadi String untuk di tampilkan
        String Discount5 = String.valueOf(Discount4);

        // total semua harga + discount discount nya
        int AllTotalWithDiscount = AllTotal - Discount4 - Discount2;
        // rubah ke String lagi
        String TotalPlusDiscount = String.valueOf(AllTotalWithDiscount);

        Intent i = new Intent(MainActivity.this, notaTransaksi.class);
        i.putExtra("GENDER", pilih_Gender);
        i.putExtra("TIPE", diskonTipe);
        i.putExtra("harPhone", hargaHandPhone);
        i.putExtra("Pelanggan", namaPelanggan);
        i.putExtra("alamat", alamatPelanggan);
        i.putExtra("jumlah_barang", jumlahBarang);
        i.putExtra("nama barang", namaHandPhone);
        i.putExtra("Total", AllTotal2);
        i.putExtra("Lagi_Discount", Discount3);
        i.putExtra("Discount_Member", Discount5);
        i.putExtra("AllTotal", TotalPlusDiscount);
        startActivity(i);
    }
}