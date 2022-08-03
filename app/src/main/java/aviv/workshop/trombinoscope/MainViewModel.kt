package aviv.workshop.trombinoscope

import aviv.workshop.trombinoscope.list.Worker
import aviv.workshop.trombinoscope.list.WorkerRepository

class MainViewModel {

    private val repository = WorkerRepository()

    fun getWorkers(): List<Worker> {
        return repository.getWorkers()
    }
}