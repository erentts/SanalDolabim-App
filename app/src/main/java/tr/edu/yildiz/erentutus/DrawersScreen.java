package tr.edu.yildiz.erentutus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import tr.edu.yildiz.erentutus.entities.Drawer;

public class DrawersScreen extends AppCompatActivity {
    Button btnBack;
    private RecyclerView Recycler;
    private RecyclerDrawers adapter;
    private ArrayList<Drawer> drawers = new ArrayList<Drawer>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawers_screen);

        getInput();
        adapter.notifyDataSetChanged();

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DrawersScreen.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void getInput(){
        Recycler = (RecyclerView) findViewById(R.id.recyclerview);
        adapter = new RecyclerDrawers(DrawersScreen.this);
        Recycler.setAdapter(adapter);
        Recycler.setLayoutManager(new LinearLayoutManager(this));
        btnBack = findViewById(R.id.btnBack);
    }
}