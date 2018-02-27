package com.example.didact.empleadosejerciciofinal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

import com.example.didact.empleadosejerciciofinal.CEmpleado;
import com.example.didact.empleadosejerciciofinal.R;

import java.util.ArrayList;

/**
 * Created by DIDACT on 27/02/2018.
 */



    public class AdaptadorEmpleado extends ArrayAdapter<CEmpleado> {
        ArrayList<CEmpleado> empleados;
        Context c;
        public AdaptadorEmpleado(Context c, ArrayList<CEmpleado> empleados) {
            super(c, R.layout.item_empleados, empleados);
            this.empleados = empleados;
            this.c = c;
        }
        public View getView(int position, View view, ViewGroup
                viewGroup) {
            LayoutInflater inflater =
                    LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.item_empleados, null);


            TextView tvoficio = (TextView)
                    item.findViewById(R.id.tvoficio);

            tvoficio.setText(empleados.get(position).getOficio());

            TextView tvnombre = (TextView)
                    item.findViewById(R.id.tvnombre);

            tvnombre.setText(empleados.get(position).getNombre() );

            TextView tvdni = (TextView)
                    item.findViewById(R.id.tvdni);

            tvdni.setText(empleados.get(position).getDni());


            return item;
        }
    }

