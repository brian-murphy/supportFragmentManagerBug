package org.gitmad.beginners.sessionsix;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements OnThreadClickedListener {

    private static String KEY_CURRENT_THREAD_INDEX = "current thread index key";
    private int currentThreadIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        if (savedInstanceState != null && savedInstanceState.containsKey(KEY_CURRENT_THREAD_INDEX)) {

            restoreThreadIndex(savedInstanceState);
        }
    }

    private void restoreThreadIndex(Bundle savedInstanceState) {
        currentThreadIndex = savedInstanceState.getInt(KEY_CURRENT_THREAD_INDEX);
        displayThread();
    }

    @Override
    public void onThreadClicked(int threadIndex) {
        currentThreadIndex = threadIndex;
        displayThread();
    }

    private void displayThread() {
        if (orientationIsLandscape()) {
            useFragmentToDisplayThread(currentThreadIndex);

        } else {
            useNewActivityToDisplayThread(currentThreadIndex);
        }
    }

    private void useNewActivityToDisplayThread(int threadIndex) {
        Intent intent = new Intent(this, ThreadDetailsActivity.class);
        intent.putExtra(ThreadDetailsActivity.KEY_THREAD_INDEX, threadIndex);

        startActivity(intent);
    }

    private void useFragmentToDisplayThread(int threadIndex) {
        ThreadDetailsFragment detailsFragment = (ThreadDetailsFragment) getSupportFragmentManager()
                .findFragmentById(R.id.detailsFragment);

        detailsFragment.setThread(threadIndex);
    }

    private boolean orientationIsLandscape() {
        return getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

        outState.putInt(KEY_CURRENT_THREAD_INDEX, currentThreadIndex);

        super.onSaveInstanceState(outState);
    }
}
