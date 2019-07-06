package com.lcta.belt.repositories

import com.lcta.belt.models.BeltAttribute
import org.springframework.data.repository.CrudRepository

interface BeltAttributeRepository extends CrudRepository<BeltAttribute, Long> {
}
