package app;

import service.ClienteService;

public class Main {

	public static void main(String[] args) {
		ClienteService.getInstance().launchClient();
	}

}
