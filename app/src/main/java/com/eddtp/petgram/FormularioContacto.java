package com.eddtp.petgram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.eddtp.petgram.Mail.SendMail;

public class FormularioContacto extends AppCompatActivity implements View.OnClickListener {

    public EditText et_nombre;
    public EditText et_correo;
    public EditText et_descripcion;
    public Button btn_enviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fomulario_contacto);

        Toolbar action_bar = (Toolbar) findViewById(R.id.action_bar);
        setSupportActionBar(action_bar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        et_nombre = (EditText) findViewById(R.id.et_nombre);
        et_correo = (EditText) findViewById(R.id.et_correo);
        et_descripcion = (EditText) findViewById(R.id.et_descripcion);
        btn_enviar = (Button) findViewById(R.id.btn_enviar);

        btn_enviar.setOnClickListener(this);
    }

    public void onClick(View view) { sendEmail(); }

    private void sendEmail(){

        String email = et_correo.getText().toString().trim();
        String subject = et_nombre.getText().toString().trim();
        String message = et_descripcion.getText().toString().trim();

        SendMail sendMail = new SendMail(this, email, subject, message);

        sendMail.execute();
    }
}