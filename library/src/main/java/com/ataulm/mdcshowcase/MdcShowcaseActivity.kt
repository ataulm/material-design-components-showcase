package com.ataulm.mdcshowcase

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.annotation.StyleRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import kotlinx.android.synthetic.main.mdcs__activity_mdc_showcase.*

class MdcShowcaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        intent.extras?.getInt(EXTRA_THEME)?.let { setTheme(it) }
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

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_mdc_showcase, menu)
        menu.findItem(R.id.day).isVisible = darkModeEnabled()
        menu.findItem(R.id.night).isVisible = !darkModeEnabled()
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.day -> {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            invalidateOptionsMenu()
            true
        }
        R.id.night -> {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            invalidateOptionsMenu()
            true
        }
        else -> super.onOptionsItemSelected(item)
    }

    private fun darkModeEnabled() = AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES

    companion object {

        internal const val EXTRA_THEME = "${BuildConfig.LIBRARY_PACKAGE_NAME}.EXTRA_THEME"
        internal const val EXTRA_ITEMS = "${BuildConfig.LIBRARY_PACKAGE_NAME}.EXTRA_ITEMS"
        internal const val EXTRA_SET_SUPPORT_ACTION_BAR = "${BuildConfig.LIBRARY_PACKAGE_NAME}.EXTRA_SET_SUPPORT_ACTION_BAR"
    }
}

fun Context.startMdcShowcase(
        @StyleRes themeResId: Int? = null,
        shouldSetSupportActionBar: Boolean = false,
        inflatables: ArrayList<Int> = arrayListOf(R.layout.mdcs__inflatables_all)
) {
    val intent = Intent(this, MdcShowcaseActivity::class.java)
            .putExtra(MdcShowcaseActivity.EXTRA_THEME, themeResId)
            .putExtra(MdcShowcaseActivity.EXTRA_ITEMS, inflatables)
            .putExtra(MdcShowcaseActivity.EXTRA_SET_SUPPORT_ACTION_BAR, shouldSetSupportActionBar)
    startActivity(intent)
}
