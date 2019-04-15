package com.example.cvapplication.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.os.Bundle;
import android.widget.Toast;

import com.example.cvapplication.MainApplication;
import com.example.cvapplication.R;
import com.example.cvapplication.data.network.WebService;
import com.example.cvapplication.data.network.model.CV;
import com.example.cvapplication.di.component.ActivityComponent;
import com.example.cvapplication.di.component.DaggerActivityComponent;
import com.example.cvapplication.ui.adapter.CVAdapter;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainView {
    @BindView(R.id.rv_cvs)
    RecyclerView mRvCVs;

    CVAdapter cvAdapter;

    @Inject
    WebService webService;

    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        ActivityComponent component = DaggerActivityComponent.builder().applicationComponent(
                MainApplication.getInstance().getApplicationComponent()).build();
        component.inject(this);
        presenter = new MainPresenter(webService);
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
