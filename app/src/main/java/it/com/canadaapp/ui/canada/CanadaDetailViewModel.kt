

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import it.com.canadaapp.data.models.CanadaDetails
import kotlinx.coroutines.Job



public class CanadaDetailViewModel(
    private val repository: DetailsRepository
) : ViewModel() {

    private lateinit var job: Job

    private val _details = MutableLiveData<List<CanadaDetails>>()
    val details: LiveData<List<CanadaDetails>>
        get() = _details

    fun getDetails() {
        job = Coroutines.ioThenMain(
            { repository.getDetails() },
            { _details.value = it }
        )
    }

    override fun onCleared() {
        super.onCleared()
        if(::job.isInitialized) job.cancel()
    }
}
