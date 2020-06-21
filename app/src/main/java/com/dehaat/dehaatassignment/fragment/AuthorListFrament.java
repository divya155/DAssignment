package com.dehaat.dehaatassignment.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;

import com.dehaat.dehaatassignment.R;
import com.dehaat.dehaatassignment.viewmodel.AuthorViewModel;

import dagger.android.support.DaggerFragment;

public class AuthorListFrament extends DaggerFragment {

    private AuthorViewModel mViewModel;

    public static AuthorListFrament newInstance() {
        return new AuthorListFrament();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.author_list_frament_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(AuthorViewModel.class);
        // TODO: Use the ViewModel
    }

}
