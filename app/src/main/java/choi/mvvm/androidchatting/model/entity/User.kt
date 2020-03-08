package choi.mvvm.androidchatting.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "User")
data class User(
    @PrimaryKey(autoGenerate = true)
    var id: Long?,

    @ColumnInfo(name = "userName")
    var userName: String,

    @ColumnInfo(name = "userEmail")
    var userEmail: String,

    @ColumnInfo(name = "userPw")
    var userPw: String,

    @ColumnInfo(name = "userTumbnail")
    var userTumbnail: String,

    @ColumnInfo(name = "userBackground")
    var userBackground: String,

    @ColumnInfo(name = "userStatemessage")
    var userStatemessage: String
) {
    constructor() : this(null, "", "", "", "", "", "")
}