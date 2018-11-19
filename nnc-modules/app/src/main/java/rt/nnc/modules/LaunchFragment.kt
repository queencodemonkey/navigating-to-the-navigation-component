package rt.nnc.modules

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

/**
 * A simple [Fragment].
 */
class LaunchFragment : Fragment() {

    override fun onResume() {
        super.onResume()
        // check signed in
        if (requireContext().isLoggedIn()) {
            findNavController().navigate(R.id.action_launchFragment_to_home)
        } else {
            findNavController().navigate(R.id.action_launchFragment_to_loginActivity)
        }
    }
}
