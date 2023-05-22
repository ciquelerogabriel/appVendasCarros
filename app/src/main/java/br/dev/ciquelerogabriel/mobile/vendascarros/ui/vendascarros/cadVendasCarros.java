    package br.dev.ciquelerogabriel.mobile.vendascarros.ui.vendascarros;

    import android.content.Context;
    import android.os.Bundle;

    import androidx.appcompat.app.AppCompatActivity;
    import androidx.fragment.app.Fragment;

    import android.view.LayoutInflater;
    import android.view.View;
    import android.view.ViewGroup;
    import android.widget.Button;
    import android.widget.CalendarView;
    import android.widget.EditText;
    import android.widget.Spinner;
    import android.widget.Toast;

    import com.android.volley.Request;
    import com.android.volley.RequestQueue;
    import com.android.volley.Response;
    import com.android.volley.VolleyError;
    import com.android.volley.toolbox.JsonObjectRequest;
    import com.android.volley.toolbox.Volley;
    import com.google.android.material.snackbar.Snackbar;

    import java.text.SimpleDateFormat;
    import java.util.Date;

    import br.dev.ciquelerogabriel.mobile.vendascarros.R;
    import br.dev.ciquelerogabriel.mobile.vendascarros.model.Carro;

    /**
     * A simple {@link Fragment} subclass.
     * create an instance of this fragment.
     */
    public class cadVendasCarros extends Fragment implements View.OnClickListener, Response.ErrorListener,
            Response.Listener {

        // atributos
        private EditText etNome;
        private EditText etCPF;
        private EditText etContato;
        private Spinner spMarca;
        private EditText etModelo;
        private Spinner spAno;
        private EditText etPlaca;
        private EditText etChassi;
        private EditText etValor;
        private CalendarView cvData;
        private Spinner spGarantia;

        private Button btSalvar;

        //volley
        private RequestQueue requestQueue;
        private JsonObjectRequest jsonObjectReq;
        private View root;


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
            this.root = inflater.inflate(R.layout.fragment_cad_vendas_carros, container, false);

            //vincular objetos com xml
            this.etNome = (EditText) root.findViewById(R.id.etNome);
            this.etCPF = (EditText) root.findViewById(R.id.etCPF);
            this.etContato = (EditText) root.findViewById(R.id.etContato);
            this.spMarca = (Spinner) root.findViewById(R.id.spMarca);
            this.etModelo = (EditText) root.findViewById(R.id.etModelo);
            this.spAno = (Spinner) root.findViewById(R.id.spAno);
            this.etPlaca = (EditText) root.findViewById(R.id.etPlaca);
            this.etChassi = (EditText) root.findViewById(R.id.etChassi);
            this.etValor = (EditText) root.findViewById(R.id.etValor);
            this.cvData = (CalendarView) root.findViewById(R.id.cvData);
            this.spGarantia = (Spinner) root.findViewById(R.id.spGarantia);
            //this.btSalvar = (EditText) root.findViewById(R.id.btSalvar);

            //instanciando a fila de requests - caso o objeto seja o root
            this.requestQueue = Volley.newRequestQueue(root.getContext());
            //inicializando a fila de requests do SO
            this.requestQueue.start();

            return root;

        }

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
    //verificando se é o botão salvar
                case R.id.Svr:
                    //instanciando classe de negócio
                    Carro p = new Carro();
                    //populando objeto com dados da tela
                    p.setModeloCarro(this.etModelo.getText().toString());
                    p.setValorCarro(Double.valueOf(this.etValor.getText().toString()));
                    p.setPlacaCarro(this.etPlaca.getText().toString());
                    p.setChassiCarro(this.etChassi.getText().toString());
                    // indice do item selecionado do Spinner
                    p.setMarcaCarro(String.valueOf(this.spMarca.getSelectedItemPosition()));
                    p.setAnoCarro(this.spAno.getSelectedItemPosition());
                    p.setGarantiaCarro(String.valueOf(this.spGarantia.getSelectedItemPosition()));
                    //Pegando a Data do CalendarView
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    String dataSelecionada = sdf.format(new Date(cvData.getDate()));
                    p.setDataCarro(dataSelecionada);

                    //request para servidor REST
                    jsonObjectReq = new JsonObjectRequest(
                            Request.Method.POST,
                            "http://10.0.2.2:8080/segServer/rest/usuario",
                            p.toJsonObject(), this, this);
                    requestQueue.add(jsonObjectReq);
                    break;
            }
       }

        @Override
        public void onErrorResponse(VolleyError error) {
            Snackbar mensagem = Snackbar.make(root,
                    "Ops! Houve um problema ao realizar o cadastro: " +
                            error.toString(),Snackbar.LENGTH_LONG);
            mensagem.show();
        }

        @Override
        public void onResponse(Object response) {
            String resposta = response.toString();
            try {
                if(resposta.equals("500")) {
                    Snackbar mensagem = Snackbar.make(root,
                            "Erro! = " + resposta,
                            Snackbar.LENGTH_LONG);
                    mensagem.show();
                } else {
                    //sucesso
                    // limpar campos da tela
                    this.etNome.setText("");
                    this.etCPF.setText("");
                    this.etContato.setText("");
                    this.etModelo.setText("");
                    this.etPlaca.setText("");
                    this.etChassi.setText("");
                    this.etValor.setText("");
                    //mensagem de sucesso
                    Snackbar mensagem = Snackbar.make(root,
                            "Sucesso! = " + resposta,
                            Snackbar.LENGTH_LONG);
                    mensagem.show();
                }
            } catch (Exception e) { e.printStackTrace(); }

        }
    }
