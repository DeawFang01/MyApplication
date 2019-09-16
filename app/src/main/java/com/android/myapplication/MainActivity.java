package com.android.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private final CallbackManager callbackManager;
    private Activity context;
    private PreferencesShared preferencesShared;
    public LoginFacebook(LoginButton login, Activity context, PreferencesShared pref, final Intent intent) {
        CallbackManager = CallbackManager.Factory.create();
        this.context = context;
        preferencesShared = pref;
        login.setReadPermissions(Arrays.asList("public_profile", "user_friends"));
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        callbackManager = CallbackManager.Factory.create();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginButton = (LoginButton) findViewById(R.id.login_button);
        loginButton.setReadPermissions("email");
        // If using in a fragment
        loginButton.setFragment(this);

        // Callback registration
        login.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Log.d("facebook", "succes" + loginResult.getAccessToken().getToken() + "id" + loginResult.getAccessToken().getExpires() + "data" + loginResult.getAccessToken().getUserId());
                conectedwithFacebook(loginResult.getAccessToken().getToken(),intent);
                try {
                                          String str_email = JSONObject.getString("email");
                                            Toast.makeText(MainActivity.this,str_email,Toast.LENGTH_LONG).show();
                                       }
                                        catch ( JSONException){
                                          e.printStackTrace();
                                        }
                                       Login.i("User" JSONObject.toString(1));
                                   }
                              });
                               request.setParameters(parameters);
                               request.executeAsync();
                            }
            }

            @Override
            public void onCancel() {
                Log.d("intra","facebook");
            }

            @Override
            public void onError(FacebookException Exception) {
                Log.d("facebook", "error" + error.toString());
            }
            }
        });

        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            callbackManager.onActivityResult(requestCode, resultCode, data);
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
