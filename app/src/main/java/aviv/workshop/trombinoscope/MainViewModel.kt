package aviv.workshop.trombinoscope

class MainViewModel {

    private val repository = WorkerRepository()

    fun getWorkers(): List<Worker> {
        return repository.getWorkers()
    }
}