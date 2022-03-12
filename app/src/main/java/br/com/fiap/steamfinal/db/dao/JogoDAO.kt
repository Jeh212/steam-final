package br.com.fiap.steamfinal.db.dao

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import br.com.fiap.steamfinal.R
import br.com.fiap.steamfinal.db.DataBaseConfiguration
import br.com.fiap.steamfinal.db.entity.JogoEntity
import br.com.fiap.steamfinal.model.Jogo

class JogoDAO(cxt:Context) {

    var db = DataBaseConfiguration(cxt)

    fun adicionarJogo(jogoEntity: JogoEntity) {
        val p0 = db.writableDatabase

        val values = ContentValues().apply {
            put("id", jogoEntity.id)
            put("nome", jogoEntity.nome)
            put("descricao", jogoEntity.descricao)
            put("categoria", jogoEntity.categoria)
            put("preco", jogoEntity.preco)

        }
        p0.insert(DataBaseConfiguration.TABLE_JOGO, null, values)
    }

//    fun getJogo(id: Int) : Cursor {
//        val p0 = db.readableDatabase
//        val selectQuery = "SELECT * FROM Jogo WHERE id = $id"
//        var cursor = p0.rawQuery(selectQuery, null)
//        if(cursor.count > 0) {
//            cursor.moveToFirst()
//            val jogo1 = Jogo(
//                R.drawable.csgo,
//                cursor.getInt(cursor.getColumnIndexOrThrow("descricao")),
//                cursor.getString(cursor.getColumnIndexOrThrow("descricao")),
//                "FPS",
//                "R$ 15,00"
//            )
//        }
//        return cursor
//    }

    fun listar() : ArrayList<JogoEntity> {
        val readableDatabase = db.readableDatabase
        val arrayList = ArrayList<JogoEntity>()

        var selectQuery = "SELECT * FROM TB_JOGO"
        val rawQuery = readableDatabase.rawQuery(selectQuery, null)
        if(rawQuery.moveToFirst()){
            do{
                val jogo = JogoEntity(
                    rawQuery.getInt(rawQuery.getColumnIndexOrThrow("id")),
                    rawQuery.getString(rawQuery.getColumnIndexOrThrow("nome")),
                    rawQuery.getString(rawQuery.getColumnIndexOrThrow("descricao")),
                    rawQuery.getString(rawQuery.getColumnIndexOrThrow("categoria")),
                    rawQuery.getString(rawQuery.getColumnIndexOrThrow("preco"))
                )
                arrayList.add(jogo)
            } while (rawQuery.moveToNext())
        }
        return arrayList
    }

}