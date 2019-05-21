package com.ynov.kotlin.rickmorty.data
import io.reactivex.Single

import com.ynov.kotlin.rickmorty.model.RMCharacter

class DataRepository (private val apiManager : ApiManager){
    fun retrieveCharacterList(): Single<List<RMCharacter>> =
        apiManager.retrieveCharacterList().map{
            it.map{
                characterRemoteEntity ->  RMCharacter(characterRemoteEntity.name/*,characterRemoteEntity.status,characterRemoteEntity.species, characterRemoteEntity.type, characterRemoteEntity.gender*/)
            }
        }
}