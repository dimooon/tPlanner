package tplanner.dimooon.com.tplanner;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import fr.castorflex.android.smoothprogressbar.SmoothProgressBar;
import fr.castorflex.android.smoothprogressbar.SmoothProgressBarUtils;
import fr.castorflex.android.smoothprogressbar.SmoothProgressDrawable;


public class LunchActivity extends Activity {

    private SmoothProgressBar mGoogleNow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lunch);

        mockLoadingProgress();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(LunchActivity.this,MainActivity.class));
                finish();
            }
        },3 * 1000);

    }

    private void mockLoadingProgress(){

        mGoogleNow = (SmoothProgressBar) findViewById(R.id.google_now);
        mGoogleNow.setSmoothProgressDrawableBackgroundDrawable(
                SmoothProgressBarUtils.generateDrawableWithColors(
                        getResources().getIntArray(R.array.pocket_background_colors),
                        ((SmoothProgressDrawable) mGoogleNow.getIndeterminateDrawable()).getStrokeWidth()));

    }

}