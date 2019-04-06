package world.mitchmiller.orbitanimation.livepape

import android.os.Bundle
import android.preference.Preference
import android.preference.PreferenceActivity
import android.widget.Toast
import world.mitchmiller.orbitanimation.R

class PrefActivity : PreferenceActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addPreferencesFromResource(R.xml.prefs)

        val numberCheckListener = object : Preference.OnPreferenceChangeListener {
            override fun onPreferenceChange(preference: Preference?, newValue: Any?): Boolean {

                if (newValue != null && newValue.toString().length > 0
                    && newValue.toString().matches(Regex("\\d*"))) {
                    return true
                }

                Toast.makeText(this@PrefActivity, "Invalid Input", Toast.LENGTH_SHORT).show()
                return false
            }
        }

        var circlePreference: Preference = preferenceScreen.findPreference("numberOfCircles")
        circlePreference.onPreferenceChangeListener = numberCheckListener


    }


}