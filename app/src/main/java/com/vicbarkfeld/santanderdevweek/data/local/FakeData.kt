package com.vicbarkfeld.santanderdevweek.data.local

import com.vicbarkfeld.santanderdevweek.data.Cartao
import com.vicbarkfeld.santanderdevweek.data.Cliente
import com.vicbarkfeld.santanderdevweek.data.Conta

class FakeData {
    fun getLocalData(): Conta {
        val cliente = Cliente("Victoria")
        val cartao = Cartao("0666")
        return Conta(
            "132199-7",
            "1805-5",
            "R$ 10.450,80",
            "R$ 12.120,00",
            cliente,
            cartao
        );
    }
}

