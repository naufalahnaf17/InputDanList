package app.android.inputdanlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {

    List<Gambar> mylist;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        listView = (ListView) findViewById(R.id.listView);
        mylist = new ArrayList<>();

        mylist.add(new Gambar(R.drawable.ic_credit_card_black_24dp ,"Credit Card"));
        mylist.add(new Gambar(R.drawable.ic_directions_bike_black_24dp ,"Sepeda"));
        mylist.add(new Gambar(R.drawable.ic_desktop_windows_black_24dp ,"Monitor"));

        Adapter adapter = new Adapter(this , R.layout.list_custom , mylist);
        listView.setAdapter(adapter);
    }
}
