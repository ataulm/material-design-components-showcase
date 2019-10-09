package com.example

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatTextView
import com.ataulm.mdcshowcase.startMdcShowcase

class DemoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startMdcShowcase(
                R.style.Theme_Demo,
                shouldSetSupportActionBar = true,
                inflatables = arrayListOf(R.layout.demo_inflatable_buttons)
        )
        finish()
    }
}

class AtaulmTextView(
        ctx: Context,
        attrs: AttributeSet
) : AppCompatTextView(
        ThemeEnforcement.createThemedContext(ctx, attrs, R.attr.ataulmTextViewStyle, 0),
        attrs,
        R.attr.ataulmTextViewStyle
)
