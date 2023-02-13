package com.swetha.freedomfighters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FighterAdapter extends RecyclerView.Adapter<FighterAdapter.FighterViewHolder> {

    Context context;
    int fighterImages[];
    String fighterNames[];

    public FighterAdapter(Context context, int[] fighterImages, String[] fighterNames) {
        this.context = context;
        this.fighterImages = fighterImages;
        this.fighterNames = fighterNames;
    }

    @NonNull
    @Override
    public FighterAdapter.FighterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.one_item_design, parent, false);
        return new FighterViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull FighterAdapter.FighterViewHolder holder, int position) {
        holder.images.setImageResource(fighterImages[position]);
        holder.names.setText(fighterNames[position]);
    }

    @Override
    public int getItemCount() {
        return fighterImages.length;
    }

    public class FighterViewHolder extends RecyclerView.ViewHolder {
        ImageView images;
        TextView names;

        public FighterViewHolder(@NonNull View itemView) {
            super(itemView);
            images = itemView.findViewById(R.id.fighterImage);
            names = itemView.findViewById(R.id.fighterName);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    Toast.makeText(context, fighterNames[pos], Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
