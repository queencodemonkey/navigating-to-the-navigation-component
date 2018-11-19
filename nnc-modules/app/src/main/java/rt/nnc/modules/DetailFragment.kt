package rt.nnc.modules

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

/**
 * A simple [Fragment].
 */
class DetailFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        DetailFragmentArgs.fromBundle(arguments).let {
            (requireActivity() as ToolbarHandler).setToolbarTitle(it.title)

            view.findViewById<TextView>(R.id.title).text = it.title
            view.findViewById<ImageView>(R.id.image).setImageResource(it.image)
        }
    }
}
