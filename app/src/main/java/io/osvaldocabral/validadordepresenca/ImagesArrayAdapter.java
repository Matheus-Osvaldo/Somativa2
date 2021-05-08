package io.osvaldocabral.validadordepresenca;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.net.URI;

public class ImagesArrayAdapter extends RecyclerView.Adapter<ImagesArrayAdapter.ViewHolder> {


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View itemView = layoutInflater.inflate(R.layout.cardview_item, parent,false);
        return new ViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if(DataModel.getInstance().listTokens.size() == 0) return;
        File file = new File(DataModel.getInstance().listTokens.get(position).getPhoto());
        holder.imageView.setImageURI(Uri.fromFile(file));
    }


    @Override
    public int getItemCount() {
        return DataModel.getInstance().listTokens.size();
    }

    
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
