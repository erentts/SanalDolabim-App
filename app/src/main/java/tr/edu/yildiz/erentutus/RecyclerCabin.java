package tr.edu.yildiz.erentutus;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import tr.edu.yildiz.erentutus.entities.Clothes;

public class RecyclerCabin extends RecyclerView.Adapter<RecyclerCabin.MyViewHolder>{
    Context context;
    private ArrayList<Clothes> clothes;
    String type;
    public RecyclerCabin(ArrayList<Clothes> clothes,Context context) {
        this.clothes = clothes;
        this.context = context;
    }
    @NonNull
    @Override
    public RecyclerCabin.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cabinlist,parent,false);
        return new RecyclerCabin.MyViewHolder(view);

    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerCabin.MyViewHolder holder, int position) {
        holder.thumbnailcabin.setImageBitmap(clothes.get(position).getThumbnail());
        holder.btnInformationn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, CombineRoomScreen.class);
                type = clothes.get(position).getType();
                switch (type){
                    case "1":
                        Clothes.combin.put("1",clothes.get(position));
                        //photo1.setImageBitmap(kiyafet.kombin.get("1").getFoto());
                        break;
                    case "2":
                        Clothes.combin.put("2",clothes.get(position));
                        //photo2.setImageBitmap(kiyafet.kombin.get("2").getFoto());
                        break;
                    case "3":
                        Clothes.combin.put("3",clothes.get(position));
                        //photo3.setImageBitmap(kiyafet.kombin.get("3").getFoto());
                        break;
                    case "4":
                        Clothes.combin.put("4",clothes.get(position));
                        //photo4.setImageBitmap(kiyafet.kombin.get("4").getFoto());
                        break;
                    case "5":
                        Clothes.combin.put("5",clothes.get(position));
                        //photo5.setImageBitmap(kiyafet.kombin.get("5").getFoto());
                        break;
                }
                intent.putExtra("type",type);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {return clothes.size();}

    public class MyViewHolder extends RecyclerView.ViewHolder{
        Button btnInformationn;
        ImageView thumbnailcabin;
        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            thumbnailcabin = itemView.findViewById(R.id.thumbnailcabin);
            btnInformationn = itemView.findViewById(R.id.btnInformationn);
        }
    }
}
