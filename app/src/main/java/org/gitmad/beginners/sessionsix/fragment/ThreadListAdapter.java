package org.gitmad.beginners.sessionsix.fragment;

import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.gitmad.beginners.sessionsix.R;

public class ThreadListAdapter extends RecyclerView.Adapter<ThreadListAdapter.ThreadViewHolder> {

    public static final int NULL_RESOURCE = 0;
    private String[] listItemStrings;
    private Bitmap[] threadImages;
    private OnThreadClickedListener itemClickListener;

    public ThreadListAdapter(String[] listItemStrings, Bitmap[] threadImages, OnThreadClickedListener itemClickListener) {
        this.listItemStrings = listItemStrings;
        this.threadImages = threadImages;
        this.itemClickListener = itemClickListener;
}

    @Override
    public ThreadViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View listItemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.thread_list_item, parent, false);

        listItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return new ThreadViewHolder(listItemView, itemClickListener);
    }

    @Override
    public void onBindViewHolder(final ThreadViewHolder holder, int position) {
        holder.textView.setText(listItemStrings[position]);
        holder.imageView.setImageBitmap(threadImages[position]);
        holder.threadIndex = position;
    }

    @Override
    public int getItemCount() {
        return listItemStrings.length;
    }

    public static class ThreadViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;
        int threadIndex;

        public ThreadViewHolder(View listItemView, final OnThreadClickedListener itemClickListener) {
            super(listItemView);

            listItemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemClickListener.onThreadClicked(threadIndex);
                }
            });

            textView = (TextView) listItemView.findViewById(R.id.threadNameTextView);
            imageView = (ImageView) listItemView.findViewById(R.id.threadImageView);
        }
    }
}
