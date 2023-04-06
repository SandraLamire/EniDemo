package com.example.enidemo.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import retrofit2.http.Query

@Dao
interface ArticleDAO {

    @Insert
    fun insert(article: Article)

    @androidx.room.Query("SELECT * FROM Article")
    fun getAll() : LiveData<List<Article>>

    @androidx.room.Query("SELECT * FROM Article WHERE id=:id")
    operator fun get(id: Long) : Article

}