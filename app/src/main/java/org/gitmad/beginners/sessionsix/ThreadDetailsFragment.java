package org.gitmad.beginners.sessionsix;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class ThreadDetailsFragment extends Fragment {

    private static String KEY_THREAD_INDEX = "thread index key";

    private TextView descriptionTextView;
    private TextView titleTextView;

    public static ThreadDetailsFragment newInstance(int threadIndex) {
        ThreadDetailsFragment fragment = new ThreadDetailsFragment();

        Bundle arguments = new Bundle();
        arguments.putInt(KEY_THREAD_INDEX, threadIndex);

        fragment.setArguments(arguments);

        return fragment;
    }

    public ThreadDetailsFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_threaddetails, container, false);

        titleTextView = (TextView) rootView.findViewById(R.id.threadNameTextView);
        descriptionTextView = (TextView) rootView.findViewById(R.id.threadDescriptionTextView);

        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (getArguments() != null) {
            setThread(getArguments().getInt(KEY_THREAD_INDEX));

        } else {
            displayNoThread();
        }
    }

    private void displayNoThread() {
        titleTextView.setText(getResources().getString(R.string.select_a_thread));
        descriptionTextView.setText("");
    }

    public void setThread(int threadIndex) {
        String threadName = getResources().getStringArray(R.array.thread_names)[threadIndex];
        String threadDescription = getResources().getStringArray(R.array.thread_descriptions)[threadIndex];

        titleTextView.setText(threadName);
        descriptionTextView.setText(threadDescription);
    }
}
