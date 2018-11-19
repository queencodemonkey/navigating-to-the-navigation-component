package rt.nnc.modules

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController

/**
 * A simple [Fragment].
 */
class HomeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.btn_browse)
            .setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_home_to_browse))

        view.findViewById<Button>(R.id.btn_edit)
            .setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_home_to_editor_nav_graph))

        view.findViewById<Button>(R.id.btn_logout)
            .setOnClickListener{
                requireContext().logout(findNavController())
            }
    }
}
