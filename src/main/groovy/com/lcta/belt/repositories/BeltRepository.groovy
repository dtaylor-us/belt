package com.lcta.belt.repositories

import com.lcta.belt.models.Belt
import org.springframework.data.repository.PagingAndSortingRepository

interface BeltRepository extends PagingAndSortingRepository<Belt, Long> {

}
