package org.gitmad.beginners.sessionsix.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.gitmad.beginners.sessionsix.R;

public class ChooseThreadFragment extends Fragment {

    private ThreadListAdapter adapter;

    private OnThreadClickedListener threadClickListener;

    public ChooseThreadFragment() {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof OnThreadClickedListener) {
            threadClickListener = (OnThreadClickedListener) context;
        } else {
            throw new ClassCastException(context.toString() + " must implement OnThreadClickedListener");
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String [] threadNames = getResources().getStringArray(R.array.thread_names);

        Drawable[] threadImages = getThreadImages();

        adapter = new ThreadListAdapter(threadNames, threadImages, threadClickListener);
    }

    @NonNull
    private Drawable[] getThreadImages() {
        TypedArray threadImageIds = getResources().obtainTypedArray(R.array.thread_image_ids);

        Drawable[] threadImages = new Drawable[threadImageIds.length()];

        for (int i = 0; i < threadImageIds.length(); i++) {
            threadImages[i] = threadImageIds.getDrawable(i);
        }

        threadImageIds.recycle();

        return threadImages;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_choosethread, container, false);

        RecyclerView threadsRecyclerView = (RecyclerView) rootView.findViewById(R.id.threadRecyclerView);
        configureRecyclerView(threadsRecyclerView);

        return rootView;
    }

    private void configureRecyclerView(RecyclerView threadsRecyclerView) {
        threadsRecyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        threadsRecyclerView.setLayoutManager(layoutManager);

        threadsRecyclerView.setAdapter(adapter);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setRetainInstance(true);
    }

    @Override
    public void onDetach() {
        super.onDetach();

        threadClickListener = null;
    }
}
