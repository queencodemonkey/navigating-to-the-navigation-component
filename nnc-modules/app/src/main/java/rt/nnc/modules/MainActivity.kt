package rt.nnc.modules

import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController

class MainActivity : AppCompatActivity(), LoginHandler, ToolbarHandler {

    companion object {
        const val IS_LOGGED_IN = "isLoggedIn"
    }

    private val toolbar by lazy { findViewById<Toolbar>(R.id.toolbar) }

    private val navController by lazy { findNavController(R.id.nav_host_fragment) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        refreshNavGraph()
    }

    override fun setToolbarTitle(title: String) {
        toolbar.title = title
    }

    override fun login() {
        val prefs = PreferenceManager.getDefaultSharedPreferences(this)
        prefs.edit().putBoolean(IS_LOGGED_IN, true).apply()
        refreshNavGraph()
    }

    override fun logout() {
        val prefs = PreferenceManager.getDefaultSharedPreferences(this)
        prefs.edit().remove(IS_LOGGED_IN).apply()
        refreshNavGraph()
    }

    private fun refreshNavGraph() {
        if (isLoggedIn()) {
            // setup regular nav graph
            navController.setGraph(R.navigation.nav_graph)
            navController.navigate(navController.graph.startDestination)
            toolbar.setupWithNavController(navController, AppBarConfiguration(navController.graph))
            toolbar.visibility = VISIBLE
        } else {
            // setup login graph
            navController.popBackStack()
            navController.setGraph(R.navigation.login_nav_graph)
            navController.navigate(navController.graph.startDestination)
            toolbar.visibility = GONE
        }
    }

    private fun isLoggedIn(): Boolean {
        val prefs = PreferenceManager.getDefaultSharedPreferences(this)
        return prefs.getBoolean(IS_LOGGED_IN, false)
    }
}
