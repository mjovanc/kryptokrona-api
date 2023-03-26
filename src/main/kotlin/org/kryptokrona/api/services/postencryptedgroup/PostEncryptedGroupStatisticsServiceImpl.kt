// Copyright (c) 2023-2023, The Kryptokrona Developers
//
// Written by Marcus Cvjeticanin
//
// All rights reserved.
//
// Redistribution and use in source and binary forms, with or without modification, are
// permitted provided that the following conditions are met:
//
// 1. Redistributions of source code must retain the above copyright notice, this list of
//    conditions and the following disclaimer.
//
// 2. Redistributions in binary form must reproduce the above copyright notice, this list
//    of conditions and the following disclaimer in the documentation and/or other
//    materials provided with the distribution.
//
// 3. Neither the name of the copyright holder nor the names of its contributors may be
//    used to endorse or promote products derived from this software without specific
//    prior written permission.
//
// THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY
// EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF
// MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL
// THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
// SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
// PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
// INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
// STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF
// THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

package org.kryptokrona.api.services.postencryptedgroup

import org.kryptokrona.api.models.PostEncryptedGroup
import org.kryptokrona.api.models.PostEncryptedGroups
import org.kryptokrona.api.models.PostsEncrypted
import org.kryptokrona.api.plugins.DatabaseFactory.db
import org.ktorm.dsl.*
import org.slf4j.LoggerFactory
import java.time.LocalDateTime

class PostEncryptedGroupStatisticsServiceImpl : PostEncryptedGroupStatisticsService {

    private val logger = LoggerFactory.getLogger("PostEncryptedGroupStatisticsServiceImpl")

    override suspend fun get1h(size: Int, page: Int): List<Map<String, Any>> {
        val now = LocalDateTime.now()
        val oneHourAgo = now.minusHours(1)

        return db.from(PostEncryptedGroups)
            .select()
            .where { PostEncryptedGroups.createdAt greaterEq oneHourAgo }
            .having { PostEncryptedGroups.createdAt lessEq now }
            .orderBy(PostEncryptedGroups.createdAt.asc())
            .groupBy(
                PostEncryptedGroups.id,
                PostEncryptedGroups.txHash,
                PostEncryptedGroups.createdAt
            )
            .offset((page - 1) * size)
            .limit(size)
            .map { row ->
                mapOf(
                    "id" to row[PostEncryptedGroups.id]!!,
                    "txHash" to row[PostEncryptedGroups.txHash]!!
                )
            }
            .toList()
    }

    override suspend fun get24h(size: Int, page: Int): List<Map<String, Any>> {
        val now = LocalDateTime.now()
        val oneHourAgo = now.minusHours(24)

        return db.from(PostEncryptedGroups)
            .select()
            .where { PostEncryptedGroups.createdAt greaterEq oneHourAgo }
            .having { PostEncryptedGroups.createdAt lessEq now }
            .orderBy(PostEncryptedGroups.createdAt.asc())
            .groupBy(
                PostEncryptedGroups.id,
                PostEncryptedGroups.txHash,
                PostEncryptedGroups.createdAt
            )
            .offset((page - 1) * size)
            .limit(size)
            .map { row ->
                mapOf(
                    "id" to row[PostEncryptedGroups.id]!!,
                    "txHash" to row[PostEncryptedGroups.txHash]!!
                )
            }
            .toList()
    }

    override suspend fun get1w(size: Int, page: Int): List<Map<String, Any>> {
        val now = LocalDateTime.now()
        val oneHourAgo = now.minusHours(24 * 7)

        return db.from(PostEncryptedGroups)
            .select()
            .where { PostEncryptedGroups.createdAt greaterEq oneHourAgo }
            .having { PostEncryptedGroups.createdAt lessEq now }
            .orderBy(PostEncryptedGroups.createdAt.asc())
            .groupBy(
                PostEncryptedGroups.id,
                PostEncryptedGroups.txHash,
                PostEncryptedGroups.createdAt
            )
            .offset((page - 1) * size)
            .limit(size)
            .map { row ->
                mapOf(
                    "id" to row[PostEncryptedGroups.id]!!,
                    "txHash" to row[PostEncryptedGroups.txHash]!!
                )
            }
            .toList()
    }

