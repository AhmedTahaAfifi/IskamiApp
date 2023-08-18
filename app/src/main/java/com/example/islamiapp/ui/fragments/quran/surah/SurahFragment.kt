package com.example.islamiapp.ui.fragments.quran.surah

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.islamiapp.data.models.quran.SurahResponse
import com.example.islamiapp.databinding.FragmentSurahBinding
import com.example.islamiapp.ui.fragments.ParentFragment
import com.example.islamiapp.ui.fragments.quran.surah.adapter.AyahAdapter
import com.example.islamiapp.uitls.extensions.hide
import com.example.islamiapp.uitls.extensions.show
import com.example.islamiapp.view.snackBar.AppSnackBar

class SurahFragment: ParentFragment() {

    private lateinit var binding: FragmentSurahBinding
    private val viewModel: SurahViewModel by viewModels()
    private val args: SurahFragmentArgs by navArgs()
    private val ayahAdapter = AyahAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        this.binding = FragmentSurahBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        this.setToolbarTitle(args.chapter.name)
        viewModel.getSurah(args.chapter.id)

        this.subscribeToLiveData()
    }

    private fun subscribeToLiveData() {
        viewModel.progressVisible.observe(viewLifecycleOwner) {
            if (it == true) {
                binding.progressBar.show()
                binding.contentLayout.hide()
            } else {
                binding.progressBar.hide()
                binding.contentLayout.show()
            }
        }
        viewModel.errorLiveData.observe(viewLifecycleOwner) {
            AppSnackBar(binding.root, textRes = it, AppSnackBar.Type.ERROR)
        }
        viewModel.responseLiveData.observe(viewLifecycleOwner) {
            this.setupView(it)
        }
    }

    private fun setupView(data: SurahResponse) {
        binding.surahName.text = data.surahData?.name

        binding.recyclerView.adapter = this.ayahAdapter
        this.ayahAdapter.submitList(data.surahData?.ayahs)

    }

}