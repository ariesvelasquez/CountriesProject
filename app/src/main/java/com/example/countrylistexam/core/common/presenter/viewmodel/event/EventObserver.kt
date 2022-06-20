package com.example.countrylistexam.core.common.presenter.viewmodel.event

import androidx.lifecycle.Observer

open class EventObserver<T>(
    private val onEventUnhandledContent: (T) -> Unit
) : Observer<Event<T>> {

    override fun onChanged(t: Event<T>?) {
        t?.getContentIfNotHandled()?.let {
            onEventUnhandledContent(it)
        }
    }
}