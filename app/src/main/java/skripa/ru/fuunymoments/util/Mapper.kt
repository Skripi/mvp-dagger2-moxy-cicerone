package skripa.ru.fuunymoments.util

interface Mapper<FROM, TO> {
    fun transform(value: FROM): TO
}
