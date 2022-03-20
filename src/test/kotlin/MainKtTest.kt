package ru.netology

import MAESTRO
import MASTER
import MIR
import VISA
import VK
import org.junit.Test
import org.junit.Assert.*
import transfer

class MainKtTest {

    @Test
    fun calculate_transfer_vk() {
        val accountType = VK
        val previous = 55000000L
        val amount = 8000000L
        val expected = 8000000L

        val result = transfer(accountType, previous, amount)

        assertEquals(expected, result)
    }

    @Test
    fun calculate_transfer_mastercard_big_previous() {
        val accountType = MASTER
        val previous = 55000000L
        val amount = 8000000L
        val expected = 7518000.0

        val result = transfer(accountType, previous, amount)

        assertEquals(expected, result)
    }

    @Test
    fun calculate_transfer_mastercard_small_previous() {
        val accountType = MASTER
        val previous = 550L
        val amount = 8000000L
        val expected = 8000000L

        val result = transfer(accountType, previous, amount)

        assertEquals(expected, result)
    }

    @Test
    fun calculate_transfer_visa_minCommission() {
        val accountType = VISA
        val previous = 5000000L
        val amount = 5000L
        val expected = 1500L

        val result = transfer(accountType, previous, amount)

        assertEquals(expected, result)
    }
    
    @Test
    fun calculate_transfer_visa() {
        val accountType = VISA
        val previous = 5000000L
        val amount = 8000000L
        val expected = 7400000.0

        val result = transfer(accountType, previous, amount)

        assertEquals(expected, result)
    }

    @Test
    fun calculate_transfer_default_amount() {
        val expected = 8000000L

        val result = transfer(amount = 8000000L)

        assertEquals(expected, result)
    }

    @Test
    fun calculate_transfer_default_mastercard_without_previous() {
        val expected = 8000000L

        val result = transfer(accountType = MASTER, amount = 8000000L)

        assertEquals(expected, result)
    }


    @Test
    fun calculate_transfer_default_maestro_without_previous() {
        val expected = 8000000L

        val result = transfer(accountType = MAESTRO, amount = 8000000L)

        assertEquals(expected, result)
    }

    @Test
    fun calculate_transfer_default_visa_min_commission() {
        val expected = 1500L

        val result = transfer(accountType = VISA, amount = 5000L)

        assertEquals(expected, result)
    }

    @Test
    fun calculate_transfer_default_mir_min_commission() {
        val expected = 1500L

        val result = transfer(accountType = MIR, amount = 5000L)

        assertEquals(expected, result)
    }


    @Test
    fun calculate_transfer_default_amount_and_previous() {
        val expected = 8000000L

        val result = transfer(previous = 50000, amount = 8000000L)

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


}