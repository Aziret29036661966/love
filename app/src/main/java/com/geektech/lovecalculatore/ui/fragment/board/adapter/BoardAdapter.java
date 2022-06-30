package com.geektech.lovecalculatore.ui.fragment.board.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.geektech.lovecalculatore.R;

public class BoardAdapter extends RecyclerView.Adapter<BoardAdapter.ViewHolder> {

    private final int[] imageMass = {
            R.drawable.first,
            R.drawable.third,
            R.drawable.forth,
            R.drawable.second
    };

    private final  String[]  title = {
            "",
            "Have a good time",
            "Cherishing love ",
            "Have a break up"
    };

    private final String[] desc = {
            "It's Funs a many more",
            "You should take the time to help those who heed you",
            "It's now no longer possible for you to cherish love",
            "We have made the correction for you don't worry   " +
                    "Maybe someone is waiting for you"
    };


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_vp,
                parent,
                false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(imageMass[position], title[position], desc[position]);
    }

    @Override
    public int getItemCount() {
        return imageMass.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private final TextView title, desc;
        private final ImageView img;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.vp_text);
            desc = itemView.findViewById(R.id.vp_text2);
            img = itemView.findViewById(R.id.vp_img);
        }

        public void onBind(int img, String title, String desc) {
            this.title.setText(title);
            this.desc.setText(desc);
            this.img.setImageResource(img);
        }
    }
}
