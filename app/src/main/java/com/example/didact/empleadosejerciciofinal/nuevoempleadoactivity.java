package com.example.didact.empleadosejerciciofinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class nuevoempleadoactivity extends AppCompatActivity {
    static final String EXTRA_EMPLEADO="Empleado";


    EditText ednombre,eddni,editoficio;
    private DatabaseReference dbRef;
    private ValueEventListener valueEventListener;


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


        if(nombre.equals("")||dni.equals("")||oficio.equals("")){
            Toast.makeText(getApplicationContext(),"Rellena todos los campos",Toast.LENGTH_LONG).show();
        }else{

            CEmpleado nuevoEmpleado=new CEmpleado(nombre,dni,oficio);
            dbRef = FirebaseDatabase.getInstance().getReference()
                    .child("Empleados");

            //String nueva_clave = dbRef.push().setValue(nuevoJugador, new DatabaseReference.CompletionListener(){
            String valoresnuevoEmpleado = nuevoEmpleado.getClass().toString();
            dbRef.child(valoresnuevoEmpleado).setValue(nuevoEmpleado, new DatabaseReference.CompletionListener(){
                public void onComplete(DatabaseError error, DatabaseReference ref) {
                    if(error == null) {
                        Toast.makeText(getApplicationContext(),
                                "INSERTADO CORRECTAMENTE",
                                Toast.LENGTH_LONG).show();
                        //limpiarFormulario();
                    }else {
                        Toast.makeText(getApplicationContext(),
                                "NO SE PUEDE INSETAR EL JUGADOR",
                                Toast.LENGTH_LONG).show();
                    }
                }
            });

        }
    }



    public void modificar (View v){


        String nombre = ednombre.getText().toString();
        String dni = eddni.getText().toString();
        String oficio = editoficio.getText().toString();


        if (nombre.equals("")  || dni.equals("") || oficio.equals("")) {
            Toast.makeText(getApplicationContext(), "Rellena todos los campos", Toast.LENGTH_LONG).show();
        } else {

            CEmpleado nuevoJugador = new CEmpleado(nombre,dni,oficio);
            dbRef = FirebaseDatabase.getInstance().getReference()
                    .child("Empleados");


            //String nueva_clave = dbRef.push().setValue(nuevoJugador, new DatabaseReference.CompletionListener(){
            String valoresañadidos= nuevoJugador.class;
            dbRef.child(valoresañadidos).setValue(nuevoJugador, new DatabaseReference.CompletionListener() {

                public void onComplete(DatabaseError error, DatabaseReference ref) {
                    if (error == null) {

                        Toast.makeText(getApplicationContext(),
                                "MODIFICADO CORRECTAMENTE",
                                Toast.LENGTH_LONG).show();

                        //limpiarFormulario();
                    } else {
                        Toast.makeText(getApplicationContext(),
                                "NO SE PUEDE MODIFICAR EL JUGADOR",
                                Toast.LENGTH_LONG).show();
                    }
                }
            });

        }






}
