package com.md.quizz;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
public EditText txtUser;
public EditText txtPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtUser = (EditText) findViewById(R.id.editTextUser);
        txtPass = (EditText) findViewById(R.id.editTextPass);
    }
    public void login(View view){
        String user = String.valueOf(txtUser.getText());
        String pass = String.valueOf(txtPass.getText());

        if (pass.equals("admin") && user.equals("admin")){
            Intent obj = new Intent(this, QuizzActivity.class);
            startActivity(obj);
        }else{

            AlertDialog.Builder builder = new AlertDialog.Builder(this)
                    .setTitle("Error de incio")
                    .setMessage("Contraseña o usuario incorrectos")
                    .setPositiveButton("Entendido",null);
            builder.show();
        }
    }
}