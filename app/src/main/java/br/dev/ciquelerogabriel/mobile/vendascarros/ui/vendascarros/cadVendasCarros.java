package br.dev.ciquelerogabriel.mobile.vendascarros.ui.vendascarros;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import br.dev.ciquelerogabriel.mobile.vendascarros.R;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class cadVendasCarros extends Fragment {

    // atributos
    private EditText etNome;
    private EditText etCPF;
    private EditText etChassi;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((AppCompatActivity)getActivity()).getSupportActionBar()
                .setDisplayShowCustomEnabled(false);
        ((AppCompatActivity) getActivity()).getSupportActionBar()
                .setDisplayHomeAsUpEnabled(false);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cad_vendas_carros, container, false);
    }
}