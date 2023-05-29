package com.example.second_lab

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.second_lab.databinding.FragmentMainBinding
import javax.inject.Inject
import kotlin.random.Random

class MainFragment() : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private lateinit var adapter: CardAdapter

    @Inject
    lateinit var viewModelFactory: NewTextViewModelFactory
    @Inject
    lateinit var viewModel : NewTextViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val component = DaggerAppComponent.builder()
            .build()
        component.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        adapter = CardAdapter()
        binding.items.adapter = adapter
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.items.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = adapter
        }
        val service = ReceiveService()
        viewModel.newText.observe(viewLifecycleOwner) { newText ->
            val cards = service.getCards(newText)
            adapter.submitList(cards)
        }
        viewModel.loadNewText()
    }
}