package com.ArmiaJsona.emojiSearch;

import com.ArmiaJsona.emojiSearch.allegro.AllegroClient;
import com.ArmiaJsona.emojiSearch.emoji.EmojiClient;
import com.ArmiaJsona.emojiSearch.translator.TranslatorClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmojiSearchApplication implements CommandLineRunner {

    @Autowired
    private EmojiClient emojipediaClient;

    @Autowired
    private AllegroClient allegroClient;

    @Autowired
    private TranslatorClient yandexClient;

    @Autowired
    PhraseResolver phraseResolver;

    public static void main(String[] args) {
        SpringApplication.run(EmojiSearchApplication.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.print(emojipediaClient.getEmojiNameByUnicode("\uD83C\uDF47"));
        System.out.println(allegroClient.getOffersByPhrase("pilka nike"));
        System.out.println(allegroClient.getOfferbyId("7074249172"));
        System.out.println("phone(ENG)" + " = " + yandexClient.getTranslation("phone") + "(PL)");
        System.out.println(phraseResolver.translatePhrasesWithEmojiToText("\uD83C\uDF54\uD83C\uDF48Hello World"));
    }
}