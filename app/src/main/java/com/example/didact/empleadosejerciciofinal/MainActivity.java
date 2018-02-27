package com.example.didact.empleadosejerciciofinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvempleados;
    ArrayList<CEmpleado> lista_empleados = new ArrayList<CEmpleado>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvempleados=(ListView)findViewById(R.id.lvempleados);
        adaptador();
        cargarDatos();




    }
    private void cargarDatos(){
        lista_empleados.add(new CEmpleado("3215645T","Adolfo Romero", "Maestro"));
        lista_empleados.add(new CEmpleado("65412365D","Ricardo Serrano", "Policía"));
        lista_empleados.add(new CEmpleado("32790645T","Marta Pérez", "Maestro"));
        lista_empleados.add(new CEmpleado("3215645T","Adolfo Romero", "Maestro"));
        lista_empleados.add(new CEmpleado("3215645T","Adolfo Romero", "Maestro"));

    }

    private void adaptador(){


        lvempleados = (ListView)findViewById(R.id.lvempleados);
        AdaptadorEmpleado adaptadorEmpleado=new AdaptadorEmpleado(this,
                lista_empleados);
        lvempleados.setAdapter(adaptadorEmpleado);
    }


    public void nuevoempleado (View v){
        Intent i=new Intent(getApplicationContext(),nuevoempleadoactivity.class);
        startActivity(i);



    }
}//fin del main
