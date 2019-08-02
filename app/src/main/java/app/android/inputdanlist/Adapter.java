package app.android.inputdanlist;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class Adapter extends ArrayAdapter<Gambar> {

    List<Gambar> listgambar;
    Context context;
    int resource;

    public Adapter(Context context, int resource , List<Gambar> listgambar) {
        super(context, resource , listgambar);
        this.context = context;
        this.resource = resource;
        this.listgambar = listgambar;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(resource , null , false);

        ImageView imageView = view.findViewById(R.id.gambar);
        TextView textView = view.findViewById(R.id.nama);
        Button btnHapus = view.findViewById(R.id.hapus);

        Gambar gambar = listgambar.get(position);
        imageView.setImageDrawable(context.getResources().getDrawable(gambar.getImage()));
        textView.setText(gambar.getNama());
        btnHapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hapusGambar(position);
            }
        });

        return view;
    }

    private void hapusGambar(final int position) {
        AlertDialog.Builder adb = new AlertDialog.Builder(context);
        adb.setTitle("Yakin Ingin Menghapus Gambar ?");
        adb.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                listgambar.remove(position);
            }
        }).setNegativeButton("No ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(context, "Tidak Jadi Di Hapus", Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog alertDialog = adb.create();
        alertDialog.show();
    }
}
