package com.example.countrylistexam.core.common.presenter.activity

import android.app.ProgressDialog
import android.os.Bundle
import android.os.PersistableBundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelLazy
import androidx.viewbinding.ViewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
abstract class BaseActivity<VB : ViewBinding> :
    AppCompatActivity() {

    lateinit var binding: VB
        private set

    abstract val bindingInflater: (LayoutInflater) -> VB


    protected open fun beforeLayout(savedInstanceState: Bundle?) = Unit
    protected open fun afterLayout(savedInstanceState: Bundle?) = Unit
    protected open fun onViewModelBound() = Unit
    protected open fun onViewsBound() = Unit
    protected open fun onInitializeListener() = Unit

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        beforeLayout(savedInstanceState)
        bindContentLayout()
        afterLayout(savedInstanceState)
        onViewModelBound()
        onViewsBound()
        onInitializeListener()
    }

    private fun bindContentLayout() {
        binding = bindingInflater.invoke(layoutInflater)
        setContentView(binding.root)
    }
}