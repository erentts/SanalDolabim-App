package tr.edu.yildiz.erentutus;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import tr.edu.yildiz.erentutus.entities.Clothes;

public class RecyclerClothes extends RecyclerView.Adapter<RecyclerClothes.MyViewHolder>{
    Context context;

    public RecyclerClothes(Context context) {
        this.context = context;
    }
    @NonNull
    @Override
    public RecyclerClothes.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.clotheslist,parent,false);
        return new RecyclerClothes.MyViewHolder(view);

    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerClothes.MyViewHolder holder, int position) {

        holder.thumbnail.setImageBitmap(Clothes.clothes.get(position).getThumbnail());
        holder.btnInformation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Clothes information")
                            .setMessage("Type: "+Clothes.clothes.get(position).getType()+"\nColor: "+
                                    Clothes.clothes.get(position).getColor()+"\nPattern: "+
                                    Clothes.clothes.get(position).getPattern()+"\nBought Date: "+
                                    Clothes.clothes.get(position).getBoughtDate()+"\nPrice: "+
                                    Clothes.clothes.get(position).getPrice())
                        .setNegativeButton("Back", null)
                        .show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return Clothes.clothes.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        Button btnInformation;
        ImageView thumbnail;
        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            thumbnail = itemView.findViewById(R.id.thumbnailcabin);
            btnInformation = itemView.findViewById(R.id.btnInformationn);
        }
    }
}

