package org.gitmad.beginners.sessionsix.fragment;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by brian on 7/11/16.
 */
public class TextViewAdapter extends RecyclerView.Adapter<TextViewAdapter.TextViewHolder> {

    @Override
    public TextViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        
    }

    @Override
    public void onBindViewHolder(TextViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    private class TextViewHolder extends RecyclerView.ViewHolder {

        public TextViewHolder(View itemView) {
            super(itemView);
        }
    }
}
