package aviv.workshop.trombinoscope

import android.util.Log
import androidx.lifecycle.ViewModel

class WorkerListViewModel : ViewModel() {

    private val repository = WorkerRepository()

    fun getWorkers(): List<Worker> {
        Log.d(TAG, "getWorkers")
        return repository.getWorkers()
    }

    companion object {
        private const val TAG = "WorkerListViewModel"
    }
}
