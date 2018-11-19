package rt.nnc.modules

import android.content.Context
import android.preference.PreferenceManager
import androidx.navigation.NavController

/**
 */

fun Context.isLoggedIn(): Boolean {
    val prefs = PreferenceManager.getDefaultSharedPreferences(this)
    return prefs.getBoolean("isLoggedIn", false)
}

fun Context.login() {
    val prefs = PreferenceManager.getDefaultSharedPreferences(this)
    prefs.edit().putBoolean("isLoggedIn", true).apply()
}

fun Context.logout(navController: NavController) {
    val prefs = PreferenceManager.getDefaultSharedPreferences(this)
    prefs.edit().remove("isLoggedIn").apply()
    navController.navigate(R.id.action_global_logout)
}
