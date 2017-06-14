package com.e_tec.e_tecserverI.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.e_tec.e_tecserverI.database.DataBaseClass;
import com.e_tec.e_tecserverI.model.Package;

public class PackageService {
	
	private Map<Integer, Package> packageList = DataBaseClass.getPackageList();
	
	public PackageService() {
		packageList.put(1234, new Package(1234, 2, 3, 4, 5));
		packageList.put(1244, new Package(1244, 2, 4, 6, 7));
		packageList.put(1254, new Package(1254, 2, 5, 8, 9));
	}
	
	public List<Package> getAllPackage() {
		return new ArrayList<Package>(packageList.values());
	}
	
	public Package getPackage(int key) {
		return packageList.get(key);
	}

	public Package addPackage(Package package1) {
		packageList.put(package1.getCode(), package1);
		//XMLWriterClient.writeXML(new ArrayList<Client>(clientList.values()));
		return package1;
	}

	public Package updatePackage(Package package1) {
		if (package1.getCode() == 0) {
			return null;
		}

		packageList.put(package1.getCode(), package1);
		//XMLWriterClient.writeXML(new ArrayList<Client>(clientList.values()));
		return package1;
	}

	public void deletePackage(int key) {
		packageList.remove(key);
		//XMLWriterClient.writeXML(new ArrayList<Client>(clientList.values()));
	}

}
