
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider



@Suppress("UNCHECKED_CAST")
public class DetailsViewModelFactory(
    private val repository: DetailsRepository
) : ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CanadaDetailViewModel(repository) as T
    }

}