package com.example.didact.empleadosejerciciofinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvempleados;
    ArrayList<CEmpleado> lista_empleados = new ArrayList<CEmpleado>();

    private DatabaseReference dbRef;
    private ValueEventListener valueEventListener;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvempleados=(ListView)findViewById(R.id.lvempleados);


        cargardatosFirebase();

        lvempleados.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                CEmpleado e =((CEmpleado)parent.getItemAtPosition(position));
                String oficio=e.getOficio();

                Toast.makeText(getApplicationContext(),"Oficio: "+oficio,
                        Toast.LENGTH_LONG).show();
            }
        });

        lvempleados.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view,
                                           int position, long id) {
                CEmpleado e =((CEmpleado)parent.getItemAtPosition(position));
                Intent i= new Intent(getApplicationContext(),nuevoempleadoactivity.class);
                startActivity(i);



                return true;
            }
        });


    }//fin del oncreate

    private void eliminardefirebase (DataSnapshot dataSnapshot){
        dbRef = FirebaseDatabase.getInstance().getReference()
                .child("Empleados");

        String idseleccionada = lvempleados.getSelectedItem().toString();
        dbRef.child(idseleccionada).removeValue(new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError error, DatabaseReference databaseReference) {
                if (error == null) {

                    Toast.makeText(getApplicationContext(),
                            "ELIMINADO CORRECTAMENTE",
                            Toast.LENGTH_LONG).show();

                    limpiarFormulario();
                } else {
                    Toast.makeText(getApplicationContext(),
                            "NO SE PUEDE ELIMINAR EL JUGADOR",
                            Toast.LENGTH_LONG).show();
                }


            }


        });

    }





    private void cagarDatosListView(DataSnapshot dataSnapshot){


        lista_empleados.add(dataSnapshot.getValue(CEmpleado.class));

        AdaptadorEmpleado adaptadorEmpleado=new AdaptadorEmpleado(this,
                lista_empleados);

        lvempleados.setAdapter(adaptadorEmpleado);
    }


    private void cargardatosFirebase() {


//referencia a la base de datos
        dbRef= FirebaseDatabase.getInstance().getReference().child("Empleados");
//añadimos el evento que nos devolvera los valores
        valueEventListener=new ValueEventListener(){
            @Override
            public void onDataChange(DataSnapshot dataSnapshot){
                //
                lista_empleados.clear();
                for (DataSnapshot empleadosDataSnapshot: dataSnapshot.getChildren()){
                    cagarDatosListView(empleadosDataSnapshot);
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError){
                Log.e("segundaactivity", "Database ERROR");


            }

        };//asignamos el evento para que sea en tiempo real
        dbRef.addValueEventListener(valueEventListener);

    }





    public void nuevoempleado (View view){
        Intent i=new Intent(getApplicationContext(),nuevoempleadoactivity.class);
        startActivity(i);



    }
    private void limpiarFormulario(){
        lvempleados.clearFocus();


    }





}//fin del main
