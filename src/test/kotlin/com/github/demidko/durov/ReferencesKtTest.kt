package com.github.demidko.durov

import assertk.assertThat
import assertk.assertions.containsAll
import assertk.assertions.isEqualTo
import kotlinx.serialization.decodeFromByteArray
import kotlinx.serialization.encodeToByteArray
import kotlinx.serialization.protobuf.ProtoBuf
import org.junit.jupiter.api.Test

class ReferencesKtTest {

  @Test
  fun lookup() {
    val db = TaggedReferences()
    val channelRef = Reference(1, "xra")
    val channelRefTwo = Reference(2, "dfs")
    db.add(channelRef, setOf("important", "top secret"))
    db.add(channelRefTwo, setOf("important", "photo"))
    assertThat(db.lookup(setOf("important"))).containsAll(channelRef, channelRefTwo)
    assertThat(db.lookup(setOf("photo"))).containsAll(channelRefTwo)
    val proto = ProtoBuf.encodeToByteArray(db)
    assertThat(ProtoBuf.decodeFromByteArray<TaggedReferences>(proto)).isEqualTo(db)
  }
}