// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.fragment_used_twice.fragment

import com.apollographql.apollo.api.GraphqlFragment
import com.apollographql.apollo.api.ResponseField
import com.apollographql.apollo.api.internal.ResponseFieldMarshaller
import com.apollographql.apollo.api.internal.ResponseReader
import kotlin.Array
import kotlin.String
import kotlin.Suppress

@Suppress("NAME_SHADOWING", "UNUSED_ANONYMOUS_PARAMETER", "LocalVariableName",
    "RemoveExplicitTypeArguments", "NestedLambdaShadowedImplicitParameter")
data class HumanDetails(
  val __typename: String = "Human",
  /**
   * What this human calls themselves
   */
  val name: String,
  val fragments: Fragments
) : GraphqlFragment {
  override fun marshaller(): ResponseFieldMarshaller = ResponseFieldMarshaller.invoke { writer ->
    writer.writeString(RESPONSE_FIELDS[0], this@HumanDetails.__typename)
    writer.writeString(RESPONSE_FIELDS[1], this@HumanDetails.name)
    this@HumanDetails.fragments.marshaller().marshal(writer)
  }

  companion object {
    private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
        ResponseField.forString("__typename", "__typename", null, false, null),
        ResponseField.forString("name", "name", null, false, null),
        ResponseField.forString("__typename", "__typename", null, false, null)
        )

    val FRAGMENT_DEFINITION: String = """
        |fragment HumanDetails on Human {
        |  __typename
        |  name
        |  ...CharacterDetails
        |}
        """.trimMargin()

    operator fun invoke(reader: ResponseReader): HumanDetails = reader.run {
      val __typename = readString(RESPONSE_FIELDS[0])!!
      val name = readString(RESPONSE_FIELDS[1])!!
      val fragments = Fragments(reader)
      HumanDetails(
        __typename = __typename,
        name = name,
        fragments = fragments
      )
    }
  }

  data class Fragments(
    val characterDetails: CharacterDetails?
  ) {
    fun marshaller(): ResponseFieldMarshaller = ResponseFieldMarshaller.invoke { writer ->
      writer.writeFragment(this@Fragments.characterDetails?.marshaller())
    }

    companion object {
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
          ResponseField.forFragment("__typename", "__typename", listOf(
            ResponseField.Condition.typeCondition(arrayOf("Human", "Droid"))
          ))
          )

      operator fun invoke(reader: ResponseReader): Fragments = reader.run {
        val characterDetails = readFragment<CharacterDetails>(RESPONSE_FIELDS[0]) { reader ->
          CharacterDetails(reader)
        }
        Fragments(
          characterDetails = characterDetails
        )
      }
    }
  }
}
