package ru.netology

import MASTER
import VISA
import VK
import org.junit.Test
import org.junit.Assert.*
import transfer

class MainKtTest {

    @Test
    fun calculate_transfer_only_with_amount() {
        val expected = 8000000L

        val result = transfer(amount = 8000000L)

        assertEquals(expected, result)
    }

    @Test
    fun calculate_transfer_with_mastercard_maestro() {
        val accountType = MASTER
        val previous = 55000000L
        val amount = 8000000L
        val expected = 7518000.0

        val result = transfer(accountType, previous, amount)

        assertEquals(expected, result)
    }

    @Test
    fun calculate_transfer_with_mastercard_maestro_without_previous() {
        val expected = 8000000L

        val result = transfer(accountType = MASTER, amount = 8000000L)

        assertEquals(expected, result)
    }

    @Test
    fun calculate_transfer_with_visa_mir() {
        val accountType = VISA
        val previous = 5000000L
        val amount = 8000000L
        val expected = 7400000.0

        val result = transfer(accountType, previous, amount)

        assertEquals(expected, result)
    }

    @Test
    fun calculate_transfer_with_visa_mir_min_commission() {
        val expected = 1500L

        val result = transfer(accountType = VISA, amount = 5000L)

        assertEquals(expected, result)
    }

    @Test
    fun calculate_transfer_with_wrong_card_type() {
        val accountType = "something"
        val previous = 5000000L
        val amount = 8000000L
        val expected = 0

        val result = transfer(accountType, previous, amount)

        assertEquals(expected, result)
    }

    @Test
    fun calculate_transfer_with_amount_and_previous() {
        val expected = 8000000L

        val result = transfer(previous = 50000, amount = 8000000L)

        assertEquals(expected, result)
    }


}