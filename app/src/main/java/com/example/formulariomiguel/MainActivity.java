package com.example.formulariomiguel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    DatePicker datePicker;
    TextView textView;
    String nombre, telefono, email, descripcion, fecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Declaraciones
        datePicker=(DatePicker) findViewById(R.id.datepicker);
        EditText ETnombre = findViewById(R.id.nombre);
        EditText ETtelefono = findViewById(R.id.telefono);
        EditText ETemail = findViewById(R.id.email);
        EditText ETdescripcion = findViewById(R.id.descripcion);
        Button btn = findViewById(R.id.BotonSiguiente);


        Bundle parametros = getIntent().getExtras();
        if(parametros != null)
        { //Captar parametros si es que hay
            String nombre = parametros.getString("Nombre");
            String telefono = parametros.getString("Telefono");
            String email = parametros.getString("Email");
            String descripcion = parametros.getString("Descripcion");
            String fecha = parametros.getString("Fecha");

            //Asignarlos
            ETnombre.setText(nombre);
            ETtelefono.setText(telefono);
            ETemail.setText(email);
            ETdescripcion.setText(descripcion);

        }



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){

                //Guardar los valores en string
                fecha = datePicker.getDayOfMonth()+ "-" + datePicker.getMonth() + "-" + datePicker.getYear();
                nombre = ETnombre.getText().toString();
                telefono = ETtelefono.getText().toString();
                email = ETemail.getText().toString();
                descripcion = ETdescripcion.getText().toString();

                Intent intent = new Intent(MainActivity.this,ConfirmacionDatos.class);
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