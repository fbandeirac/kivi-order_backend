package com.kivikood.plugins

import kotlinx.coroutines.Dispatchers
import kotlinx.serialization.Serializable
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction
import org.jetbrains.exposed.sql.transactions.transaction

object Users : IntIdTable() {
    val name = varchar("name", length = 50)
    val age = integer("age")
}

@Serializable
data class User(val id: Int, val name: String, val age: Int)

class UserService(private val database: Database) {
    init {
        transaction(database) {
            SchemaUtils.create(Users)
        }
    }

    suspend fun <T> dbQuery(block: suspend () -> T): T =
        newSuspendedTransaction(Dispatchers.IO) { block() }

    suspend fun create(user: User): Int? {
        return dbQuery {
            try {
                Users.insertAndGetId {
                    it[name] = user.name
                    it[age] = user.age
                }.value
            } catch (e: Exception) {
                null
            }
        }
    }

    suspend fun read(id: Int): User? {
        return dbQuery {
            Users.select { Users.id eq id }
                .map { User(it[Users.id].value, it[Users.name], it[Users.age]) }
                .singleOrNull()
        }
    }

    suspend fun update(id: Int, user: User)  {
        return dbQuery {
            val updatedRowCount = Users.update({ Users.id eq id }) {
                it[name] = user.name
                it[age] = user.age
            }
            if (updatedRowCount > 0) {
                User(id, user.name, user.age)
            } else {
                null
            }
        }
    }

    suspend fun delete(id: Int): Int {
        return dbQuery {
            Users.deleteWhere { Users.id.eq(id) }
        }
    }

    suspend fun all(): List<User> {
        return dbQuery {
            Users.selectAll().map {
                User(it[Users.id].value, it[Users.name], it[Users.age])
            }
        }
    }
}