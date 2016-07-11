package org.gitmad.beginners.sessionsix.fragment;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.gitmad.beginners.sessionsix.R;

public class ChooseThreadFragment extends Fragment {

    //TODO add alternative RecyclerView implementation to demo it.

    private ArrayAdapter<String> threadsArrayAdapter;

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

        threadsArrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1);

        String [] threadNames = getResources().getStringArray(R.array.thread_names);
        threadsArrayAdapter.addAll(threadNames);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_choosethread, container, false);

        ListView threadsListView = (ListView) rootView.findViewById(R.id.threadListView);
        threadsListView.setAdapter(threadsArrayAdapter);

        threadsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                threadClickListener.onThreadClicked(position);
            }
        });

        return rootView;
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
