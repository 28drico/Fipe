package br.com.zup.fipe.ui.carro.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.zup.fipe.data.model.MarcaResponseItemItem
import br.com.zup.fipe.databinding.ItemMarcaBinding

class MarcaAdapter(
    private var marcaLista: MutableList<MarcaResponseItemItem>,
//    private val clickCarro: (CarrosResponseItem) -> Unit,
): RecyclerView.Adapter<MarcaAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemMarcaBinding) : RecyclerView.ViewHolder(binding.root){
        fun showCarro(carro:MarcaResponseItemItem){
            binding.tvTipoCarro.text = carro.nome
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemMarcaBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val carro = marcaLista[position]
        holder.showCarro(carro)
        holder.binding.cvListaMarca.setOnClickListener {
//            clickCarro(carro)
        }
    }

    override fun getItemCount(): Int = marcaLista.size

    fun updateCarroList(atualizaLista: MutableList<MarcaResponseItemItem>){
        marcaLista = atualizaLista
        notifyDataSetChanged()
    }
}