package aviv.workshop.trombinoscope.details

import androidx.lifecycle.ViewModel
import aviv.workshop.trombinoscope.list.Worker
import aviv.workshop.trombinoscope.list.WorkerRepository

class DetailsViewModel : ViewModel() {

    private val repository = WorkerRepository()

    fun getWorker(workerId: Int): Worker {
        return repository.getWorker(workerId)
    }
}