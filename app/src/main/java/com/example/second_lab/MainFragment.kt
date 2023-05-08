package com.example.second_lab

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.second_lab.databinding.FragmentMainBinding
import kotlin.random.Random

class MainFragment(val cards : MutableList<AbstractCard>) : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private lateinit var adapter: CardAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
        adapter.submitList(cards)
    }
}