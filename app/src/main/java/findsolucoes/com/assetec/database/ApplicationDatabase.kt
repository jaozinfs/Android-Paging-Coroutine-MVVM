package findsolucoes.com.assetec.database

import androidx.room.*
import androidx.room.Database
import findsolucoes.com.assetec.model.dao.UserDao
import findsolucoes.com.assetec.model.entitys.UserEntity

@Database(entities = [UserEntity::class], version = 1, exportSchema = false)
abstract class AssetecDatabase : RoomDatabase(){

    abstract fun userDao(): UserDao

}