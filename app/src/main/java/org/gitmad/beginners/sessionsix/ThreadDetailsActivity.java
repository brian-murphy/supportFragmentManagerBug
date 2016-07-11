package org.gitmad.beginners.sessionsix;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ThreadDetailsActivity extends AppCompatActivity {

    public static String KEY_THREAD_INDEX = "thread index asdf";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_details);

        if (isNewOrientationLandscape()) {
            finish();

        } else if (savedInstanceState == null) {

            int threadIndex = getIntent().getIntExtra(KEY_THREAD_INDEX, -1);

            ThreadDetailsFragment detailsFragment = ThreadDetailsFragment.newInstance(threadIndex);

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.detailsFragmentFrame, detailsFragment)
                    .commit();
        }
    }

    private boolean isNewOrientationLandscape() {
        return getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
    }
}
