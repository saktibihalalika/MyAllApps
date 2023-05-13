package com.sakti.myallapps.ui.listview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.sakti.myallapps.R
import java.util.*

class ListviewFragment : Fragment() {

    private lateinit var myListView: ListView
    private lateinit var mySortButton: Button
    private var galaxies = arrayOf(
        "Sombrero", "Cartwheel", "Pinwheel", "StarBust", "Whirlpool",
        "Ring Nebular", "Own Nebular", "Centaurus A", "Virgo Stellar Stream",
        "Canis Majos Overdensity", "Mayall's Object", "Leo", "Milky Way",
        "IC 1011", "Messier 81", "Andromeda", "Messier 87"
    )
    private var sortAscending = true
    private var galaxiesList = Arrays.asList(*galaxies)

    private fun sortData() {
        if (sortAscending) galaxiesList.sorted()
        else galaxiesList.sortedDescending()

        sortAscending = !sortAscending
        myListView.adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, galaxiesList)
        myListView.onItemClickListener =
            AdapterView.OnItemClickListener { _, _, i, _ ->
                Toast.makeText(
                    requireContext(),
                    galaxiesList[i],
                    Toast.LENGTH_SHORT
                ).show()
            }
    }

    private fun initializeViews(view: View) {
        myListView = view.findViewById(R.id.myListView)
        myListView.adapter = object : ArrayAdapter<String>(requireContext(), R.layout.item_galaxy, R.id.galaxyName, galaxiesList) {
            override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
                val view = super.getView(position, convertView, parent)
                val galaxyImage = view.findViewById<ImageView>(R.id.galaxyImage)
                when (galaxiesList[position]) {
                    "Sombrero" -> galaxyImage.setImageResource(R.drawable.sombrero)
                    "Cartwheel" -> galaxyImage.setImageResource(R.drawable.cartwheel)
                    "Pinwheel" -> galaxyImage.setImageResource(R.drawable.pinwheel)
                    "StarBust" -> galaxyImage.setImageResource(R.drawable.starbust)
                    "Whirlpool" -> galaxyImage.setImageResource(R.drawable.whirlpool)
                    "Ring Nebular" -> galaxyImage.setImageResource(R.drawable.ring_nebular)
                    "Own Nebular" -> galaxyImage.setImageResource(R.drawable.own_nebular)
                    "Centaurus A" -> galaxyImage.setImageResource(R.drawable.centaurus_a)
                    "Virgo Stellar Stream" -> galaxyImage.setImageResource(R.drawable.virgo_stellar_stream)
                    "Canis Majos Overdensity" -> galaxyImage.setImageResource(R.drawable.canis_majos_overdensity)
                    "Mayall's Object" -> galaxyImage.setImageResource(R.drawable.mayalls_object)
                    "Leo" -> galaxyImage.setImageResource(R.drawable.leo)
                    "Milky Way" -> galaxyImage.setImageResource(R.drawable.milky_way)
                    "IC 1011" -> galaxyImage.setImageResource(R.drawable.ic_1011)
                    "Messier 81" -> galaxyImage.setImageResource(R.drawable.messier_81)
                    "Andromeda" -> galaxyImage.setImageResource(R.drawable.andromeda)
                    "Messier 87" -> galaxyImage.setImageResource(R.drawable.messier_87)
                }
                return view
            }
        }


        mySortButton = view.findViewById(R.id.mySortBtn)
        mySortButton.setOnClickListener { sortData() }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_listview, container, false)
        initializeViews(view)
        return view
    }
}
