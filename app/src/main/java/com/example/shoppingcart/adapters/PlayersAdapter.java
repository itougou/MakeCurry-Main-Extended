package com.example.shoppingcart.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoppingcart.R;
import com.example.shoppingcart.databinding.CookRowBinding;
import com.example.shoppingcart.databinding.TextItemViewBinding;

public class PlayersAdapter  extends RecyclerView.Adapter<PlayersAdapter.ViewHolder>{
    private String[] players = {"ジャンボ鶴田","天龍源一郎","長州力","スタン・ハンセン"};

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from( parent.getContext() );
        View view = layoutInflater.inflate(R.layout.text_item_view, parent, false);
        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlayersAdapter.ViewHolder holder, int position) {
        String item = this.players[position];
        holder.textView.setText(item);
    }

    @Override
    public int getItemCount() {
        return this.players.length;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public ViewHolder(View view) {
            super(view);
            textView = view.findViewById(R.id.textViewPlayer);
        }
    }
}
