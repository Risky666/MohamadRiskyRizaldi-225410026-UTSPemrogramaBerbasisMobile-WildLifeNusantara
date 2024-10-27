
package id.mohamadriskyrizaldi.wildlifenusantara.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape// Fungsi untuk membuat sudut yang dibulatkan.
import androidx.compose.material3.Shapes//Kelas bawaan dari Material3 yang digunakan untuk mendefinisikan bentuk global komponen UI
import androidx.compose.ui.unit.dp

val Shapes = Shapes(
    small = RoundedCornerShape(50.dp),//Mengatur bentuk sudut bulat dengan radius 50 dp.
    medium = RoundedCornerShape(bottomStart = 16.dp, topEnd = 16.dp)//ini berfungsi untuk membulatkan dua sudut yaitu: sudut bawah-kiri dan atas-kanan dengan radius 16 dp.
)
