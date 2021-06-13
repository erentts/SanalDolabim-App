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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import tr.edu.yildiz.erentutus.dataaccess.database;
import tr.edu.yildiz.erentutus.entities.Clothes;

public class AddClothes extends AppCompatActivity {
    private EditText txtBoughtDate, txtPrice,textType,txtPattern,txtColor;
    private String type,color,pattern,boughtDate,price;
    private int request_imageopen=0,pos;
    private Bitmap bitmap;
    private ImageView Photo;
    private Button btnSelect,btnSave;
    private database data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_clothes);

        getInputs();
        Intent intent = getIntent();
        pos = intent.getIntExtra("position",0);
        data = new database(this);
        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
                intent.setType("image/*");
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                startActivityForResult(intent, request_imageopen);
            }
        });
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSpinner();
                SQLiteDatabase db = data.getWritableDatabase();
                ContentValues data = new ContentValues();
                byte[] photo = BytetoArray();
                Clothes clothes = new Clothes(type,color,pattern,boughtDate,price,bitmap);
                data.put("type",type);
                data.put("color",color);
                data.put("pattern",pattern);
                data.put("boughtDate",boughtDate);
                data.put("price",price);
                data.put("thumbnail",photo);
                data.put("drawerId",pos+1);
                Clothes.clothes.add(clothes);
                db.insertOrThrow("Clothes",null,data);
                Toast.makeText(getApplicationContext(),"Clothes has been added !", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void getInputs(){
        textType = findViewById(R.id.textType);
        txtPattern = findViewById(R.id.txtPattern);
        txtColor = findViewById(R.id.txtColor);
        txtBoughtDate = findViewById(R.id.txtBoughtDate);
        txtPrice = findViewById(R.id.txtPrice);
        btnSelect = findViewById(R.id.btnSelect);
        Photo = findViewById(R.id.Photo);
        btnSave = findViewById(R.id.btnSave);
    }

    public void getSpinner(){
        type = textType.getText().toString();
        color = txtColor.getText().toString();
        pattern = txtPattern.getText().toString();
        boughtDate = txtBoughtDate.getText().toString();
        price = txtPrice.getText().toString();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == request_imageopen && resultCode == RESULT_OK){
            Uri uri = data.getData();
            try{
                if(Build.VERSION.SDK_INT >= 28){
                    ImageDecoder.Source source = ImageDecoder.createSource(this.getContentResolver(),uri);
                    bitmap = ImageDecoder.decodeBitmap(source);
                    Photo.setImageBitmap(bitmap);
                }else{
                    bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(),uri);
                    Photo.setImageBitmap(bitmap);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public byte[] BytetoArray(){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,50, byteArrayOutputStream);
        byte[] bytes = byteArrayOutputStream.toByteArray();
        return bytes;
    }


}