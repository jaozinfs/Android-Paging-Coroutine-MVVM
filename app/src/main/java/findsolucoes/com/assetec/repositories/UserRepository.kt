package findsolucoes.com.assetec.repositories

import android.os.AsyncTask
import findsolucoes.com.assetec.database.ApplicationDatabase
import findsolucoes.com.assetec.model.dao.UserDao
import findsolucoes.com.assetec.model.entitys.UserEntity

class UserRepository(private val db: ApplicationDatabase){


    fun updateUser(userEntity: UserEntity, callback: () -> Unit, onError: (Throwable) -> Unit){
        UpdateUserAsyncTask(db.userDao(), callback, onError).execute(userEntity) }

    fun insertUser(userEntity: UserEntity){
        try{
            InsertUserAsync(db.userDao()).execute(userEntity)
        }catch (error : Throwable){
            //..
        }
    }

    //get user asynk in database
    fun getUser() : UserEntity = GetUserAsynkTask(db.userDao()).execute().get()


    /**
     * Get user async
     */
    private class GetUserAsynkTask (val userDao: UserDao) : AsyncTask<UserEntity, Void, UserEntity>() {

        override fun doInBackground(vararg userEntity: UserEntity): UserEntity {

            return userDao.getUser()
        }
    }

    /**
     * Update user async
     */
    private class UpdateUserAsyncTask (val userDao: UserDao, val callback: () -> Unit, val failedupdate: (Throwable) -> Unit) : AsyncTask<UserEntity, Void, Void>() {
        override fun doInBackground(vararg userEntity: UserEntity):  Void? {
            try {
                userDao.updateUser(userEntity[0])
                callback()
            }catch (e: Throwable){
                failedupdate(e)
            }
            return null
        }
    }

    /**
     * Insert user async
     */
    private class InsertUserAsync (val userDao: UserDao) : AsyncTask<UserEntity, Void, Void>() {
        override fun doInBackground(vararg userEntity: UserEntity): Void? {
            userDao.insertUser(userEntity[0])
            return null
        }
    }

}