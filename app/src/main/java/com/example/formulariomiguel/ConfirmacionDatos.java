package com.example.formulariomiguel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ConfirmacionDatos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacion_datos);

        Bundle parametros = getIntent().getExtras();
        String nombre = parametros.getString("Nombre");
        String telefono = parametros.getString("Telefono");
        String email = parametros.getString("Email");
        String descripcion = parametros.getString("Descripcion");
        String fecha = parametros.getString("Fecha");

        TextView TVnombre = findViewById(R.id.ConfNombre);
        TextView TVtelefono = findViewById(R.id.ConfTelefono);
        TextView TVemail = findViewById(R.id.ConfEmail);
        TextView TVdescripcion = findViewById(R.id.ConfDescripcion);
        TextView TVfecha = findViewById(R.id.ConfFechaNacimiento);

        TVnombre.setText(nombre);
        TVtelefono.setText(telefono);
        TVemail.setText(email);
        TVdescripcion.setText(descripcion);
        TVfecha.setText(fecha);


        Button btn2 = findViewById(R.id.BotonEditar);



        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){

                Intent intent = new Intent(ConfirmacionDatos.this,MainActivity.class);
                intent.putExtra("Nombre", nombre);
                intent.putExtra("Telefono", telefono);
                intent.putExtra("Email", email);
                intent.putExtra("Descripcion", descripcion);
                intent.putExtra("Fecha", fecha);
                startActivity(intent);
            }

            });

    }
}