package id.mohamadriskyrizaldi.wildlifenusantara.data
import androidx.annotation.DrawableRes //mengimport data dari resource drawable
import androidx.annotation.StringRes  //mengimport data dari resource string
import id.mohamadriskyrizaldi.wildlifenusantara.R

//ini untuk menyimpan data hewan
data class Animal(
    @DrawableRes val imageResourceId: Int, //ID untuk gambar hewan dari res/drawable.
    @StringRes val name: Int, //name: ID string untuk nama hewan dari res/values/strings.xml.
    @StringRes val description: Int //description: ID string untuk deskripsi hewan dari res/values/strings.xml.
)

//animals adalah daftar list dari objek Animal. Setiap objek berisi gambar, nama, dan deskripsi.
val animals = listOf(
    Animal(R.drawable.anoa, R.string.animal_name_1, R.string.animal_description_1),
    Animal(R.drawable.babirusa, R.string.animal_name_2, R.string.animal_description_2),
    Animal(R.drawable.badak, R.string.animal_name_3, R.string.animal_description_3),
    Animal(R.drawable.cenderawasih, R.string.animal_name_4, R.string.animal_description_4),
    Animal(R.drawable.elangjawa, R.string.animal_name_5, R.string.animal_description_5),
    Animal(R.drawable.harimau, R.string.animal_name_6, R.string.animal_description_6),
    Animal(R.drawable.kakatua, R.string.animal_name_7, R.string.animal_description_7),
    Animal(R.drawable.komodo, R.string.animal_name_8, R.string.animal_description_8),
    Animal(R.drawable.oranghutansumatra, R.string.animal_name_9, R.string.animal_description_9),
    Animal(R.drawable.pesutmahakam, R.string.animal_name_10, R.string.animal_description_10),
    //Animal(R.drawable.babirusa, R.string.animal_name_11, R.string.animal_description_11),


)
