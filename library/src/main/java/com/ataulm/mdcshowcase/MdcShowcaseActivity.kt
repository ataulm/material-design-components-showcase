package com.ataulm.mdcshowcase

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.annotation.StyleRes
import androidx.appcompat.app.AppCompatActivity

class MdcShowcaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(intent.getIntExtra(EXTRA_THEME, 0))
        setContentView(R.layout.activity_mdc_showcase)
    }

    companion object {

        internal const val EXTRA_THEME = "${BuildConfig.LIBRARY_PACKAGE_NAME}.EXTRA_THEME"

        fun startActivity(context: Context, @StyleRes themeResId: Int) {
            val intent = Intent(context, MdcShowcaseActivity::class.java)
                    .putExtra(EXTRA_THEME, themeResId)
            context.startActivity(intent)
        }
    }
}
