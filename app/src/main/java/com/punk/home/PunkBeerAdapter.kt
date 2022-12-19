package com.punk.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.punk.R
import com.punk.databinding.ItemPunkBeersBinding
import com.punk.models.PunkBeer

class PunkBeerAdapter(
    val context: Context,
    val beerList:ArrayList<PunkBeer>
) :
    RecyclerView.Adapter<PunkBeerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val bind = DataBindingUtil.inflate<ItemPunkBeersBinding>(
            LayoutInflater.from(context), R.layout.item_punk_beers, parent, false
        )
        return ViewHolder(bind)
    }

    override fun getItemCount(): Int {
        return beerList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(beerList[position])

        Glide
            .with(context)
            .load(beerList[position].imageUrl)
            .fitCenter()
            .placeholder(R.drawable.ic_loading)
            .into(holder.b.beerImage)
    }

    inner class ViewHolder(val b: ItemPunkBeersBinding) : RecyclerView.ViewHolder(b.root) {
        fun onBind(beer: PunkBeer) {
            b.executePendingBindings()
            b.beer = beer
        }
    }
}