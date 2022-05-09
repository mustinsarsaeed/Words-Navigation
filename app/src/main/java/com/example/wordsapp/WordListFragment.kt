package com.example.wordsapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wordsapp.databinding.FragmentLetterListBinding
//Convert DetailActivity to WordListFragment
class WordListFragment : Fragment() {
    //Implement WordListFragment 1) Copy companion object from DetailActivity and paste here
    companion object {
        const val LETTER = "letter"
        const val SEARCH_PREFIX = "https://www.google.com/search?q="
    }
    //Implement WordListFragment 4) you add a binding variable of type FragmentWordListBinding?
    private var _binding: FragmentLetterListBinding? = null
    //Implement WordListFragment 5) You then create a get-only variable so that you can reference views without having to use ?.
    private val binding get() = _binding!!
    //Getting Arguments 1) In WordListFragment, create a letterId property.
    // You can mark this as lateinit so that you don't have to make it nullable.
    private lateinit var letterId: String
    //Getting Arguments 2)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            letterId = it.getString(LETTER).toString()
        }
    }

    //Implement WordListFragment 6) Then you inflate the layout, assigning
    // the _binding variable and returning the root view. Remember that for fragments you do this in onCreateView(), not onCreate().
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLetterListBinding.inflate(inflater, container, false)
         return binding.root
    }
    //Implement WordListFragment 7) Next, you implement onViewCreated(). This is almost identical to configuring the recyclerView in onCreate() in the DetailActivity.
    // However, because fragments don't have direct access to the intent, you need to reference it with activity.intent.
    // You have to do this in onViewCreated() however, as there's no guarantee the activity exists earlier in the lifecycle.
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        //Getting Argument 3) Replac recyclerView.adapter = WordAdapter(letterId, requireContext()) for Fragment
        //Replace activity?.intent?.extras?.getString(LETTER).toString() requireContext()) for Activity
        recyclerView.adapter = WordAdapter(letterId, requireContext())

        recyclerView.addItemDecoration(
            DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        )
    }
    //Implement WordListFragment 8) Finally, you can reset the _binding variable in onDestroyView().
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}