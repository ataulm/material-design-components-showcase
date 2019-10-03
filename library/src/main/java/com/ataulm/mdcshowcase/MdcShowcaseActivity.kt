package com.ataulm.mdcshowcase

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.annotation.StyleRes
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.mdcs__activity_mdc_showcase.*

class MdcShowcaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(intent.getIntExtra(EXTRA_THEME, 0))
        setContentView(R.layout.mdcs__activity_mdc_showcase)

        val shouldSetSupportActionBar = intent.getBooleanExtra(EXTRA_SET_SUPPORT_ACTION_BAR, false)
        if (shouldSetSupportActionBar) {
            materialToolbar.visibility = View.VISIBLE
            setSupportActionBar(materialToolbar)
        } else {
            materialToolbar.visibility = View.GONE
        }

        val adapter = InflatablesAdapter()
        recyclerView.adapter = adapter
        val items = intent.getIntegerArrayListExtra(EXTRA_ITEMS)
        adapter.submitList(items)
    }

    companion object {

        internal const val EXTRA_THEME = "${BuildConfig.LIBRARY_PACKAGE_NAME}.EXTRA_THEME"
        internal const val EXTRA_ITEMS = "${BuildConfig.LIBRARY_PACKAGE_NAME}.EXTRA_ITEMS"
        internal const val EXTRA_SET_SUPPORT_ACTION_BAR = "${BuildConfig.LIBRARY_PACKAGE_NAME}.EXTRA_SET_SUPPORT_ACTION_BAR"
    }
}

fun Context.startMdcShowcase(
        @StyleRes themeResId: Int,
        shouldSetSupportActionBar: Boolean = false,
        inflatables: ArrayList<Int> = arrayListOf(R.layout.mdcs__default_inflatable)
) {
    val intent = Intent(this, MdcShowcaseActivity::class.java)
            .putExtra(MdcShowcaseActivity.EXTRA_THEME, themeResId)
            .putExtra(MdcShowcaseActivity.EXTRA_ITEMS, inflatables)
            .putExtra(MdcShowcaseActivity.EXTRA_SET_SUPPORT_ACTION_BAR, shouldSetSupportActionBar)
    startActivity(intent)
}
