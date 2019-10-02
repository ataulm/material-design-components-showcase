material design components showcase
===================================

[Nick Rout](https://twitter.com/ricknout) added [this awesome debug activity to MuVi](https://github.com/ataulm/muvi/pull/27) which showcases Material components with a given theme.

This library lets you see how your application theme is applied to different Material components. Add it as a dependency to your project:

```groovy
allprojects {
    repositories {
        maven { url "https://jitpack.io" }
    }
}
```

Then open the included Activity:

```kotlin
class DebugActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_debug)

        openThemeShowcaseButton.setOnClickListener {
            MdcShowcaseActivity.startActivity(this, R.style.Theme_MyApp)
        }
    }
}
```
