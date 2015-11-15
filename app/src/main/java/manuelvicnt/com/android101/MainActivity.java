package manuelvicnt.com.android101;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText yourNameEditText;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        // Load the view container
        setContentView(R.layout.activity_main);

        // Access to the toolbar programmatically
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        // Setting the toolbar object as the toolbar for the app
        setSupportActionBar(toolbar);

        // We get the object programmatically so we can access to its content
        yourNameEditText = (EditText) findViewById(R.id.name);

        // The same with the button
        submitButton = (Button) findViewById(R.id.submit_button);

        handleOnClickOnSubmitButton();
    }

    @Override
    protected void onResume() {

        super.onResume();

        // This method is called when the view comes visible. So we can handle some scenarios.
        // For example, let's say we want the color of the button to change depending on the
        // content of the EditText when the user goes to this screen.

        // If the EditText has no text on it, then it's going to be blue
        // if it has, it's going to be green

        // The first time you come to this screen the button is going to be blue,
        // If you type something and put the app to the background, when you open it again,
        // it's going to be green

        // The way of accessing to the res folder programmatically is with the getResources() method
        if (isYourNameEditTextEmpty()) {
            submitButton.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_light));
        } else {
            submitButton.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));
        }
    }

    private boolean isYourNameEditTextEmpty() {

        String textOnEditText = yourNameEditText.getText().toString();
        return TextUtils.isEmpty(textOnEditText);
    }

    private void handleOnClickOnSubmitButton() {

        final Activity mainActivity = this;

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nameOnEditText = yourNameEditText.getText().toString();

                Intent goToWelcomeScreen = new Intent(mainActivity, WelcomeActivity.class);
                goToWelcomeScreen.putExtra(WelcomeActivity.PASS_NAME_TO_WELCOME_ACTIVITY, nameOnEditText);
                startActivity(goToWelcomeScreen);
            }
        });
    }
}
