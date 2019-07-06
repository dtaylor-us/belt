package com.lcta.belt.services

import com.lcta.belt.models.Belt

interface BeltService {

    List findAll()

    Belt findById(long id)

    Belt findByIdOrError(long id)

    Belt save(Belt belt)

    Belt update(Belt belt, Long id)

    void deleteById(long id)

}
