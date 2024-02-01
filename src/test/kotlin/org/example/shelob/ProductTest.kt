package org.example.shelob

import com.navercorp.fixturemonkey.FixtureMonkey
import com.navercorp.fixturemonkey.kotlin.KotlinPlugin
import com.navercorp.fixturemonkey.kotlin.giveMeBuilder
import com.navercorp.fixturemonkey.kotlin.giveMeOne
import com.navercorp.fixturemonkey.kotlin.setExp
import io.kotest.matchers.longs.shouldBeGreaterThan
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.Test

class ProductTest {

    @Test
    fun basic() {
        val fixtureMonkey = FixtureMonkey.builder()
            .plugin(KotlinPlugin())
            .build()

        val actual: Product = fixtureMonkey.giveMeOne()

        actual shouldNotBe null
    }

    @RepeatedTest(10)
    fun postCondition() {
        val fixtureMonkey = FixtureMonkey.builder()
            .plugin(KotlinPlugin())
            .build()

        val actual = fixtureMonkey.giveMeBuilder<Product>()
            .setPostCondition { it.id > 0 }
            .sample()

        actual.id shouldBeGreaterThan 0
    }

    @Test
    fun setExp() {
        val fixtureMonkey = FixtureMonkey.builder()
            .plugin(KotlinPlugin())
            .build()

        val actual = fixtureMonkey.giveMeBuilder<Product>()
            .setExp(Product::id, 1L)
            .sample()

        actual.id shouldBe 1L
    }
}
