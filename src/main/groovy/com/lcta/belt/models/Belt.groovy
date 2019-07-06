package com.lcta.belt.models


import javax.persistence.*

@Entity
class Belt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id

    String name

    @OneToMany( // tell persistence provider 'attributes' is one-to-many relation with BeltAttribute
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL, // cascade all operation to 'attributes' values
            orphanRemoval = true, // auto delete BeltAttribute entity that has no Belt
            mappedBy = 'belt' // mark for bi-directional relation
    )
    List<BeltAttribute> attributes

    boolean equals(o) {
        if (this.is(o)) return true
        if (!(o instanceof Belt)) return false

        Belt belt = (Belt) o

        if (id != belt.id) return false

        return true
    }

    int hashCode() {
        return (id != null ? id.hashCode() : 0)
    }
}