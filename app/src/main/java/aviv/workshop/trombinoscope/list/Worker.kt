package aviv.workshop.trombinoscope.list

import androidx.annotation.DrawableRes
import aviv.workshop.trombinoscope.R

data class Worker(
    val name: String = "Rabbit",
    @DrawableRes val pictureRes: Int = R.drawable.rabbit,
    val pictureUrl: String? = "https://i.pinimg.com/736x/02/07/b6/0207b6b5817da1984c2f08693122f32e.jpg",
    val arrivalDate: String = "2022",
    val location: String = "France",
    val jobTitle: String = "Rabbit"
)