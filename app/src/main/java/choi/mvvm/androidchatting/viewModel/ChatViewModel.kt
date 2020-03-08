package choi.mvvm.androidchatting.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import choi.mvvm.androidchatting.model.ChatRepository
import choi.mvvm.androidchatting.model.entity.User

class ChatViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = ChatRepository(application)
    private val contacts = repository.getAll()

    fun getAll(): LiveData<List<User>> {
        return this.contacts
    }

    fun insert(user: User) {
        repository.insert(user)
    }

    fun delete(user: User) {
        repository.delete(user)
    }
}