package tr.edu.yildiz.erentutus;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import tr.edu.yildiz.erentutus.dataaccess.database;
import tr.edu.yildiz.erentutus.entities.Clothes;

public class CombineRoomScreen extends AppCompatActivity {
    Button btnHeadChoice,btnFaceChoice,btnUpperChoice,btnBottomChoice,btnFootChoice,btnSaveCombine,btnPrevious,btnBackMain;
    Bitmap bitmap1,bitmap2,bitmap3,bitmap4,bitmap5;
    public static ImageView thumbnail1,thumbnail2,thumbnail3,thumbnail4,thumbnail5;
    Integer pos;
    String type;
    private database data;
    public static ArrayList<Clothes> clothes2 = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combine_room_screen);


        getInputs();
        Intent intent = getIntent();
        data = new database(this);

        if(intent.hasExtra("type")){
            type = intent.getStringExtra("type");
            switch (type){
                case "1":
                    thumbnail1.setImageBitmap(Clothes.combin.get("1").getThumbnail());
                    break;
                case "2":
                    thumbnail2.setImageBitmap(Clothes.combin.get("2").getThumbnail());
                    break;
                case "3":
                    thumbnail3.setImageBitmap(Clothes.combin.get("3").getThumbnail());
                    break;
                case "4":
                    thumbnail4.setImageBitmap(Clothes.combin.get("4").getThumbnail());
                    break;
                case "5":
                    thumbnail5.setImageBitmap(Clothes.combin.get("5").getThumbnail());
                    break;
            }
        }
        btnHeadChoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data("1");
                changeRoom("1");
            }
        });
        btnFaceChoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data("2");
                changeRoom("2");
            }
        });
        btnUpperChoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data("3");
                changeRoom("3");
            }
        });
        btnBottomChoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data("4");
                changeRoom("4");
            }
        });
        btnFootChoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data("5");
                changeRoom("5");
            }
        });
        btnSaveCombine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fillCombine();
                Toast.makeText(getApplicationContext(),"Saved !", Toast.LENGTH_SHORT).show();
            }
        });
        btnPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CombineRoomScreen.this, Combines.class);
                startActivity(intent);
                finish();
            }
        });
        btnBackMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CombineRoomScreen.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }


    public void fillCombine(){
        ArrayList<Bitmap> kombin_resimler = new ArrayList<>();
        SQLiteDatabase db = data.getWritableDatabase();
        ContentValues data = new ContentValues();
        data.put("thumbnail1",BytetoArray(Clothes.combin.get("1").getThumbnail()));
        data.put("thumbnail2",BytetoArray(Clothes.combin.get("2").getThumbnail()));
        data.put("thumbnail3",BytetoArray(Clothes.combin.get("3").getThumbnail()));
        data.put("thumbnail4",BytetoArray(Clothes.combin.get("4").getThumbnail()));
        data.put("thumbnail5",BytetoArray(Clothes.combin.get("5").getThumbnail()));
        db.insertOrThrow("Combine",null,data);
        kombin_resimler.add(Clothes.combin.get("1").getThumbnail());
        kombin_resimler.add(Clothes.combin.get("2").getThumbnail());
        kombin_resimler.add(Clothes.combin.get("3").getThumbnail());
        kombin_resimler.add(Clothes.combin.get("4").getThumbnail());
        kombin_resimler.add(Clothes.combin.get("5").getThumbnail());
        Clothes.combines.add(kombin_resimler);
    }
    public byte[] BytetoArray(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,50, byteArrayOutputStream);
        byte[] bytes = byteArrayOutputStream.toByteArray();
        return bytes;
    }
    public void getInputs(){
        btnHeadChoice = (Button) findViewById(R.id.btnHeadChoice);
        btnFaceChoice = (Button) findViewById(R.id.btnFaceChoice);
        btnUpperChoice = (Button) findViewById(R.id.btnUpperChoice);
        btnBottomChoice = (Button) findViewById(R.id.btnBottomChoice);
        btnFootChoice = (Button) findViewById(R.id.btnFootChoice);
        btnFaceChoice = (Button) findViewById(R.id.btnFaceChoice);
        btnSaveCombine = findViewById(R.id.btnSaveCombine);
        btnPrevious = findViewById(R.id.btnPrevious);
        btnBackMain = findViewById(R.id.btnBackMain);
        thumbnail1 = (ImageView) findViewById(R.id.thumbnail1);
        thumbnail2 = (ImageView) findViewById(R.id.thumbnail2);
        thumbnail3 = (ImageView) findViewById(R.id.thumbnail3);
        thumbnail4 = (ImageView) findViewById(R.id.thumbnail4);
        thumbnail5 = (ImageView) findViewById(R.id.thumbnail5);

    }
    public void data(String kontrol){
        clothes2.clear();
        Clothes.clothes.forEach((x) -> {
            if(x.getType().equals(kontrol)){
                clothes2.add(x);
            }
        });
    }
    public void changeRoom(String type){
        Intent intent = new Intent(CombineRoomScreen.this, ChooseClothesInCabin.class);
        intent.putExtra("type",type);
        startActivity(intent);
    }
}