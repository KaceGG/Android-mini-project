package thud.baitapduan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

import thud.baitapduan.ui.ListMovie;
import thud.baitapduan.ui.SignInActivity;

public class MainActivity extends AppCompatActivity {

    List<String> listMenu;
    ListView lvMenu;
    ArrayAdapter<String> adapter;
    Class[] arrClasses = {ListMovie.class, SignInActivity.class};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
        lvMenu = findViewById(R.id.listview_menu);
        listMenu = new ArrayList<String>();
        listMenu.add("Book movie ticket");
        listMenu.add("Login again");
        listMenu.add("Exit");

        adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                listMenu
        );
        lvMenu.setAdapter(adapter);
        lvMenu.setOnItemClickListener(new ChooseActivity());
    }

    private class ChooseActivity implements android.widget.AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            if (i == 2)
                finish();
            else {
                Intent intent = new Intent(MainActivity.this, arrClasses[i]);
                startActivity(intent);
            }
        }
    }
}