package com.example.cvapplication.ui.main;

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

public class MainActivity extends AppCompatActivity implements MainView {

    @BindView(R.id.rv_cvs)
    RecyclerView mRvCVs;

    CVAdapter cvAdapter;
    RestAPIHelper restAPIHelper = new RestAPIHelper();

    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter = new MainPresenter(new RestAPIHelper().getWebService());
        presenter.attach(this);

        mRvCVs.setLayoutManager(new LinearLayoutManager(this));
        presenter.getCVs();
    }

    @Override
    protected void onDestroy() {
        presenter.detach();
        super.onDestroy();
    }

    @Override
    public void displayData(List<CV> cvList) {
        cvAdapter = new CVAdapter(cvList);
        mRvCVs.setAdapter(cvAdapter);
    }

    @Override
    public void displayMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
