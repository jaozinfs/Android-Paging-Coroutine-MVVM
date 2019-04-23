package findsolucoes.com.assetec.model.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import findsolucoes.com.assetec.model.entitys.UserEntity


@Dao
interface UserDao{

    @Query("SELECT * FROM userentity")
    fun getUser(): UserEntity

    @Insert
    fun insertUser(vararg user: UserEntity)

    @Update
    fun updateUser(vararg user: UserEntity)
}