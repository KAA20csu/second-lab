package com.example.second_lab

import android.graphics.Color
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class CardAdapter() :
    androidx.recyclerview.widget.ListAdapter<AbstractCard, CardAdapter.CardViewHolder>(CardDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder =
        CardViewHolder(
            LayoutInflater.from(parent.context).inflate(
                when (viewType) {
                    1 -> R.layout.first
                    2 -> R.layout.second
                    3 -> R.layout.third
                    else -> R.layout.fourth
                }, parent, false)
        )

    override fun getItemViewType(position: Int): Int {
        val card: AbstractCard = getItem(position)
        return card.viewType
    }

    override fun submitList(list: MutableList<AbstractCard>?) {
        super.submitList(list)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val title by lazy { itemView.findViewById<TextView?>(R.id.title) }
        private val subtitle by lazy { itemView.findViewById<TextView?>(R.id.subtitle) }
        private val img by lazy { itemView.findViewById<ImageView?>(R.id.img) }
        private val bag by lazy { itemView.findViewById<LinearLayout?>(R.id.bag) }

        fun bind(abstractCard: AbstractCard) {
            // img?.setImageURI(Uri.parse(abstractCard.img))
            title?.text = abstractCard.title
            subtitle?.text = abstractCard.subtitle
            if(abstractCard.img != null) {
                Picasso.get().load(abstractCard.img).into(img)
            }
            if(abstractCard.hasBag != null) {
                bag.setBackgroundColor(Color.parseColor(abstractCard.hasBag))
            }
        }
    }

    class CardDiffUtil : DiffUtil.ItemCallback<AbstractCard>() {
        override fun areItemsTheSame(oldItem: AbstractCard, newItem: AbstractCard): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: AbstractCard, newItem: AbstractCard): Boolean {
            return oldItem == newItem
        }
    }
}