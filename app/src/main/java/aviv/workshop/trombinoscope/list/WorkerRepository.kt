package aviv.workshop.trombinoscope.list

import aviv.workshop.trombinoscope.R

class WorkerRepository {

    fun getWorkers(): List<Worker> {
        return listOf(
            Worker(
                "Ahmed Abdellaoui",
                R.drawable.ahmed,
                "https://media-exp1.licdn.com/dms/image/C4D03AQGUK5q3ryAFuQ/profile-displayphoto-shrink_200_200/0/1517349681988?e=1652918400&v=beta&t=GW-68M6vB0w0oyPs8U_MOdJqZEv9gfF557r3C71o6rA",
                "2019",
                "Android Architect"
            ), Worker(
                "Navek Portella",
                R.drawable.navek,
                "https://eip.epitech.eu/2013/selfishfriendship/www.epitech.eu/intra/photos/portel_n.jpg",
                "2016",
                "Android Lead Engineer"
            ),
            Worker(
                "Mehdi Chouag",
                R.drawable.mehdi,
                "https://pbs.twimg.com/profile_images/1064824881651621888/iZkCLqWQ_400x400.jpg",
                "2019",
                "Android Engineer"
            ),
            Worker(
                "Laurent Binutti",
                R.drawable.laurent,
                "https://pbs.twimg.com/profile_images/1064824881651621888/iZkCLqWQ_400x400.jpg",
                "2021",
                "Android Engineer"
            ),
            Worker(
                "François Grzybowski",
                R.drawable.francois,
                "https://pbs.twimg.com/profile_images/1064824881651621888/iZkCLqWQ_400x400.jpg",
                "2016",
                "Engineering Manager"
            ),
            Worker(
                "Anthony Valette",
                R.drawable.anthony,
                "https://pbs.twimg.com/profile_images/1064824881651621888/iZkCLqWQ_400x400.jpg",
                "2016",
                "Android Lead Engineer"
            ),
            Worker(
                "Pierre Louis Bertheau",
                R.drawable.pierrelouis,
                "https://pbs.twimg.com/profile_images/1064824881651621888/iZkCLqWQ_400x400.jpg",
                "2022",
                "Android Engineer"
            ),
            Worker(
                "Valentin Tran",
                R.drawable.valentin,
                "https://pbs.twimg.com/profile_images/1064824881651621888/iZkCLqWQ_400x400.jpg",
                "2021",
                "Android Engineer"
            ),
            Worker(
                "Kelly Luu",
                R.drawable.kelly,
                "https://pbs.twimg.com/profile_images/1064824881651621888/iZkCLqWQ_400x400.jpg",
                "2020",
                "Android Engineer"
            )
        )
    }
}