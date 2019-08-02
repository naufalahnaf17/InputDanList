package app.android.inputdanlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText eAngka1 , eAngka2;
    Button btnJumlah;
    TextView txtHasil;
    int angka1 , angka2 , hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eAngka1 = (EditText) findViewById(R.id.angka1);
        eAngka2 = (EditText) findViewById(R.id.angka2);
        btnJumlah = (Button) findViewById(R.id.btnJumlah);
        txtHasil = (TextView) findViewById(R.id.hasil);

        btnJumlah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jumlahkkan();
            }
        });

    }

    private void jumlahkkan() {
        angka1 = Integer.parseInt(eAngka1.getText().toString());
        angka2 = Integer.parseInt(eAngka2.getText().toString());

        hasil = angka1+angka2;

        txtHasil.setText(hasil+"");
    }
}
