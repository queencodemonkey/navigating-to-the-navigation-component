package rt.nnc.modules

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * A simple [Fragment].
 */
class BrowseFragment : Fragment() {

    private val data = listOf(
        BrowseItem("Sand dunes", R.drawable.img1151613_unsplash),
        BrowseItem("Peeling paint", R.drawable.img1151848_unsplash),
        BrowseItem("Firefighters", R.drawable.img1152408_unsplash),
        BrowseItem("Windmills", R.drawable.img209586_unsplash),
        BrowseItem("Building", R.drawable.img719772_unsplash)
    )

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_browse, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<RecyclerView>(R.id.recyclerview).apply {
            adapter = BrowseAdapter(layoutInflater, data)
            layoutManager = LinearLayoutManager(context)
        }
    }

    class BrowseAdapter(
        private val inflater: LayoutInflater,
        private val data: List<BrowseItem>
    ) : RecyclerView.Adapter<BrowseViewHolder>() {

        override fun getItemCount(): Int = data.size

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BrowseViewHolder =
            BrowseViewHolder(inflater, parent)

        override fun onBindViewHolder(holder: BrowseViewHolder, position: Int) {
            data[position].let {
                holder.image.setImageResource(it.imageResId)
                holder.title.text = it.imageTitle

                val action = BrowseFragmentDirections.actionBrowseToDetail(it.imageResId, it.imageTitle)
                holder.itemView.setOnClickListener {
                    holder.itemView.findNavController().navigate(action)
                }
            }
        }
    }

    class BrowseViewHolder(
        inflater: LayoutInflater, parent: ViewGroup,
        view: View = inflater.inflate(R.layout.vh_browse, parent, false),
        val image: ImageView = view.findViewById(R.id.item_image),
        val title: TextView = view.findViewById(R.id.item_title)
    ) : RecyclerView.ViewHolder(view)

    data class BrowseItem(val imageTitle: String, val imageResId: Int)
}
