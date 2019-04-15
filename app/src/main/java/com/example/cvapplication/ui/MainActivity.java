package com.example.cvapplication.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.widget.Toast;

import com.example.cvapplication.R;
import com.example.cvapplication.data.Network.Model.CV;
import com.example.cvapplication.data.Network.RestAPIHelper;
import com.example.cvapplication.ui.adapter.CVAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rv_cvs)
    RecyclerView mRvCVs;

    CVAdapter cvAdapter;
    RestAPIHelper restAPIHelper = new RestAPIHelper();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mRvCVs.setLayoutManager(new LinearLayoutManager(this));
        restAPIHelper.getWebService().getCVs().enqueue(new Callback<List<CV>>() {
            @Override
            public void onResponse(Call<List<CV>> call, Response<List<CV>> response) {
                if(response.isSuccessful()){
                    cvAdapter = new CVAdapter(response.body());
                    mRvCVs.setAdapter(cvAdapter);
                }else{
                    Toast.makeText(MainActivity.this,response.message(),Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<CV>> call, Throwable t) {
                Toast.makeText(MainActivity.this,t.getLocalizedMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }
}
