package br.com.zup.fipe.data.model


import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "marcas")
data class MarcaResponseItemItem(
    @SerializedName("codigo")
    @PrimaryKey
    val codigo: String = "",
    @SerializedName("nome")
    val nome: String = ""
):Parcelable