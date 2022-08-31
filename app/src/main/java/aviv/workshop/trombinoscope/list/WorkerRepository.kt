package aviv.workshop.trombinoscope.list

import aviv.workshop.trombinoscope.R

class WorkerRepository {

    fun getWorkers(): List<Worker> {
        return listOf(
            Worker(
                1,
                "Abdullah Al Samman",
                R.drawable.abdullah,
                "",
                "2022",
                "Germany",
                "Android Engineer"
            ),
            Worker(
                1,
                "Ahmed Abdellaoui",
                R.drawable.ahmed,
                "https://media-exp1.licdn.com/dms/image/C4D03AQGUK5q3ryAFuQ/profile-displayphoto-shrink_200_200/0/1517349681988?e=1652918400&v=beta&t=GW-68M6vB0w0oyPs8U_MOdJqZEv9gfF557r3C71o6rA",
                "2019",
                "France",
                "Android CoE"
            ),
            Worker(
                1,
                "Andrea Westrich",
                R.drawable.andrea,
                "",
                "2019",
                "Germany",
                "Android CoE"
            ),
            Worker(
                1,
                "Anthony Valette",
                R.drawable.anthony,
                "https://pbs.twimg.com/profile_images/1064824881651621888/iZkCLqWQ_400x400.jpg",
                "2016",
                "France",
                "Android Lead Engineer"
            ),
            Worker(
                1,
                "Bhumanyu BARKAKATI",
                R.drawable.bhumanyu,
                "",
                "2022",
                "Belgium",
                "Android Engineer"
            ),
            Worker(
                1,
                "Chiara Müller-Kallweit",
                arrivalDate = "2019",
                location = "Germany",
                jobTitle = "Android Engineer"
            ),
            Worker(
                1,
                "Cristian Garcia Alvarez",
                R.drawable.cristian,
                "",
                "2021",
                "Belgium",
                "Android CoE"
            ),
            Worker(
                1,
                "Florien Flament",
                R.drawable.florien,
                "",
                "2022",
                "Belgium",
                "Android Engineer"
            ),
            Worker(
                1,
                "Kelly Luu",
                R.drawable.kelly,
                "https://pbs.twimg.com/profile_images/1064824881651621888/iZkCLqWQ_400x400.jpg",
                "2020",
                "France",
                "Android Engineer"
            ),
            Worker(
                1,
                "Laurent Binutti",
                R.drawable.laurent,
                "https://pbs.twimg.com/profile_images/1064824881651621888/iZkCLqWQ_400x400.jpg",
                "2021",
                "France",
                "Android Engineer"
            ),
            Worker(
                1,
                "Lionel Collin",
                R.drawable.lionel,
                "",
                "2022",
                "Belgium",
                "Android Engineer"
            ),
            Worker(
                1,
                "Luca Bartl",
                R.drawable.luca,
                "",
                "2022",
                "Germany",
                "Android Engineer"
            ),
            Worker(
                1,
                "Mehdi Chouag",
                R.drawable.mehdi,
                "https://pbs.twimg.com/profile_images/1064824881651621888/iZkCLqWQ_400x400.jpg",
                "2019",
                "France",
                "Android Engineer"
            ),
            Worker(
                1,
                "Michael Widlok",
                R.drawable.michael,
                "",
                "2022",
                "Germany",
                "Android Engineer"
            ),
            Worker(
                1,
                "Navek Portella",
                R.drawable.navek,
                "https://eip.epitech.eu/2013/selfishfriendship/www.epitech.eu/intra/photos/portel_n.jpg",
                "2016",
                "France",
                "Android Lead Engineer"
            ),
            Worker(
                1,
                "Pierre-Louis Bertheau",
                R.drawable.pierrelouis,
                "https://pbs.twimg.com/profile_images/1064824881651621888/iZkCLqWQ_400x400.jpg",
                "2022",
                "France",
                "Android Engineer"
            ),
            Worker(
                "Théo Sitnikow",
                R.drawable.theo,
                "https://ca.slack-edge.com/T8MMQ651A-U03R36766H2-2505e10b664c-512",
                "2022",
                "France",
                "Android Engineer"
            ),
            Worker(
                1,
                "Valentin Tran",
                R.drawable.valentin,
                "https://pbs.twimg.com/profile_images/1064824881651621888/iZkCLqWQ_400x400.jpg",
                "2021",
                "France",
                "Android Engineer"
            ),
            Worker(
                1,
                "Zhiyi Wang",
                R.drawable.wang,
                "",
                "2019",
                "Germany",
                "Android Engineer"
            ),
        )
    }
}