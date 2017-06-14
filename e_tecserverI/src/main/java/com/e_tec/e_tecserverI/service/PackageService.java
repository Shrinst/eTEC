package com.e_tec.e_tecserverI.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.e_tec.e_tecserverI.database.DataBaseClass;
import com.e_tec.e_tecserverI.model.Package;
import com.e_tec.e_tecserverI.xml.writer.XMLWriterPackage;

public class PackageService {
	
	private Map<Integer, Package> packageList = DataBaseClass.getPackageList();
	
	public PackageService() {
		
	}
	
	public List<Package> getAllPackage() {
		return new ArrayList<Package>(packageList.values());
	}
	
	public Package getPackage(int key) {
		return packageList.get(key);
	}

	public Package addPackage(Package package1) {
		packageList.put(package1.getCode(), package1);
		XMLWriterPackage.writeXML(new ArrayList<Package>(packageList.values()));
		return package1;
	}

	public Package updatePackage(Package package1) {
		if (package1.getCode() == 0) {
			return null;
		}

		packageList.put(package1.getCode(), package1);
		XMLWriterPackage.writeXML(new ArrayList<Package>(packageList.values()));
		return package1;
	}

	public void deletePackage(int key) {
		packageList.remove(key);
		XMLWriterPackage.writeXML(new ArrayList<Package>(packageList.values()));
	}

}
