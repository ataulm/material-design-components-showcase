package com.example

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ataulm.mdcshowcase.startMdcShowcase

class DemoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startMdcShowcase(R.style.Theme_Demo, shouldSetSupportActionBar = true)
        finish()
    }
}
