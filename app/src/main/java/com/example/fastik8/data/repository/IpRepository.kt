package com.example.fastik8.domain.repository

interface IpRepository {

    suspend fun getPublicIp(): String?
}