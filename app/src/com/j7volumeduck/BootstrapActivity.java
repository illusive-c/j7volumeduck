package com.j7volumeduck;

import android.app.Activity;
import android.os.Bundle;

/**
 * No-display entry point for installers and for the DSA "start app at boot"
 * hook: launches the foreground service and disappears.
 */
public class BootstrapActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DuckService.start(this);
        finish();
    }
}
