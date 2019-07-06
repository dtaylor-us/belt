package com.lcta.belt.services

import com.lcta.belt.models.Belt
import com.lcta.belt.repositories.BeltRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service

import javax.persistence.EntityNotFoundException

@Service
class BeltServiceImpl implements BeltService {

    @Autowired
    BeltRepository beltRepository

    @Override
    List findAll() {
        beltRepository.findAll(Sort.by('name')).asList()
    }

    @Override
    Belt findById(long id) {
        beltRepository.findById(id).orElse(null)
    }

    @Override
    Belt findByIdOrError(long id) {
        beltRepository.findById(id).orElseThrow({
            new EntityNotFoundException()
        })
    }

    @Override
    Belt save(Belt belt) {
        belt.attributes?.each { it.belt = belt }
        beltRepository.save(belt)
    }

    @Override
    Belt update(Belt belt, Long id) {
        Belt persisted = findByIdOrError(id)
        persisted.with {
            name = belt.name
        }
        def toBeRemoved = []
        // find values to update & delete
        persisted.attributes.each {
            def a = belt.attributes.find { it2 -> it2.id == it.id }
            if (a == null) toBeRemoved.add(it)
            else it.name = a.name
        }
        persisted.attributes.removeAll(toBeRemoved)
        // assign persisted entity as the belt
        belt.attributes.each {
            if (it.id == null) {
                it.belt = persisted
                persisted.attributes.add(it)
            }
        }
        beltRepository.save(persisted)
    }

    @Override
    def void deleteById(long id) {
        def belt = findByIdOrError(id)
        beltRepository.delete(belt)
        printf("{$belt.name} has been deleted")
    }
}
