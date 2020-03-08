package choi.mvvm.androidchatting.model

import android.app.Application
import androidx.lifecycle.LiveData
import choi.mvvm.androidchatting.model.dao.UserDao
import choi.mvvm.androidchatting.model.entity.User

class ChatRepository(application: Application) {

    private val chatDataBase = ChatDataBase.getInstance(application)!!
    private val userDao: UserDao = chatDataBase.userDao()
    private val users: LiveData<List<User>> = userDao.getAll()

    fun getAll(): LiveData<List<User>> {
        return users
    }

    fun insert(user: User) {
        try {
            val thread = Thread(Runnable {
                userDao.insert(user) })
            thread.start()
        } catch (e: Exception) { }
    }

    fun delete(user: User) {
        try {
            val thread = Thread(Runnable {
                userDao.delete(user)
            })
            thread.start()
        } catch (e: Exception) { }
    }

}