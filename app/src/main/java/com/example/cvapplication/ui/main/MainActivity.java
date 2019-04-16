package com.example.cvapplication.ui.main;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.cvapplication.MainApplication;
import com.example.cvapplication.R;
import com.example.cvapplication.data.temp.WebService;
import com.example.cvapplication.data.temp.temp2.CV;
import com.example.cvapplication.di.component.ActivityComponent;
import com.example.cvapplication.di.component.DaggerActivityComponent;
import com.example.cvapplication.ui.adapter.CVAdapter;

import java.util.List;

import javax.inject.Inject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainView {
    @BindView(R.id.rv_cvs)
    RecyclerView mItems;

    @BindView(R.id.pb_home)
    ProgressBar mProgress;

    @Inject
    WebService webService;

    private MainPresenter presenter;
    private CVAdapter cvAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        ActivityComponent component = DaggerActivityComponent.builder()
                .applicationComponent(MainApplication.getInstance().getApplicationComponent())
                .build();
        component.inject(this);

        presenter = new MainPresenter(webService);
        presenter.attach(this);

        cvAdapter = new CVAdapter();
        mItems.setLayoutManager(new LinearLayoutManager(this));
        mItems.setAdapter(cvAdapter);

        presenter.getCVs();
    }

    @Override
    protected void onDestroy() {
        presenter.detach();
        super.onDestroy();
    }

    @Override
    public void displayData(List<CV> cvList) {
        cvAdapter.setData(cvList);
    }

    @Override
    public void displayMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showProgress() {
        mProgress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mProgress.setVisibility(View.GONE);
    }
}
