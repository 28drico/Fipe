package br.com.zup.fipe.ui.carro.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.zup.fipe.CARRO_KEY
import br.com.zup.fipe.data.model.MarcaResponseItemItem
import br.com.zup.fipe.databinding.FragmentMarcaBinding
import br.com.zup.fipe.ui.carro.viewmodel.MarcaViewModel
import br.com.zup.fipe.viewstate.ViewState

class MarcaFragment : Fragment() {

    private lateinit var binding : FragmentMarcaBinding

    private val viewmodel: MarcaViewModel by lazy {
        ViewModelProvider(this)[MarcaViewModel::class.java]
    }

    private val adapter: MarcaAdapter by lazy {
        MarcaAdapter(arrayListOf())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = FragmentMarcaBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRvMarca()
        viewmodel.getAllCarrosNetwork()
        initObserver()
    }

    private fun initObserver(){
     viewmodel.carroLista.observe(this.viewLifecycleOwner){
         when(it){
             is ViewState.Success -> {
                 adapter.updateCarroList(it.data.toMutableList())
             }
             is ViewState.Error -> {
                 Toast.makeText(
                     context,
                     "${it.throwable.message}",
                     Toast.LENGTH_LONG
                 ).show()
             }
             is ViewState.EmptyList -> {
                 Toast.makeText(
                     context,
                     "Error",
                     Toast.LENGTH_LONG
                 ).show()
             }
             else -> {}
         }
     }
    }


    private fun setUpRvMarca(){
        binding.rvMarca.adapter = adapter
        binding.rvMarca.layoutManager = LinearLayoutManager(context)
    }

    fun irParaResultado(carroResult: MarcaResponseItemItem){
        val bundle = bundleOf(CARRO_KEY to carroResult)
    }
}