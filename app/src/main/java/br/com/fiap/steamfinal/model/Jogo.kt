package br.com.fiap.steamfinal.model

import android.os.Parcel
import android.os.Parcelable

data class Jogo(
    var foto: Int,
    val id: Int,
    val nome: String?,
    val descricao: String?,
    val categoria: String?,
    val preco: String?
    ) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(foto)
        parcel.writeInt(id)
        parcel.writeString(nome)
        parcel.writeString(descricao)
        parcel.writeString(categoria)
        parcel.writeString(preco)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Jogo> {
        override fun createFromParcel(parcel: Parcel): Jogo {
            return Jogo(parcel)
        }

        override fun newArray(size: Int): Array<Jogo?> {
            return arrayOfNulls(size)
        }
    }
}