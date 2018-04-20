package com.ArmiaJsona.emojiSearch;

import com.ArmiaJsona.emojiSearch.allegro.AllegroClient;
import com.ArmiaJsona.emojiSearch.emoji.EmojiClient;
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

	public static void main(String[] args) {
		SpringApplication.run(EmojiSearchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.print(emojipediaClient.getEmojiNameByUnicode("\uD83C\uDF47"));
		System.out.println(allegroClient.getOffersByPhrase("pilka nike"));
	}
}
