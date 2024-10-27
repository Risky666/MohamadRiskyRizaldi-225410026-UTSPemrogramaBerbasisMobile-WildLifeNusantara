//MohamadRiskyRizaldi-225410026-IF1-UTS-Pemrograman Berbasis Mobile

@file:OptIn(ExperimentalMaterial3Api::class)// digunakan untuk mengaktifkan API eksperimental dari Jetpack Compose Material 3.
package id.mohamadriskyrizaldi.wildlifenusantara

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.*
import androidx.compose.runtime.*
//import androidx.compose.material3.icons.Icons
//import androidx.compose.material3.icons.filled.ExpandLess
//import androidx.compose.material3.icons.filled.ExpandMore
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.Alignment
import id.mohamadriskyrizaldi.wildlifenusantara.data.Animal
import id.mohamadriskyrizaldi.wildlifenusantara.data.animals
import id.mohamadriskyrizaldi.wildlifenusantara.ui.theme.WildlifeNusantaraTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WildlifeNusantaraTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    WildlifeApp()
                }
            }
        }
    }
}

@Composable
fun WildlifeApp() {
    Scaffold(
        topBar = { WildlifeTopAppBar() }
    ) { paddingValues ->
        LazyColumn(contentPadding = paddingValues) {
            items(animals) { animal ->
                AnimalItem(
                    animal = animal,
                    modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))
                )
            }
        }
    }
}

@Composable
fun AnimalItem(//animal: Animal adalah Parameter yang menerima objek dari kelas Animal, berisi data hewan seperti gambar, nama, dan deskripsi
    animal: Animal,
    modifier: Modifier = Modifier//modifier: Modifier = Modifier: Parameter opsional untuk mengatur tampilan komponen seperti ukuran, margin, atau padding.
) {
    var expanded by remember { mutableStateOf(false) }
    Card(modifier = modifier) {
        Column(
            modifier = Modifier
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioNoBouncy,
                        stiffness = Spring.StiffnessMedium
                    )
                )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(R.dimen.padding_small))
            ) {
                AnimalIcon(animal.imageResourceId)//AnimalIcon: Menampilkan ikon atau gambar hewan.
                AnimalInformation(animal.name)//AnimalInformation: Menampilkan nama hewan.
                Spacer(Modifier.weight(1f))//enambahkan spasi fleksibel agar tombol ekspansi berada di sisi kanan.
                AnimalItemButton(expanded = expanded, onClick = { expanded = !expanded })
            }
            if (expanded) {// Mengecek apakah expanded bernilai true. Jika iya, deskripsi akan ditampilkan.
                AnimalDescription(  //Menampilkan teks deskripsi hewan
                    descriptionRes = animal.description,
                    modifier = Modifier.padding(
                        start = dimensionResource(R.dimen.padding_medium),
                        top = dimensionResource(R.dimen.padding_small),
                        bottom = dimensionResource(R.dimen.padding_medium),
                        end = dimensionResource(R.dimen.padding_medium)
                    )
                )
            }
        }
    }
}


// AnimalItemButton membuat tombol ikon yang memungkinkan user  untuk memperluas atau menyusutkan informasi tentang hewan.
@Composable
private fun AnimalItemButton(
    expanded: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    IconButton(
        onClick = onClick,
        modifier = modifier
    ) {
        Icon(
            imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
            contentDescription = stringResource(R.string.expand_button_content_description),
            tint = MaterialTheme.colorScheme.secondary
        )
    }
}


@Composable
fun WildlifeTopAppBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(//ini adalah code untuk AppBar dengan judul dan konten yang berada di tengah.
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier
                        .size(dimensionResource(R.dimen.image_size)) //ini untuk mengatur ukuran gambar di topappbar
                        .padding(dimensionResource(R.dimen.padding_small)), //ini untuk mengatur batas antara gambar dan teks
                    painter = painterResource(R.drawable.ic_woof_logo), //logotopbar mengfambil dari resource drawable
                    contentDescription = null
                )
                Text(//menampilkan nama aplikasi
                    text = stringResource(R.string.app_name),//tulisan yang ada di topAppbar
                    style = MaterialTheme.typography.displayLarge//tampilan tulisan topappbar menjadi besar
                )
            }
        },
        modifier = modifier
    )
}

@Composable
fun AnimalIcon(@DrawableRes animalIcon: Int, modifier: Modifier = Modifier) { //menampilkan gambar ikon untuk setiap hewan
    Image(
        painter = painterResource(animalIcon),
        contentDescription = null,
        modifier = modifier
            .size(dimensionResource(R.dimen.image_size))
            .padding(dimensionResource(R.dimen.padding_small))
            .clip(MaterialTheme.shapes.small),//mengatur bentuk gambar sesuai yang berada di tema
        contentScale = ContentScale.Crop //jika gambar memenuhi ukuran container maka akan di crop
    )
}


//ini adalah code untuk menampilkan nama hewan,mengambil teks dari string
@Composable
fun AnimalInformation(@StringRes nameRes: Int, modifier: Modifier = Modifier) {
    Text(
        text = stringResource(nameRes),
        style = MaterialTheme.typography.displayMedium,//ini untuk mengatur font
        modifier = modifier.padding(start = dimensionResource(R.dimen.padding_medium))
    )
}


//ini adalah code untuk menampilkan informasi tentang hewan jika item diperluas.
@Composable
fun AnimalDescription(@StringRes descriptionRes: Int, modifier: Modifier = Modifier) {
    Text(
        text = stringResource(descriptionRes),
        style = MaterialTheme.typography.bodyLarge,
        modifier = modifier
    )
}