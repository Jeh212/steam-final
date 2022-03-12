package br.com.fiap.steamfinal.db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import br.com.fiap.steamfinal.db.entity.JogoEntity

class DataBaseConfiguration(ctx: Context) : SQLiteOpenHelper(ctx, DB_NAME, null, DB_VERSION){

    companion object {
        private val DB_VERSION = 2
        private val DB_NAME = "Steam"
        val TABLE_JOGO = "TB_JOGO"
    }

    override fun onCreate(p0: SQLiteDatabase?) {
        val CREATE_TABLE = "CREATE TABLE $TABLE_JOGO (id INTEGER PRIMARY KEY, nome TEXT, descricao TEXT, categoria TEXT, preco REAL);"
        p0?.execSQL(CREATE_TABLE)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        val DROP_TABLE = "DROP TABLE IF EXISTS $TABLE_JOGO;"
        p0?.execSQL(DROP_TABLE)
        onCreate(p0)
    }




}