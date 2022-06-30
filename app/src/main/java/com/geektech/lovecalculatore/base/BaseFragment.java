package com.geektech.lovecalculatore.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.viewbinding.ViewBinding;

import com.geektech.lovecalculatore.R;

import org.jetbrains.annotations.NotNull;

import dagger.hilt.android.AndroidEntryPoint;

public abstract class BaseFragment<VB extends ViewBinding> extends Fragment {
    protected VB binding;
    protected NavController controller;

    protected abstract VB bind();

    @Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = bind();
        controller = Navigation.findNavController(requireActivity(), R.id.fragmentContainerView);
        setupUI();
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupObserver();
    }

    protected abstract void setupUI();

    protected void setupObserver() {

    }
}