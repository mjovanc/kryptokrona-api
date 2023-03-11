package org.kryptokrona.api.services

import org.kryptokrona.api.models.*
import org.kryptokrona.api.plugins.DatabaseConnection
import org.ktorm.dsl.*
import org.ktorm.entity.add
import org.ktorm.entity.count
import org.ktorm.entity.find

class SupplyServiceImpl : SupplyService {

    private val db = DatabaseConnection.database

    override fun getAll(size: Int, page: Int): List<Supply> {
        return db.from(Supplies)
            .select()
            .offset((page - 1) * size)
            .limit(size)
            .map { row -> Supplies.createEntity(row) }
    }

    override fun getById(id: Long): Supply? {
        return db.supplies.find { it.id eq id }
    }

    override fun save(supply: Supply) {
        db.supplies.add(supply)
    }

    override fun delete(id: Long) {
        db.delete(Supplies) { it.id eq id }
    }

    override fun getTotalCount(): Int {
        return db.supplies.count()
    }

}