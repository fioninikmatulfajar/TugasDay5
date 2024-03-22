package com.example.tugasday5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class HasilProses extends AppCompatActivity {
    private TextView namacustomerText, kodebarangText, namabarangText, hargaText, jumlahText, subtotalText, diskonhargaText, diskonmemberText, totalText;
    public Button btnshare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_proses);

        namacustomerText = findViewById(R.id.namacustomer);
        kodebarangText = findViewById(R.id.kodebarang);
        namabarangText = findViewById(R.id.namabarang);
        hargaText = findViewById(R.id.harga);
        jumlahText = findViewById(R.id.jumlah);
        subtotalText = findViewById(R.id.subtotal);
        diskonhargaText = findViewById(R.id.diskonharga);
        diskonmemberText = findViewById(R.id.diskonmember);
        totalText = findViewById(R.id.total);
        btnshare = findViewById(R.id.btnshare);

        btnshare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareData();
            }
        });

        Intent intent = getIntent();
        String namacustomer = intent.getStringExtra(getString(R.string.nama_customer));
        String kodebarang = intent.getStringExtra(getString(R.string.kode_item));
        String namabarang = intent.getStringExtra(getString(R.string.nama_barang));
        long harga = intent.getLongExtra(getString(R.string.hargaa), 0);
        int jumlah = intent.getIntExtra(getString(R.string.jumlah_barang), 0);
        long subtotal = intent.getLongExtra(getString(R.string.sub_total), 0);
        long diskonharga = intent.getLongExtra(getString(R.string.diskon_harga), 0);
        long diskonmember = intent.getLongExtra(getString(R.string.diskon_member), 0);
        long total = intent.getLongExtra(getString(R.string.total), 0);

        NumberFormat formatter = new DecimalFormat("#,###,###,###");
        String formattedHarga = "Rp" + formatter.format(harga);
        String formattedsubtotal = "Rp" + formatter.format(subtotal);
        String formatteddiskonharga = "Rp" + formatter.format(diskonharga);
        String formatteddiskonmember = "Rp" + formatter.format(diskonmember);
        String formattedtotal = "Rp" + formatter.format(total);

        namacustomerText.setText(getString(R.string.nama_pelanggan) + ": " + namacustomer);
        kodebarangText.setText(getString(R.string.kode_item) + ": " + kodebarang);
        namabarangText.setText(getString(R.string.nama_barang) + ": " + namabarang);
        hargaText.setText(getString(R.string.hargaa) + ": " + formattedHarga);
        jumlahText.setText(getString(R.string.jumlah_barang) + ": " + jumlah);
        subtotalText.setText(getString(R.string.sub_total) + ": " + formattedsubtotal);
        diskonhargaText.setText(getString(R.string.diskon_harga) + ": " + formatteddiskonharga);
        diskonmemberText.setText(getString(R.string.diskon_member) + ": " + formatteddiskonmember);
        totalText.setText(getString(R.string.total) + ": " + formattedtotal);

    }

    private void shareData() {
        String dataToShare = "Detail Transaksi\n" +
                namacustomerText.getText().toString() + "\n" +
                kodebarangText.getText().toString() + "\n" +
                namabarangText.getText().toString() + "\n" +
                hargaText.getText().toString() + "\n" +
                jumlahText.getText().toString() +"\n" +
                subtotalText.getText().toString() + "\n" +
                diskonhargaText.getText().toString() + "\n" +
                diskonmemberText.getText().toString() + "\n" +
                totalText.getText().toString();

        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, dataToShare);
        startActivity(Intent.createChooser(shareIntent, "Bagikan ke"));
    }

}