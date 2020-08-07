

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import it.com.canadaapp.R
import it.com.canadaapp.data.models.CanadaDetails
import it.com.canadaapp.databinding.RecycleViewItemBinding


class DetailsAdapter (
    private val _details: List<CanadaDetails>
) : RecyclerView.Adapter<DetailsAdapter.DetailViewHolder>(){

    override fun getItemCount() = _details.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DetailViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.recycle_view_item,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {
        holder.recyclerviewItem.candadetails = _details[position]
    }


    inner class DetailViewHolder(
        val recyclerviewItem: RecycleViewItemBinding
    ) : RecyclerView.ViewHolder(recyclerviewItem.root)

}