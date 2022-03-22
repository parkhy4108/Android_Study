package com.devyoung.retrofit

interface CompletionListener {
    fun loadComplete(data : Data)
    fun responseIsNotSuccessful(code:Int)
    fun loadFail()
}