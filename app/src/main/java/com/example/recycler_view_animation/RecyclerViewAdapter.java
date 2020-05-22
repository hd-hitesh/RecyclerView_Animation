package com.example.recycler_view_animation;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ItemViewHolder> {


    private List<String> itemList;


    public RecyclerViewAdapter(List<String> itemList) {
        this.itemList = itemList;
    }


    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row, viewGroup, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder myViewHolder, int position) {
        myViewHolder.tvItem.setText(itemList.get(position));
        Animation animation = AnimationUtils.loadAnimation(myViewHolder.itemView.getContext(), R.anim.item_animation_slide_from_right);
//        Animation animation = AnimationUtils.loadAnimation(myViewHolder.itemView.getContext(), R.anim.item_animation_fall_down);
        myViewHolder.itemView.startAnimation(animation);
    }

    @Override
    public int getItemCount() {
        return itemList == null ? 0 : itemList.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {

        TextView tvItem;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            tvItem = itemView.findViewById(R.id.tvItem);
        }
    }
}