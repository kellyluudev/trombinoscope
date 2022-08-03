package aviv.workshop.trombinoscope.list

import androidx.lifecycle.ViewModel

class WorkerListViewModel : ViewModel() {

    private val repository = WorkerRepository()

    fun getWorkers(): List<Worker> {
        return repository.getWorkers()
    }
}