package aviv.workshop.trombinoscope

import androidx.annotation.DrawableRes

data class Worker(
    val name: String = "Ahmed Abdellaoui",
    @DrawableRes val pictureRes: Int = R.drawable.ahmed,
    val pictureUrl: String = "https://media-exp1.licdn.com/dms/image/C4D03AQGUK5q3ryAFuQ/profile-displayphoto-shrink_200_200/0/1517349681988?e=1652918400&v=beta&t=GW-68M6vB0w0oyPs8U_MOdJqZEv9gfF557r3C71o6rA",
    val arrivalDate: String = "2019",
    val jobTitle: String = "Android Architect"
)