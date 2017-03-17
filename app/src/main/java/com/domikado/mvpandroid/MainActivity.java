package com.domikado.mvpandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements LoginView {

    private LoginInterface presenter;
    private EditText etUsername;
    private EditText etPass;
    private Button btLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = (EditText) findViewById(R.id.editText);
        etPass = (EditText) findViewById(R.id.editText2);
        btLogin = (Button) findViewById(R.id.button);

        presenter = new LoginPresent(this);
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.login(etUsername.getText().toString(), etPass.getText().toString());
            }
        });
    }

    @Override
    public void showMessageError() {
        Toast.makeText(this, "Username or password is wrong", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginSuccess() {
        Toast.makeText(this, "Sukses login", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginError() {
        Toast.makeText(this, "invalid login", Toast.LENGTH_SHORT).show();
    }
}
