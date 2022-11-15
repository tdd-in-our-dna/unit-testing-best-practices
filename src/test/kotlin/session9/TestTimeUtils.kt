package session9

import java.time.Clock
import java.time.LocalDate
import java.time.ZoneId.systemDefault


val EPOCH_DAY: LocalDate = LocalDate.ofEpochDay(0)

fun fixedClock(localDate: LocalDate = EPOCH_DAY) = Clock.fixed(localDate.toInstant(), systemDefault())!!

fun LocalDate.toInstant() = atStartOfDay(systemDefault()).toInstant()!!