package com.lcta.belt.controllers

import com.lcta.belt.models.Belt
import com.lcta.belt.services.BeltService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import javax.transaction.Transactional

@RestController
@RequestMapping('belt')
@Transactional
class BeltController {
    @Autowired
    BeltService beltService

    @GetMapping('')
    List findAll() {
        beltService.findAll()
    }

    @GetMapping('{id}')
    Belt findOne(@PathVariable long id) {
        beltService.findById(id)
    }

    @PostMapping('')
    Belt save(@RequestBody Belt belt) {
        beltService.save(belt)
    }

    @PutMapping('{id}')
    Belt update(@RequestBody Belt belt, @PathVariable long id) {
        beltService.update(belt, id)
    }

    @DeleteMapping('{id}')
    deleteById(@PathVariable long id) {
        beltService.deleteById(id)
    }
}