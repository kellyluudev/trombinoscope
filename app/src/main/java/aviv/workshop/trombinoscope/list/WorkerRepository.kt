package aviv.workshop.trombinoscope.list

import aviv.workshop.trombinoscope.R

class WorkerRepository {

    fun getWorkers(): List<Worker> {
        return workerList
    }

    fun getWorker(workerId: Int): Worker {
        val defaultRabbitWorker = Worker()
        return workerList.find { workerId == it.id } ?: defaultRabbitWorker
    }

    private val workerList = listOf(
        Worker(
            1,
            "Abdullah Al Samman",
            R.drawable.abdullah,
            "https://ca.slack-edge.com/T8MMQ651A-U030W16RX8W-39ebea2942d7-512",
            "2022",
            "Germany",
            "Android Engineer"
        ),
        Worker(
            2,
            "Ahmed Abdellaoui",
            R.drawable.ahmed,
            "https://ca.slack-edge.com/T8MMQ651A-UQH3TU59D-8a4363a281a2-512",
            "2019",
            "France",
            "Android CoE"
        ),
        Worker(
            3,
            "Andrea Westrich",
            R.drawable.andrea,
            "https://ca.slack-edge.com/T8MMQ651A-UKH3EQCF9-2f5bca5fc518-512",
            "2019",
            "Germany",
            "Android CoE"
        ),
        Worker(
            4,
            "Anthony Valette",
            R.drawable.anthony,
            "https://ca.slack-edge.com/T8MMQ651A-UAP3X0X5H-e381aee7197d-512",
            "2016",
            "France",
            "Android Lead Engineer"
        ),
        Worker(
            5,
            "Bhumanyu BARKAKATI",
            R.drawable.bhumanyu,
            "https://ca.slack-edge.com/T8MMQ651A-U03LHQC0PR9-5972d0e42e11-512",
            "2022",
            "Belgium",
            "Android Engineer"
        ),
        Worker(
            6,
            "Chiara Müller-Kallweit",
            arrivalDate = "2019",
            location = "Germany",
            jobTitle = "Android Engineer"
        ),
        Worker(
            7,
            "Cristian Garcia Alvarez",
            R.drawable.cristian,
            "https://ca.slack-edge.com/T8MMQ651A-U0233A24KLP-3f37039f4b10-512",
            "2021",
            "Belgium",
            "Android CoE"
        ),
        Worker(
            8,
            "Florien Flament",
            R.drawable.florien,
            "https://ca.slack-edge.com/T8MMQ651A-U037G8BAJQ7-ad596ea60fc0-512",
            "2022",
            "Belgium",
            "Android Engineer"
        ),
        Worker(
            9,
            "Kelly Luu",
            R.drawable.kelly,
            "https://ca.slack-edge.com/T8MMQ651A-UT85M1SR1-727f9fd0994d-512",
            "2020",
            "France",
            "Android Engineer"
        ),
        Worker(
            10,
            "Laurent Binutti",
            R.drawable.laurent,
            "https://ca.slack-edge.com/T8MMQ651A-U023F9N2LKT-2e5589ea0c95-512",
            "2021",
            "France",
            "Android Engineer"
        ),
        Worker(
            11,
            "Lionel Collin",
            R.drawable.lionel,
            "https://ca.slack-edge.com/T8MMQ651A-U03LU5FN8EB-7c5fbbaf36c9-512",
            "2022",
            "Belgium",
            "Android Engineer"
        ),
        Worker(
            12,
            "Luca Bartl",
            R.drawable.luca,
            "https://ca.slack-edge.com/T8MMQ651A-U03PCPJMVQU-9592f798fb93-512",
            "2022",
            "Germany",
            "Android Engineer"
        ),
        Worker(
            13,
            "Mehdi Chouag",
            R.drawable.mehdi,
            "https://ca.slack-edge.com/T8MMQ651A-UQJKRJKFS-a1ebfbb63a7a-512",
            "2019",
            "France",
            "Android Engineer"
        ),
        Worker(
            14,
            "Michael Widlok",
            R.drawable.michael,
            "https://ca.slack-edge.com/T8MMQ651A-UKHBVJST0-bb7a792700e1-512",
            "2022",
            "Germany",
            "Android Engineer"
        ),
        Worker(
            15,
            "Navek Portella",
            R.drawable.navek,
            "https://ca.slack-edge.com/T8MMQ651A-U9VN23BL6-2272e041ba65-512",
            "2016",
            "France",
            "Android Lead Engineer"
        ),
        Worker(
            16,
            "Pierre-Louis Bertheau",
            R.drawable.pierrelouis,
            "https://ca.slack-edge.com/T8MMQ651A-U02SCBZ93B5-bd012c08476d-512",
            "2022",
            "France",
            "Android Engineer"
        ),
        Worker(
            17,
            "Théo Sitnikow",
            R.drawable.theo,
            "https://ca.slack-edge.com/T8MMQ651A-U03R36766H2-2505e10b664c-512",
            "2022",
            "France",
            "Android Engineer"
        ),
        Worker(
            18,
            "Valentin Tran",
            R.drawable.valentin,
            "https://ca.slack-edge.com/T8MMQ651A-U017C09B76U-9b1b623c22e3-512",
            "2021",
            "France",
            "Android Engineer"
        ),
        Worker(
            19,
            "Zhiyi Wang",
            R.drawable.wang,
            "https://ca.slack-edge.com/T8MMQ651A-UKENXDZNY-994716444290-512",
            "2019",
            "Germany",
            "Android Engineer"
        ),
    )
}