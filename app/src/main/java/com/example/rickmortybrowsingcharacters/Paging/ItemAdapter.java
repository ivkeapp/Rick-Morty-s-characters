package com.example.rickmortybrowsingcharacters.Paging;

import android.arch.paging.PagedListAdapter;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.rickmortybrowsingcharacters.Models.Result;
import com.example.rickmortybrowsingcharacters.Paging.AlertDialog.ShowAlertDialog;
import com.example.rickmortybrowsingcharacters.R;

public class ItemAdapter extends PagedListAdapter<Result, ItemAdapter.ItemViewHolder> {

    private Context mContext;

    public ItemAdapter(Context mContext) {

        super(DIFF_CALLBACK);
        this.mContext = mContext;

    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.list_item_layout, viewGroup, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ItemViewHolder itemViewHolder, int i) {

        final Result result = getItem(i);

        if(result != null){
            Glide.with(mContext)
                    .load(result.getImage())
                    .into(itemViewHolder.characterImage);

            itemViewHolder.headline.setText(result.getName());
        }else{
            Toast.makeText(mContext, "Error Loading Character", Toast.LENGTH_SHORT).show();
        }

        itemViewHolder.parent_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowAlertDialog dialog = new ShowAlertDialog();
                dialog.showInfoDialog(mContext, result);
            }
        });

    }

    //Determine whether two objects or two list objects are the same or not
    private static DiffUtil.ItemCallback<Result> DIFF_CALLBACK = new DiffUtil.ItemCallback<Result>() {

        @Override
        public boolean areItemsTheSame(@NonNull Result result, @NonNull Result t1) {
            return result.getId().equals(t1.getId());
        }

        @Override
        public boolean areContentsTheSame(@NonNull Result result, @NonNull Result t1) {
            return result.equals(t1);
        }
    };

    class ItemViewHolder extends RecyclerView.ViewHolder {

        ImageView characterImage;
        TextView headline;
        RelativeLayout parent_layout;

        private ItemViewHolder(@NonNull View itemView) {

            super(itemView);

            characterImage = itemView.findViewById(R.id.character_image);
            headline = itemView.findViewById(R.id.headline);
            parent_layout = itemView.findViewById(R.id.list_item_parent_layout);

        }
    }

}
