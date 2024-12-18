package com.JorgeRosas.SB1.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for checking if a sentence is a palindrome.
 */

@RestController
public class PalindromeController {

    @GetMapping("/palindrome/{sentenceString}")
    public String function1(@PathVariable String sentenceString) {

        sentenceString = sentenceString.replaceAll("!|,|\\.|\\?", "").toLowerCase();
        sentenceString=sentenceString.replace(" ", "");
        sentenceString=sentenceString.replace("á", "a");
        sentenceString=sentenceString.replace("é", "e");
        sentenceString=sentenceString.replace("í", "i");
        sentenceString=sentenceString.replace("ó", "o");
        sentenceString=sentenceString.replace("ú", "u");

        for(int i=0;i<(sentenceString.length()/2);i++) {
            if(sentenceString.substring(i,i+1).equals(sentenceString.substring(sentenceString.length()-i-1,sentenceString.length()-i))) {
                continue; //System.out.println(true);
            } else {
                return "The sentence '"+sentenceString+"' it's not a palindrome"; //System.out.println(false);
            }
        }

        return "The sentence '"+sentenceString+"' it's a palindrome";
    }

}
