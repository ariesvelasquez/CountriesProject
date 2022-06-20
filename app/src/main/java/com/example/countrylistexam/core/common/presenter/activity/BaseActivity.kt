package com.example.countrylistexam.core.common.presenter.activity

import android.content.DialogInterface
import android.os.Bundle
import android.os.PersistableBundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.example.countrylistexam.R
import com.example.countrylistexam.core.common.presenter.dialogs.ProgressDialog
import com.google.android.material.dialog.MaterialAlertDialogBuilder

abstract class BaseActivity<VB : ViewBinding> :
    AppCompatActivity() {

    lateinit var binding: VB
        private set

    abstract val bindingInflater: (LayoutInflater) -> VB

    private var progressDialog: ProgressDialog? = null

    protected open fun initIntentData(savedInstanceState: Bundle?) = Unit
    protected open fun onSetLayout(savedInstanceState: Bundle?) = Unit
    protected open fun initDataObservables() = Unit
    protected open fun initViews() = Unit // Initialize adapters, etc.
    protected open fun initViewEventListeners() = Unit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initIntentData(savedInstanceState)
        bindContentLayout()
        onSetLayout(savedInstanceState)
        initDataObservables()
        initViews()
        initViewEventListeners()
    }

    private fun bindContentLayout() {
        binding = bindingInflater.invoke(layoutInflater)
        setContentView(binding.root)
    }

    fun showProgressDialog(tag: String) {
        progressDialog = ProgressDialog.newInstance()
        progressDialog?.show(supportFragmentManager, tag)
    }

    fun dismissProgressDialog() {
        progressDialog?.dismiss()
    }

    fun handleOnError(throwable: Throwable) {
        showDialog(message = throwable.message)
    }

    fun showDialog(
        title: String? = getString(R.string.error),
        message: String? = getString(R.string.error_something_went_wrong)
    ) {
        MaterialAlertDialogBuilder(this)
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton(
                R.string.close
            ) { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }
}