package com.example.crosswordsolver.logic

import android.content.Context
import com.example.crosswordsolver.model.LetterButtonModel

fun getListOfWords(context: Context, countOfLetters: Int): List<String> {
    return context.assets.open("word_lists/words${countOfLetters}Letter.txt")
        .bufferedReader()
        .use { it.readLines() }
}


//fun searchByMask(words: List<String>, result: MutableList<String>, countOfLetters: Int) {
//    var search: String
//
//    while (true) {
//        search = readln().lowercase()
//        if (search.length == countOfLetters) {
//            break
//        } else {
//            println("Вы ввели не $countOfLetters символов, попробуйте снова: ")
//        }
//    }
//
//    for (word in words) {
//        var matches = true
//        val currentWord = word.lowercase()
//        for (i in 0 until countOfLetters) {
//            if (search[i] != '*' && search[i] != currentWord[i]) {
//                matches = false
//                break
//            }
//        }
//        if (matches) {
//            result.add(word)
//        }
//    }
//}

fun searchBySet(
    words: List<String>,
    search: Set<LetterButtonModel>,
    lettersToExclude: Set<LetterButtonModel>
): List<String> {
    return words.filter { word ->
        val lowercaseWord = word.lowercase()
        search.all { it.letter in lowercaseWord } && lettersToExclude.none { it.letter in lowercaseWord }
    }
}