package findsolucoes.com.assetec.model.entitys

import androidx.room.*

@Entity
data  class UserEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var  name: String,
    var  email: String,
    var token: String)