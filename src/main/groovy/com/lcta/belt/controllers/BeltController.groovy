package com.lcta.belt.controllers

import com.lcta.belt.models.Belt
import com.lcta.belt.services.BeltService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

import javax.transaction.Transactional

@RestController
@RequestMapping('belt')
@CrossOrigin(origins = "http://localhost:3449")
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