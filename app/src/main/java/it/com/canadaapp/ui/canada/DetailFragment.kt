package it.com.canadaapp


import CanadaDetailViewModel
import ConnectionApi
import DetailsAdapter
import DetailsRepository
import DetailsViewModelFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import it.com.canadaapp.R
import kotlinx.android.synthetic.main.canada_detail_fragment.*


class DetailFragment : Fragment(){

    private lateinit var factory: DetailsViewModelFactory
    private lateinit var viewModel: CanadaDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.canada_detail_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val api = ConnectionApi()
        val repository = DetailsRepository(api)

        factory = DetailsViewModelFactory(repository)
        viewModel = ViewModelProviders.of(this, factory).get(CanadaDetailViewModel::class.java)

        viewModel.getDetails()

        viewModel.details.observe(viewLifecycleOwner, Observer { details ->
            recycler_view_details.also {
                it.layoutManager = LinearLayoutManager(requireContext())
                it.setHasFixedSize(true)
                it.adapter = DetailsAdapter(details)
            }
        })
    }


}
