package skripa.ru.fuunymoments.adapters

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class RecyclerAdapter<Model, Holder: RecyclerView.ViewHolder> : RecyclerView.Adapter<Holder> {
    private var items: ArrayList<Model>

    private lateinit var context: Context

    constructor() : super() { this.items = ArrayList<Model>() }

    constructor(items: ArrayList<Model>) : super() { this.items = items }

    constructor(items: List<Model>) : super() { this.items = items as ArrayList<Model> }

    open fun add(item: Model) {
        this.items.add(item)
        notifyDataSetChanged()
    }

    open fun add(start: Int, item: Model) {
        this.items.add(start, item)
        notifyDataSetChanged()
    }

    open fun add(items: ArrayList<Model>, clear: Boolean = false) {
        if (clear) this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    open fun addAll(items: List<Model>, clear: Boolean = false) {
        if (clear) this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    open fun addAll(start: Int, items: ArrayList<Model>) {
        this.items.addAll(start, items)
        notifyDataSetChanged()
    }

    open fun addAll(start: Int, items: List<Model>) {
        this.items.addAll(start, items)
        notifyDataSetChanged()
    }

    open fun remove(item: Model) {
        this.items.remove(item)
        notifyDataSetChanged()
    }

    open fun remove(index: Int) {
        this.items.removeAt(index)
        notifyDataSetChanged()
    }

    open fun removeAll() {
        this.items.clear()
        notifyDataSetChanged()
    }

    open fun get(index: Int) = items[index]

    open fun getAll() = items

    override fun getItemCount() = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder
            = onCreateHolder(parent, viewType)


    override fun onBindViewHolder(holder: Holder, position: Int)
            = this.onBindHolder(holder, items[position], position)

    protected abstract fun onCreateHolder(viewGroup: ViewGroup, viewType: Int): Holder

    protected abstract fun onBindHolder(holder: Holder, item: Model, pos: Int)

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
    }
}
