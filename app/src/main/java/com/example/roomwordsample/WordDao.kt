package com.example.roomwordsample

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface WordDao {

    @Query("select * from word_table order by word asc")
    fun getAllWordsInAsc() : LiveData<List<Word>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertWord(word: Word)

    @Query("delete from word_table")
    suspend fun truncate()

}