package tr.edu.yildiz.erentutus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activities extends AppCompatActivity {
    private RecyclerView Recycler;
    private RecyclerActivity adapter;
    Button btnActBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activities);

        getInputs();
        adapter.notifyDataSetChanged();

        btnActBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activities.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }

    public void getInputs(){
        Recycler = (RecyclerView) findViewById(R.id.recyclerview);
        adapter = new RecyclerActivity(Activities.this);
        Recycler.setAdapter(adapter);
        Recycler.setLayoutManager(new LinearLayoutManager(this));
        btnActBack = findViewById(R.id.btnActBack);
    }
}