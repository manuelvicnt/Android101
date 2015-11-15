package manuelvicnt.com.android101;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {

    public static final String PASS_NAME_TO_WELCOME_ACTIVITY = "passNameToWelcomeActivity";

    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        // Load the view container
        setContentView(R.layout.activity_welcome);

        // We access to the bundle passed to this Activity
        Bundle bundleFromPreviousActivity = getIntent().getExtras();
        getNameFromBundle(bundleFromPreviousActivity);

        // Now we can get the view and set the text
        TextView welcomeTextView = (TextView) findViewById(R.id.hello_name);
        welcomeTextView.setText("Hello " + name);
    }

    private void getNameFromBundle(Bundle bundleFromPreviousActivity) {

        // We check if we have data or not. It might be that they didn't pass anything to this activity
        if (bundleFromPreviousActivity != null) {

            // We check that the name is available
            if (bundleFromPreviousActivity.containsKey(PASS_NAME_TO_WELCOME_ACTIVITY)) {

                // We can access to the name now.
                name = bundleFromPreviousActivity.getString(PASS_NAME_TO_WELCOME_ACTIVITY);

                // If it's empty we handle the error
                if (TextUtils.isEmpty(name)) {
                    handleError();
                }
            } else {
                handleError();
            }

        } else {
            handleError();
        }
    }

    private void handleError() {

        name = "no one";
    }
}
