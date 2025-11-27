package com.example.businesscard.activity1.util

import java.security.SecureRandom

object RandomStringUtil {

    private const val CHARSET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"
    private val random = SecureRandom()

    fun randomString8(): String = randomString(8)

    fun randomString(length: Int): String {
        val sb = StringBuilder(length)
        repeat(length) {
            val idx = random.nextInt(CHARSET.length)
            sb.append(CHARSET[idx])
        }
        return sb.toString()
    }
}