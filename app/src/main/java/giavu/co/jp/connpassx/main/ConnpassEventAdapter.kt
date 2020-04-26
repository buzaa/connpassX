package giavu.co.jp.connpassx.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import giavu.co.jp.connpassx.BR
import giavu.co.jp.connpassx.R
import giavu.co.jp.connpassx.extension.BindableAdapter
import giavu.co.jp.repository.model.Event

class ConnpassEventAdapter(
    private val lifecycleOwner: LifecycleOwner
) : RecyclerView.Adapter<ConnpassEventAdapter.ViewHolder>(), BindableAdapter<List<Event>> {
    private var events: List<Event> = emptyList()


    class ViewHolder(
        val binding: ViewDataBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(event: Event) {
            binding.setVariable(BR.data, event)
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ViewDataBinding>(
            layoutInflater,
            viewType,
            parent,
            false
        ).apply {
            lifecycleOwner = this@ConnpassEventAdapter.lifecycleOwner
        }
        return ViewHolder(
            binding = binding
        )
    }

    override fun getItemCount(): Int {
        return events.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(event = events[position])
    }

    override fun setData(data: List<Event>) {
        this.events = data
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {
        return R.layout.layout_event_item
    }
}
