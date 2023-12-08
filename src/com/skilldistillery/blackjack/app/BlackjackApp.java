package com.skilldistillery.blackjack.app;

import com.skilldistillery.blackjack.entities.Dealer;
import com.skilldistillery.blackjack.entities.Player;

public class BlackjackApp {

	public static void main(String[] args) {
		
		BlackjackApp app = new BlackjackApp();
		app.run();
	}
	
	//No instances of any other objects other than player and dealer (good encapsulation)
	public void run() {
		Player player = new Player();
		Dealer dealer = new Dealer();
	}

}
