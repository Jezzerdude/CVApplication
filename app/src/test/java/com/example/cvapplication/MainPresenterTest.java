package com.example.cvapplication;

import com.example.cvapplication.data.network.WebService;
import com.example.cvapplication.data.network.model.CV;
import com.example.cvapplication.ui.main.MainPresenter;
import com.example.cvapplication.ui.main.MainView;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;

import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MainPresenterTest {
    @Rule
    public TestRule rule = new ImmediateSchedulersRule();

    @Mock
    MainView mainView;

    @Mock
    WebService webService;

    private MainPresenter presenter;
    private List<CV> cvs = new ArrayList<>();

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        presenter = new MainPresenter(webService);
    }

    @Test
    public void getCvSuccessShouldCallDisplayList() {
        when(webService.getCVs()).thenReturn(Single.just(cvs));
        presenter.getCVs();

        verify(mainView).displayData(cvs);
        verify(mainView, never()).displayMessage(anyString());
    }

    @Test
    public void getCvFailureShouldCallDisplayError() {

        String errorMessage = "This is error";
        when(webService.getCVs()).thenReturn(Single.error(new RuntimeException(errorMessage)));
        presenter.getCVs();

        verify(mainView, never()).displayData(anyList());
        verify(mainView).displayMessage(errorMessage);
    }
}
