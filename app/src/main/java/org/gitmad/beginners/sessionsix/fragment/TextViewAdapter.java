package org.gitmad.beginners.sessionsix.fragment;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.gitmad.beginners.sessionsix.R;
import org.w3c.dom.Text;

public class TextViewAdapter extends RecyclerView.Adapter<TextViewAdapter.TextViewHolder> {

    private String[] listItemStrings;
    private OnThreadClickedListener itemClickListener;

    public TextViewAdapter(String[] listItemStrings, OnThreadClickedListener itemClickListener) {
        this.listItemStrings = listItemStrings;
        this.itemClickListener = itemClickListener;
    }

    @Override
    public TextViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View listItemView = LayoutInflater.from(parent.getContext())
                .inflate(android.R.layout.simple_list_item_1, parent, false);

        return new TextViewHolder(listItemView);
    }

    @Override
    public void onBindViewHolder(final TextViewHolder holder, int position) {
        holder.textView.setText(listItemStrings[position]);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.onThreadClicked(holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return listItemStrings.length;
    }

    public static class TextViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public TextViewHolder(View listItemView) {
            super(listItemView);

            textView = (TextView) listItemView.findViewById(android.R.id.text1);
        }
    }
}
