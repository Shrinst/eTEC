package com.e_tec.e_tecserverI.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.e_tec.e_tecserverI.database.DataBaseClass;
import com.e_tec.e_tecserverI.model.Client;
import com.e_tec.e_tecserverI.xml.writer.XMLWriterClient;

public class ClientService {
	
	private Map<String, Client> clientList = DataBaseClass.getClientList();

	public ClientService() {
//		Client client = new Client("TOBE", "jfishgos");
//		client.getCart().add(new Product("PS4", "JFKDG", 45, 1, "juegos", "GG"));
//		client.getCart().add(new Product("PS4", "JFKDG", 45, 1, "juegos", "GG"));
//		clientList.put("TOBE", client);
//		clientList.put("Milton", new Client("Milton", "NFJBJGG"));
//		clientList.put("Noguera", new Client("Noguera", "NFJBJGG"));
	}

	public List<Client> getAllClient() {
		return new ArrayList<Client>(clientList.values());
	}

	public Client getClient(String key) {
		return clientList.get(key);
	}

	public Client addClient(Client client) {
		clientList.put(client.getName(), client);
		XMLWriterClient.writeXML(new ArrayList<Client>(clientList.values()));
		return client;
	}

	public Client updateClient(Client client) {
		if (client.getName().isEmpty()) {
			return null;
		}

		clientList.put(client.getName(), client);
		XMLWriterClient.writeXML(new ArrayList<Client>(clientList.values()));
		return client;
	}

	public void deleteClient(String name) {
		clientList.remove(name);
		XMLWriterClient.writeXML(new ArrayList<Client>(clientList.values()));
	}

	public Map<String, Client> getClientList() {
		return clientList;
	}
}
