package com.roy.coffeetrip.activity.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.roy.coffeetrip.R;

/**
 * Created by ${Roy} on 16/5/27.
 */
public class LoginAty extends AppCompatActivity {

    private ImageView finishImg;
    private TextView signUpTv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_login);

        finishImg = (ImageView) findViewById(R.id.login_finish_img);
        finishImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        signUpTv = (TextView) findViewById(R.id.login_sign_up_tv);
        signUpTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginAty.this,SignUpAty.class);
                startActivity(intent);
            }
        });

    }
}
