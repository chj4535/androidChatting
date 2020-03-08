package choi.mvvm.androidchatting.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import choi.mvvm.androidchatting.model.entity.User
import choi.mvvm.androidchatting.model.dao.UserDao

@Database(entities = [User::class], version = 1)
abstract class ChatDataBase: RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {
        private var INSTANCE: ChatDataBase? = null

        fun getInstance(context: Context): ChatDataBase? {
            if (INSTANCE == null) {
                synchronized(ChatDataBase::class) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        ChatDataBase::class.java, "chatdb")
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return INSTANCE
        }
    }

}