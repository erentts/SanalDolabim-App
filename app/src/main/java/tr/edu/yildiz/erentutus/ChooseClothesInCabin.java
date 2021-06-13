package tr.edu.yildiz.erentutus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.os.Bundle;

public class ChooseClothesInCabin extends AppCompatActivity {
    private RecyclerView Recycler;
    private RecyclerCabin adapter;
    Button btnBackTo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_clothes_in_cabin);

        getInputs();
        adapter.notifyDataSetChanged();
        btnBackTo = findViewById(R.id.btnBackTo);
        btnBackTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChooseClothesInCabin.this, CombineRoomScreen.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void getInputs(){
        Recycler = (RecyclerView) findViewById(R.id.recyclerview);
        adapter = new RecyclerCabin(CombineRoomScreen.clothes2,ChooseClothesInCabin.this);
        Recycler.setAdapter(adapter);
        Recycler.setLayoutManager(new LinearLayoutManager(this));
        btnBackTo = (Button) findViewById(R.id.btnBackTo);
    }
}