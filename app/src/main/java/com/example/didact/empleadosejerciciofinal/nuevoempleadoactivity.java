package com.example.didact.empleadosejerciciofinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class nuevoempleadoactivity extends AppCompatActivity {
    static final String EXTRA_EMPLEADO="Empleado";


    EditText ednombre,eddni,editoficio;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevoempleadoactivity);



        ednombre=(EditText)findViewById(R.id.ednombre);
        eddni=(EditText)findViewById(R.id.eddni);
        editoficio=(EditText)findViewById(R.id.editoficio);

        Bundle b=getIntent().getExtras();
        if(b!=null){
            String nombre=b.getString ("Nombre");
            Toast.makeText(getApplicationContext(),
                    "Nombre recogido "+nombre,

                    Toast.LENGTH_LONG).show();
        }
    }








    public void insertar (View v) {


        String nombre = ednombre.getText().toString();
        String dni = eddni.getText().toString();
        String oficio = editoficio.getText().toString();


        if (nombre.equals("") || dni.equals("") || oficio.equals("")) {
            Toast.makeText(getApplicationContext(), "Rellena todos los campos", Toast.LENGTH_LONG).show();
        } else {

            //Crear el objeto libro con los valores del formulario
            CEmpleado e = new CEmpleado(nombre, dni, oficio);
            //Creamos el objeto intent para preparar el envio de datos.

            Intent i = new Intent(getApplicationContext(),MainActivity.class);
            //envimaos los extras con i.putextra

            i.putExtra(EXTRA_EMPLEADO, e);

            startActivity(i);


        }
    }

    public void modificar (View v){}



}
