package tr.edu.yildiz.erentutus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class ClothesScreen extends AppCompatActivity {
    Button btnBackToMain;
    private RecyclerView Recycler;
    private RecyclerClothes adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothes_screen);

        getInputs();

        adapter.notifyDataSetChanged();
        btnBackToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ClothesScreen.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void getInputs(){
        Recycler = (RecyclerView) findViewById(R.id.recyclerview);
        adapter = new RecyclerClothes(ClothesScreen.this);
        Recycler.setAdapter(adapter);
        Recycler.setLayoutManager(new LinearLayoutManager(this));
        btnBackToMain = findViewById(R.id.btnBackToMain);
    }
}