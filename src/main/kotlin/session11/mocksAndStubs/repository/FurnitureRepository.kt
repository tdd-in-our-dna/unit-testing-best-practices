package session11.mocksAndStubs.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import session11.mocksAndStubs.domain.Furniture

@Repository
interface FurnitureRepository: JpaRepository<Furniture, Int> {
    @Query("SELECT COUNT(*) > 0 FROM furniture WHERE id=:furnitureId AND is_reserved=false", nativeQuery = true)
    fun isAvailable(@Param("furnitureId") furnitureId: Int): Boolean

    @Transactional
    @Modifying
    @Query("UPDATE furniture SET is_reserved=true WHERE id=?1", nativeQuery = true)
    fun reserve(furnitureId: Int)

    fun getById(furnitureId: Int): Furniture
}