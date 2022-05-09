package com.example.wordsapp

import android.os.Bundle
import android.view.*
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wordsapp.databinding.FragmentLetterListBinding

class LetterListFragment : Fragment() {
    //Implement LetterListFragment 1)In LetterListFragment.kt,
    // start by getting a reference to the FragmentLetterListBinding, and name the reference _binding.
    private var _binding: FragmentLetterListBinding? = null

    //Implement LetterListFragment 2) Create a new property, called binding (without the underscore) and set it equal to _binding!!.
    private val binding get() = _binding!!
    //Implement LetterListFragment 5) Below the binding property, create a property for the recycler view.
    private lateinit var recyclerView: RecyclerView
    //Implement LetterListFragment 10) Finally, copy over the isLinearLayoutManager property from MainActivity.
    // Put this right below the declaration of the recyclerView property.
    private var isLinearLayoutManager = true

    //Implement LetterListFragment 3)To display the options menu, override onCreate().
    // Inside onCreate() call setHasOptionsMenu() passing in true.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    //Implement LetterListFragment 4)Remember that with fragments, the layout is inflated in onCreateView().
    // Implement onCreateView() by inflating the view, setting the value of _binding, and returning the root view.
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLetterListBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    //Implement LetterListFragment 6)Then set the value of the recyclerView property in onViewCreated(),
    // and call chooseLayout() like you did in MainActivity.
    // You'll move the chooseLayout() method into LetterListFragment soon, so don't worry that there's an error.
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = binding.recyclerView
        chooseLayout()
    }

    //Implement LetterListFragment 7) Finally, in onDestroyView(), reset the _binding property to null, as the view no longer exists.
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    //Implement LetterListFragment 8) The only other thing to note is there are some subtle differences
    // with the onCreateOptionsMenu() method when working with fragments.
    // While the Activity class has a global property called menuInflater, Fragment does not have this property.
    // The menu inflater is instead passed into onCreateOptionsMenu(). Also note that the onCreateOptionsMenu()
    // method used with fragments doesn't require a return statement. Implement the method as shown:
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.layout_menu, menu)

        val layoutButton = menu.findItem(R.id.action_switch_layout)
        setIcon(layoutButton)
    }

    //Implement LetterListFragment 9) Move the remaining code for chooseLayout(), setIcon(),
    // and onOptionsItemSelected() from MainActivity as-is.
    // The only other difference to note is that because unlike an activity, a fragment is not a Context.
    // You can't pass in this (referring to the fragment object) as the layout manager's context.
    // However, fragments provide a context property you can use instead. The rest of the code is identical to MainActivity.
    private fun chooseLayout() {
        when (isLinearLayoutManager) {
            true -> {
                recyclerView.layoutManager = LinearLayoutManager(context)
                recyclerView.adapter = LetterAdapter()
            }
            false -> {
                recyclerView.layoutManager = GridLayoutManager(context, 4)
                recyclerView.adapter = LetterAdapter()
            }
        }
    }

    private fun setIcon(menuItem: MenuItem?) {
        if (menuItem == null)
            return

        menuItem.icon =
            if (isLinearLayoutManager)
                ContextCompat.getDrawable(this.requireContext(), R.drawable.ic_grid_layout)
            else ContextCompat.getDrawable(this.requireContext(), R.drawable.ic_linear_layout)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_switch_layout -> {
                isLinearLayoutManager = !isLinearLayoutManager
                chooseLayout()
                setIcon(item)

                return true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}