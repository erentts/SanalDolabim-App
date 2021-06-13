package tr.edu.yildiz.erentutus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Combines extends AppCompatActivity {
    Button btnBackk;
    private RecyclerView Recycler;
    private RecyclerCombines adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combines);

        getInputs();
        adapter.notifyDataSetChanged();
        btnBackk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Combines.this, CombineRoomScreen.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void getInputs(){
        Recycler = (RecyclerView) findViewById(R.id.recyclerview);
        adapter = new RecyclerCombines(Combines.this,0);
        Recycler.setAdapter(adapter);
        Recycler.setLayoutManager(new LinearLayoutManager(this));
        btnBackk = findViewById(R.id.btnBackk);
    }
}