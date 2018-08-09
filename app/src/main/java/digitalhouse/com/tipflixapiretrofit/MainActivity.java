package digitalhouse.com.tipflixapiretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import digitalhouse.com.tipflixapiretrofit.pojo.Example;
import digitalhouse.com.tipflixapiretrofit.Service.ConfiguradorRetrofit;
import digitalhouse.com.tipflixapiretrofit.Service.FilmesService;
import digitalhouse.com.tipflixapiretrofit.pojo.Result;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView text;
    private static final String TAG = "David";
    private int valor;
    public int page = 0;
    public Button botao1;
    List <Result> lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.text);
        botao1 = findViewById(R.id.botao_1);
        botao1.setOnClickListener(this);

        FilmesService service = ConfiguradorRetrofit.getRetrofitInstance().create(FilmesService.class);
        Call<Example> requestCatalogo = service.listCatalogo();

        requestCatalogo.enqueue(new Callback<Example>() {



            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                if (response.isSuccessful()) {
                    Example result = response.body();
                    lista = result.getExample();
                    text.setText(lista.get(page).getTitle());
                }
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Log.e(TAG, "Deu muito ruim" + t.getMessage());
            }
        });

    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.botao_1){
            page++;
            text.setText(lista.get(page).getTitle());

        }

    }



}
