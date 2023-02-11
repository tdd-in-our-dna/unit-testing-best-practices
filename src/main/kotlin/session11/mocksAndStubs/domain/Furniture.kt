package session11.mocksAndStubs.domain

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class Furniture(
    @Id
    @Column
    val id: Int,

    @Column
    val title: String,

    @Column
    val price: Double,

    @Column
    var isReserved: Boolean
) {
    constructor() : this(
        0,
        "",
        0.0,
        false
    )
}