    override suspend fun get1m(size: Int, page: Int): List<Map<String, Any>> {
        val now = LocalDateTime.now()
        val oneHourAgo = now.minusHours(24 * 7 * 4)

        return db.from(PostEncryptedGroups)
            .select()
            .where { PostEncryptedGroups.createdAt greaterEq oneHourAgo }
            .having { PostEncryptedGroups.createdAt lessEq now }
            .orderBy(PostEncryptedGroups.createdAt.asc())
            .groupBy(
                PostEncryptedGroups.id,
                PostEncryptedGroups.txHash,
                PostEncryptedGroups.createdAt
            )
            .offset((page - 1) * size)
            .limit(size)
            .map { row ->
                mapOf(
                    "id" to row[PostEncryptedGroups.id]!!,
                    "txHash" to row[PostEncryptedGroups.txHash]!!
                )
            }
            .toList()
    }

    override suspend fun get1y(size: Int, page: Int): List<Map<String, Any>> {
        val now = LocalDateTime.now()
        val oneHourAgo = now.minusHours(24 * 7 * 4 * 12)

        return db.from(PostEncryptedGroups)
            .select()
            .where { PostEncryptedGroups.createdAt greaterEq oneHourAgo }
            .having { PostEncryptedGroups.createdAt lessEq now }
            .orderBy(PostEncryptedGroups.createdAt.asc())
            .groupBy(
                PostEncryptedGroups.id,
                PostEncryptedGroups.txHash,
                PostEncryptedGroups.createdAt
            )
            .offset((page - 1) * size)
            .limit(size)
            .map { row ->
                mapOf(
                    "id" to row[PostEncryptedGroups.id]!!,
                    "txHash" to row[PostEncryptedGroups.txHash]!!
                )
            }
            .toList()
    }

    override suspend fun getTotal1h(): Int {
        val now = LocalDateTime.now()
        val oneHourAgo = now.minusHours(1)

        return db.from(PostEncryptedGroups)
                .select()
                .where { PostEncryptedGroups.createdAt greaterEq oneHourAgo }
                .having { PostEncryptedGroups.createdAt lessEq now }
                .groupBy(
                    PostEncryptedGroups.id,
                    PostEncryptedGroups.txHash,
                    PostEncryptedGroups.createdAt
                )
                .totalRecordsInAllPages
    }

    override suspend fun getTotal24h(): Int {
        val now = LocalDateTime.now()
        val oneHourAgo = now.minusHours(24)

        return db.from(PostEncryptedGroups)
                .select()
                .where { PostEncryptedGroups.createdAt greaterEq oneHourAgo }
                .having { PostEncryptedGroups.createdAt lessEq now }
                .groupBy(
                    PostEncryptedGroups.id,
                    PostEncryptedGroups.txHash,
                    PostEncryptedGroups.createdAt
                )
                .totalRecordsInAllPages
    }

    override suspend fun getTotal1w(): Int {
        val now = LocalDateTime.now()
        val oneHourAgo = now.minusHours(24 * 7)

        return db.from(PostEncryptedGroups)
                .select()
                .where { PostEncryptedGroups.createdAt greaterEq oneHourAgo }
                .having { PostEncryptedGroups.createdAt lessEq now }
                .groupBy(
                    PostEncryptedGroups.id,
                    PostEncryptedGroups.txHash,
                    PostEncryptedGroups.createdAt
                )
                .totalRecordsInAllPages
    }

    override suspend fun getTotal1m(): Int {
        val now = LocalDateTime.now()
        val oneHourAgo = now.minusHours(24 * 7 * 4)

        return db.from(PostEncryptedGroups)
                .select()
                .where { PostEncryptedGroups.createdAt greaterEq oneHourAgo }
                .having { PostEncryptedGroups.createdAt lessEq now }
                .groupBy(
                    PostEncryptedGroups.id,
                    PostEncryptedGroups.txHash,
                    PostEncryptedGroups.createdAt
                )
                .totalRecordsInAllPages
    }

    override suspend fun getTotal1y(): Int {
        val now = LocalDateTime.now()
        val oneHourAgo = now.minusHours(24 * 7 * 4 * 12)

        return db.from(PostEncryptedGroups)
                .select()
                .where { PostEncryptedGroups.createdAt greaterEq oneHourAgo }
                .having { PostEncryptedGroups.createdAt lessEq now }
                .groupBy(
                    PostEncryptedGroups.id,
                    PostEncryptedGroups.txHash,
                    PostEncryptedGroups.createdAt
                )
                .totalRecordsInAllPages
    }
}