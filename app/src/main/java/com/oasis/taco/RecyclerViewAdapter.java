package com.oasis.taco;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>{

    Context mContext;
    List<Contact> mData;
    Dialog myDialog;


    public RecyclerViewAdapter(Context mContext, List<Contact> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    //Viewholder for the RecyclerView
    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private LinearLayout item_contact;
        private TextView nameContact,phoneContact;
        private ImageView img;

        public MyViewHolder (View itemView){
            super(itemView);
            item_contact = (LinearLayout) itemView.findViewById(R.id.contact_item);
            nameContact = (TextView) itemView.findViewById(R.id.tvName);
            phoneContact = (TextView) itemView.findViewById(R.id.phoneContact);
            img = (ImageView) itemView.findViewById(R.id.imgContact);
        }
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.item_contact,parent,false);
        final MyViewHolder viewHolder = new MyViewHolder(v);



        myDialog = new Dialog(mContext);
        myDialog.setContentView(R.layout.dialog_contact);
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));


        //Contact Onclick Listener
        viewHolder.item_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               //When user clicks a Contact, the following code will generate the Contact Dialog

                TextView dialog_name_tv = myDialog.findViewById(R.id.dialog_name);
                TextView dialog_phone_tv = myDialog.findViewById(R.id.dialog_phone);
                ImageView dialog_img = myDialog.findViewById(R.id.dialog_img);
                dialog_name_tv.setText(mData.get(viewHolder.getAdapterPosition()).getName());
                dialog_phone_tv.setText(mData.get(viewHolder.getAdapterPosition()).getPhone());
                dialog_img.setImageResource(mData.get(viewHolder.getAdapterPosition()).getPhoto());
                myDialog.show();
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.nameContact.setText(mData.get(position).getName());
        holder.phoneContact.setText(mData.get(position).getPhone());
        holder.img.setImageResource(mData.get(position).getPhoto());


    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


}
