package com.example.firebase_to_rec;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import de.hdodenhof.circleimageview.CircleImageView;

public class adapter_for_rec extends FirebaseRecyclerAdapter<model,adapter_for_rec.myviewholder>
{

    public adapter_for_rec(@NonNull FirebaseRecyclerOptions<model> options)
    {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull model model)
    {
        try{
        holder.name.setText(model.getName());
        holder.phone.setText(model.getPhone());
        holder.trans.setText(model.getTrans());
        holder.address.setText(model.getAddress());
        holder.price.setText(model.getPrice());
        Glide.with(holder.imgview.getContext()).load(model.getImg()).into(holder.imgview);
        }catch (Exception e){} //try catch
    } //onbind

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row,parent,false);
        return new myviewholder(view);

    } //oncreate

    class myviewholder extends RecyclerView.ViewHolder //view holder holds the single row reference for all other views
    {
        CircleImageView imgview;
        TextView name,phone,trans,address,price;

        public myviewholder(@NonNull View itemView) {
            super(itemView);

           try {
               imgview = (CircleImageView) itemView.findViewById(R.id.imgview);
               name = (TextView) itemView.findViewById(R.id.name);
               phone = (TextView) itemView.findViewById(R.id.phone);
               trans = (TextView) itemView.findViewById(R.id.trans);
               address = (TextView) itemView.findViewById(R.id.address);
               price = (TextView) itemView.findViewById(R.id.price);
            }catch (Exception e){} //try catch
           }
    } // myviewholder

}//adapter_for_rec
