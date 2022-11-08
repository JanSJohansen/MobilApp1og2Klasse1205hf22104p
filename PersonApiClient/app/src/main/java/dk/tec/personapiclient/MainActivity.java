package dk.tec.personapiclient;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity
{
    TextView txtName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtName = findViewById(R.id.txtName);

        ElevService elevService = ServiceBuilder.buildService(ElevService.class);
        Call<Elev> request = elevService.getElevById(1004);
        request.enqueue(new Callback<Elev>() {
            @Override
            public void onResponse(Call<Elev> call, Response<Elev> response)
            {
                Elev elev = response.body();
                txtName.setText(elev.navn);
            }

            @Override
            public void onFailure(Call<Elev> call, Throwable t)
            {
                txtName.setText(t.getMessage());
            }
        });
    }
}