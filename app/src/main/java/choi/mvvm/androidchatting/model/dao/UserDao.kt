package choi.mvvm.androidchatting.model.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import choi.mvvm.androidchatting.model.entity.User

@Dao
interface UserDao {

    @Query("SELECT * FROM User ORDER BY id ASC")
    fun getAll(): LiveData<List<User>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: User)

    @Delete
    fun delete(user: User)

}