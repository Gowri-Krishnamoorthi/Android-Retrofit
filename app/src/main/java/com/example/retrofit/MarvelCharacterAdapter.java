package com.example.retrofit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.List;

public class MarvelCharacterAdapter extends RecyclerView.Adapter<MarvelCharacterAdapter.ViewHolder> {

    private List<MarvelCharacter> characters;
    private Context context;

    public MarvelCharacterAdapter(Context context, List<MarvelCharacter> characters) {
        this.context = context;
        this.characters = characters;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_marvel_character, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MarvelCharacter character = characters.get(position);
        String imageUrl = character.getImageurl();
        Glide.with(context)
                .load(imageUrl)
                .into(holder.imageView);

        holder.name.setText(character.getName());
        holder.realName.setText(character.getRealname());
        holder.team.setText(character.getTeam());
        holder.firstAppearance.setText(character.getFirstappearance());
        holder.createdBy.setText(character.getCreatedby());
        holder.publisher.setText(character.getPublisher());
        holder.bio.setText(character.getBio());
    }

    @Override
    public int getItemCount() {
        return characters.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView name, realName, team, firstAppearance, createdBy, publisher, bio;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            name = itemView.findViewById(R.id.name);
            realName = itemView.findViewById(R.id.realName);
            team = itemView.findViewById(R.id.team);
            firstAppearance = itemView.findViewById(R.id.firstAppearance);
            createdBy = itemView.findViewById(R.id.createdBy);
            publisher = itemView.findViewById(R.id.publisher);
            bio = itemView.findViewById(R.id.bio);
        }
    }
}
