package com.example.islamiapp.ui.fragments.quran.quran

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import com.example.islamiapp.data.models.quran.QuranResponse
import com.example.islamiapp.databinding.FragmentQuranBinding
import com.example.islamiapp.ui.fragments.ParentFragment
import com.example.islamiapp.ui.fragments.quran.quran.adapter.ChaptersAdapter
import com.example.islamiapp.view.snackBar.AppSnackBar

class QuranFragment: ParentFragment() {
    private lateinit var binding: FragmentQuranBinding
    private val viewModel: QuranViewModel by viewModels()
    private val chaptersAdapter = ChaptersAdapter {
        this.viewModel.goToSurahFragment(it)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        this.binding = FragmentQuranBinding.inflate(inflater, container, false)
        this.viewModel.navigator = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getChapters()

        this.subscribeToLiveData()
    }

    private fun subscribeToLiveData() {
        viewModel.progressVisible.observe(viewLifecycleOwner) {
            binding.progressBar.isVisible = it
        }
        viewModel.errorLiveData.observe(viewLifecycleOwner) {
            AppSnackBar(binding.root, it, AppSnackBar.Type.ERROR)
        }
        viewModel.responseLiveData.observe(viewLifecycleOwner) {
            this.setupView(it)
        }
    }

    private fun setupView(data: QuranResponse) {
        binding.quranRecyclerView.adapter = this.chaptersAdapter
        chaptersAdapter.submitList(data.chapters)
    }
}