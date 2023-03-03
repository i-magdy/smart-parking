package com.devwarex.smartparking

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform