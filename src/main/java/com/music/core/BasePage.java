package com.music.core;

public class BasePage {
	protected KeyWordWeb keyword;

	public BasePage() {
		keyword = new KeyWordWeb();
	}

	public BasePage(KeyWordWeb keyword) {
		this.keyword = keyword;
	}
}
